package control;

import dao.MenuDAO;
import interface_Control.ICRUDControl;
import java.util.List;
import model.Menu;

public abstract class MenuControl<T extends Menu> implements ICRUDControl<T, String> {
    protected MenuDAO mDao = new MenuDAO();
    
    public MenuControl(MenuDAO mDao) {
        this.mDao = mDao;
    }
    
    @Override
    public void insert(T menu) {
        menu.setId_menu(generateId());
        mDao.insert(menu);
    }

    @Override
    public void update(T menu) {
        mDao.update(menu, menu.getId_menu());
    }

    @Override
    public void delete(String id) {
        mDao.delete(id);
    }

    @Override
    public String generateId() {
        return "M" + mDao.generateId();
    }

    // Metode abstrak untuk memastikan jenis menu yang tepat
    protected abstract boolean cekJenis(Menu menu);

    // Metode abstrak untuk mengembalikan daftar menu yang sesuai
    public abstract List<T> showListMenu();

    // Metode untuk mencari harga berdasarkan id menu
    public float searchHarga(String id_menu) {
        return mDao.searchHarga(id_menu);
    }
}
