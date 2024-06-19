package control;
import dao.MakananDAO;
import interface_Control.IMakananControl;
import java.util.ArrayList;
import java.util.List;
import model.Makanan;
import model.Menu;
import table.TabelMakanan;

public class MakananControl extends MenuControl<Makanan> implements IMakananControl {
    public MakananControl(MakananDAO mkDao) {
        super(mkDao);
    }

    @Override
    protected boolean cekJenis(Menu menu) {
        return menu instanceof Makanan;
    }

    @Override
    public void insert(Makanan mk) {
        mk.setId_menu(generateId());
        ((MakananDAO) mDao).insert(mk);  // Cast to MakananDAO
    }

    @Override
    public void update(Makanan mk) {
        ((MakananDAO) mDao).update(mk, mk.getId_menu(), mk.getCatatan());  // Cast to MakananDAO
    }

    @Override
    public TabelMakanan showTableBySearch(String search) {
        List<Menu> data = mDao.showData(search);
        List<Makanan> temp = new ArrayList<>();
        for (Menu menu : data) {
            if (menu.getJenis_menu().equals("Makanan") && cekJenis(menu)) {
                temp.add((Makanan) menu);
                System.out.println("Adding Makanan");
            }
        }
        return new TabelMakanan(temp);
    }

    @Override
    public List<Makanan> showListMenu() {
        List<Menu> data = mDao.showDataList();
        List<Makanan> temp = new ArrayList<>();
        for (Menu menu : data) {
            if (cekJenis(menu)) {
                temp.add((Makanan) menu);
            }
        }
        return temp;
    }
}