/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import static coronaprojekt.Main_Page.minDatabaskoppling;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Simon Sandberg
 */
public class visaInlagg {

    public static InfDB minDatabaskoppling;
    Login_Page user = new Login_Page(minDatabaskoppling);
    String userName = user.getCurrentUserName();

    public void createPost() {
        
    }

    public void loadPosts() {
        Blogg inlagg = new Blogg(minDatabaskoppling, 20);
        inlagg.hamtaFormellaBloggInlagg();
        inlagg.hamtaInformellaBloggInlagg();
    }

    public void setPane() {

    }

    public void setTextArea(javax.swing.JTextArea txt) {
        this.txtArea = txt;
    }

    public void setPicture() {
        imageLbl.setIcon(new ImageIcon(getClass().getResource("")));
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

    private javax.swing.JTextArea txtArea;
    private javax.swing.JPanel postPanel;
    private javax.swing.JLabel rubrikLbl;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel imageLbl;
    private javax.swing.JRadioButton pickerRBtn;
}
