package control;

import dao.KaryawanDAO;
import java.util.List;
import model.Karyawan;

public class KaryawanControl {
    KaryawanDAO kDao = new KaryawanDAO();
    
    public String generateId(){
        return "K"+kDao.generateId();
    } // Membuat Id dengan awal K dan angka terbesar

    public void insertDataProduk(Karyawan K){
        K.setId_karyawan(generateId());
        kDao.insert(K);
    } // memasukkan id dari generateID ke objek karyawan lalu insert K ke DAO
    
    public Karyawan searchDataKaryawan (String id){
        return kDao.search(id);
    } // mencari karyawan berdasarkan ID lalu return tipe data karyawan

    public void updateDataProduk(Karyawan K){
        kDao.update(K, K.getId_karyawan());
    } // update isi?
    
    public void deleteDataKaryawan(String id){
        kDao.delete(id);
    } // menghapus karyawan di database berdasarkan id
    
    // Dropdown
    public List<Karyawan> showListKaryawan(){
        List<Karyawan> data = kDao.IShowForDropdown();
        
        System.out.println("Ini jumlah: " + data.size());
        
        return data;
    }
}
