/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import oru.inf.InfDB;
import java.text.SimpleDateFormat;
import java.util.Date;
import oru.inf.InfException;
/**
 *
 * @author jacob
 */
public class Kommentar {
 
    
    private static InfDB db;
    private int anvandareID;
    private int limit;

    public Kommentar(InfDB idb, int anvadareID) {
        this.db = idb;
        this.anvandareID = anvandareID;
    }
    
    public boolean skrivaEnKommentarTillBlogg(int BloggID, String text){
        boolean resultat = false;
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        
        try{
            
        // Kontrollera om BloggID finns i databasen
        String fraga = "SELCT ID FROM BLOGG WHERE ID = " + BloggID;
        int res = Integer.parseInt(this.db.fetchSingle(fraga));
        
        if(BloggID == res){
            
        }
        
        // om bloggID finns kontrollera att text är mindre än 3000 ord (alltså length).
        
        // lägg till sedan en kommentar i databasen
        // alltså lägg till i "kommentar" och "kommentarer_till_blogg" tabellen
           int nyKommentarID = Integer.parseInt(db.getAutoIncrement("KOMMENTAR", "ID"));
        fraga = "Insert into kommentar(ID, TEXT, SKAPAD) VALUES(" +nyKommentarID+ ","
                + text + "," + date + ")"; 
        
        this.db.insert(fraga);

        fraga = "Insert into kommentarer_till_blogg(KOMMENTARID, BLOGGID) VALUES(" +nyKommentarID+ ","
                + BloggID + ")"; 
        
        this.db.insert(fraga);
        
        // om allt gick ok sätt resultat till true
        resultat = true;
        }catch(InfException e){
            System.out.println(e);
        }
        
        
        return resultat;
    }
    
}
