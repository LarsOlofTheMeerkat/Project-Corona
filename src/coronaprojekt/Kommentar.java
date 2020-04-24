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
            String res1 = "SELECT KOMMENTARID FROM KOMMENTARER_TILL_BLOGG WHERE BLOGGID = " + bloggId;
            ArrayList<HashMap<String, String>> res = this.db.fetchRows(res1);
            
            if(res != null){
            ArrayList lista = this.skapaEnArrayMedEndastEttVarde(res, "KOMMENTARID");
            
            System.out.println("Lista");
            System.out.println(res);
            String fraga = "SELECT * FROM KOMMENTAR WHERE ID IN " + this.fixaListaMedIds(lista);
            resultat = this.db.fetchRows(fraga);
            }
            
        }catch(InfException e){
            System.out.println(e);
        }
        return resultat;
    }
    
    public boolean skrivaKommentar(int bloggID, String text) {
        boolean resultat = false;
        String date = new SimpleDateFormat ("yyyy-MM-dd").format(new Date());
        try{
            System.out.println("BLOGGID");
            System.out.println(bloggID);
            String fraga = "SELECT ID FROM BLOGG WHERE ID=" + bloggID +"";
            
            int res = Integer.parseInt(this.db.fetchSingle(fraga));
            if(bloggID == res){            
                int nyKommentarID = Integer.parseInt(db.getAutoIncrement("KOMMENTAR","ID"));
                String fraga1 = "Insert into kommentar (ID, TEXT, SKAPAD) VALUES(" + nyKommentarID + ",'" + text + "','" + date + "')";
                this.db.insert(fraga1);
                String fraga2 = "insert into kommentarer_till_blogg (KOMMENTARID, BLOGGID) VALUES (" + nyKommentarID + "," + bloggID + ")";
                this.db.insert(fraga2);
                resultat = true;
                }   
            }
        catch (InfException e) {
        System.out.println(e);
        } 
    return resultat;
    }
    
}
