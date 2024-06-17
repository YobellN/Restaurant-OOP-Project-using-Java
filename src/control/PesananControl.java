/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.PesananDAO;
import java.util.List;
import model.Pesanan;
import table.TabelPesanan;

/**
 *
 * @author Tok Se Ka 220711904
 */
public class PesananControl {
    PesananDAO kDao = new PesananDAO();

    public void insertDataPesanan(Pesanan K){
        kDao.insert(K);
    } // memasukkan id dari generateID ke objek karyawan lalu insert K ke DAO
    
    public Pesanan searchDataPesanan (String data){
        return kDao.search(data);
    } // mencari karyawan berdasarkan id, nama, jabatan, username lalu return tipe data karyawan

    public void updateDataPesanan(Pesanan K){
        kDao.update(K, K.getId_pesanan(), K.getId_menu());
    } // update isi?
    
    public void deleteDataPesanan(String idPesanan, String idMenu){
        kDao.delete(idPesanan, idMenu);
    } // menghapus karyawan di database berdasarkan id
    
    public TabelPesanan showTable(String target){
        List<Pesanan> data = kDao.showData(target);
        TabelPesanan tabelPesanan = new TabelPesanan(data);

        return tabelPesanan;
    }
}
