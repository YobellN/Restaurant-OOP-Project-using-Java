package control;

import model.Penitip;
import dao.PenitipDAO;
import java.util.List;

public class PenitipControl {
    PenitipDAO cDao = new PenitipDAO();
    
    public void insertDataPenitip(Penitip p){
        cDao.insert(p);
    }
    
    public String showAllStringPenitip(){
        List<Penitip> listP = cDao.showData(0);
        String penitipString = "";
        int i=0;
        
        for(Penitip p : listP){
            i++;
            penitipString+= p.getId_penitip()+". "+p.getNama()+" | "+p.getAlamat()+" | "+p.getNo_telepon()+"\n";
        }
        return penitipString;
    }
    
    public Penitip searchCustomerById(int id_penitip){ // UBAH MENJADI NAMA
        return cDao.search(id_penitip);
    }
    
    public void updateDataCustomer(Penitip p, int id_penitip){
        cDao.update(p, id_penitip);
    }
    
    public void deleteDataCustomer(int id_penitip){
        cDao.delete(id_penitip);
    }
    
    // Dropdown
    public List<Penitip> showListPenitip(){
        List<Penitip> data = cDao.IShowForDropdown();
        return data;
    }
}