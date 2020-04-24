/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;


import oru.inf.InfDB;
import java.util.HashMap;
import java.util.ArrayList;
import oru.inf.InfException;
import java.util.Comparator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Collections;
import java.text.DateFormat;
import java.text.ParseException;

/**
 *
 * @author jacob
 */
public class Blogg {
    
    private static InfDB db;
    private int anvandareID;
    private int limit;

    public Blogg(InfDB idb, int limit) {
        this.db = idb;
        this.limit = limit;
    }
    
    
    public ArrayList hamtaInformellaBloggInlagg(){
        
        ArrayList<HashMap<String, String>> res = new ArrayList();
        try {
            String fraga = "SELECT * FROM BLOGG WHERE INFORMELL = 'J' ORDER BY skapad DESC rows 1 to " + limit;
            res = this.db.fetchRows(fraga);

        } catch (InfException e) {
            System.out.println(e);
            System.out.println("Something went wrong");
        }

        return res;
        
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
    
    private ArrayList skapaEnArrayMedEndastEttVarde(ArrayList<HashMap<String, String>> listan, String indexNamn) {
        ArrayList nyLista = new ArrayList();
        for (int i = 0; i < listan.size(); i++) {
            nyLista.add(listan.get(i).get(indexNamn));
        }
        return nyLista;
    }
    
    public ArrayList hamtaInformellaBloggInlaggMedKategori(String kategori){
        
        ArrayList<HashMap<String, String>> res = new ArrayList();
        try {
            String queryHamtaKategoriID = "SELECT ID FROM KATEGORI WHERE NAMN = '" + kategori + "'";
            String res1 = this.db.fetchSingle(queryHamtaKategoriID);
            
            System.out.println(queryHamtaKategoriID);
            System.out.println(res1);
            
            if(res1 != null){
                
                String queryHamtaBloggIDAvKategoriID = "SELECT BLOGGID FROM BLOGG_TILLHOR_KATEGORI WHERE KATEGORIID = " + res1;
                ArrayList<HashMap<String, String>> bloggIdsHashMap = this.db.fetchRows(queryHamtaBloggIDAvKategoriID);
                System.out.println(queryHamtaBloggIDAvKategoriID);
                System.out.println(bloggIdsHashMap);
                String listaMedIds = this.fixaListaMedIds(this.skapaEnArrayMedEndastEttVarde(bloggIdsHashMap, "BLOGGID"));
                System.out.println(listaMedIds);
                String fraga = "SELECT * FROM BLOGG WHERE INFORMELL = 'J' AND ID IN "+listaMedIds+" ORDER BY skapad DESC rows 1 to " + limit;
                res = this.db.fetchRows(fraga);
            }

        } catch (InfException e) {
            System.out.println(e);
            System.out.println("Something went wrong");
        }

        return res;
        
    }
    
    public ArrayList hamtaFormellaBloggInlaggMedKategori(String kategori){
        
        ArrayList<HashMap<String, String>> res = new ArrayList();
        try {
            String queryHamtaKategoriID = "SELECT ID FROM KATEGORI WHERE NAMN = '" + kategori + "'";
            String res1 = this.db.fetchSingle(queryHamtaKategoriID);
            
            System.out.println(queryHamtaKategoriID);
            System.out.println(res1);
            
            if(res1 != null){
                
                String queryHamtaBloggIDAvKategoriID = "SELECT BLOGGID FROM BLOGG_TILLHOR_KATEGORI WHERE KATEGORIID = " + res1;
                ArrayList<HashMap<String, String>> bloggIdsHashMap = this.db.fetchRows(queryHamtaBloggIDAvKategoriID);
                System.out.println(queryHamtaBloggIDAvKategoriID);
                System.out.println(bloggIdsHashMap);
                String listaMedIds = this.fixaListaMedIds(this.skapaEnArrayMedEndastEttVarde(bloggIdsHashMap, "BLOGGID"));
                System.out.println(listaMedIds);
                String fraga = "SELECT * FROM BLOGG WHERE INFORMELL = 'N' AND ID IN "+listaMedIds+" ORDER BY skapad DESC rows 1 to " + limit;
                res = this.db.fetchRows(fraga);
            }

        } catch (InfException e) {
            System.out.println(e);
            System.out.println("Something went wrong");
        }

        return res;
        
    }
    
    public ArrayList hamtaFormellaBloggInlagg(){
        
        ArrayList<HashMap<String, String>> res = new ArrayList();
        try {
            String fraga = "SELECT * FROM BLOGG WHERE INFORMELL = 'N' ORDER BY skapad DESC rows 1 to " + limit;
            res = this.db.fetchRows(fraga);

        } catch (InfException e) {
            System.out.println(e);
            System.out.println("Something went wrong");
        }

        return res;
        
    }
    
    public ArrayList hamtaBloggInlaggMedAnvandare(ArrayList<HashMap<String, String>> bloggar){
        
        ArrayList<HashMap<String, String>> res = new ArrayList();
        try {
            String fraga = "";
            HashMap<String, String> res1 = new HashMap<>();
            for(int i = 0; i < bloggar.size(); i++){
                HashMap<String, String> newRow = new HashMap<>();
                fraga = "SELECT * FROM ANVANDARE WHERE ID = " + bloggar.get(i).get("ANVANDAREID");
                res1 = this.db.fetchRow(fraga);
                newRow.put("ID", bloggar.get(i).get("ID"));
                newRow.put("ANVANDAREID", bloggar.get(i).get("ANVANDAREID"));
                newRow.put("NAMN", res1.get("NAMN"));
                newRow.put("TEXT", bloggar.get(i).get("TEXT"));
                newRow.put("RUBRIK", bloggar.get(i).get("RUBRIK"));
                newRow.put("INFORMELL", bloggar.get(i).get("INFORMELL"));
                newRow.put("SKAPAD", bloggar.get(i).get("SKAPAD"));
                res.add(newRow);
            }


        } catch (InfException e) {
            System.out.println(e);
            System.out.println("Something went wrong");
        }

        return res;
        
    }
    
    
    public javax.swing.JComboBox<String> valjKategori(javax.swing.JComboBox<String> cboxValjKategori){
        int i = 1;
        try {
            int antalKategoier = Integer.parseInt(db.fetchSingle("SELECT COUNT(*) FROM kategori"));
            while (i <= (antalKategoier)) {
                String kategori = db.fetchSingle("SELECT namn from kategori where id = '" + i + "'");
                cboxValjKategori.addItem(kategori);
                i++;
            }
        } catch (InfException ex) {
            System.out.println("Kunde inte skriva ut kategorierna till cbox: " + ex.getMessage());
        }
        return cboxValjKategori;
    }
    
    
    
    
}
