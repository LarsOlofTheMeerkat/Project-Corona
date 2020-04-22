/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;

/**
 *
 * @author Jacob
 */
public class Mote {
    
    
    private static InfDB db;
    private int anvandareID;
    private int limit;

    public Mote(InfDB idb, int anvandareID, int limit) {
        this.db = idb;
        this.anvandareID = anvandareID;
        this.limit = limit;
    }
    
    public ArrayList hamtaMinaMotenMellanTvaDatum(String datum1, String datum2){
        ArrayList<HashMap<String, String>> moten = this.hamtaMinaMoten();
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<HashMap<String, String>> resultat = new ArrayList<HashMap<String, String>>();
        System.out.println("Här");
        System.out.println(moten);
        for(int i = 0; i < moten.size(); i++){
            String datumet = moten.get(i).get("DAG");
            try{
                Date motesDatum = sdformat.parse(datumet);
                Date d2 = sdformat.parse(datum1);
                Date d3 = sdformat.parse(datum2);
                
                if(motesDatum.compareTo(d2) > 0 && motesDatum.compareTo(d3) < 0
                        || motesDatum.compareTo(d2) == 0 ||
                        motesDatum.compareTo(d3) == 0)  {
                    resultat.add(moten.get(i));
                    continue;
                 }
                
            }catch(ParseException e){
                System.out.println(e);
            }
            
        }
        return resultat;
    }
    
    public ArrayList hamtaMinaMoten(){
        ArrayList<HashMap<String, String>> skickaTillbaka = new ArrayList<>();
        try{
            String fraga = "SELECT * FROM DELTAR WHERE ANVANDAREID = " + this.anvandareID;
            ArrayList<HashMap<String, String>> res = this.db.fetchRows(fraga);
            System.out.println("Mina möten resultat");
            System.out.println(res);
            String fraga1 = "";
            HashMap<String, String> res1 = new HashMap<String, String>();
            HashMap<String, String> newRow = new HashMap<String, String>();
            for(int i = 0; i < res.size(); i++){
                fraga1 = "SELECT * FROM MOTE WHERE ID = " + res.get(i).get("MOTEID");
                res1 = this.db.fetchRow(fraga1);
                skickaTillbaka.add(res1);
            }
            
        }catch(InfException e){
            System.out.println(e);
        }
        return skickaTillbaka;
    }
    
    /*
        Skapar ett nytt möte
    */
    public boolean nyttMote(String datum, String tid){
        boolean resultat = false;
        try{
            int nyMoteID = Integer.parseInt(db.getAutoIncrement("MOTE", "ID"));
            String fraga2 = "INSERT INTO MOTE(ID, DAG, TID)"+
                        "VALUES("+nyMoteID+","+datum+","+tid+") ";
            this.db.insert(fraga2);
            resultat = true;
        }catch(InfException e){
            System.out.println(e);
        }
        return resultat;
    }
    
    /*
    Tacka ja eller nej till ett möte
    */
    public boolean svaraPaMote(int moteId, int AnvandareID, String deltar){
        boolean resultat = false;
        try{
            if(deltar.equals("J") || deltar.equals("N")){
            String fraga = "SELECT * FROM DELTAR WHERE MOTEID = " + moteId + " AND ANVANDAREID=" +AnvandareID;
            HashMap<String, String> res = this.db.fetchRow(fraga);
            
            String fraga1 = "UPDATE DELTAR SET DELTAR = '"+deltar+" WHERE MOTEID = " + moteId + " AND ANVANDAREID=" +AnvandareID;
            
            this.db.update(fraga1);
            resultat = true;
            
            }
        }catch(InfException e){
            System.out.println(e);
        }
        return resultat;
    }
    /*
    Funktionen lägger in en rad i deltar tabellen
    Funktionen kopplar ett möte med en användare
    (alltså lägger in i deltar)
    */
    public boolean bokaMote(int moteId, int AnvandareID, String deltar){
        boolean resultat = false;
        try{
            String fraga = "SELECT ID FROM MOTE WHERE ID = " + moteId;
            String res = this.db.fetchSingle(fraga);
            
            String fraga1 = "SELECT ID FROM ANVANDARE WHERE ID = " + AnvandareID;
            String res1 = this.db.fetchSingle(fraga);
            
            if(Integer.parseInt(res) == moteId &&
                    Integer.parseInt(res1) == AnvandareID){
                String fraga2 = "INSERT INTO DELTAR(MOTEID, ANVANDAREID, DELTAR)"+
                        "VALUES("+moteId+","+AnvandareID+", '"+deltar+"') ";
                this.db.insert(fraga2);
                resultat = true;
            }
        }catch(InfException e){
            System.out.println(e);
        }
        return resultat;
    }
    
    
}
