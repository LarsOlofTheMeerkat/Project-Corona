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

/**
 *
 * @author Simon Sandberg
 */
public class ettInlagg  {

    public static InfDB minDatabaskoppling;
    Login_Page user = new Login_Page(minDatabaskoppling);
    String userName = "Jacob";
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
    
    
    
    
    public ettInlagg(InfDB db, HashMap<String, String> ettInlaggFranDatabasen, int artikelEllerBlogg){
        this.artikelEllerBlogg = artikelEllerBlogg;
        this.ID = Integer.parseInt(ettInlaggFranDatabasen.get("ID"));
        Fil filer = new Fil(db);
        ArrayList listaMedFilIds = new ArrayList<>();
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

    public void visaPost() {
        //System.out.println(this.text);
        
        // Rubrik
        this.rubrikLbl.setText(this.rubrik);
        postPanel.add(this.rubrikLbl);
        
        // datum och författare
        this.nameLbl.setText(this.userName);
        postPanel.add(this.nameLbl);
        this.datumLabel.setText(this.skapad);
        postPanel.add(this.datumLabel);

        // texten
        this.txtArea.setText(this.text);

        postPanel.add(this.txtArea);
        

        
        for(int i = 0; i < this.filer.size(); i++){
            System.out.println("JA");
            if(this.filer.get(i) != null && this.filer.get(i).get("SOKVAG") != null){
                System.out.println("JA2");
                System.out.println(this.filer.get(i).get("SOKVAG"));
                this.setPicture(this.filer.get(i).get("SOKVAG"));
            }
        }
    }

    public void loadPosts() {
        Blogg inlagg = new Blogg(minDatabaskoppling, 20);
        inlagg.hamtaFormellaBloggInlagg();
        inlagg.hamtaInformellaBloggInlagg();
    }

    public void setTextArea(javax.swing.JTextArea txt) {
        this.txtArea = txt;
    }

    public void setPicture(String sokvag) {
         JLabel element = new JLabel(); 
         try{
             element.setIcon(new ImageIcon(getClass().getResource(sokvag)));
             bilder.add(element);
         }catch(java.lang.NullPointerException e){
             System.out.println(e);
         }
         
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