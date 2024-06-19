package control;
import dao.MakananDAO;
import interface_Control.IMakananControl;
import java.util.ArrayList;
import java.util.List;
import model.Makanan;
import model.Menu;
import table.TabelMakanan;

public class MakananControl extends MenuControl<Makanan> implements IMakananControl {
    private MakananDAO mkDao;
    
    public MakananControl(MakananDAO mDao) {
        super(mDao);
        this.mkDao = mDao; // Inisialisasi mkDao
    }
    
    @Override
    protected boolean cekJenis(Menu menu) {
        return menu instanceof Makanan;
    }

    @Override
    public void insert(Makanan mk) {
        mk.setId_menu(generateId());
        mkDao.insert(mk);  // Tidak perlu casting, karena mkDao sudah bertipe MakananDAO
    }

    @Override
    public void update(Makanan mk) {
        mkDao.update(mk, mk.getId_menu(), mk.getCatatan());  // Tidak perlu casting, karena mkDao sudah bertipe MakananDAO
    }

    @Override
    public TabelMakanan showTableBySearch(String search) {
        List<Menu> data = mkDao.showData(search);
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
        List<Menu> data = mkDao.showDataList();
        List<Makanan> temp = new ArrayList<>();
        for (Menu menu : data) {
            if (cekJenis(menu)) {
                temp.add((Makanan) menu);
            }
        }
        return temp;
    }
}