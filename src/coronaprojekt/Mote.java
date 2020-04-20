/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import oru.inf.InfDB;
import oru.inf.InfException;

import java.util.HashMap;

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
    
    
    /*
        Skapar ett nytt möte
    */
    public boolean nyttMote(String datum, String tid){
        boolean resultat = false;
        try{
            String fraga2 = "INSERT INTO MOTE(DAG, TID)"+
                        "VALUES("+datum+","+tid+") ";
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
