/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.PelangganDAO;
import interface_Control.IPelangganControl;
import java.util.List;
import model.Pelanggan;
import table.TabelPelanggan;

/**
 *
 * @author yobel
 */
public class PelangganControl implements IPelangganControl {
    private PelangganDAO pDao;

    public PelangganControl(PelangganDAO pDao) {
        this.pDao = pDao;
    }

    @Override
    public void insert(Pelanggan pelanggan) {
        pelanggan.setId_pelanggan(generateId());
        pDao.insert(pelanggan);
    }

    @Override
    public void update(Pelanggan pelanggan) {
        pDao.update(pelanggan, pelanggan.getId_pelanggan());
    }

    @Override
    public void delete(String id) {
        pDao.delete(id);
    }

    @Override
    public String generateId() {
        return "P-" + pDao.generateId();
    }

    @Override
    public TabelPelanggan showTableBySearch(String search) {
        List<Pelanggan> data = pDao.showData(search);
        return new TabelPelanggan(data);
    }

    @Override
    public Pelanggan searchDataPelanggan(String id) {
        return pDao.search(id);
    }
    
    public List<Pelanggan> showListPelanggan(){
        List<Pelanggan> dataPelanggan = pDao.showDataList();
        return dataPelanggan;
    }
}
