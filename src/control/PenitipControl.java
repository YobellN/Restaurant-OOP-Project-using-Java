package control;

import model.Karyawan;
import dao.PenitipDAO;
import java.util.List;

public class PenitipControl {
    PenitipDAO cDao = new PenitipDAO();
    
    public void insertDataPenitip(Karyawan p){
        cDao.insert(p);
    }
    
    public String showAllStringPenitip(){
        List<Karyawan> listP = cDao.showData(0);
        String penitipString = "";
        int i=0;
        
        for(Karyawan p : listP){
            i++;
            penitipString+= p.getId_penitip()+". "+p.getNama()+" | "+p.getAlamat()+" | "+p.getNo_telepon()+"\n";
        }
        return penitipString;
    }
    
    public Karyawan searchCustomerById(int id_penitip){ // UBAH MENJADI NAMA
        return cDao.search(id_penitip);
    }
    
    public void updateDataCustomer(Karyawan p, int id_penitip){
        cDao.update(p, id_penitip);
    }
    
    public void deleteDataCustomer(int id_penitip){
        cDao.delete(id_penitip);
    }
    
    // Dropdown
    public List<Karyawan> showListPenitip(){
        List<Karyawan> data = cDao.IShowForDropdown();
        return data;
    }
}