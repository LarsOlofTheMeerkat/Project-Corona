/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import java.util.Date;
import javax.swing.DefaultListModel;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Main
 */
public class KallaTillMote extends javax.swing.JFrame {
    
    private final InfDB idb;
    private final int anvandareID;
    //private String[] forslagnaDatum;
    /**
     * Creates new form KallaTillMote
     * @param idb
     * @param anvandareID
     */
    public KallaTillMote(InfDB idb, int anvandareID) {
        initComponents();
        this.idb=idb;  
        cboxSkrivUtAnvandare();
        this.anvandareID=anvandareID;
        
        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
    }


    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfTitle = new java.awt.TextField();
        lblAngeTitle = new javax.swing.JLabel();
        tfPlats = new java.awt.TextField();
        lblAngePlats = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareaAnteckning = new javax.swing.JTextArea();
        lblAnteckning = new javax.swing.JLabel();
        lblGeforslagDatum = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        lblForeslagnaDatum = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listDatum = new javax.swing.JList<>();
        btnLaggTillForslag = new javax.swing.JButton();
        btnTaBortForslag = new javax.swing.JButton();
        lblBjudINTillMotet = new javax.swing.JLabel();
        cboxPersoner = new javax.swing.JComboBox<>();
        btnLaggTillPerson = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listPersonerAttBjudaIn = new javax.swing.JList<>();
        btnTaBortEnPerson = new javax.swing.JButton();
        lblPersonerAttBjudaIn = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tfTidFran = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Organisera ett möte");

        lblAngeTitle.setText("Ange title:");

        lblAngePlats.setText("Ange plats:");

