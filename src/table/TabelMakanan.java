/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Makanan;
import model.Menu;

public class TabelMakanan extends AbstractTableModel{
    private List<Menu> list;

    public TabelMakanan(List<Menu> list) {
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
         Makanan makanan = (Makanan) list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return makanan.getId_menu();
            case 1:
                return makanan.getNama_menu();
            case 2:
                return makanan.getJenis_menu();
            case 3:
                return makanan.getSpecial();
            case 4:
                return makanan.getHarga();
            case 5:
                return makanan.getGambar();
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
                return "Catatan";
            case 4:
                return "Harga";
            default:
                return null;
        }
    }
}