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
    
    
}
