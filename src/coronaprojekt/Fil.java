/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import oru.inf.InfDB;
import oru.inf.InfException;

import java.io.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jacob
 */
public class Fil {
    
    private String url;
    private BufferedImage originalBI;
    private static InfDB db;
    private InputStream in;
    private FileInputStream instream = null;
    
    public Fil(InfDB idb){
        this.db = idb;
    }
    
    private ArrayList skapaEnArrayMedEndastEttVarde(ArrayList<HashMap<String, String>> listan, String indexNamn) {
        ArrayList nyLista = new ArrayList();
        for (int i = 0; i < listan.size(); i++) {
            nyLista.add(listan.get(i).get(indexNamn));
        }
        return nyLista;
    }
    
    private String fixaListaMedIds(ArrayList lista) {
        String query = "(";
        for (int i = 0; i < lista.size(); i++) {
            query = query + lista.get(i);
            if (i + 1 != lista.size()) {
                query = query + ",";
            }
        }
        query = query + ")";
        return query;
    }
    
    public ArrayList hamtaFilIDsMedBloggID(int BloggID){
        ArrayList resultat = new ArrayList();
        try{
            String fraga = "SELECT FILID FROM FILER_TILL_BLOGG WHERE BLOGGID = " + BloggID;
            ArrayList<HashMap<String, String>> res = this.db.fetchRows(fraga);
            System.out.println(res);
            if(res != null){
                
                resultat = this.skapaEnArrayMedEndastEttVarde(res, "FILID");
                
            }
            
        }catch(InfException e){
            System.out.println(e);
        }
        return resultat;
    }
    public ArrayList hamtaFilIDsMedArtikelID(int ArtikelID){
        ArrayList resultat = new ArrayList();
        try{
            String fraga = "SELECT FILID FROM FILER_TILL_ARTIKEL WHERE ARTIKELID = " + ArtikelID;
            ArrayList<HashMap<String, String>> res = this.db.fetchRows(fraga);
            
            if(res != null){
                
                resultat = this.skapaEnArrayMedEndastEttVarde(res, "FILID");
                
            }
            
        }catch(InfException e){
            System.out.println(e);
        }
        return resultat;
    }
    
    public ArrayList hamtaFilerMedFilIDs(ArrayList listaMedFiler){
        
        String query = this.fixaListaMedIds(listaMedFiler);
        
        ArrayList res = new ArrayList();
        
        try{
            
            String fraga = "SELECT * FROM FIL WHERE ID IN " + query + ";";
            
            res = this.db.fetchRows(fraga);
            
            
        }catch(InfException e){
           
            System.out.println(e);
            
        }
        
        return res;
        
    }
    /*
    Behöver ett GUI där användaren bestämmer vart på datorn filen ska sparas på
    
    funktionen tar in ett filID och sen ett directory som är för att bestämma vart filen ska sparas
    */
    public void laddaNerFilPaDisk(int FilID, String directory){
        
        try{
            
            String fraga = "SELECT FILID FROM FIL WHERE ID = " + FilID;
            
            if(Integer.parseInt(this.db.fetchSingle(fraga)) == FilID){
                
                 fraga = "SELECT * FROM FIL WHERE ID = " + FilID;
                HashMap<String, String> sokvag = this.db.fetchRow(fraga);
                
                this.laddaFilPaDatorn(sokvag.get("SOKVAG"));
                
                this.sparaFil(sokvag.get("SOKVAG"), directory);
                
            }
            
        }catch(InfException e){
            System.out.println(e);
        }
        
    }
    
    public void laddaFilPaDatorn(javax.swing.JFileChooser jFileChooser2){
        System.out.println("geh?");
        
        try{
            
            File infile =new File(jFileChooser2.getSelectedFile().getAbsolutePath());
            
            instream = new FileInputStream(infile);

        }catch (Exception exep)
        {
            exep.printStackTrace();
        }
    }
    
    public void laddaFilPaDatorn(String sokvag){
        System.out.println("geh?");
        
        try{
            
            String folder = System.getProperty("user.dir");
            String OperatingSystem = System.getProperty("os.name").toLowerCase();
            System.out.println(OperatingSystem);
            String directory = "";
            directory = folder + "\\anvandarFiler\\" + sokvag;
            
            File infile =new File(directory);
            
            instream = new FileInputStream(infile);

        }catch (Exception exep)
        {
            exep.printStackTrace();
        }
    }
    
