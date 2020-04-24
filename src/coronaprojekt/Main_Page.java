/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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
public class Main_Page extends javax.swing.JFrame {

    public static InfDB minDatabaskoppling;

    /**
     * Creates new form Main_Page
     */
    public Main_Page(InfDB minDatabaskoppling) {
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

        jPanel2 = new javax.swing.JPanel();
        formel_Blogg_btn = new javax.swing.JPanel();
        formBlg_Lbl = new javax.swing.JLabel();
        informell_Blogg_btn = new javax.swing.JPanel();
        informBlg_Lbl = new javax.swing.JLabel();
        notis_btn = new javax.swing.JPanel();
        notis_lbl = new javax.swing.JLabel();
        projects_btn1 = new javax.swing.JPanel();
        projBtn_Lbl1 = new javax.swing.JLabel();
        notis_btn1 = new javax.swing.JPanel();
        notis_lbl1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main_Window_Pane");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setName("main_Page_JFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        formel_Blogg_btn.setBackground(new java.awt.Color(3, 194, 252));
        formel_Blogg_btn.setPreferredSize(new java.awt.Dimension(480, 100));
        formel_Blogg_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formel_Blogg_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formel_Blogg_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formel_Blogg_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formel_Blogg_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formel_Blogg_btnMouseReleased(evt);
            }
        });
        formel_Blogg_btn.setLayout(new java.awt.BorderLayout());

        formBlg_Lbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        formBlg_Lbl.setForeground(new java.awt.Color(255, 255, 255));
        formBlg_Lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        formBlg_Lbl.setText("Formel Blogg");
        formBlg_Lbl.setMaximumSize(new java.awt.Dimension(300, 25));
        formBlg_Lbl.setPreferredSize(new java.awt.Dimension(300, 25));
        formBlg_Lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formBlg_LblMouseClicked(evt);
            }
        });
        formel_Blogg_btn.add(formBlg_Lbl, java.awt.BorderLayout.CENTER);

        informell_Blogg_btn.setBackground(new java.awt.Color(3, 194, 252));
        informell_Blogg_btn.setPreferredSize(new java.awt.Dimension(480, 100));
        informell_Blogg_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                informell_Blogg_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                informell_Blogg_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                informell_Blogg_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                informell_Blogg_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                informell_Blogg_btnMouseReleased(evt);
            }
        });
        informell_Blogg_btn.setLayout(new java.awt.BorderLayout());

        informBlg_Lbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        informBlg_Lbl.setForeground(new java.awt.Color(255, 255, 255));
        informBlg_Lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informBlg_Lbl.setText("Informell Blogg");
        informBlg_Lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                informBlg_LblMouseClicked(evt);
            }
        });
        informell_Blogg_btn.add(informBlg_Lbl, java.awt.BorderLayout.CENTER);

        notis_btn.setBackground(new java.awt.Color(3, 194, 252));
        notis_btn.setForeground(new java.awt.Color(255, 255, 255));
        notis_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                notis_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                notis_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                notis_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                notis_btnMouseReleased(evt);
            }
        });
        notis_btn.setLayout(new java.awt.BorderLayout());

        notis_lbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        notis_lbl.setForeground(new java.awt.Color(255, 255, 255));
        notis_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notis_lbl.setText("Notiser");
        notis_btn.add(notis_lbl, java.awt.BorderLayout.CENTER);

        projects_btn1.setBackground(new java.awt.Color(3, 194, 252));
        projects_btn1.setPreferredSize(new java.awt.Dimension(480, 100));
        projects_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projects_btn1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                projects_btn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                projects_btn1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                projects_btn1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                projects_btn1MouseReleased(evt);
            }
        });
        projects_btn1.setLayout(new java.awt.BorderLayout());

        projBtn_Lbl1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        projBtn_Lbl1.setForeground(new java.awt.Color(255, 255, 255));
        projBtn_Lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        projBtn_Lbl1.setText("Projekt");
        projBtn_Lbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projBtn_Lbl1MouseClicked(evt);
            }
        });
        projects_btn1.add(projBtn_Lbl1, java.awt.BorderLayout.CENTER);

        notis_btn1.setBackground(new java.awt.Color(3, 194, 252));
        notis_btn1.setForeground(new java.awt.Color(255, 255, 255));
        notis_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                notis_btn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                notis_btn1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                notis_btn1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                notis_btn1MouseReleased(evt);
            }
        });
        notis_btn1.setLayout(new java.awt.BorderLayout());

        notis_lbl1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        notis_lbl1.setForeground(new java.awt.Color(255, 255, 255));
        notis_lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notis_lbl1.setText("Notiser");
        notis_btn1.add(notis_lbl1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(0, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(980, 980, 980)
                .addComponent(projects_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(notis_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(formel_Blogg_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(informell_Blogg_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1925, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(1936, 1936, 1936)
                    .addComponent(notis_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(231, 231, 231)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notis_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projects_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(997, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(notis_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(formel_Blogg_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(informell_Blogg_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(14, 14, 14)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Funktioner som hanterar hur UI regerar när användaren rör sin mus över och klickar på delar av UI
    private void formel_Blogg_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formel_Blogg_btnMouseEntered
        formel_Blogg_btn.setBackground(hoverColorBtn);
        formel_Blogg_btn.setVisible(false);
        formel_Blogg_btn.setVisible(true);
    }//GEN-LAST:event_formel_Blogg_btnMouseEntered

    private void formel_Blogg_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formel_Blogg_btnMouseExited
        formel_Blogg_btn.setBackground(baseColorBtn);
        formel_Blogg_btn.setVisible(false);
        formel_Blogg_btn.setVisible(true);
    }//GEN-LAST:event_formel_Blogg_btnMouseExited

    private void informell_Blogg_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_informell_Blogg_btnMouseEntered
        informell_Blogg_btn.setBackground(hoverColorBtn);
        informell_Blogg_btn.setVisible(false);
        informell_Blogg_btn.setVisible(true);
    }//GEN-LAST:event_informell_Blogg_btnMouseEntered

    private void informell_Blogg_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_informell_Blogg_btnMouseExited
        informell_Blogg_btn.setBackground(baseColorBtn);
        informell_Blogg_btn.setVisible(false);
        informell_Blogg_btn.setVisible(true);
    }//GEN-LAST:event_informell_Blogg_btnMouseExited

    private void notis_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notis_btnMouseEntered
        notis_btn.setBackground(hoverColorBtn);
        notis_btn.setVisible(false);
        notis_btn.setVisible(true);
    }//GEN-LAST:event_notis_btnMouseEntered

    private void notis_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notis_btnMouseExited
        notis_btn.setBackground(baseColorBtn);
        notis_btn.setVisible(false);
        notis_btn.setVisible(true);
    }//GEN-LAST:event_notis_btnMouseExited

    private void formel_Blogg_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formel_Blogg_btnMouseReleased
        formel_Blogg_btn.setBackground(hoverColorBtn);
        formel_Blogg_btn.setVisible(false);
        formel_Blogg_btn.setVisible(true);
    }//GEN-LAST:event_formel_Blogg_btnMouseReleased

    private void formel_Blogg_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formel_Blogg_btnMousePressed
        formel_Blogg_btn.setBackground(clickedColorBtn);
        formel_Blogg_btn.setVisible(false);
        formel_Blogg_btn.setVisible(true);
    }//GEN-LAST:event_formel_Blogg_btnMousePressed

    private void informell_Blogg_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_informell_Blogg_btnMousePressed
        informell_Blogg_btn.setBackground(clickedColorBtn);
        informell_Blogg_btn.setVisible(false);
        informell_Blogg_btn.setVisible(true);
    }//GEN-LAST:event_informell_Blogg_btnMousePressed

    private void informell_Blogg_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_informell_Blogg_btnMouseReleased
        informell_Blogg_btn.setBackground(hoverColorBtn);
        informell_Blogg_btn.setVisible(false);
        informell_Blogg_btn.setVisible(true);
    }//GEN-LAST:event_informell_Blogg_btnMouseReleased

    private void notis_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notis_btnMousePressed
        notis_btn.setBackground(clickedColorBtn);
        notis_btn.setVisible(false);
        notis_btn.setVisible(true);
    }//GEN-LAST:event_notis_btnMousePressed

    private void notis_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notis_btnMouseReleased
        notis_btn.setBackground(hoverColorBtn);
        notis_btn.setVisible(false);
        notis_btn.setVisible(true);
    }//GEN-LAST:event_notis_btnMouseReleased
    //En klick funktion, i dem här ska alla länkar till andra metoder och klasser ligga
    private void formel_Blogg_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formel_Blogg_btnMouseClicked


    }//GEN-LAST:event_formel_Blogg_btnMouseClicked
    //klick Funktion
    private void informell_Blogg_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_informell_Blogg_btnMouseClicked


    }//GEN-LAST:event_informell_Blogg_btnMouseClicked

    private void formBlg_LblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formBlg_LblMouseClicked
        System.out.println("Formella");

        Blogg inlagg = new Blogg(this.minDatabaskoppling, 5);
        ArrayList<HashMap<String, String>> inlaggen = inlagg.hamtaFormellaBloggInlagg();
        ArrayList<HashMap<String, String>> formellaBloggInlaggMedAnvandare = inlagg.hamtaBloggInlaggMedAnvandare(inlaggen);

        jPanel1.removeAll();

        //jScrollPane1.getViewport().add(tabellen, null);
        javax.swing.JLabel hej = new JLabel();
        hej.setText("Här visas alla formella inlägg");
        jPanel1.add(hej, null);
        for (int i = 0; i < formellaBloggInlaggMedAnvandare.size(); i++) {

            // hämta kommentarer till blog
            ArrayList kommentarer = new Kommentar(minDatabaskoppling)
                    .hamtaKommentarerTillBlogg(Integer.parseInt(formellaBloggInlaggMedAnvandare.get(i).get("ID")));

            hej = new JLabel();
            javax.swing.JLabel hej2 = new JLabel();
            ettInlagg ettInlagg1 = new ettInlagg(this.minDatabaskoppling, formellaBloggInlaggMedAnvandare.get(i), 1, kommentarer);

            //ettInlagg1.setPost();
            hej.setText(ettInlagg1.getRubrik());
            hej2.setText(ettInlagg1.getSkapad());

            JButton btn = ettInlagg1.getButton();

            jPanel1.add(hej, null);
            jPanel1.add(hej2, null);
            jPanel1.add(btn, null);

        }
        // uppdatera jframe
        //frame.setVisible(true);
        //GridLayout boxlayout = new GridLayout(0,1);
        //jPanel1.setLayout(boxlayout);
        /*JScrollPane panelPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);*/
        //jPanel1.add(panel);

        SwingUtilities.updateComponentTreeUI(this);

    }//GEN-LAST:event_formBlg_LblMouseClicked

    private void informBlg_LblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_informBlg_LblMouseClicked
        System.out.println("informella");

        Blogg inlagg = new Blogg(this.minDatabaskoppling, 5);
        ArrayList<HashMap<String, String>> inlaggen = inlagg.hamtaInformellaBloggInlagg();
        ArrayList<HashMap<String, String>> informellaBloggInlaggMedAnvandare = inlagg.hamtaBloggInlaggMedAnvandare(inlaggen);

        jPanel1.removeAll();

        //jScrollPane1.getViewport().add(tabellen, null);
        javax.swing.JLabel hej = new JLabel();
        hej.setText("Här visas alla informella inlägg");
        jPanel1.add(hej, null);
        for (int i = 0; i < informellaBloggInlaggMedAnvandare.size(); i++) {

            // hämta kommentarer till blog
            ArrayList kommentarer = new Kommentar(minDatabaskoppling)
                    .hamtaKommentarerTillBlogg(Integer.parseInt(informellaBloggInlaggMedAnvandare.get(i).get("ID")));

            hej = new JLabel();
            javax.swing.JLabel hej2 = new JLabel();
            ettInlagg ettInlagg1 = new ettInlagg(this.minDatabaskoppling, informellaBloggInlaggMedAnvandare.get(i), 1, kommentarer);

            //ettInlagg1.setPost();
            hej.setText(ettInlagg1.getRubrik());
            hej2.setText(ettInlagg1.getSkapad());

            JButton btn = ettInlagg1.getButton();

            jPanel1.add(hej, null);
            jPanel1.add(hej2, null);
            jPanel1.add(btn, null);

        }
        // uppdatera jframe
        //frame.setVisible(true);
        //GridLayout boxlayout = new GridLayout(0,1);
        //jPanel1.setLayout(boxlayout);
        /*JScrollPane panelPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);*/
        //jPanel1.add(panel);

        SwingUtilities.updateComponentTreeUI(this);

    }//GEN-LAST:event_informBlg_LblMouseClicked

    private void projBtn_Lbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projBtn_Lbl1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_projBtn_Lbl1MouseClicked

    private void projects_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projects_btn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_projects_btn1MouseClicked

    private void projects_btn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projects_btn1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_projects_btn1MouseEntered

    private void projects_btn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projects_btn1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_projects_btn1MouseExited

    private void projects_btn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projects_btn1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_projects_btn1MousePressed

    private void projects_btn1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projects_btn1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_projects_btn1MouseReleased

    private void notis_btn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notis_btn1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_notis_btn1MouseEntered

    private void notis_btn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notis_btn1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_notis_btn1MouseExited

    private void notis_btn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notis_btn1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_notis_btn1MousePressed

    private void notis_btn1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notis_btn1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_notis_btn1MouseReleased

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
    private javax.swing.JLabel formBlg_Lbl;
    private javax.swing.JPanel formel_Blogg_btn;
    private javax.swing.JLabel informBlg_Lbl;
    private javax.swing.JPanel informell_Blogg_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel notis_btn;
    private javax.swing.JPanel notis_btn1;
    private javax.swing.JLabel notis_lbl;
    private javax.swing.JLabel notis_lbl1;
    private javax.swing.JLabel projBtn_Lbl1;
    private javax.swing.JPanel projects_btn1;
    // End of variables declaration//GEN-END:variables

    private Color hoverColorBtn = new Color(41, 205, 255, 200);
    private Color baseColorBtn = new Color(3, 194, 252, 150);
    private Color clickedColorBtn = new Color(117, 223, 255, 200);

    //Initierar alla delar av huvud UI
    public void initMainWindow() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        formel_Blogg_btn.setBackground(baseColorBtn);

        informell_Blogg_btn.setBackground(baseColorBtn);

        notis_btn.setBackground(baseColorBtn);

        jPanel2.setOpaque(true);

        System.out.println("Init of Main Page Complete");
    }
}
