/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import oru.inf.InfDB;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import java.lang.IllegalArgumentException;
import oru.inf.InfException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import javax.swing.*; 
import java.awt.event.*;
/**
 *
 * @author Simon Sandberg
 */
public class hamta_blogg extends javax.swing.JFrame {
    public static InfDB minDatabaskoppling;
    /**
     * Creates new form Main_Page
     */
    public hamta_blogg(InfDB minDatabaskoppling) {
        initComponents();
        initMainWindow();
                this.minDatabaskoppling = minDatabaskoppling; 

    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main_Window_Pane");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setName("main_Page_JFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(null);

        jPanel1.setLayout(new java.awt.GridLayout(10, 2, 5, 5));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 120, 1440, 790);

        jButton1.setText("Hämta informella");
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 30, 190, 23);

        jButton2.setText("Hämta formella");
        getContentPane().add(jButton2);
        jButton2.setBounds(220, 30, 200, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Page(minDatabaskoppling).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private Color hoverColorBtn = new Color(41, 205, 255, 200);
    private Color baseColorBtn = new Color(3, 194, 252, 150);
    private Color clickedColorBtn = new Color(117, 223, 255, 200);
    //Initierar alla delar av huvud UI
    public void initMainWindow()
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
      
        System.out.println("Init of Main Page Complete");    
    };
}
