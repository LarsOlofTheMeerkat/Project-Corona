/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author juan
 */
public class SkapaBlogginlagg extends javax.swing.JFrame {
    private InfDB idb;
    private String vilkenBlogg;
    private String choosenFile;
    private int anvandareID;
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /**
     * Creates new form SkapaBlogginlagg
     * @param idb
     * @param anvandareID
     * @param vilkenBlogg
     */
    public SkapaBlogginlagg(InfDB idb, int anvandareID, String vilkenBlogg) {//Ange informell/formell på String vilkenBlogg
        initComponents();
        this.idb=idb;  
        this.anvandareID = anvandareID;
        this.vilkenBlogg=vilkenBlogg;
        choosenFile="";
        cboxSkrivUtKategorier();
        
        jComboBox1.removeAllItems();
        jComboBox1.addItem("J");
        jComboBox1.addItem("N");
        
        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtAreaBloggText = new javax.swing.JTextArea();
        cboxValjKategori = new javax.swing.JComboBox<>();
        BtnAddFile = new javax.swing.JButton();
        BtnAddPost = new javax.swing.JButton();
        lblChoosenFile = new javax.swing.JLabel();
        lblConfirmAddedPost = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitel.setText("Skriv ett nytt blogginlägg");

        TxtAreaBloggText.setColumns(20);
        TxtAreaBloggText.setRows(5);
        TxtAreaBloggText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtAreaBloggTextFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(TxtAreaBloggText);

        BtnAddFile.setText("Bifoga fil");
        BtnAddFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddFileActionPerformed(evt);
            }
        });

        BtnAddPost.setText("Skicka inlägg");
        BtnAddPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddPostActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(411, 411, 411)
                        .addComponent(lblTitel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboxValjKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(210, 210, 210)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BtnAddFile)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BtnAddPost))
                                    .addComponent(lblChoosenFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(lblConfirmAddedPost, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblTitel)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblConfirmAddedPost, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxValjKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAddFile)
                    .addComponent(BtnAddPost)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblChoosenFile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAddPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddPostActionPerformed
        String kategori = cboxValjKategori.getSelectedItem().toString();
        String bloggText = TxtAreaBloggText.getText();
        String informell;
        if(vilkenBlogg.equals("informell")){
            informell=jComboBox1.getSelectedItem().toString();
        }else{
            informell=jComboBox1.getSelectedItem().toString();
        }
        try{
            int bloggpost_id = Integer.parseInt(idb.getAutoIncrement("blogg", "ID"));
            String kategori_id = idb.fetchSingle("SELECT id from kategori where namn = '" + kategori + "'");
            idb.insert("INSERT INTO BLOGG (ID, TEXT, ANVANDAREID, INFORMELL) VALUES ('"+bloggpost_id+"', '"+bloggText+"', '"+anvandareID+"', '"+informell+"')");
            idb.insert("INSERT INTO BLOGG_TILLHOR_KATEGORI (KATEGORIID, BLOGGID) VALUES ('"+kategori_id+"', '"+bloggpost_id+"')");
            if (!choosenFile.isEmpty()){
                sparaInfoBifogadFil(bloggpost_id);
            } 
            TxtAreaBloggText.setText("");
            lblChoosenFile.setText("");
        } catch (InfException e) {
            System.out.println("btn add post" + e);
        } catch (IOException ex) {
            Logger.getLogger(SkapaBlogginlagg.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblConfirmAddedPost.setText("Ditt inlägg har skickats!");
    }//GEN-LAST:event_BtnAddPostActionPerformed

    private void BtnAddFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddFileActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnValue = fc.showOpenDialog(this);
        if(returnValue==JFileChooser.APPROVE_OPTION){
            try{
                File f = fc.getSelectedFile();
                String filename = f.getAbsolutePath();
                lblChoosenFile.setText(filename);
                choosenFile = filename;              
            }catch(Exception e){
                System.out.println("Couldnt load file: " + e);
                lblChoosenFile.setText("Couldn't load file!");
            }
        }else{
            lblChoosenFile.setText("No file choosen!");
        }
    }//GEN-LAST:event_BtnAddFileActionPerformed

    private void TxtAreaBloggTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtAreaBloggTextFocusGained
        lblConfirmAddedPost.setText("");
    }//GEN-LAST:event_TxtAreaBloggTextFocusGained
    
    private String getCurrentDateTime(){
        LocalDate localDate = LocalDate.now();
        return DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
    }
    
    private boolean fileExists(String pathToFile){
        File file = new File(pathToFile);
        return file.exists();
    }
    
    private String findAvailableFileName(String fileName){        
        int i = 1;
        boolean availableNameFound = false;
        while(!availableNameFound){
            String newFileName = "("+i+")"+fileName;
            String folder = System.getProperty("user.dir"); 
            String fileDest = folder + ("\\anvandarFiler\\"+newFileName);
            if(fileExists(fileDest)){
                i++;
            }
            else{
                return fileDest;
            }
        }  
        return null;
    }
    
    private void copyFileToDir(String pathToFile){
        try {
            String separator = "\\";
            String[] arr=pathToFile.replaceAll(Pattern.quote(separator), "\\\\").split("\\\\");
            String fileName = arr[arr.length-1];

            String folder = System.getProperty("user.dir"); 
            String fileDest = folder + ("\\anvandarFiler\\"+fileName);
 
            if(fileExists(fileDest)){
                fileDest = findAvailableFileName(fileName);
            }
                     
            Path src = Paths.get(pathToFile);
            Path dest = Paths.get(fileDest);
            Files.copy(src, dest);

        } catch (IOException ex) {
            System.out.println("Failed copyFileToDir: "+ex);
        }
    }
    
    private void sparaInfoBifogadFil(int bloggpost_id) throws IOException{
        String separator = "\\";
        String[] arr=choosenFile.replaceAll(Pattern.quote(separator), "\\\\").split("\\\\");
        String fileName = arr[arr.length-1];
        
        String folder = System.getProperty("user.dir"); 
        String fileDest = folder + ("\\anvandarFiler\\"+fileName);
      
        copyFileToDir(choosenFile);
        
        try{
            int fil_id = Integer.parseInt(idb.getAutoIncrement("fil", "ID"));
            idb.insert("INSERT INTO FIL (ID, SOKVAG, INFORMATION, SKAPAD) VALUES ('"+fil_id+"', '"+fileDest+"', '"+fileName+"', '"+getCurrentDateTime()+"')");
            idb.insert("INSERT INTO FILER_TILL_BLOGG (FILID, BLOGGID) VALUES ('"+fil_id+"', '"+bloggpost_id+"')");
        }catch(InfException e){
            System.out.println("sparaInfoBifogadFil " + e);
        }
    }
    
    private void cboxSkrivUtKategorier(){
        int i = 1;
        try {
            int antalKategoier = Integer.parseInt(idb.fetchSingle("SELECT COUNT(*) FROM kategori"));
                while(i<=(antalKategoier)){
                    String kategori = idb.fetchSingle("SELECT namn from kategori where id = '" + i + "'");
                    cboxValjKategori.addItem(kategori);
                    i++;          
                }   
        } catch (InfException ex) {
            System.out.println("Kunde inte skriva ut kategorierna till cbox: " + ex.getMessage());
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAddFile;
    private javax.swing.JButton BtnAddPost;
    private javax.swing.JTextArea TxtAreaBloggText;
    private javax.swing.JComboBox<String> cboxValjKategori;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblChoosenFile;
    private javax.swing.JLabel lblConfirmAddedPost;
    private javax.swing.JLabel lblTitel;
    // End of variables declaration//GEN-END:variables
}
