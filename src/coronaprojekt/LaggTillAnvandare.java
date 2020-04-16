/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import javax.swing.JOptionPane;
import oru.inf.InfException;
import oru.inf.InfDB;
       

/**
 *
 * @author julia
 */
public class LaggTillAnvandare {
    
    public static InfDB minDatabaskoppling;
    

    public void laggTillNyAnvandare(int nyttID, String nyttAnvandarnamn, String nyttLosen, String nyTelefon, String nyttNamn, String nyAdmin, String nyEmail) {
        // Metod för att registrera ny användare.
        try {

            nyttID = Integer.parseInt(minDatabaskoppling.fetchSingle("SELECT MAX(ID) FROM ANVANDARE")) + 1;

            String nyAgent = "INSERT INTO Anvandare VALUES (" + nyttID + ",'" + nyttAnvandarnamn + "','" + nyttLosen + "','" + nyTelefon + "','" + nyttNamn + "','" + nyAdmin + "','" + nyEmail + "')";

            if (nyAdmin == "J") {
                minDatabaskoppling.insert(nyAgent);
            } else if (nyAdmin == "N") {
                minDatabaskoppling.insert(nyAgent);

            }

            JOptionPane.showMessageDialog(null, "Användare '" + nyttNamn + "' har fått ID '" + nyttID + "' och har lagts till i systemet.");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Hoppsan, något gick visst fel! Kontrollera inmatad text.");
            System.out.println("Internt felmeddelande " + e.getMessage());
        }
    }

    public void HamtaInfoAnvandare(javax.swing.JRadioButton rbtnNej,javax.swing.JRadioButton rbtnJa, 
            javax.swing.JTextField txtAnvNamn,
            javax.swing.JTextField txtEmail,
            javax.swing.JTextField txtLosen,
            javax.swing.JTextField txtNamn,
            javax.swing.JTextField txtTelefon) {
        try {

            int nyttID = Integer.parseInt(minDatabaskoppling.getAutoIncrement("ANVANDARE", "ID"));
            String anvnamn = txtAnvNamn.getText();
            String losen = txtLosen.getText();
            String telefon = txtTelefon.getText();
            String namn = txtNamn.getText();
            String email = txtEmail.getText();

            String admin = "";
            if (rbtnJa.isSelected()) {
                admin = "J";
            } else if (rbtnNej.isSelected()) {
                admin = "N";
            }

            laggTillNyAnvandare(nyttID, anvnamn, losen, telefon, namn, admin, email);
            txtAnvNamn.setText("");
            txtLosen.setText("");
            txtTelefon.setText("");
            txtNamn.setText("");
            txtEmail.setText("");

        } catch (InfException e) {
            System.out.println("Fel" + e.getMessage());
        }
    }
}


