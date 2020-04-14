/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author jacob
 */
public class Fil {
    
    private String url;
    private BufferedImage originalBI;
    private static InfDB db;
    
    public Fil(InfDB idb){
        this.db = idb;
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
            double randomNumber = (Math.random() * ((100 - 1) + 1)) + 1;
            String filNamn = filnamn  + randomNumber + ".png";
            directory = folder + "\\bilder\\" + filNamn;

         try {
            ImageIO.write(originalBI, "png", new File(directory));
        } catch (IOException ex) {
            System.out.println("Failed to save image!");
        }
        return filNamn;
    }
    
    public boolean sparaFilMedBloggID(String filnamn, int BloggID){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        boolean resultat = false;
        try{
            
            String fraga = "SELECT ID FROM BLOGG WHERE ID =" + BloggID;
            String res = this.db.fetchSingle(fraga);
            
            if(res != null){
                
            int nyFilId = Integer.parseInt(db.getAutoIncrement("FIL", "ID"));
            fraga = "INSERT INTO FIL(ID, SOKVAG, SKAPAD) VALUES("+nyFilId+","+
                    filnamn + "," + date + ")";
            
            this.db.insert(fraga);

            fraga = "Insert into FILTER_TILL_BLOGG(FILID, BLOGGID) VALUES(" +nyFilId+ ","
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
