/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Padfo
 */
public class Kategori {
    
private static InfDB minDatabaskoppling;
    
    public void laggTillKategori(javax.swing.JComboBox<String> cbListaAllaKategorier){
        
        String kategori = (String) cbListaAllaKategorier.getSelectedItem();
        String k_bas = ("select * from KATEGORI where NAMN = '" + kategori + "'");
        String inlagg =  "Sed ut perspiciatis unde omnis";
        String anvandare= "1";
        String Identitet = "9";
        String Status = "N";
        {
            
           System.out.println(kategori);   
           HashMap<String, String> svar;
            try {
                svar = minDatabaskoppling.fetchRow(k_bas);
                String k_id = svar.get("ID");
                System.out.println(k_id);
                {
                    String query = ("insert into BLOGG (ID, TEXT, ANVANDAREID, INFORMELL) values "
                    + "(" + Identitet +  ", '" + inlagg + "', '" + anvandare + "', '" + Status + "')");
                    
                    System.out.println(query);
                    minDatabaskoppling.insert(query);
                    
                    {
                        String query2 = ("insert into BLOGG_TILLHOR_KATEGORI (KATEGORIID, BLOGGID) values "
                    + "(" + k_id +  ", '" +  Identitet + "')");
                    
                    System.out.println(query2);
                    minDatabaskoppling.insert(query2);}
                    
                }

            } catch (InfException ex) {
                 System.out.println("Kategori Exceptions");
            }
    }
            
    
}}


        
