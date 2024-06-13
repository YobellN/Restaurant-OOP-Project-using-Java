package control;

import dao.ProdukDAO;
import java.util.List;
import model.Produk;

public class ProdukControl {
    ProdukDAO pDao = new ProdukDAO();
    
    public String generateId(){
        return "P"+pDao.generateId();
    }

    public Produk searchDataProduk (String id){
        return pDao.search(id);
    }

    public void deleteDataProduk(String id){
        pDao.delete(id);
    }
    
    // Dropdown
    public List<Produk> showListProduk(){
        List<Produk> data = pDao.IShowForDropdown();
        
        System.out.println("Ini jumlah: " + data.size());
        
        return data;
    }
}
