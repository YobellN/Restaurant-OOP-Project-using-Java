/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Pesanan;

/**
 *
 * @author Tok Se Ka 220711904
 */
public class TabelPesanan extends AbstractTableModel{
    private List<Pesanan> list;

    public TabelPesanan(List<Pesanan> list) {
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
                return list.get(rowIndex).getNamaMenu();
            case 2:
                return list.get(rowIndex).getJumlah();
            case 3:
                return list.get(rowIndex).getSub_total();
            case 4:
                return list.get(rowIndex).getId_pesanan();
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
                return "Jumlah";
            case 3:
                return "Sub Total";
            default:
                return null;
        }
    }
}
