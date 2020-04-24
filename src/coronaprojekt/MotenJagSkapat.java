/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Main
 */
public class MotenJagSkapat extends javax.swing.JFrame {

    private final InfDB idb;
    private final int anvandareID;
    /**
     * Creates new form MinaMoten
     * @param idb
     */
    public MotenJagSkapat(InfDB idb,int anvandareID) {
        initComponents();
        this.idb=idb;
        this.anvandareID=anvandareID;
        cboxSkrivUtAnvandare();
    }

    
    
    
    private void cboxSkrivUtAnvandare(){
        int i = 0;
        try {
            int antalMotenJagSkapat = Integer.parseInt(idb.fetchSingle("select count(*) from mote where adminid = " + anvandareID));
                while(i<(antalMotenJagSkapat)){
                    //String kategori = idb.fetchSingle("SELECT title from mote where adminid = '" + anvandareID + "'");
                    ArrayList<HashMap<String, String>> titlar = idb.fetchRows("SELECT title from mote where adminid = '" + anvandareID + "'");
                    Object[] minTitlar = titlar.toArray();
                    //String datum = datumTid[0].substring(5,minTitlar[i].toString().length()-1);
                    cboxMinaMoten.addItem(minTitlar[i].toString().substring(7,minTitlar[i].toString().length()-1));
                    i++;          
                }   
        } catch (InfException ex) {
            System.out.println("Kunde inte skriva ut anvandarna till cbox: " + ex.getMessage());
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

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cboxMinaMoten = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listVilkaSomRostat = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        btnVisa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Möten du skapat");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Tider : Antal röster en tid fick");

        jButton1.setText("Besluta markerad tid för mötet");

        jLabel3.setText("Välj mötet att besluta tid för");

        listVilkaSomRostat.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listVilkaSomRostat);

        jLabel4.setText("Vilka som anget tid då de kan ha mötet");

        btnVisa.setText("Visa");
        btnVisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(468, 468, 468)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboxMinaMoten, 0, 238, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3))
                    .addComponent(btnVisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(92, 92, 92)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(101, 101, 101))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboxMinaMoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(btnVisa)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    DefaultListModel modelVilkaSomRostat = new DefaultListModel();
    private void btnVisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaActionPerformed
        String titel = cboxMinaMoten.getSelectedItem().toString(); 
        
        try{
            String moteid = idb.fetchSingle("select id from mote where title = '"+titel+"'");
            //ArrayList<HashMap<String, String>> anvandareid = idb.fetchRows("select anvandareid from rostat_pa_motestider where moteid = "+moteid+"");
            ArrayList<HashMap<String, String>> anvandareid = idb.fetchRows("select anvandareid from rostat_pa_motestider where moteid = 39");
            Object[] minTitlar = anvandareid.toArray();   
            
            for (Object minTitlar1 : minTitlar) {
                modelVilkaSomRostat.addElement(minTitlar1);
            }
            listVilkaSomRostat.setModel(modelVilkaSomRostat);
        
        
        } catch (InfException ex) {
            System.out.println("Kunde inte skriva ut anvandarna till cbox: " + ex.getMessage());
        }
        

    }//GEN-LAST:event_btnVisaActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVisa;
    private javax.swing.JComboBox<String> cboxMinaMoten;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listVilkaSomRostat;
    // End of variables declaration//GEN-END:variables
}