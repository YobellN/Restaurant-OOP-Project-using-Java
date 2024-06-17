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
    
    public String generateId(){
        return "T"+kDao.generateId();
    }

    public void insertDataTransaksi(Transaksi K){
        K.setId_pesanan(generateId());
        kDao.insert(K);
    } // memasukkan id dari generateID ke objek karyawan lalu insert K ke DAO
    
    public Transaksi searchDataTransaksi (String data){
        return kDao.search(data);
    } // mencari karyawan berdasarkan id, nama, jabatan, username lalu return tipe data karyawan

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
}
