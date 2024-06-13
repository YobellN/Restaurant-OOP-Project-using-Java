package control;

import dao.MenuDAO;
import java.util.List;
import model.Menu;

public class MenuControl {
    MenuDAO mDao = new MenuDAO();
    
    public String generateId(){
        return "M"+mDao.generateId();
    }

    public Menu searchDataMenu (String id_menu){
        return mDao.search(id_menu);
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
