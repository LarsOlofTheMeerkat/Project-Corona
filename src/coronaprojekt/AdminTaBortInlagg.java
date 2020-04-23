
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author mizz_
 */
public class AdminTaBortInlagg {
    
    private static InfDB db;
    private int anvandareID;
    
    
    public AdminTaBortInlagg(InfDB idb, int anvandareID) {
        this.db = idb;
        this.anvandareID = anvandareID;
        
      
    }
    
    
     public boolean taBortInlagg(int BloggID){
        
        boolean resultat = false;

        try {
            String fraga = "SELECT ISADMIN FROM ANVANDARE WHERE ANVANDAREID = " + this.anvandareID;
            
            String resultat1 = this.db.fetchSingle(fraga);
            //kontrollerar om användaren är admin
            if(resultat1 == "J"){
                fraga = "DELETE FROM BLOGG WHERE ID = " + BloggID;
                this.db.delete(fraga);
                resultat = true;
            }
            else
            {
            
            JOptionPane.showMessageDialog(null,"Endast Admin kan radera inlägg");
            }
 
        } catch (InfException e) {
            System.out.println("Something went wrong" + e);
        }

        return resultat;
        
    }
    
    
    
    
    
    
    
    
}
