/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.PelangganDAO;
import java.util.List;
import model.Pelanggan;
import table.TabelPelanggan;

/**
 *
 * @author yobel
 */
public class PelangganControl {
    PelangganDAO pDao = new PelangganDAO();
    
    public String generateId(){
        return "P-"+pDao.generateId();
    } // Membuat Id dengan awal K dan angka terbesar

    public void insertDataPelanggan(Pelanggan P){
        P.setId_pelanggan(generateId());
        pDao.insert(P);
    } // memasukkan id dari generateID ke objek karyawan lalu insert K ke DAO
    
    public Pelanggan searchDataPelanggan (String data){
        return pDao.search(data);
    } // mencari karyawan berdasarkan id, nama, jabatan, username lalu return tipe data karyawan

    public void updateDataPelanggan(Pelanggan P){
        pDao.update(P, P.getId_pelanggan());
    } // update isi?
    
    public void deleteDataPelanggan(String id){
        pDao.delete(id);
    } // menghapus karyawan di database berdasarkan id
    
    public TabelPelanggan showTable(String target){
        List<Pelanggan> data = pDao.showData(target);
        TabelPelanggan tabelPelanggan = new TabelPelanggan(data);

        return tabelPelanggan;
    }
    
    public List<Pelanggan> showListPelanggan(){
        List<Pelanggan> dataPelanggan = pDao.IShowForDropdown();
        return dataPelanggan;
    }
}
