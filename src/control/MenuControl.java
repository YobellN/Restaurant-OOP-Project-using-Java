package control;

import dao.MenuDAO;
import java.util.List;
import model.Menu;
import table.TabelMakanan;
import table.TabelMinuman;

public class MenuControl {
    MenuDAO mDao = new MenuDAO();
    
    public String generateId(){
        return "M"+mDao.generateId();
    }

    
    public void deleteDataMenu(String id_menu){
        mDao.delete(id_menu);
    }
    
    // Dropdown
    public List<Menu> showListMenu(){
        List<Menu> data = mDao.IShowForDropdown();  
        return data;
    }
    
}
