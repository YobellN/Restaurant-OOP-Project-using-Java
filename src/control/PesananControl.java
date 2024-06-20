/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.PesananDAO;
import interface_Control.IPesananControl;
import interface_Control.IShowTableBySearch;
import java.util.List;
import model.Pesanan;
import table.TabelPesanan;

/**
 *
 * @author Tok Se Ka 220711904
 */
public class PesananControl implements IPesananControl, IShowTableBySearch<TabelPesanan, String>{
    PesananDAO pDao = new PesananDAO();
    
    public void insertDataPesanan(List<Pesanan> pesananList) {
       for (Pesanan pesanan : pesananList) {
           pDao.insert(pesanan);
       }
    } 
    public void updateDataPesanan(Pesanan P){
        pDao.update(P, P.getId_pesanan(), P.getId_menu());
    } // update isi?
    
    public void deleteDataPesanan(String idPesanan, String idMenu){
        pDao.delete(idPesanan, idMenu);
    } // menghapus karyawan di database berdasarkan id
    
    public TabelPesanan showTableBySearch(String target){
        List<Pesanan> data = pDao.showData(target);
        return new TabelPesanan(data);
    }

    

}
