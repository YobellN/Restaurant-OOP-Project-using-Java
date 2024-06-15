package control;
import dao.MakananDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;
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
    
    public TabelMakanan showTableBySearch(String search){
        List<Menu> data = mkDao.search(search);
        List<Menu> temp = new ArrayList<>(); // Initialize the temp list
        for (Menu menu : data) {
            if (menu.getJenis_menu().equals("Makanan")) {
                temp.add(menu);
                System.out.println("Adding Makanan");
            }
        }
        TabelMakanan tabelMakanan = new TabelMakanan(temp);
        return tabelMakanan;
    }
    
    public void updateDataProduk(Makanan mk){
        mkDao.update(mk, mk.getId_menu(), mk.getCatatan());
    }

}
