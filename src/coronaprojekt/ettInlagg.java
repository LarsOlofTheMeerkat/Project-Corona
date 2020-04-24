/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import static coronaprojekt.Main_Page.minDatabaskoppling;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;
import javax.swing.*; 

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
 
import java.awt.Insets;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
/**
 *
 * @author Simon Sandberg
 */
public class ettInlagg  implements ActionListener{

    public static InfDB minDatabaskoppling;
    Login_Page user = new Login_Page(minDatabaskoppling);
    String userName = "";
    String text;
    String anvandareID;
    String informell;
    String skapad;
    String rubrik;
    int artikelEllerBlogg;
    int ID;
    ArrayList<HashMap<String, String>> filer = new ArrayList<HashMap<String, String>>();
    ArrayList bilder = new ArrayList<>();
    
    // components
    private javax.swing.JPanel postPanel;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JLabel rubrikLbl;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel imageLbl;
    private javax.swing.JLabel datumLabel;
    private javax.swing.JButton knapp;
    
    private ArrayList<HashMap<String, String>> kommentarer;
    private String kommentar;
    private String typ;
    
    
    
    
    public ettInlagg(InfDB db, HashMap<String, String> ettInlaggFranDatabasen, int artikelEllerBlogg, ArrayList<HashMap<String, String>> kommentarer){
        this.artikelEllerBlogg = artikelEllerBlogg;
        this.ID = Integer.parseInt(ettInlaggFranDatabasen.get("ID"));
        Fil filer = new Fil(db);
        ArrayList listaMedFilIds = new ArrayList<>();
        
        this.userName = ettInlaggFranDatabasen.get("NAMN");
        this.kommentarer = kommentarer;
        
        if(artikelEllerBlogg == 1){
            // blogg inlägg
            this.text = ettInlaggFranDatabasen.get("TEXT");
            this.anvandareID = ettInlaggFranDatabasen.get("ANVANDAREID");
            this.informell = ettInlaggFranDatabasen.get("INFORMELL");
            this.skapad = ettInlaggFranDatabasen.get("SKAPAD");
            this.rubrik = ettInlaggFranDatabasen.get("RUBRIK");
            System.out.println(this.ID);
            listaMedFilIds = filer.hamtaFilIDsMedBloggID(this.ID);
            
        }else if(artikelEllerBlogg == 0){
            // ARTIKEL inlägg
            this.rubrik = ettInlaggFranDatabasen.get("RUBRIK");
            this.text = ettInlaggFranDatabasen.get("TEXT");
            this.anvandareID = ettInlaggFranDatabasen.get("ANVANDAREID");
            this.skapad = ettInlaggFranDatabasen.get("SKAPAD");
            listaMedFilIds = filer.hamtaFilIDsMedArtikelID(this.ID);
        }
        
        this.filer = filer.hamtaFilerMedFilIDs(listaMedFilIds);
        this.postPanel = new JPanel();
        this.txtArea = new JTextArea(5,2);
        this.txtArea.setEditable(false);
this.txtArea.setLineWrap(true);
this.txtArea.setWrapStyleWord(true);
        this.rubrikLbl = new JLabel();
        this.nameLbl = new JLabel();
        this.imageLbl = new JLabel();
        this.datumLabel = new JLabel();
        
        this.knapp = new JButton("Se artikel");
        this.knapp.addActionListener(this);
        minDatabaskoppling = db;
    }
    
    public ettInlagg(InfDB db, HashMap<String, String> res,
            int artikelEllerBlogg){
        
      
        
        if(artikelEllerBlogg == 1){
            // blogg inlägg
            this.text = res.get("TEXT");
            this.anvandareID = res.get("ANVANDAREID");
            this.informell = res.get("INFORMELL");
            this.skapad = res.get("SKAPAD");
            this.rubrik = res.get("RUBRIK");
            this.kommentar = res.get("KOMMENTAR");
            
        }
        
        this.postPanel = new JPanel();
        this.txtArea = new JTextArea(5,2);
        this.txtArea.setEditable(false);
this.txtArea.setLineWrap(true);
this.txtArea.setWrapStyleWord(true);
        this.rubrikLbl = new JLabel();
        this.nameLbl = new JLabel();
        this.imageLbl = new JLabel();
        this.datumLabel = new JLabel();
        
        if(!res.containsKey("TYP")){
            
        this.typ = "Blogg";
        this.knapp = new JButton("Se artikel");
        this.knapp.addActionListener(this);
        
        }else{
            this.typ = res.get("TYP");
        }
        minDatabaskoppling = db;
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        JFrame nyJFRAME = new JFrame();
        
        nyJFRAME.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        nyJFRAME.setVisible(true);
        
        JPanel jPanel1 = new JPanel();
        GridLayout boxlayout = new GridLayout(0,1);
        jPanel1.setLayout(boxlayout);
        nyJFRAME.setLayout(boxlayout);
        
        this.setPost();
        
        jPanel1.add(this.getRubrik(1), null);
        jPanel1.add(this.getForfattare(), null);
        jPanel1.add(this.getSkapad(1), null);
        jPanel1.add(this.getText(), null);
        
        JButton enknapp = new JButton("Se kommentarer");
        enknapp.addActionListener(new enKommentar(minDatabaskoppling,this.kommentarer));
        System.out.println(this.kommentarer);
        jPanel1.add(enknapp, null);
        
        JButton enknapp1 = new JButton("Skriv en kommentar");
        enknapp1.addActionListener(new enKommentar(minDatabaskoppling,"skrivkommentar", this.ID));
        jPanel1.add(enknapp1, null);
        
        // images
        for(int i = 0; i < this.filer.size(); i++){
            System.out.println("JA");
            if(this.filer.get(i) != null && this.filer.get(i).get("SOKVAG") != null){
                System.out.println("JA2");
                System.out.println(this.filer.get(i).get("SOKVAG"));
                JLabel nyLabel = this.setPicture(this.filer.get(i).get("SOKVAG"));
                jPanel1.add(nyLabel, null);
            }
        }
        
        nyJFRAME.add(jPanel1);
        SwingUtilities.updateComponentTreeUI(nyJFRAME);
    }
    
