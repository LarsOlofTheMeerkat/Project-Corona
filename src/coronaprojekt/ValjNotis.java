package coronaprojekt;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alice och Julia
 */
public class ValjNotis extends javax.swing.JFrame {
        public static InfDB minDatabaskoppling;



    /**
     * Creates new form ValjNotis
     */
    public ValjNotis(InfDB minDatabaskoppling ) {
        initComponents();
        this.minDatabaskoppling = minDatabaskoppling; 
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

        jRbtnEmail = new javax.swing.JRadioButton();
        jRbtnSms = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jRbtnBada = new javax.swing.JRadioButton();
        txtNamn = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jRbtnEmail.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jRbtnEmail.setForeground(new java.awt.Color(255, 255, 255));
        jRbtnEmail.setText("Email");
        jRbtnEmail.setToolTipText("");

        jRbtnSms.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jRbtnSms.setForeground(new java.awt.Color(255, 255, 255));
        jRbtnSms.setText("Sms");

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jButton1.setText("Välj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jRbtnBada.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jRbtnBada.setForeground(new java.awt.Color(255, 255, 255));
        jRbtnBada.setText("Både Sms & Email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRbtnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jRbtnSms, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jRbtnBada, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRbtnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRbtnSms, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRbtnBada, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jRbtnEmail.isSelected() && isEmpty1(txtNamn)) {
            andraNotisEmail();
            JOptionPane.showMessageDialog(null, "Du har valt att få notiser via email");
        } else if (jRbtnSms.isSelected()&& isEmpty1(txtNamn)) {
            andraNotisSms();
            JOptionPane.showMessageDialog(null, "Du har valt att få notiser via sms");
        }  else if  (jRbtnBada.isSelected()&& isEmpty1(txtNamn)) {
            andraNotisSms();
            andraNotisEmail();
            JOptionPane.showMessageDialog(null, "Du har valt att få notiser via email och sms");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

      
    public void andraNotisEmail() {
        
        try {
            String anvNamn = txtNamn.getText();
        System.out.println("update anvandare set emailnotis  = 'J' where anvandarnamn = '" + anvNamn + "'");
            minDatabaskoppling.update("update anvandare set emailnotis  = 'J' where anvandarnamn = '" + anvNamn + "'");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick visst fel!");
        }
    }
    
    
     
    public void andraNotisSms() {
        
        try {
            String anvNamn = txtNamn.getText();
        System.out.println("update anvandare set emailnotis  = 'J' where anvandarnamn = '" + anvNamn + "'");
            minDatabaskoppling.update("update anvandare set emailnotis  = 'J' where anvandarnamn = '" + anvNamn + "'");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick visst fel!");
        }
    }
    
    
    
     public static boolean isEmpty1(JTextField faltAttKolla) { 
    // Denna metod kollar ifall ett textfält är tomt
        boolean empty = false;
        String txtFalt = faltAttKolla.getText();

        
        if (txtFalt.isEmpty()) {
            empty = true;
            JOptionPane.showMessageDialog(null, "Var god fyll i fältet");

            faltAttKolla.requestFocus();
        }
        return empty;
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
            java.util.logging.Logger.getLogger(ValjNotis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ValjNotis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ValjNotis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ValjNotis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ValjNotis(minDatabaskoppling).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JRadioButton jRbtnBada;
    private javax.swing.JRadioButton jRbtnEmail;
    private javax.swing.JRadioButton jRbtnSms;
    private javax.swing.JTextField txtNamn;
    // End of variables declaration//GEN-END:variables
}
