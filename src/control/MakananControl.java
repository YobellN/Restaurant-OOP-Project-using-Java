package control;
import dao.MakananDAO;
import java.util.List;
import model.Makanan;
import model.Menu;
import table.TabelMakanan;

public class MakananControl {
    MakananDAO mkDao = new MakananDAO();

    public void insertDataMenu(Makanan mk){
        mk.setId_menu("M"+mkDao.generateId());
        mkDao.insert(mk);
    }

    public TabelMakanan showTable(){
        List<Menu> data = mkDao.showData("Makanan");
        TabelMakanan tabelMakanan = new TabelMakanan(data);

        return tabelMakanan;
    }

    public void updateDataProduk(Makanan mk){
        mkDao.update(mk, mk.getId_menu(), mk.getCatatan());
    }
}