    /*
        Funktionen ska ändra size på element
    */
    public void setSizeTxtArea(){
        
    }
    public void setSizeRubrik(){
        
    }
    public void setSizeImage(){
        
    }
    
    public void setPane() {

    }
    
    public void adjustLayout(javax.swing.JPanel panel){
        GridLayout boxlayout = new GridLayout(0,1);
        postPanel.setLayout(boxlayout);
        panel.setLayout(boxlayout);
    }
   
    public void addPanelTo(javax.swing.JPanel panel){
        //jframe.addGroup().addComponent(postPanel);
       // BoxLayout experimentLayout = new BoxLayout(postPanel, BoxLayout.PAGE_AXIS);
                //new GridLayout(0,2);
        //jframe.setLayout(experimentLayout);
        
        //postPanel.setMaximumSize(new Dimension(1000, 1));
        panel.add(postPanel);
        
    }
    
    public String getRubrik(){
        return this.rubrik;
    }
    
    public String getKommentar(){
        return this.kommentar;
    }
    
    public String getTyp(){
        return this.typ;
    }
    
    public javax.swing.JLabel getRubrik(int hej){
        return this.rubrikLbl;
    }
    
    public String getSkapad(){
        return this.skapad;
    }
    
    public JLabel getForfattare(){
        JLabel hej = new JLabel();
        hej.setText(this.userName);
        return hej;
    }
    
    public javax.swing.JLabel getSkapad(int hej){
        return this.datumLabel;
    }
    
    public javax.swing.JTextArea getText(){
        return this.txtArea;
    }
    
    public javax.swing.JButton getButton(){
        return this.knapp;
    }

    public void setPost() {
        //System.out.println(this.text);
        
        // Rubrik
        this.rubrikLbl.setText(this.rubrik);
        //postPanel.add(this.rubrikLbl);
        
        // datum och författare
        /*this.nameLbl.setText(this.userName);
        postPanel.add(this.nameLbl);*/
        this.datumLabel.setText(this.skapad);
        //postPanel.add(this.datumLabel);

        // texten
        this.txtArea.setText(this.text);

        //postPanel.add(this.txtArea);
        

        /*
        for(int i = 0; i < this.filer.size(); i++){
            System.out.println("JA");
            if(this.filer.get(i) != null && this.filer.get(i).get("SOKVAG") != null){
                System.out.println("JA2");
                System.out.println(this.filer.get(i).get("SOKVAG"));
                this.setPicture(this.filer.get(i).get("SOKVAG"));
            }
        }*/
    }

    public void loadPosts() {
        Blogg inlagg = new Blogg(minDatabaskoppling, 20);
        inlagg.hamtaFormellaBloggInlagg();
        inlagg.hamtaInformellaBloggInlagg();
    }

    public void setTextArea(javax.swing.JTextArea txt) {
        this.txtArea = txt;
    }

    public JLabel setPicture(String sokvag) {
         JLabel element = new JLabel(); 
         Fil nyFilKlass = new Fil(minDatabaskoppling);
         String directory = nyFilKlass.getSokVag();
         try{
             //element.setIcon(new ImageIcon(getClass().getResource(directory+sokvag)));
             BufferedImage bild = ImageIO.read(new File(directory+sokvag));
             ImageIcon ikon = new ImageIcon(bild);
             element.setIcon(ikon);
         }catch(IOException e1){
             System.out.println(e1);
         }
         return element;
    }

    public void setLables() {

    }

    public int getUserID() {
        int ID = 0;
        try {
            String query = "select ID from Anvandare where Anvandarnamn ='" + userName + "';";
            String res = minDatabaskoppling.fetchSingle(query);
            ID = Integer.parseInt(res);
        } catch (InfException undantag) {
            System.out.println("Fel: " + undantag.getMessage());
        }
        return ID;
    }
    
    
    private javax.swing.JRadioButton pickerRBtn;
    
}