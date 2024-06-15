package control;
import dao.MinumanDAO;
import java.util.ArrayList;
import java.util.List;
import model.Menu;
import model.Minuman;
import table.TabelMakanan;
import table.TabelMinuman;

public class MinumanControl {
    MinumanDAO mnDao = new MinumanDAO();
    
    public void insertDataMenu(Minuman mn){
        mn.setId_menu("M"+mnDao.generateId());
        mnDao.insert(mn);
    }
    
    public TabelMinuman showTable() {
        List<Menu> data = mnDao.showData("Minuman");
        TabelMinuman tabelMinuman = new TabelMinuman(data);

        return tabelMinuman;
    }
    
    public TabelMinuman showTableBySearch(String search){
        List<Menu> data = mnDao.search(search);
        List<Menu> temp = new ArrayList<>(); // Initialize the temp list
        for (Menu menu : data) {
            if (menu.getJenis_menu().equals("Minuman")) {
                temp.add(menu);
            }
        }
        TabelMinuman tabelMinuman = new TabelMinuman(temp);
        return tabelMinuman;
    }
    
    public void updateDataProduk(Minuman mn){
        mnDao.update(mn, mn.getId_menu(), mn.getUkuran());
    }
}
