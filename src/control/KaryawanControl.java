package control;

import dao.KaryawanDAO;
import interface_Control.IKaryawanControl;
import java.util.List;
import model.Karyawan;
import table.TabelKaryawan;

public class KaryawanControl implements IKaryawanControl {
    private KaryawanDAO kDao;

    public KaryawanControl(KaryawanDAO kDao) { 
        this.kDao = kDao;
    }

    @Override
    public void insert(Karyawan karyawan) { // UNTUK INSERT KARYAWAN
        karyawan.setId_karyawan(generateId());
        kDao.insert(karyawan);
    }

    @Override
    public void update(Karyawan karyawan) { // UNTUK UPDATE KARYAWAN
        kDao.update(karyawan, karyawan.getId_karyawan());
    }

    @Override 
    public void delete(String id) { // UNTUK DELETE KARYAWAN
        kDao.delete(id);
    }

    @Override
    public String generateId() { // UNTUK GENERATE ID
        return "K" + kDao.generateId();
    }

    @Override
    public TabelKaryawan showTableBySearch(String search) { // DIPAKAI UNTUK MENG SHOW KARYAWAN
        List<Karyawan> data = kDao.showData(search);
        return new TabelKaryawan(data);
    }

    @Override 
    public Karyawan searchDataKaryawan(String id) { // DIPAKAI UNTUK MENCARI KARYAWAN SETELAH LOGIN
        return kDao.search(id);
    }
    
    @Override
    public boolean loginKaryawan(String user, String pass, String id){  // DIPAKAI UNTUK LOGIN
        return kDao.cekLogin(user, pass, id);
    }
}
