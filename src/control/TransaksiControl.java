/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.TransaksiDAO;
import java.util.List;
import model.Transaksi;
import table.TabelTransaksi;

/**
 *
 * @author Tok Se Ka 220711904
 */
public class TransaksiControl {
    TransaksiDAO kDao = new TransaksiDAO();
    
    public String generateId(){ // DIPAKAI UNTUK MEMBUAT ID BARU
        return "T"+kDao.generateId();
    }

    public void insertDataTransaksi(Transaksi K){ // DIPAKAI UNTUK MEMASUKKAN TRANSAKSI KE SQL
        K.setId_pesanan(generateId());
        kDao.insert(K);
    } 
    
    public void insertTotalHarga(Transaksi K){ // DIPAKAI UNTUK INSERT HARGA 
        kDao.updateHarga(K);
    }

    public void updateDataTransaksi(Transaksi K){
        kDao.update(K, K.getId_pesanan());
    } // update isi?
    
    public void deleteDataTransaksi(String idTransaksi, String idMenu){
        kDao.delete(idTransaksi);
    } // menghapus karyawan di database berdasarkan id
    
    public TabelTransaksi showTable(String target){
        List<Transaksi> data = kDao.showData(target);
        TabelTransaksi tabelTransaksi = new TabelTransaksi(data);

        return tabelTransaksi;
    }
    
    public void createReceipt(String id_pesanan){
        kDao.createReceipt(id_pesanan);
    }
}
