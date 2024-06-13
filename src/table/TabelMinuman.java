/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Menu;

public class TabelMinuman extends AbstractTableModel{
    private List<Menu> list;

    public TabelMinuman(List<Menu> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 5;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId_menu();
            case 1:
                return list.get(rowIndex).getNama_menu();
            case 2:
                return list.get(rowIndex).getJenis_menu();
            case 3:
                return list.get(rowIndex).getSpecial();
            case 4:
                return list.get(rowIndex).getHarga();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID Menu";
            case 1:
                return "Nama Menu";
            case 2:
                return "Jenis Menu";
            case 3:
                return "Ukuran";
            case 4:
                return "Harga";
            default:
                return null;
        }
    }
}