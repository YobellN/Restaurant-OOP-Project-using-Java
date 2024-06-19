package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Reservasi;

public class TabelReservasi extends AbstractTableModel{
    private List<Reservasi> list;

    public TabelReservasi(List<Reservasi> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 9;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId_reservasi();
            case 1:
                return list.get(rowIndex).getId_pelanggan();
            case 2:
                return list.get(rowIndex).getPelanggan().getNama_pelanggan();
            case 3:
                return list.get(rowIndex).getPelanggan().getNomor_telepon();
            case 4:
                return list.get(rowIndex).getPelanggan().getAlamat_pelanggan();
            case 5:
                return list.get(rowIndex).getJenis_reservasi();
            case 6:
                return list.get(rowIndex).getPaket_reservasi();
            case 7:
                return list.get(rowIndex).getTanggal_reservasi();
            case 8:
                return "Rp " + list.get(rowIndex).getTotal_harga();
            case 9:
                return list.get(rowIndex).getPelanggan();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID Reservasi";
            case 1:
                return "ID Pelanggan";
            case 2:
                return "Nama Pelanggan";
            case 3:
                return "No Telepon Pelanggan";
            case 4:
                return "Alamat Pelanggan";
            case 5:
                return "Jenis";
            case 6:
                return "Paket";
            case 7:
                return "Tanggal";
            case 8:
                return "Total Harga";
            default:
                return null;
        }
    }
}