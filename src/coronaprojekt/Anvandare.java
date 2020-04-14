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
 * @author Jacob
 */
public class Anvandare {

    private static InfDB db;
    private int anvandareID;
    private int limit;

    public Anvandare(InfDB idb, int anvandareID, int limit) {
        this.db = idb;
        this.anvandareID = anvandareID;
        this.limit = limit;
    }
    
    public void testlaggTillAnvandare(){
        try{
            int id = Integer.parseInt(this.db.fetchSingle("SELECT MAX(ID) FROM ANVANDARE")) + 1;
            String anvnamn = "test";
            String losen = "test";
            String telefon = "test";
            String namn = "test";
            String admin = "N";
            String email = "test";

           String laggTillAnvandare = "INSERT INTO ANVANDARE " +
            "VALUES(" + id + ", '" + anvnamn + "', '" + losen + "', '" + telefon + "', '" + namn + "', '" + admin + "', '" + email + "');";
           System.out.println(laggTillAnvandare);
            this.db.insert(laggTillAnvandare);
            
            


        }
        catch(InfException ettUndantag){
            System.out.println("Fel");
        }
    }
    
    public boolean taBortInlagg(int BloggID){
        
        boolean res = false;

        try {
            String fraga = "SELECT ANVANDAREID FROM BLOGG WHERE ID = " + BloggID;
            
            String res1 = this.db.fetchSingle(fraga);
            // Kontrollerar om blogg inlägget tillhör använadaren
            if(Integer.parseInt(res1) == this.anvandareID){
                fraga = "DELETE FROM BLOGG WHERE ID = " + BloggID;
                this.db.delete(fraga);
                res = true;
            }
 
        } catch (InfException e) {
            System.out.println("Something went wrong" + e);
        }

        return res;
        
    }
    
    public ArrayList hittaMinaBloggInlagg(){
        
        ArrayList<HashMap<String, String>> res = new ArrayList();

        try {
            String fraga = "SELECT * FROM BLOGG WHERE ANVANDAREID = " + this.anvandareID;

            res = this.db.fetchRows(fraga);

        } catch (InfException e) {
            System.out.println("Something went wrong" + e);
        }

        return res;
        
    }

