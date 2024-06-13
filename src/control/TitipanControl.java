package control;
import dao.TitipanDAO;
import java.util.List;
import model.Produk;
import model.Titipan;

public class TitipanControl {
    TitipanDAO mDao = new TitipanDAO();
    
    public void insertDataProduk(Titipan mtr){
        mtr.setId_produk("P"+mDao.generateId());
        mDao.insert(mtr);
    }
    
    public String showStringProduk(){
        List<Produk> listK = mDao.showData("Titipan");
        String produkString = "";
        for(Produk k : listK){
            produkString += k.getString() + "\n";
        }
        return produkString;
    }
    
    public void updateDataProduk(Titipan K){
        System.out.println(K.getStok());
        mDao.update(K, K.getId_produk(), K.getStok());
    }
}
