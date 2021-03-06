/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import coronaprojekt.Blogg;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author filip
 */
public class NewsFeed_1 extends javax.swing.JFrame {

    private static InfDB idb;
    private int limit;

    public NewsFeed_1(InfDB idb) {
        initComponents();
        this.idb = idb;
        limit = 5;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtFeed = new javax.swing.JTextArea();
        jBtnMer = new javax.swing.JButton();
        lblBild = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();
        lblText = new javax.swing.JLabel();
        lblSkapad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtFeed.setColumns(20);
        txtFeed.setRows(5);
        jScrollPane1.setViewportView(txtFeed);

        jBtnMer.setText("Visa inlägg");
        jBtnMer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMerActionPerformed(evt);
            }
        });

        lblBild.setText("Bild här");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtnMer, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSkapad)
                            .addComponent(lblText)
                            .addComponent(lblNamn)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(lblBild)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnMer)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(lblNamn)
                .addGap(2, 2, 2)
                .addComponent(lblBild)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblText)
                .addGap(28, 28, 28)
                .addComponent(lblSkapad)
                .addContainerGap(325, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnMerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMerActionPerformed

        try {
            
            String id = "";
            ArrayList inlagg = hamtaBloggInlaggMedAnvandare(hamtaFormellaBloggInlagg());
            Iterator itr = inlagg.iterator();
            while (itr.hasNext()) {
                
                HashMap<String, String> map = (HashMap<String, String>) itr.next();
                id = (String) map.get("ANVANDAREID");
                
                
            }
            
            System.out.println(id);
            
            String hamtaFilID = idb.fetchSingle("SELECT FILID FROM FILER_TILL_BLOGG WHERE BLOGGID = " + id);
            String hamtaBild = idb.fetchSingle("SELECT SOKVAG FROM FIL WHERE ID = " + hamtaFilID);
            
            try {
                System.out.println(hamtaBild);
                
                BufferedImage bild = ImageIO.read(new File(hamtaBild));
                ImageIcon ikon = new ImageIcon(bild);
                lblBild.setIcon(ikon);
            } catch (IOException ex) {
                Logger.getLogger(NewsFeed.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (InfException ex) {
            Logger.getLogger(NewsFeed.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jBtnMerActionPerformed

    //Jacobs pro-kod
    public ArrayList hamtaInformellaBloggInlagg() {

        ArrayList<HashMap<String, String>> res = new ArrayList();
        try {
            String fraga = "SELECT * FROM BLOGG WHERE INFORMELL = 'J' ORDER BY skapad DESC rows 1 to " + limit;
            res = this.idb.fetchRows(fraga);

        } catch (InfException e) {
            System.out.println(e);
            System.out.println("Something went wrong");
        }

        return res;

    }

    public ArrayList hamtaFormellaBloggInlagg() {

        ArrayList<HashMap<String, String>> res = new ArrayList();
        try {

            String fraga = "SELECT * FROM BLOGG WHERE INFORMELL = 'N' ORDER BY SKAPAD DESC ROWS 1 TO " + limit;
            res = this.idb.fetchRows(fraga);

        } catch (InfException e) {
            System.out.println(e);
            System.out.println("Something went wrong");

        }

        return res;
    }

    public ArrayList hamtaArtikelInlagg() {

        ArrayList<HashMap<String, String>> res = new ArrayList();
        try {
            String fraga = "SELECT * FROM ARTIKEL ORDER BY SKAPAD DESC ROWS 1 TO " + limit;
            res = this.idb.fetchRows(fraga);

        } catch (InfException e) {
            System.out.println(e);
            System.out.println("Something went wrong");

        }
        return res;
    }

    public ArrayList hamtaArtikelMedAnvandare(ArrayList<HashMap<String, String>> artikel) {

        ArrayList<HashMap<String, String>> res = new ArrayList();
        try {

            String fraga = "";
            HashMap<String, String> res1 = new HashMap<>();
            HashMap<String, String> newRow = new HashMap<>();
            for (int i = 0; i < artikel.size(); i++) {

                fraga = "SELECT * FROM ANVANDARE WHERE ID = " + artikel.get(i).get("ANVANDAREID");
                res1 = this.idb.fetchRow(fraga);
                newRow.put("ANVANDAREID", artikel.get(i).get("ANVANDAREID"));
                newRow.put("NAMN", res1.get("NAMN"));
                newRow.put("TEXT", artikel.get(i).get("TEXT"));
                newRow.put("SKAPAD", artikel.get(i).get("SKAPAD"));
                res.add(newRow);
            }

        } catch (InfException fel) {
            System.out.println(fel);
            System.out.println("Something went wrong");

        }
        return res;
    }

    public ArrayList hamtaBloggInlaggMedAnvandare(ArrayList<HashMap<String, String>> bloggar) {

        ArrayList<HashMap<String, String>> res = new ArrayList();
        try {
            String fraga = "";
            HashMap<String, String> res1 = new HashMap<>();
            HashMap<String, String> newRow = new HashMap<>();
            for (int i = 0; i < bloggar.size(); i++) {
                fraga = "SELECT * FROM ANVANDARE WHERE ID = " + bloggar.get(i).get("ANVANDAREID");
                res1 = this.idb.fetchRow(fraga);
                newRow.put("ANVANDAREID", bloggar.get(i).get("ANVANDAREID"));
                newRow.put("NAMN", res1.get("NAMN"));
                newRow.put("TEXT", bloggar.get(i).get("TEXT"));
                newRow.put("INFORMELL", bloggar.get(i).get("INFORMELL"));
                newRow.put("SKAPAD", bloggar.get(i).get("SKAPAD"));
                res.add(newRow);
            }

        } catch (InfException e) {
            System.out.println(e);
            System.out.println("Something went wrong");
        }

        return res;

    }

    public void visaInformell() {

        //nollställer TextArea
        txtFeed.setLineWrap(true);
        txtFeed.setText("");

        //Instansierar variablar
        String id = "";
        String namn = "";
        String text = "";
        String skapad = "";

        //lägger blogginlägg/artiklar i lokalvariabel
        ArrayList inlagg = hamtaBloggInlaggMedAnvandare(hamtaInformellaBloggInlagg());

        //Hämtar data från inlägg som sparas i variablarna
        Iterator itr = inlagg.iterator();
        while (itr.hasNext()) {

            HashMap<String, String> map = (HashMap<String, String>) itr.next();
            id = (String) map.get("ANVANDAREID");
            namn = (String) map.get("NAMN");
            text = (String) map.get("TEXT");
            skapad = (String) map.get("SKAPAD");

        }

        //Informationen visas på TextArea 
        txtFeed.append(id + "\n\n");
        txtFeed.append(namn + "\n\n");
        txtFeed.append(text + "\n\n");
        txtFeed.append(skapad + "\n\n");

    }

    public void visaFormell() {

        //nollställer TextArea samt fixa så att texten hoppar ned en rad
        txtFeed.setLineWrap(true);
        txtFeed.setText("");

        //Instansierar variablar
        String id = "";
        String namn = "";
        String text = "";
        String skapad = "";

        //lägger blogginlägg/artiklar i lokalvariabel
        ArrayList inlagg = hamtaBloggInlaggMedAnvandare(hamtaFormellaBloggInlagg());

        //Hämtar data från inlägg som sparas i variablarna
        Iterator itr = inlagg.iterator();
        while (itr.hasNext()) {

            HashMap<String, String> map = (HashMap<String, String>) itr.next();
            id = (String) map.get("ANVANDAREID");
            namn = (String) map.get("NAMN");
            text = (String) map.get("TEXT");
            skapad = (String) map.get("SKAPAD");

        }

        //Informationen visas på TextArea 
        txtFeed.append(namn + "\n\n");
        txtFeed.append(text + "\n\n");
        txtFeed.append(skapad + "\n\n");

    }

    public void visaArtikel() {

        //nollställer TextArea samt fixa så att texten hoppar ned en rad
        txtFeed.setLineWrap(true);
        txtFeed.setText("");

        //Instansierar variablar
        String id = "";
        String namn = "";
        String text = "";
        String skapad = "";

        //lägger blogginlägg/artiklar i lokalvariabel
        ArrayList inlagg = hamtaBloggInlaggMedAnvandare(hamtaArtikelInlagg());

        //Hämtar data från inlägg som sparas i variablarna
        Iterator itr = inlagg.iterator();
        while (itr.hasNext()) {

            HashMap<String, String> map = (HashMap<String, String>) itr.next();
            id = (String) map.get("ANVANDAREID");
            namn = (String) map.get("NAMN");
            text = (String) map.get("TEXT");
            skapad = (String) map.get("SKAPAD");

        }

        //Informationen visas på TextArea 
        txtFeed.append(namn + "\n\n");
        txtFeed.append(text + "\n\n");
        txtFeed.append(skapad + "\n\n");

    }

    public void visaBild() throws IOException, InfException {

        //String bloggFil = "SELECT SOKVAG, FIL.ID, BLOGG.ID FROM FIL JOIN FILER_TILL_BLOGG ON FIL.ID = FILID JOIN BLOGG ON BLOGGID = BLOGG.ID"; 
        //String bloggID = "SELECT ID FROM BLOGG";
        //String filID = "SELECT ID FROM FIL";
        //ArrayList<HashMap<String, String>> inlagg
         String id = "";
        ArrayList inlagg = hamtaBloggInlaggMedAnvandare(hamtaFormellaBloggInlagg());
        Iterator itr = inlagg.iterator();
        while (itr.hasNext()) {

            HashMap<String, String> map = (HashMap<String, String>) itr.next();
            id = (String) map.get("ANVANDAREID");
            

        }
        
        String hamtaFilID = "SELECT FILID FROM FILER_TILL_BLOGG WHERE BLOGGID = " + id;
        String hamtaBild = "SELECT SOKVAG FROM FIL WHERE ID = " + hamtaFilID;
        
        try {
            

            BufferedImage bild = ImageIO.read(new File(hamtaBild));
            ImageIcon ikon = new ImageIcon(bild);
            lblBild.setIcon(ikon);
        } catch (IOException ex) {
            Logger.getLogger(NewsFeed.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewsFeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewsFeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewsFeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewsFeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewsFeed(idb).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnMer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBild;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblSkapad;
    private javax.swing.JLabel lblText;
    private javax.swing.JTextArea txtFeed;
    // End of variables declaration//GEN-END:variables
}
