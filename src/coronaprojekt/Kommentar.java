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
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author jacob
 */
public class Kommentar {
 
    
    private static InfDB db;
    private int anvandareID;
    private int limit;

    public Kommentar(InfDB idb) {
        this.db = idb;
    }
    
    private ArrayList skapaEnArrayMedEndastEttVarde(ArrayList<HashMap<String, String>> listan, String indexNamn) {
        ArrayList nyLista = new ArrayList();
        for (int i = 0; i < listan.size(); i++) {
            nyLista.add(listan.get(i).get(indexNamn));
        }
        return nyLista;
    }
    
    private String fixaListaMedIds(ArrayList lista) {
        String query = "(";
        for (int i = 0; i < lista.size(); i++) {
            query = query + lista.get(i);
            if (i + 1 != lista.size()) {
                query = query + ",";
            }
        }
        query = query + ")";
        return query;
    }
    
    public ArrayList hamtaKommentarerTillBlogg(int bloggId){
        ArrayList<HashMap<String, String>> resultat = new ArrayList<>();
        try{
            String res1 = "SELECT BLOGGID FROM KOMMENTARER_TILL_BLOGG WHERE BLOGGID = " + bloggId;
            ArrayList<HashMap<String, String>> res = this.db.fetchRows(res1);
            
            ArrayList lista = this.skapaEnArrayMedEndastEttVarde(res, "BLOGGID");
            
            String fraga = "SELECT * FROM KOMMENTAR WHERE ID IN " + this.fixaListaMedIds(lista);
            resultat = this.db.fetchRows(fraga);
            
        }catch(InfException e){
            System.out.println(e);
        }
        return resultat;
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
