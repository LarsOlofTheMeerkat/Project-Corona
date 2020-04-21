/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
/**
 *
 * @author Jacob
 */
public class Kalender {
    
    public Kalender(){
        
        
        
    }
    
    public String convertDateToString(String date1){
        String format = "";
        System.out.println(date1);
        String[] Words = date1.split(" ");
        String theDate = date1.replace(Words[Words.length-2], "").trim();
        System.out.println(theDate);
        java.util.Date date = new Date(theDate);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        format = formatter.format(date);
        System.out.println(format);
        return format;
    }
    
    
}
