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
    
    
    
    
    
    
    
}