        txtareaAnteckning.setColumns(20);
        txtareaAnteckning.setLineWrap(true);
        txtareaAnteckning.setRows(5);
        txtareaAnteckning.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtareaAnteckning);

        lblAnteckning.setText("Anteckning:");

        lblGeforslagDatum.setText("Ge förslag när ni ska träffas");

        lblForeslagnaDatum.setText("Datumen du föreslagit:");

        jScrollPane2.setViewportView(listDatum);

        btnLaggTillForslag.setText("Lägg till förslaget");
        btnLaggTillForslag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillForslagActionPerformed(evt);
            }
        });

        btnTaBortForslag.setText("Ta bort förslag");
        btnTaBortForslag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortForslagActionPerformed(evt);
            }
        });

        lblBjudINTillMotet.setText("Bjud in personer till mötet:");

        btnLaggTillPerson.setText("Lägg till personen");
        btnLaggTillPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillPersonActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(listPersonerAttBjudaIn);

        btnTaBortEnPerson.setText("Ta bort en person");
        btnTaBortEnPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortEnPersonActionPerformed(evt);
            }
        });

        lblPersonerAttBjudaIn.setText("Personerna du vill bjuda in:");

        jButton1.setText("Klar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tfTidFran.setColumns(5);
        tfTidFran.setText("07:15");

        jLabel3.setText("Tid:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAngeTitle)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblAnteckning)
                                .addComponent(tfPlats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1)
                                .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblAngePlats))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(140, 140, 140)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(tfTidFran, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(81, 81, 81))
                                                .addComponent(lblGeforslagDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(btnLaggTillForslag, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(155, 155, 155)
                                        .addComponent(lblForeslagnaDatum))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(127, 127, 127)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnTaBortForslag, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(174, 174, 174)
                                        .addComponent(lblPersonerAttBjudaIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(164, 164, 164)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnTaBortEnPerson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblBjudINTillMotet)
                                        .addGap(32, 32, 32))
                                    .addComponent(btnLaggTillPerson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboxPersoner, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(82, 82, 82))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(420, 1015, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(327, 327, 327))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAngeTitle)
                            .addComponent(lblBjudINTillMotet))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAngePlats, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(tfPlats, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboxPersoner, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLaggTillPerson)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblAnteckning)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblPersonerAttBjudaIn)
                                .addGap(18, 18, 18))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(lblGeforslagDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTidFran, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLaggTillForslag)
                        .addGap(40, 40, 40)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblForeslagnaDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTaBortForslag)
                            .addComponent(btnTaBortEnPerson)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    DefaultListModel modelDatum = new DefaultListModel();
    private void btnLaggTillForslagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillForslagActionPerformed
        Date date = jDateChooser.getDate();
        Kalender kalender = new Kalender();
        String datum = kalender.convertDateToString(String.valueOf(date));      
        String tid = tfTidFran.getText();
        modelDatum.addElement(datum +"  kl  "+ tid);
        listDatum.setModel(modelDatum);  
        jDateChooser.setCalendar(null);  
    }//GEN-LAST:event_btnLaggTillForslagActionPerformed

    private void btnTaBortForslagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortForslagActionPerformed
        modelDatum.removeElementAt(listDatum.getSelectedIndex());
    }//GEN-LAST:event_btnTaBortForslagActionPerformed

    DefaultListModel modelAnvandare = new DefaultListModel();
    private void btnLaggTillPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillPersonActionPerformed
        String anvandare = cboxPersoner.getSelectedItem().toString();
        jDateChooser.setCalendar(null);     
        modelAnvandare.addElement(anvandare);
        listPersonerAttBjudaIn.setModel(modelAnvandare); 
    }//GEN-LAST:event_btnLaggTillPersonActionPerformed

    private void btnTaBortEnPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortEnPersonActionPerformed
        modelAnvandare.removeElementAt(listPersonerAttBjudaIn.getSelectedIndex());
    }//GEN-LAST:event_btnTaBortEnPersonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String title = tfTitle.getText();
        String plats = tfPlats.getText();
        String anteckning = txtareaAnteckning.getText();

        Object[] datum = modelDatum.toArray();
        Object[] anvandare = modelAnvandare.toArray();
        
        try{ 
            int moteid = Integer.parseInt(idb.getAutoIncrement("mote", "id"));
            idb.insert("INSERT INTO MOTE (ID, TID, DAG, ADMINID, TITLE, ANTECKNING, PLATS) VALUES ("+moteid+", '"+""+"', '"+""+"', "+anvandareID+", '"+title+"', '"+anteckning+"', '"+plats+"')");
            System.out.println("INSERT INTO MOTE (ID, TID, DAG, ADMINID, TITLE, ANTECKNING, PLATS) VALUES ("+moteid+", '"+""+"', '"+""+"', "+anvandareID+", '"+title+"', '"+anteckning+"', '"+plats+"')");
            for(int i = 0; i< modelAnvandare.getSize();i++){
                int id = Integer.parseInt(idb.getAutoIncrement("deltar", "id"));
                String fraga = "SELECT id from anvandare where anvandarnamn = '"+anvandare[i]+"'";
                int anvandarIdAttBjudaIn = Integer.parseInt(idb.fetchSingle(fraga));         
                idb.insert("INSERT INTO DELTAR (ID, MOTEID, ANVANDAREID) VALUES ("+id+", "+moteid+", "+anvandarIdAttBjudaIn+")");
                System.out.println("INSERT INTO DELTAR (ID, MOTEID, ANVANDAREID) VALUES ("+id+", "+moteid+", "+anvandarIdAttBjudaIn+")");
            } 
            
            for(int i = 0; i< modelDatum.getSize();i++){
                String forslagnaDatumTid = String.valueOf(datum[i]).replaceAll("\\s+","");
                String[] datumTid = forslagnaDatumTid.split("kl");
                int id = Integer.parseInt(idb.getAutoIncrement("FORESLAGNA_MOTESTIDER", "id"));  
                idb.insert("INSERT INTO FORESLAGNA_MOTESTIDER (ID, MOTEID, TID, DAG) VALUES ("+id+", "+moteid+", '"+datumTid[1]+"', '"+datumTid[0]+"')");
                System.out.println("INSERT INTO FORESLAGNA_MOTESTIDER (ID, MOTEID, TID, DAG) VALUES ("+id+", "+moteid+", '"+datumTid[1]+"', '"+datumTid[0]+"')");
            }    
        }catch(InfException ex){
            System.out.println("Kunde inte lägga in mötet i databasen: " + ex.getMessage());
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
        private void cboxSkrivUtAnvandare(){
        int i = 1;
        try {
            int antalKategoier = Integer.parseInt(idb.fetchSingle("SELECT COUNT(*) FROM anvandare"));
                while(i<=(antalKategoier)){
                    String kategori = idb.fetchSingle("SELECT namn from anvandare where id = '" + i + "'");
                    cboxPersoner.addItem(kategori);
                    i++;          
                }   
        } catch (InfException ex) {
            System.out.println("Kunde inte skriva ut anvandarna till cbox: " + ex.getMessage());
        }
    }
   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaggTillForslag;
    private javax.swing.JButton btnLaggTillPerson;
    private javax.swing.JButton btnTaBortEnPerson;
    private javax.swing.JButton btnTaBortForslag;
    private javax.swing.JComboBox<String> cboxPersoner;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAngePlats;
    private javax.swing.JLabel lblAngeTitle;
    private javax.swing.JLabel lblAnteckning;
    private javax.swing.JLabel lblBjudINTillMotet;
    private javax.swing.JLabel lblForeslagnaDatum;
    private javax.swing.JLabel lblGeforslagDatum;
    private javax.swing.JLabel lblPersonerAttBjudaIn;
    private javax.swing.JList<String> listDatum;
    private javax.swing.JList<String> listPersonerAttBjudaIn;
    private java.awt.TextField tfPlats;
    private javax.swing.JTextField tfTidFran;
    private java.awt.TextField tfTitle;
    private javax.swing.JTextArea txtareaAnteckning;
    // End of variables declaration//GEN-END:variables
}
