/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.TransaksiDAO;
import interface_Control.ITransaksiControl;
import java.util.List;
import model.Transaksi;
import table.TabelTransaksi;

/**
 *
 * @author Tok Se Ka 220711904
 */
public class TransaksiControl implements ITransaksiControl {
    private TransaksiDAO kDao;
    
    public TransaksiControl(TransaksiDAO tDao) {
        this.kDao = tDao;
    }
    
    @Override
    public String generateId() {
        return "T" + kDao.generateId();
    }

    @Override
    public void insert(Transaksi transaksi) {
        transaksi.setId_pesanan(generateId());
        kDao.insert(transaksi);
    }

    @Override
    public void update(Transaksi transaksi) {
        kDao.update(transaksi, transaksi.getId_pesanan());
    }

    @Override
    public void delete(String id) {
        kDao.delete(id);
    }

    @Override
    public TabelTransaksi showTableBySearch(String search) {
        List<Transaksi> data = kDao.showData(search);
        return new TabelTransaksi(data);
    }

    public void createReceipt(String id_pesanan){
        kDao.createReceipt(id_pesanan);
    }
    
    @Override
    public void insertTotalHarga(Transaksi transaksi) {
        kDao.updateHarga(transaksi);
    }
    
    public TabelTransaksi showTableByTanggal(String tanggalMulai, String tanggalSelesai){
        List<Transaksi> data = kDao.showDatabyTanggal(tanggalMulai, tanggalSelesai);
        return new TabelTransaksi(data);
    }
    
    public String cariMenuTerlaris(){
        return kDao.cariNamaMenuTerlaris() + " (Terjual " + kDao.cariJumlahProdukTerlaris() +" Item)";
    }
    
    public double hitungTotalOmset(){
        return kDao.hitungTotalOmset();
    }
    
    public int hitungTotalTransaksi(){
        return kDao.hitungTotalTransaksi();
    }
}
