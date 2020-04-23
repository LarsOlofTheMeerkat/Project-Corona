/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author jacob
 */
public class RenderItems {
    
    
    public void renderItems(ArrayList<HashMap<String,String>> items, ArrayList ColumnName, javax.swing.JTable test ){
       
        
        DefaultTableModel model = (DefaultTableModel) test.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[ColumnName.size()];
        for(int p = 0; p < items.size(); p++){
                for(int t = 0; t < rowData.length; t++){
                    rowData[t] = items.get(p).get(ColumnName.get(t));
                }
                model.addRow(rowData);
        }
        
        
    }
    
}
