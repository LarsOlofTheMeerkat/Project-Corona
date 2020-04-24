/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import static coronaprojekt.Main_Page.minDatabaskoppling;
import static coronaprojekt.ettInlagg.minDatabaskoppling;
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
public class enKommentar  implements ActionListener{

    public static InfDB minDatabaskoppling;
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
    
    private String onlyDisplay = "";
    private int bloggID;
    private JTextArea text1;
    
    public enKommentar(InfDB db, ArrayList<HashMap<String, String>> kommentarer){
        this.kommentarer = kommentarer;
        minDatabaskoppling = db;
    }
    
     public enKommentar(InfDB db,String text){
        this.onlyDisplay = text;
        minDatabaskoppling = db;
    }
     
     public enKommentar(InfDB db,String text, int bloggID){
        this.onlyDisplay = text;
        this.bloggID = bloggID;
        minDatabaskoppling = db;
    }
     
     public enKommentar(InfDB db,String text, int bloggID, JTextArea text1){
        this.onlyDisplay = text;
        this.bloggID = bloggID;
        this.text1 = text1;
        minDatabaskoppling = db;
    }
    
    public void actionPerformed(ActionEvent e){
        if(this.onlyDisplay == "skrivkommentar"){
            
        JFrame nyJFRAME = new JFrame();
        
        nyJFRAME.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        nyJFRAME.setVisible(true);
        
        JPanel jPanel1 = new JPanel();
        GridLayout boxlayout = new GridLayout(0,1);
        jPanel1.setLayout(boxlayout);
        nyJFRAME.setLayout(boxlayout);
        
        this.txtArea = new JTextArea(5,2);
        jPanel1.add(this.txtArea, null);
        
        JButton enknapp = new JButton("Kommentera");
        enknapp.addActionListener(new enKommentar(minDatabaskoppling,"kommentera", this.bloggID, this.txtArea));
        jPanel1.add(enknapp, null);
        
        nyJFRAME.add(jPanel1);
        SwingUtilities.updateComponentTreeUI(nyJFRAME);
            
        }else if(this.onlyDisplay == "kommentera"){
            JFrame nyJFRAME = new JFrame();
        
        nyJFRAME.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        nyJFRAME.setVisible(true);
        
        JPanel jPanel1 = new JPanel();
        GridLayout boxlayout = new GridLayout(0,1);
        jPanel1.setLayout(boxlayout);
        nyJFRAME.setLayout(boxlayout);
        
        JLabel text = new JLabel();
        text.setText("Tack för att du kommenterade!");
        
        jPanel1.add(text, null);
        
        Kommentar nyKommentar = new Kommentar(minDatabaskoppling);
        System.out.println(this.bloggID);
        System.out.println(this.text1.getText());
        nyKommentar.skrivaKommentar(this.bloggID, this.text1.getText());
        System.out.println("Kommentar gjord");
        
        nyJFRAME.add(jPanel1);
        SwingUtilities.updateComponentTreeUI(nyJFRAME);
        
        }else{
        
        JFrame nyJFRAME = new JFrame();
        
        nyJFRAME.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        nyJFRAME.setVisible(true);
        
        JPanel jPanel1 = new JPanel();
        GridLayout boxlayout = new GridLayout(0,1);
        jPanel1.setLayout(boxlayout);
        nyJFRAME.setLayout(boxlayout);
        
        if(this.kommentarer != null && this.kommentarer.size() > 0){
        for(int i = 0; i < this.kommentarer.size(); i++){
            JLabel kommentar = new JLabel();
            kommentar.setText(this.kommentarer.get(i).get("TEXT"));
            jPanel1.add(kommentar);
        }
        }else{
            JLabel kommentar = new JLabel();
            kommentar.setText("Finns inga kommentarer.");
            jPanel1.add(kommentar);
        }
        
        nyJFRAME.add(jPanel1);
        SwingUtilities.updateComponentTreeUI(nyJFRAME);
        }
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