package control;

import dao.KaryawanDAO;
import java.util.List;
import model.Karyawan;
import table.TabelKaryawan;

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
    
    public TabelKaryawan showTable(){
        List<Karyawan> data = kDao.showData("Kasir");
        TabelKaryawan tabelKaryawan = new TabelKaryawan(data);

        return tabelKaryawan;
    }
    
}
