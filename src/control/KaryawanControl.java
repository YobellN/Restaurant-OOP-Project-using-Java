package control;

import dao.KaryawanDAO;
import java.util.List;
import model.Karyawan;
import table.TabelKaryawan;

public class KaryawanControl {
    KaryawanDAO kDao = new KaryawanDAO();
    
    public String generateId(){ // DIPAKAI UNTUK MEMBUAT ID KARYAWAN
        return "K"+kDao.generateId();
    } // Membuat Id dengan awal K dan angka terbesar

    public void insertDataKaryawan(Karyawan K){ // DIPAKAI UNTUK MEMASUKKAN DATA DARI OBJEK KE mySQL
        K.setId_karyawan(generateId());
        kDao.insert(K);
    } // memasukkan id dari generateID ke objek karyawan lalu insert K ke DAO
    
    public Karyawan searchDataKaryawan (String data){ // DIPAKAI UNTUK MENCARI DATA KARYAWAN
        return kDao.search(data);
    } // mencari karyawan berdasarkan id, nama, jabatan, username lalu return tipe data karyawan

    public void updateDataKaryawan(Karyawan K){ // DIPAKAI UNTUK UPDATE DATA KARYAWAN
        kDao.update(K, K.getId_karyawan());
    } // update isi?
    
    public void deleteDataKaryawan(String id){ // DIPAKAI UNTUK MENGHAPUS DATA KARYAWAN
        kDao.delete(id);
    } // menghapus karyawan di database berdasarkan id
    
    public TabelKaryawan showTable(String target){ // DIPAKAI UNTUK SHOW TABLE
        List<Karyawan> data = kDao.showData(target);
        TabelKaryawan tabelKaryawan = new TabelKaryawan(data);

        return tabelKaryawan;
    }
    
    public boolean loginKaryawan(String user, String pass, String id){ //DIPAKAI UNTUK LOGIN AWAL
        return kDao.cekLogin(user, pass, id);
    }
}
