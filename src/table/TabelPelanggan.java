package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Pelanggan;

public class TabelPelanggan extends AbstractTableModel{
    private List<Pelanggan> list;

    public TabelPelanggan(List<Pelanggan> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId_pelanggan();
            case 1:
                return list.get(rowIndex).getNama_pelanggan();
            case 2:
                return list.get(rowIndex).getNomor_telepon();
            case 3:
                return list.get(rowIndex).getAlamat_pelanggan();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID Pelanggan";
            case 1:
                return "Nama Pelanggan";
            case 2:
                return "Nomor Telepon";
            case 3:
                return "Alamat";
            default:
                return null;
        }
    }
}