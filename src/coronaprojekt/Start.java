/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Jacob
 */
public class Start {
    
private static InfDB minDatabaskoppling;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            String folder = System.getProperty("user.dir");
            String OperatingSystem = System.getProperty("os.name").toLowerCase();
            System.out.println(OperatingSystem);
            String directory = "";
           
            //Kollar om datorns Operativ System är Mac eller PC.
            if(OperatingSystem.contains("mac")){
            directory = folder + ("/db/CORONAPROJEKT.FDB");
            } else{
            directory = folder + ("\\db\\CORONAPROJEKT.FDB");
            }
            System.out.println(directory);
           
            minDatabaskoppling = new InfDB(directory);
            
            String query = "SELECT * FROM anvandare where id = 1";
            HashMap<String, String> obj = minDatabaskoppling.fetchRow(query);

            System.out.println(obj);
            System.out.println("Working..");
            
            // Skicka databasen till en sida 
            // new LoginScreen(minDatabaskoppling).setVisible(true);
            new Main_Page().setVisible(true);
        }catch(InfException ettUndantag){
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Intern felmeddelande " + ettUndantag.getMessage());
        }
    }
    
}
