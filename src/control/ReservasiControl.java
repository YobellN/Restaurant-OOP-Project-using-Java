package control;

import dao.ReservasiDAO;
import interface_Control.ICRUDControl;
import interface_Control.IShowTableBySearch;
import java.util.List;
import model.Reservasi;
import table.TabelReservasi;

public class ReservasiControl implements ICRUDControl<Reservasi, String>, IShowTableBySearch<TabelReservasi, String>{
    private ReservasiDAO rDao = new ReservasiDAO();
    
    public String generateId(){
        return "R"+rDao.generateId();
    }
    
    public void insert(Reservasi R){
        R.setId_reservasi(generateId());
        rDao.insert(R);
    }
    
    public Reservasi searchDataReservasi (String data){
        return rDao.search(data);
    }
    
    public void update(Reservasi R){
        rDao.update(R, R.getId_reservasi());
    }
    
    public void delete(String id){
        rDao.delete(id);
    }
    
    public TabelReservasi showTableBySearch(String target){
        List<Reservasi> data = rDao.showData(target);
        TabelReservasi tabelReservasi = new TabelReservasi(data);

        return tabelReservasi;
    }

}
