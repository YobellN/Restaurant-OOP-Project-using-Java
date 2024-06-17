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

    public void insertDataKaryawan(Karyawan K){
        K.setId_karyawan(generateId());
        kDao.insert(K);
    } // memasukkan id dari generateID ke objek karyawan lalu insert K ke DAO
    
    public Karyawan searchDataKaryawan (String data){
        return kDao.search(data);
    } // mencari karyawan berdasarkan id, nama, jabatan, username lalu return tipe data karyawan

    public void updateDataKaryawan(Karyawan K){
        kDao.update(K, K.getId_karyawan());
    } // update isi?
    
    public void deleteDataKaryawan(String id){
        kDao.delete(id);
    } // menghapus karyawan di database berdasarkan id
    
    public TabelKaryawan showTable(String target){
        List<Karyawan> data = kDao.showData(target);
        TabelKaryawan tabelKaryawan = new TabelKaryawan(data);

        return tabelKaryawan;
    }
    
    public boolean loginKaryawan(String user, String pass, String id){
        return kDao.cekLogin(user, pass, id);
    }
    
}
