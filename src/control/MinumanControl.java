package control;
import dao.MinumanDAO;
import interface_Control.IMinumanControl;
import java.util.ArrayList;
import java.util.List;
import model.Menu;
import model.Minuman;
import table.TabelMinuman;

public class MinumanControl extends MenuControl<Minuman> implements IMinumanControl {

    private MinumanDAO mDAO = new MinumanDAO();

    @Override
    protected boolean cekJenis(Menu menu) {
        return menu instanceof Minuman;
    }

    @Override
    public void insert(Minuman mn) {
        mn.setId_menu(generateId());
        ((MinumanDAO) mDao).insert(mn);  // Cast to MinumanDAO
    }

    @Override
    public void update(Minuman mn) {
        ((MinumanDAO) mDao).update(mn, mn.getId_menu(), mn.getUkuran());  // Cast to MinumanDAO
    }

    @Override
    public TabelMinuman showTableBySearch(String search) {
        List<Menu> data = mDao.showData(search);
        List<Minuman> temp = new ArrayList<>();
        for (Menu menu : data) {
            if (menu.getJenis_menu().equals("Minuman") && cekJenis(menu)) {
                temp.add((Minuman) menu);
                System.out.println("Adding Minuman");
            }
        }
        return new TabelMinuman(temp);
    }

    @Override
    public List<Minuman> showListMenu() {
        List<Menu> data = mDao.showDataList();
        List<Minuman> temp = new ArrayList<>();
        for (Menu menu : data) {
            if (cekJenis(menu)) {
                temp.add((Minuman) menu);
            }
        }
        return temp;
    }
}
