package control;
import dao.OriginalDAO;
import java.util.List;
import model.Produk;
import model.Original;

public class OriginalControl {
    OriginalDAO mDao = new OriginalDAO();


        public void insertDataProduk(Original P){
            P.setId_produk("P"+mDao.generateId());
            mDao.insert(P);
        }

        public String showStringProduk(){
            List<Produk> listP = mDao.showData("Original");
            String kendaraanString = "";
            for(Produk p : listP){
                kendaraanString += p.getString() + "\n";
            }
            return kendaraanString;
        }

        public void updateDataProduk(Original P){
            mDao.update(P, P.getId_produk(), P.getJenis_mesin());
        }
}
