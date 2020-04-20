/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import oru.inf.InfDB;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import java.lang.IllegalArgumentException;
import oru.inf.InfException;
import javax.swing.JOptionPane;

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

        formel_Blogg_btn = new javax.swing.JPanel();
        formBlg_Lbl = new javax.swing.JLabel();
        informell_Blogg_btn = new javax.swing.JPanel();
        informBlg_Lbl = new javax.swing.JLabel();
        projects_btn = new javax.swing.JPanel();
        projBtn_Lbl = new javax.swing.JLabel();
        newsflow_Panel = new javax.swing.JPanel();
        blogg_Window_Formel = new javax.swing.JScrollPane();
        formel_Blogg_Panel = new javax.swing.JPanel();
        create_Post_Btn = new javax.swing.JPanel();
        make_Post_Panel = new javax.swing.JPanel();
        txt_Area_Scroll = new javax.swing.JScrollPane();
        txt_Area = new javax.swing.JTextArea();
        catagory_Box = new javax.swing.JComboBox<>();
        file_btn = new javax.swing.JButton();
        post_btn = new javax.swing.JButton();
        lblChoosenFIle = new javax.swing.JLabel();
        blogg_Window_Informell = new javax.swing.JScrollPane();
        informell_Blogg_Panel = new javax.swing.JPanel();
        blogg_Window_Projekt = new javax.swing.JScrollPane();
        projekt_Blogg_Panel = new javax.swing.JPanel();
        notis_btn = new javax.swing.JPanel();
        notis_lbl = new javax.swing.JLabel();
        account_btn = new javax.swing.JPanel();
        account_lbl = new javax.swing.JLabel();
        konto_Panel = new javax.swing.JPanel();
        background_Image_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main_Window_Pane");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setName("main_Page_JFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(null);

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
        formel_Blogg_btn.add(formBlg_Lbl, java.awt.BorderLayout.CENTER);

        getContentPane().add(formel_Blogg_btn);
        formel_Blogg_btn.setBounds(6, 6, 480, 100);

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
        informell_Blogg_btn.add(informBlg_Lbl, java.awt.BorderLayout.CENTER);

        getContentPane().add(informell_Blogg_btn);
        informell_Blogg_btn.setBounds(492, 6, 480, 100);

        projects_btn.setBackground(new java.awt.Color(3, 194, 252));
        projects_btn.setPreferredSize(new java.awt.Dimension(480, 100));
        projects_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projects_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                projects_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                projects_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                projects_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                projects_btnMouseReleased(evt);
            }
        });
        projects_btn.setLayout(new java.awt.BorderLayout());

        projBtn_Lbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        projBtn_Lbl.setForeground(new java.awt.Color(255, 255, 255));
        projBtn_Lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        projBtn_Lbl.setText("Projekt");
        projects_btn.add(projBtn_Lbl, java.awt.BorderLayout.CENTER);

        getContentPane().add(projects_btn);
        projects_btn.setBounds(978, 6, 480, 100);

        newsflow_Panel.setBackground(new java.awt.Color(3, 194, 252));

        javax.swing.GroupLayout newsflow_PanelLayout = new javax.swing.GroupLayout(newsflow_Panel);
        newsflow_Panel.setLayout(newsflow_PanelLayout);
        newsflow_PanelLayout.setHorizontalGroup(
            newsflow_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );
        newsflow_PanelLayout.setVerticalGroup(
            newsflow_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );

        getContentPane().add(newsflow_Panel);
        newsflow_Panel.setBounds(1470, 110, 445, 980);

        blogg_Window_Formel.setBackground(new java.awt.Color(3, 194, 252));
        blogg_Window_Formel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        blogg_Window_Formel.setMinimumSize(new java.awt.Dimension(950, 980));
        blogg_Window_Formel.setName(""); // NOI18N
        blogg_Window_Formel.setPreferredSize(new java.awt.Dimension(950, 980));
        blogg_Window_Formel.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                blogg_Window_FormelMouseWheelMoved(evt);
            }
        });

        create_Post_Btn.setBackground(new java.awt.Color(102, 204, 255));
        create_Post_Btn.setPreferredSize(new java.awt.Dimension(480, 60));
        create_Post_Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                create_Post_BtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout create_Post_BtnLayout = new javax.swing.GroupLayout(create_Post_Btn);
        create_Post_Btn.setLayout(create_Post_BtnLayout);
        create_Post_BtnLayout.setHorizontalGroup(
            create_Post_BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        create_Post_BtnLayout.setVerticalGroup(
            create_Post_BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        make_Post_Panel.setBackground(new java.awt.Color(51, 255, 204));

        txt_Area.setColumns(20);
        txt_Area.setRows(5);
        txt_Area_Scroll.setViewportView(txt_Area);

        file_btn.setText("Choose File");

        post_btn.setText("Lägg Upp");
        post_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                post_btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout make_Post_PanelLayout = new javax.swing.GroupLayout(make_Post_Panel);
        make_Post_Panel.setLayout(make_Post_PanelLayout);
        make_Post_PanelLayout.setHorizontalGroup(
            make_Post_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(make_Post_PanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(make_Post_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_Area_Scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, make_Post_PanelLayout.createSequentialGroup()
                        .addComponent(catagory_Box, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(file_btn))
                    .addComponent(post_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblChoosenFIle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        make_Post_PanelLayout.setVerticalGroup(
            make_Post_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(make_Post_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_Area_Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(make_Post_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catagory_Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(file_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblChoosenFIle, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(post_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout formel_Blogg_PanelLayout = new javax.swing.GroupLayout(formel_Blogg_Panel);
        formel_Blogg_Panel.setLayout(formel_Blogg_PanelLayout);
        formel_Blogg_PanelLayout.setHorizontalGroup(
            formel_Blogg_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formel_Blogg_PanelLayout.createSequentialGroup()
                .addGap(487, 487, 487)
                .addGroup(formel_Blogg_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(create_Post_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formel_Blogg_PanelLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(make_Post_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(663, Short.MAX_VALUE))
        );
        formel_Blogg_PanelLayout.setVerticalGroup(
            formel_Blogg_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formel_Blogg_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(create_Post_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(make_Post_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(769, Short.MAX_VALUE))
        );

        blogg_Window_Formel.setViewportView(formel_Blogg_Panel);

        getContentPane().add(blogg_Window_Formel);
        blogg_Window_Formel.setBounds(6, 112, 1452, 1120);

        blogg_Window_Informell.setBackground(new java.awt.Color(3, 194, 252));
        blogg_Window_Informell.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        blogg_Window_Informell.setMinimumSize(new java.awt.Dimension(950, 980));
        blogg_Window_Informell.setName(""); // NOI18N
        blogg_Window_Informell.setPreferredSize(new java.awt.Dimension(950, 980));
        blogg_Window_Informell.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                blogg_Window_InformellMouseWheelMoved(evt);
            }
        });

        javax.swing.GroupLayout informell_Blogg_PanelLayout = new javax.swing.GroupLayout(informell_Blogg_Panel);
        informell_Blogg_Panel.setLayout(informell_Blogg_PanelLayout);
        informell_Blogg_PanelLayout.setHorizontalGroup(
            informell_Blogg_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1525, Short.MAX_VALUE)
        );
        informell_Blogg_PanelLayout.setVerticalGroup(
            informell_Blogg_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1117, Short.MAX_VALUE)
        );

        blogg_Window_Informell.setViewportView(informell_Blogg_Panel);

        getContentPane().add(blogg_Window_Informell);
        blogg_Window_Informell.setBounds(6, 112, 1452, 980);

        blogg_Window_Projekt.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                blogg_Window_ProjektMouseWheelMoved(evt);
            }
        });

        projekt_Blogg_Panel.setPreferredSize(new java.awt.Dimension(1452, 1120));

        javax.swing.GroupLayout projekt_Blogg_PanelLayout = new javax.swing.GroupLayout(projekt_Blogg_Panel);
        projekt_Blogg_Panel.setLayout(projekt_Blogg_PanelLayout);
        projekt_Blogg_PanelLayout.setHorizontalGroup(
            projekt_Blogg_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1452, Short.MAX_VALUE)
        );
        projekt_Blogg_PanelLayout.setVerticalGroup(
            projekt_Blogg_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1120, Short.MAX_VALUE)
        );

        blogg_Window_Projekt.setViewportView(projekt_Blogg_Panel);

        getContentPane().add(blogg_Window_Projekt);
        blogg_Window_Projekt.setBounds(6, 112, 1452, 1120);

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

        getContentPane().add(notis_btn);
        notis_btn.setBounds(1470, 5, 220, 100);

        account_btn.setBackground(new java.awt.Color(3, 194, 252));
        account_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                account_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                account_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                account_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                account_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                account_btnMouseReleased(evt);
            }
        });
        account_btn.setLayout(new java.awt.BorderLayout());

        account_lbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        account_lbl.setForeground(new java.awt.Color(255, 255, 255));
        account_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        account_lbl.setText("Konto");
        account_btn.add(account_lbl, java.awt.BorderLayout.CENTER);

        getContentPane().add(account_btn);
        account_btn.setBounds(1695, 5, 220, 100);

        javax.swing.GroupLayout konto_PanelLayout = new javax.swing.GroupLayout(konto_Panel);
        konto_Panel.setLayout(konto_PanelLayout);
        konto_PanelLayout.setHorizontalGroup(
            konto_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1452, Short.MAX_VALUE)
        );
        konto_PanelLayout.setVerticalGroup(
            konto_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1120, Short.MAX_VALUE)
        );

        getContentPane().add(konto_Panel);
        konto_Panel.setBounds(6, 112, 1452, 1120);

        background_Image_lbl.setBackground(new java.awt.Color(255, 102, 102));
        background_Image_lbl.setForeground(new java.awt.Color(102, 255, 102));
        background_Image_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coronaprojekt/resources/UniversitetsmiljÃ¶er00162.jpg"))); // NOI18N
        background_Image_lbl.setText("jLabel1");
        background_Image_lbl.setAlignmentY(0.0F);
        background_Image_lbl.setFocusable(false);
        background_Image_lbl.setMaximumSize(new java.awt.Dimension(1920, 1080));
        background_Image_lbl.setMinimumSize(new java.awt.Dimension(1920, 1080));
        background_Image_lbl.setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(background_Image_lbl);
        background_Image_lbl.setBounds(0, 0, 1950, 1090);

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

    private void projects_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projects_btnMouseEntered
        projects_btn.setBackground(hoverColorBtn);
        projects_btn.setVisible(false);
        projects_btn.setVisible(true);
    }//GEN-LAST:event_projects_btnMouseEntered

    private void projects_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projects_btnMouseExited
        projects_btn.setBackground(baseColorBtn);
        projects_btn.setVisible(false);
        projects_btn.setVisible(true);
    }//GEN-LAST:event_projects_btnMouseExited

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

    private void account_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account_btnMouseEntered
        account_btn.setBackground(hoverColorBtn);
        account_btn.setVisible(false);
        account_btn.setVisible(true);
    }//GEN-LAST:event_account_btnMouseEntered

    private void account_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account_btnMouseExited
        account_btn.setBackground(baseColorBtn);
        account_btn.setVisible(false);
        account_btn.setVisible(true);
    }//GEN-LAST:event_account_btnMouseExited

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

    private void projects_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projects_btnMousePressed
        projects_btn.setBackground(clickedColorBtn);
        projects_btn.setVisible(false);
        projects_btn.setVisible(true);
    }//GEN-LAST:event_projects_btnMousePressed

    private void projects_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projects_btnMouseReleased
        projects_btn.setBackground(hoverColorBtn);
        projects_btn.setVisible(false);
        projects_btn.setVisible(true);
    }//GEN-LAST:event_projects_btnMouseReleased

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

    private void account_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account_btnMousePressed
        account_btn.setBackground(clickedColorBtn);
        account_btn.setVisible(false);
        account_btn.setVisible(true);

    }//GEN-LAST:event_account_btnMousePressed

    private void account_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account_btnMouseReleased
        account_btn.setBackground(hoverColorBtn);
        account_btn.setVisible(false);
        account_btn.setVisible(true);
    }//GEN-LAST:event_account_btnMouseReleased

    private void blogg_Window_FormelMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_blogg_Window_FormelMouseWheelMoved
        formel_Blogg_Panel.setBackground(baseColorBtn);
        formel_Blogg_Panel.setVisible(false);
        formel_Blogg_Panel.setVisible(true);

        blogg_Window_Formel.setBackground(baseColorBtn);
        blogg_Window_Formel.setVisible(false);
        blogg_Window_Formel.setVisible(true);
    }//GEN-LAST:event_blogg_Window_FormelMouseWheelMoved
    //En klick funktion, i dem här ska alla länkar till andra metoder och klasser ligga
    private void formel_Blogg_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formel_Blogg_btnMouseClicked
        blogg_Window_Formel.setVisible(true);
        formel_Blogg_Panel.setVisible(true);

        blogg_Window_Informell.setVisible(false);
        informell_Blogg_Panel.setVisible(false);

        konto_Panel.setVisible(false);

        blogg_Window_Projekt.setVisible(false);
        projekt_Blogg_Panel.setVisible(false);
    }//GEN-LAST:event_formel_Blogg_btnMouseClicked
    //klick Funktion
    private void informell_Blogg_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_informell_Blogg_btnMouseClicked
        blogg_Window_Informell.setVisible(true);
        informell_Blogg_Panel.setVisible(true);

        blogg_Window_Formel.setVisible(false);
        formel_Blogg_Panel.setVisible(false);

        konto_Panel.setVisible(false);

        blogg_Window_Projekt.setVisible(false);
        projekt_Blogg_Panel.setVisible(false);
    }//GEN-LAST:event_informell_Blogg_btnMouseClicked

    private void blogg_Window_InformellMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_blogg_Window_InformellMouseWheelMoved
        informell_Blogg_Panel.setBackground(baseColorBtn);
        informell_Blogg_Panel.setVisible(false);
        informell_Blogg_Panel.setVisible(true);

        blogg_Window_Informell.setBackground(baseColorBtn);
        blogg_Window_Informell.setVisible(false);
        blogg_Window_Informell.setVisible(true);
    }//GEN-LAST:event_blogg_Window_InformellMouseWheelMoved

    private void account_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account_btnMouseClicked
        konto_Panel.setVisible(true);

        blogg_Window_Formel.setVisible(false);
        formel_Blogg_Panel.setVisible(false);

        blogg_Window_Informell.setVisible(false);
        informell_Blogg_Panel.setVisible(false);

        blogg_Window_Projekt.setVisible(false);
        projekt_Blogg_Panel.setVisible(false);
    }//GEN-LAST:event_account_btnMouseClicked

    private void projects_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projects_btnMouseClicked
        blogg_Window_Projekt.setVisible(true);
        projekt_Blogg_Panel.setVisible(true);

        blogg_Window_Formel.setVisible(false);
        formel_Blogg_Panel.setVisible(false);

        blogg_Window_Informell.setVisible(false);
        informell_Blogg_Panel.setVisible(false);

        konto_Panel.setVisible(false);
    }//GEN-LAST:event_projects_btnMouseClicked

    private void blogg_Window_ProjektMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_blogg_Window_ProjektMouseWheelMoved
        projekt_Blogg_Panel.setBackground(baseColorBtn);
        projekt_Blogg_Panel.setVisible(false);
        projekt_Blogg_Panel.setVisible(true);

        blogg_Window_Projekt.setBackground(baseColorBtn);
        blogg_Window_Projekt.setVisible(false);
        blogg_Window_Projekt.setVisible(true);
    }//GEN-LAST:event_blogg_Window_ProjektMouseWheelMoved

    private void create_Post_BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create_Post_BtnMouseClicked
        if (make_Post_Panel.isShowing() == false) {
            System.out.println("We in!!!");
            BloggInlagg bL = new BloggInlagg(minDatabaskoppling, 1, "N");
            catagory_Box = bL.cboxSkrivUtKategorier(catagory_Box);

            make_Post_Panel.setVisible(true);

            formel_Blogg_Panel.setBackground(baseColorBtn);
            formel_Blogg_Panel.setVisible(false);
            formel_Blogg_Panel.setVisible(true);

            blogg_Window_Formel.setBackground(baseColorBtn);
            blogg_Window_Formel.setVisible(false);
            blogg_Window_Formel.setVisible(true);
        }
    }//GEN-LAST:event_create_Post_BtnMouseClicked

    private void post_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_post_btnMouseClicked
        if (make_Post_Panel.isShowing() == true) {
            System.out.println("Wesa in!!!");
            BloggInlagg bL = new BloggInlagg(minDatabaskoppling, 1, "N");
            bL.addPost(catagory_Box, txt_Area, lblChoosenFIle);

            make_Post_Panel.setVisible(false);
            
            formel_Blogg_Panel.setBackground(baseColorBtn);
            formel_Blogg_Panel.setVisible(false);
            formel_Blogg_Panel.setVisible(true);

            blogg_Window_Formel.setBackground(baseColorBtn);
            blogg_Window_Formel.setVisible(false);
            blogg_Window_Formel.setVisible(true);
        }
    }//GEN-LAST:event_post_btnMouseClicked

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
    private javax.swing.JPanel account_btn;
    private javax.swing.JLabel account_lbl;
    private javax.swing.JLabel background_Image_lbl;
    private javax.swing.JScrollPane blogg_Window_Formel;
    private javax.swing.JScrollPane blogg_Window_Informell;
    private javax.swing.JScrollPane blogg_Window_Projekt;
    private javax.swing.JComboBox<String> catagory_Box;
    private javax.swing.JPanel create_Post_Btn;
    private javax.swing.JButton file_btn;
    private javax.swing.JLabel formBlg_Lbl;
    private javax.swing.JPanel formel_Blogg_Panel;
    private javax.swing.JPanel formel_Blogg_btn;
    private javax.swing.JLabel informBlg_Lbl;
    private javax.swing.JPanel informell_Blogg_Panel;
    private javax.swing.JPanel informell_Blogg_btn;
    private javax.swing.JPanel konto_Panel;
    private javax.swing.JLabel lblChoosenFIle;
    private javax.swing.JPanel make_Post_Panel;
    private javax.swing.JPanel newsflow_Panel;
    private javax.swing.JPanel notis_btn;
    private javax.swing.JLabel notis_lbl;
    private javax.swing.JButton post_btn;
    private javax.swing.JLabel projBtn_Lbl;
    private javax.swing.JPanel projects_btn;
    private javax.swing.JPanel projekt_Blogg_Panel;
    private javax.swing.JTextArea txt_Area;
    private javax.swing.JScrollPane txt_Area_Scroll;
    // End of variables declaration//GEN-END:variables

    private Color hoverColorBtn = new Color(41, 205, 255, 200);
    private Color baseColorBtn = new Color(3, 194, 252, 150);
    private Color clickedColorBtn = new Color(117, 223, 255, 200);

    //Initierar alla delar av huvud UI
    public void initMainWindow() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        formel_Blogg_btn.setBackground(baseColorBtn);

        informell_Blogg_btn.setBackground(baseColorBtn);

        projects_btn.setBackground(baseColorBtn);

        blogg_Window_Formel.setBackground(baseColorBtn);
        blogg_Window_Formel.getViewport().setOpaque(false);
        formel_Blogg_Panel.setBackground(baseColorBtn);
        formel_Blogg_Panel.setOpaque(false);

        newsflow_Panel.setBackground(baseColorBtn);

        blogg_Window_Informell.setBackground(baseColorBtn);
        blogg_Window_Informell.getViewport().setOpaque(false);
        blogg_Window_Informell.setVisible(false);
        informell_Blogg_Panel.setBackground(baseColorBtn);
        informell_Blogg_Panel.setOpaque(false);
        informell_Blogg_Panel.setVisible(false);

        blogg_Window_Projekt.setBackground(baseColorBtn);
        blogg_Window_Projekt.getViewport().setOpaque(false);
        blogg_Window_Projekt.setVisible(false);
        projekt_Blogg_Panel.setBackground(baseColorBtn);
        projekt_Blogg_Panel.setOpaque(false);
        projekt_Blogg_Panel.setVisible(false);

        notis_btn.setBackground(baseColorBtn);

        account_btn.setBackground(baseColorBtn);

        konto_Panel.setBackground(baseColorBtn);
        konto_Panel.setVisible(false);

        create_Post_Btn.setVisible(true);
        make_Post_Panel.setVisible(false);

        System.out.println("Init of Main Page Complete");
    }
;
}