    public String sparaFil(String filnamn){
        FileOutputStream outstream = null;
        String filNamn = "";
        try{
            String folder = System.getProperty("user.dir");
            String OperatingSystem = System.getProperty("os.name").toLowerCase();
            System.out.println(OperatingSystem);
            String directory = "";
            double randomNumber = (Math.random() * ((1000 - 1) + 1)) + 1;
            filNamn = + Math.floor(randomNumber)+ filnamn ;
            directory = folder + "\\anvandarFiler\\" + filNamn;
            
            File outfile =new File(directory);
 
    	    outstream = new FileOutputStream(outfile);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    /*copying the contents from input stream to
    	     * output stream using read and write methods
    	     */
    	    while ((length = instream.read(buffer)) > 0){
    	    	outstream.write(buffer, 0, length);
    	    }

    	    //Closing the input/output file streams
    	    instream.close();
    	    outstream.close();

    	    System.out.println("File copied successfully!!");
            
        }catch (Exception exep)
        {
            exep.printStackTrace();
        }
        
     return filNamn;
        
    }
    
    public void sparaFil(String filnamn, String directory){
        FileOutputStream outstream = null;
        try{
            
            File outfile =new File(directory);
 
    	    outstream = new FileOutputStream(outfile);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    /*copying the contents from input stream to
    	     * output stream using read and write methods
    	     */
    	    while ((length = instream.read(buffer)) > 0){
    	    	outstream.write(buffer, 0, length);
    	    }

    	    //Closing the input/output file streams
    	    instream.close();
    	    outstream.close();

    	    System.out.println("File copied successfully!!");
            
        }catch (Exception exep)
        {
            exep.printStackTrace();
        }
        
     
        
    }
    
    public boolean lasBildFilPaDatorn(javax.swing.JFileChooser jFileChooser2){
        boolean res = false;
        try{
            url = jFileChooser2.getSelectedFile().getAbsolutePath();
            File f = new File(url); //image file path
            originalBI = ImageIO.read(f);
            System.out.println("Succesfully read");
            res = true;
        }catch(IOException e){
          System.out.println(e);
        }
        return res;
    }
    
    public String sparaBild(String filnamn){
        
            String folder = System.getProperty("user.dir");
            String OperatingSystem = System.getProperty("os.name").toLowerCase();
            System.out.println(OperatingSystem);
            String directory = "";
            double randomNumber = (Math.random() * ((1000 - 1) + 1)) + 1;
            String filNamn = filnamn  + Math.floor(randomNumber) + ".png";
            directory = folder + "\\anvandarFiler\\" + filNamn;

         try {
            ImageIO.write(originalBI, "png", new File(directory));
        } catch (IOException ex) {
            System.out.println("Failed to save image!");
        }
        return filNamn;
    }
    
    public String getSokVag(){
        String folder = System.getProperty("user.dir");
        String OperatingSystem = System.getProperty("os.name").toLowerCase();
        System.out.println(OperatingSystem);
       String directory = folder + "\\anvandarFiler\\";
       return directory;
    }
    
    public boolean sparaFilMedBloggID(String filnamn, int BloggID){
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        boolean resultat = false;
        try{
            
            String fraga = "SELECT ID FROM BLOGG WHERE ID =" + BloggID;
            String res = this.db.fetchSingle(fraga);
            
            if(res != null){
                int nyFilId = 1;
              try{
                  nyFilId = Integer.parseInt(db.getAutoIncrement("FIL", "ID"));
              }catch(java.lang.NumberFormatException e){
                  nyFilId = 1;
              }
            
            fraga = "INSERT INTO FIL(ID, SOKVAG, SKAPAD) VALUES("+nyFilId+",'"+
                    filnamn + "','" + date + "')";
            
            this.db.insert(fraga);

            fraga = "Insert into FILER_TILL_BLOGG(FILID, BLOGGID) VALUES(" +nyFilId+ ","
                + BloggID + ")"; 
        
            this.db.insert(fraga);
                
            resultat = true;
            }
            
        }catch(InfException e){
            System.out.println(e);
        }
        return resultat;
    }
    
    
    
}
