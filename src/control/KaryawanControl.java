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
    public void insert(Karyawan karyawan) {
        karyawan.setId_karyawan(generateId());
        kDao.insert(karyawan);
    }

    @Override
    public void update(Karyawan karyawan) {
        kDao.update(karyawan, karyawan.getId_karyawan());
    }

    @Override
    public void delete(String id) {
        kDao.delete(id);
    }

    @Override
    public String generateId() {
        return "K" + kDao.generateId();
    }

    @Override
    public TabelKaryawan showTableBySearch(String search) {
        List<Karyawan> data = kDao.showData(search);
        return new TabelKaryawan(data);
    }

    @Override
    public Karyawan searchDataKaryawan(String id) {
        return kDao.search(id);
    }
    
    @Override
    public boolean loginKaryawan(String user, String pass, String id){
        return kDao.cekLogin(user, pass, id);
    }
}
