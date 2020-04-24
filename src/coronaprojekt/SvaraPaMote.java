/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Main
 */
public class SvaraPaMote extends javax.swing.JFrame {
    
    private final InfDB idb;
    private final int anvandareID;
    private final String moteTitel;
    /**
     * Creates new form SvaraPaMote
     * @param idb
     * @param anvandareID
     * @param moteTitel
     */
    public SvaraPaMote(InfDB idb, int anvandareID, String moteTitel) {
        initComponents();
        this.idb=idb;  
        this.anvandareID=anvandareID;
        this.moteTitel=moteTitel;
        laddaInfoTillGui();
    }
    
    DefaultListModel foreslagnaTiderModel = new DefaultListModel();
    private void laddaInfoTillGui(){
       
        try{
            String plats = idb.fetchSingle("select plats from mote where title = '"+moteTitel+"'");
            lblPlats.setText("Plats: " +plats);
            String anteckning = idb.fetchSingle("select anteckning from mote where title = '"+moteTitel+"'");
            TxtAreaInfo.setText(anteckning);
            String adminid = idb.fetchSingle("select adminid from mote where title = '"+moteTitel+"'");
            String adminNamn = idb.fetchSingle("select anvandarnamn from anvandare where id = '"+adminid+"'");
            lblRubrik.setText(adminNamn+" bjöd in dig till mötet "+moteTitel);
            String moteid = idb.fetchSingle("select id from mote where title = '"+moteTitel+"'");

            ArrayList<HashMap<String, String>> forslagnaMotesDagar = idb.fetchRows("select dag from foreslagna_motestider where moteid = '"+moteid+"'");
            Object[] arrDagar = forslagnaMotesDagar.toArray();
            ArrayList<HashMap<String, String>> forslagnaMotesTider = idb.fetchRows("select tid from foreslagna_motestider where moteid = '"+moteid+"'");
            Object[] arrTider = forslagnaMotesTider.toArray();
            
            for(int i = 0; i< arrDagar.length;i++){
                foreslagnaTiderModel.addElement(arrDagar[i] +"  kl  "+ arrTider[i]);
            }
            listForeslagnaTider.setModel(foreslagnaTiderModel);
            
            
        }catch(InfException ex){
            System.out.println("Kunde inte hämta data ur DB till gui: " + ex.getMessage());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRubrik = new javax.swing.JLabel();
        lblPlats = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtAreaInfo = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listForeslagnaTider = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listValdaTider = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRubrik.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblRubrik.setText("pelle pelleson bjöd in dig till mötet Rosa Point");

        lblPlats.setText("plats: uni bibloteket");

        TxtAreaInfo.setEditable(false);
        TxtAreaInfo.setColumns(20);
        TxtAreaInfo.setLineWrap(true);
        TxtAreaInfo.setRows(5);
        jScrollPane1.setViewportView(TxtAreaInfo);

        jLabel1.setText("Information om mötet:");

        jScrollPane2.setViewportView(listForeslagnaTider);

        jLabel2.setText("Välj tiderna för mötet som passar dig:");

        jButton1.setText("Välj  tid");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(listValdaTider);

        jLabel3.setText("Tiderna du valt:");

        jButton2.setText("Ta bort en vald tid");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Klar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPlats)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(105, 105, 105)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel2)))
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(jLabel3))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(lblRubrik)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblRubrik)
                .addGap(30, 30, 30)
                .addComponent(lblPlats, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    DefaultListModel valdaTiderModel = new DefaultListModel();
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        valdaTiderModel.addElement(listForeslagnaTider.getSelectedValue());
        listValdaTider.setModel(valdaTiderModel);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        valdaTiderModel.removeElementAt(listValdaTider.getSelectedIndex());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Object[] datumTider = valdaTiderModel.toArray();              
        try{
            for(int i = 0; i< valdaTiderModel.getSize();i++){
                String forslagnaDatumTid = String.valueOf(datumTider[i]).replaceAll("\\s+","");
                String[] datumTid = forslagnaDatumTid.split("kl");
                String tid = datumTid[1].substring(5,datumTid[1].length()-1);
                String datum = datumTid[0].substring(5,datumTid[0].length()-1);
                                 
                int id = Integer.parseInt(idb.getAutoIncrement("ROSTAT_PA_MOTESTIDER", "id"));
                String moteid = idb.fetchSingle("select id from mote where title = '"+moteTitel+"'"); 
                idb.insert("INSERT INTO ROSTAT_PA_MOTESTIDER (ID, MOTEID, TID, DAG, ANVANDAREID) VALUES ("+id+", "+moteid+", '"+tid+"', '"+datum+"', "+anvandareID+")");
            }         
        }catch(InfException ex){
            System.out.println("Kunde inte lägg in data i DB: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TxtAreaInfo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblPlats;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JList<String> listForeslagnaTider;
    private javax.swing.JList<String> listValdaTider;
    // End of variables declaration//GEN-END:variables
}