    protected ArrayList<HashMap<String, String>>
            setListOrderByDate(ArrayList<HashMap<String, String>> menuItems2) {

        Collections.sort(menuItems2, new Comparator<HashMap<String, String>>() {
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd");//do determ    

            @Override
            public int compare(HashMap<String, String> mapping1,
                    HashMap<String, String> mapping2) {
                try {
                    return f.parse(mapping2.get("SKAPAD")).compareTo(f.parse(mapping1.get("SKAPAD")));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
        return menuItems2;
    }

    private ArrayList skapaEnArrayMedEndastEttVarde(ArrayList<HashMap<String, String>> listan, String indexNamn) {
        ArrayList nyLista = new ArrayList();
        for (int i = 0; i < listan.size(); i++) {
            nyLista.add(listan.get(i).get(indexNamn));
        }
        return nyLista;
    }


    /*
    
    Parametern inställningar är för att bestämma vilka nyheter som ska visas:
    1. bloggnotis
    2. kommentarer
    3. bloggtags
    
    Funktionen tar fram information baserat på inställningar och visar
    ett nyhetsflöde där första nyheten är den nyaste
     */
    public ArrayList anvandarSidan(HashMap<String, Boolean> installningar) {
        ArrayList resultat = new ArrayList();

        // målet är att hämta blogginlägg baserat på vad användaren har prenumerant på
        if (installningar.containsKey("bloggnotis")) {
            // Hämtar kategorier kopplad till användare och notiser
            ArrayList notisKategorierKoppladTillAnvandare = this.hamtaNotiserRelateradeTillAnvandareBaraKategoriID();
            //System.out.println(notisKategorierKoppladTillAnvandare);
            // hämtar alla kategorier ID
            //ArrayList allaKategoriID = this.hamtaKategoriID(notisKategorierKoppladTillAnvandare);
            //System.out.println(allaKategoriID);
            // hämta alla blogg inlägg
            ArrayList kategoriIDs = this.skapaEnArrayMedEndastEttVarde(notisKategorierKoppladTillAnvandare, "KATEGORIID");
            //System.out.println(kategoriIDs);
            ArrayList bloggInlagg = this.hamtaBloggInlaggMedKategoriID(kategoriIDs);
            //System.out.println("Blogg notiser:");
            //System.out.println(bloggInlagg);
            resultat.addAll(bloggInlagg);
        }

        if (installningar.containsKey("kommentarer")) {
            // Hämtar senaste blogg inlägg av användare
            ArrayList<HashMap<String, String>> bloggInlaggAvAnvandare = this.hamtaSenasteBloggInlaggAvAnvandare();

            ArrayList<HashMap<String, String>> kommentarer_final = new ArrayList();
            for (int i = 0; i < bloggInlaggAvAnvandare.size(); i++) {

                HashMap<String, String> bloggInlagg = bloggInlaggAvAnvandare.get(i);
                ArrayList lista = new ArrayList();
                lista.add(bloggInlagg.get("ID"));
                // hamtar kommentarer
                ArrayList<HashMap<String, String>> kommentar = this.hamtaKommentarerRelateradeTillAnvandare(lista);
                if (kommentar == null) {
                    continue;
                }
                HashMap<String, String> enKommentar = kommentar.get(0);

                HashMap<String, String> enHashMap = new HashMap();
                enHashMap.put("BLOGG_RUBRIK", bloggInlagg.get("RUBRIK"));
                enHashMap.put("BLOGG_ID", bloggInlagg.get("ID"));
                enHashMap.put("KOMMENTAR", enKommentar.get("TEXT"));
                enHashMap.put("SKAPAD", enKommentar.get("SKAPAD"));

                kommentarer_final.add(enHashMap);
            }

            //ArrayList bloggIds = this.skapaEnArrayMedEndastEttVarde(bloggInlaggAvAnvandare, "ID");
            // hämtar kommentarer
            //ArrayList kommentarer = this.hamtaKommentarerRelateradeTillAnvandare(bloggIds);
            //System.out.println("Kommentarer:");
            //System.out.println(kommentarer_final);
            resultat.addAll(kommentarer_final);
        }

        if (installningar.containsKey("bloggtags")) {
            // Hämtar blogg id relaterade till användare
            ArrayList<HashMap<String, String>> hamtaTags = this.hamtaTagsRelateradeTillAnvandare();

            ArrayList<HashMap<String, String>> tags_final = new ArrayList();
            for (int i = 0; i < hamtaTags.size(); i++) {
                HashMap<String, String> entag = hamtaTags.get(i);
                ArrayList lista = new ArrayList();
                lista.add(entag.get("TAGID"));
                // hamta alla tags row som är relaterad till denna tag
                ArrayList<HashMap<String, String>> tagRows = this.hamtaTags(lista);

                // hamta alla användares användarnamn som är relaterad till tagen
                lista = new ArrayList();
                for (int t = 0; t < tagRows.size(); t++) {
                    lista.add(tagRows.get(t).get("ANVANDAREID"));
                }
                // Hamta alla namn hos användare
                ArrayList<HashMap<String, String>> namnAnvandare = this.hamtaAnvandareBaraNamn(lista);
                ArrayList listaMedNamn = new ArrayList();
                for (int t = 0; t < tagRows.size(); t++) {
                    listaMedNamn.add(namnAnvandare.get(t).get("NAMN"));
                }

                // nu har vi alla namn nu behöver vi blogginlägget
                lista = new ArrayList();
                lista.add(entag.get("BLOGGID"));
                // hämta ett blogg inlägg
                ArrayList<HashMap<String, String>> bloggInlagg1 = this.hamtaBloggInlaggMedID(lista);
                // tar ut ett blogg inlagg
                HashMap<String, String> ettBloggInlagg = bloggInlagg1.get(0);

                HashMap<String, String> enHashMap = new HashMap();
                enHashMap.put("BLOGG_RUBRIK", ettBloggInlagg.get("RUBRIK"));
                enHashMap.put("BLOGG_ID", ettBloggInlagg.get("ID"));
                enHashMap.put("ANVANDARE", this.fixaStrangMedKolon(listaMedNamn));
                enHashMap.put("SKAPAD", ettBloggInlagg.get("SKAPAD"));

                tags_final.add(enHashMap);

            }

            resultat.addAll(tags_final);
        }

        // sortera efter datum
        resultat = this.setListOrderByDate(resultat);

        return resultat;
    }

    public ArrayList hamtaAnvandareBaraNamn(ArrayList anvandare) {
        String query = this.fixaListaMedIds(anvandare);
        ArrayList<HashMap<String, String>> res = new ArrayList();

        try {
            String fraga = "SELECT NAMN FROM ANVANDARE WHERE ID in " + query;

            res = this.db.fetchRows(fraga);

        } catch (InfException e) {
            System.out.println("Something went wrong");
        }

        return res;

    }

    public ArrayList hamtaAnvandare(ArrayList anvandare) {
        String query = this.fixaListaMedIds(anvandare);
        ArrayList<HashMap<String, String>> res = new ArrayList();
        try {
            String fraga = "SELECT anvandarnamn FROM ANVANDARE WHERE ANVANDAREID in " + query;
            res = this.db.fetchRows(fraga);

        } catch (InfException e) {
            System.out.println("Something went wrong");
        }

        return res;

    }

    public ArrayList hamtaTags(ArrayList tagsID) {

        ArrayList res = new ArrayList();
        String query = this.fixaListaMedIds(tagsID);
        try {
            String fraga = "SELECT * FROM TAGS WHERE TAGID in " + query;
            res = this.db.fetchRows(fraga);

        } catch (InfException e) {
            System.out.println("Something went wrong");
        }

        return res;

    }

    public ArrayList<HashMap<String, String>> hamtaTagsRelateradeTillAnvandare() {
        ArrayList<HashMap<String, String>> res = new ArrayList();
        try {
            String fraga = "SELECT * FROM TAGS WHERE ANVANDAREID = " + this.anvandareID + " rows 1 to " + limit;
            res = this.db.fetchRows(fraga);

        } catch (InfException e) {
            System.out.println("Something went wrong");
        }

        return res;
    }

    public ArrayList<HashMap<String, String>> hamtaTagsRelateradeTillAnvandareBaraID() {
        ArrayList<HashMap<String, String>> res = new ArrayList();
        try {
            String fraga = "SELECT BLOGGID FROM TAGS WHERE ANVANDAREID = " + this.anvandareID + " rows 1 to " + limit;
            res = this.db.fetchRows(fraga);

        } catch (InfException e) {
            System.out.println("Something went wrong");
        }

        return res;
    }

    public ArrayList hamtaKategoriID(ArrayList kategorier) {

        ArrayList res = new ArrayList();
        String query = this.fixaListaMedIds(kategorier);
        try {
            String fraga = "SELECT ID FROM KATEGORI WHERE NAMN in " + query;
            res = this.db.fetchRows(fraga);

        } catch (InfException e) {
            System.out.println("Something went wrong");
        }

        return res;

    }

    public ArrayList hamtaBloggInlaggMedKategoriID(ArrayList ID) {
        ArrayList<HashMap<String, String>> res = new ArrayList();

        String query = this.fixaListaMedIds(ID);

        System.out.println(query);

        try {
            String fraga = "SELECT BLOGGID FROM BLOGG_TILLHOR_KATEGORI WHERE KATEGORIID IN " + query + "rows 1 to " + limit;

            ArrayList res1 = this.db.fetchRows(fraga);

            ArrayList bloggIds = this.skapaEnArrayMedEndastEttVarde(res1, "BLOGGID");

            res = this.hamtaBloggInlaggMedID(bloggIds);

        } catch (InfException e) {
            System.out.println("Something went wrong");
        }

        return res;
    }

    public ArrayList<HashMap<String, String>> hamtaNotiserRelateradeTillAnvandare() {
        ArrayList<HashMap<String, String>> res = new ArrayList();
        try {
            String fraga = "SELECT * FROM NOTIS WHERE AGARE = " + this.anvandareID + " ORDER BY skapad DESC rows 1 to " + limit;
            res = this.db.fetchRows(fraga);

        } catch (InfException e) {
            System.out.println("Something went wrong");
        }

        return res;
    }

    public ArrayList<HashMap<String, String>> hamtaNotiserRelateradeTillAnvandareBaraKategoriID() {
        ArrayList<HashMap<String, String>> res = new ArrayList();
        try {
            String fraga = "SELECT KATEGORIID FROM NOTIS WHERE AGARE = " + this.anvandareID + " ORDER BY skapad DESC rows 1 to " + limit;
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

    private String fixaStrangMedKolon(ArrayList lista) {
        String query = "";
        for (int i = 0; i < lista.size(); i++) {
            query = query + lista.get(i);
            if (i + 1 != lista.size()) {
                query = query + ",";
            }
        }
        query = query + "";
        return query;
    }

    public ArrayList<HashMap<String, String>> hamtaKommentarerRelateradeTillAnvandare(ArrayList bloggIDs) {
        ArrayList<HashMap<String, String>> res = new ArrayList();

        String query = this.fixaListaMedIds(bloggIDs);

        try {
            String fraga = "SELECT KOMMENTARID FROM KOMMENTARER_TILL_BLOGG WHERE BLOGGID in " + query + " rows 1 to " + limit;
            ArrayList<HashMap<String, String>> res1 = this.db.fetchRows(fraga);
            System.out.println("HEJ!");
            System.out.println(bloggIDs);
            System.out.println(query);
            ArrayList kommentarIds = this.skapaEnArrayMedEndastEttVarde(res1, "KOMMENTARID");

            res = this.hamtaKommentarer(kommentarIds);

        } catch (InfException e) {
            System.out.println("Something went wrong");
        }

        return res;
    }

    public ArrayList<HashMap<String, String>> hamtaKommentarer(ArrayList kommentarID) {
        ArrayList<HashMap<String, String>> res = new ArrayList();

        String query = this.fixaListaMedIds(kommentarID);

        try {
            String fraga = "SELECT * FROM KOMMENTAR WHERE ID in " + query + " ORDER BY skapad DESC rows 1 to " + limit;
            res = this.db.fetchRows(fraga);

        } catch (InfException e) {
            System.out.println("Something went wrong");
        }

        return res;
    }

    public ArrayList<HashMap<String, String>> hamtaSenasteBloggInlaggAvAnvandare() {
        ArrayList<HashMap<String, String>> res = new ArrayList();
        try {
            String fraga = "SELECT * FROM BLOGG WHERE ANVANDAREID = " + this.anvandareID + " ORDER BY skapad DESC rows 1 to " + limit;
            res = this.db.fetchRows(fraga);

        } catch (InfException e) {
            System.out.println("Something went wrong");
        }

        return res;
    }

    public ArrayList<HashMap<String, String>> hamtaSenasteBloggInlaggAvAnvandareBaraID() {
        ArrayList<HashMap<String, String>> res = new ArrayList();
        try {
            String fraga = "SELECT ID FROM BLOGG WHERE ANVANDAREID = " + this.anvandareID + " ORDER BY skapad DESC rows 1 to " + limit;
            res = this.db.fetchRows(fraga);

        } catch (InfException e) {
            System.out.println("Something went wrong");
        }

        return res;
    }

    public ArrayList<HashMap<String, String>> hamtaBloggInlaggMedID(ArrayList ID) {
        ArrayList<HashMap<String, String>> res = new ArrayList();

        String query = this.fixaListaMedIds(ID);
        try {
            String fraga = "SELECT * FROM BLOGG WHERE ID in " + query + " ORDER BY skapad DESC rows 1 to " + limit;
            res = this.db.fetchRows(fraga);

        } catch (InfException e) {
            System.out.println("Something went wrong");
        }

        return res;
    }

}
