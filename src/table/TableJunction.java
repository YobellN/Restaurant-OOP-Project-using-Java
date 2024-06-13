/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package table;
//
//import java.util.List;
//import javax.swing.table.AbstractTableModel;
//import model.Penitipan;
//
//public class TableJunction extends AbstractTableModel{
//    private List<Penitipan> list;
//
//    public TableJunction(List<Penitipan> list) {
//        this.list = list;
//    }
//    
//    @Override
//    public int getRowCount(){
//        return list.size();
//    }
//    
//    @Override
//    public int getColumnCount(){
//        return 7;
//    }
//    
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex){
//        switch(columnIndex){
//            case 0:
//                return list.get(rowIndex).getPenitip().getNama();
//            case 1:
//                return list.get(rowIndex).getProduk().getNama();
//            case 2:
//                return list.get(rowIndex).getProduk().getJenis();
//            case 3:
//                return list.get(rowIndex).getCatatan();
//            case 4:
//                return list.get(rowIndex).getStatus_penitipan();
//            case 5:
//                return list.get(rowIndex).getJumlah_titipan();
//            case 6:
//                return list.get(rowIndex).getTanggal_penitipan();
//            case 7:
//                return list.get(rowIndex).getId_penitip();
//            case 8:
//                return list.get(rowIndex).getId_produk();
//            case 9:
//                return list.get(rowIndex).getId_penitipan();
//            default:
//                return null;
//        }
//    }
//    
//    @Override
//    public String getColumnName(int column){
//        switch(column){
//            case 0:
//                return "Nama Penitip";
//            case 1:
//                return "Nama Produk Titipan";
//            case 2:
//                return "Jenis";
//            case 3:
//                return "Catatan";
//            case 4:
//                return "Status Penitipan";
//            case 5:
//                return "Jumlah Titipan";
//            case 6:
//                return "Tanggal Penitipan";
//            default:
//                return null;
//        }
//    }
//}