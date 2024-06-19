package control;

import dao.ReservasiDAO;
import java.util.List;
import model.Reservasi;
import table.TabelReservasi;

public class ReservasiControl {
    private ReservasiDAO rDao = new ReservasiDAO();
    
    public String generateId(){
        return "R"+rDao.generateId();
    }
    
    public void insertDataReservasi(Reservasi R){
        R.setId_reservasi(generateId());
        rDao.insert(R);
    }
    
    public Reservasi searchDataReservasi (String data){
        return rDao.search(data);
    }
    
    public void updateDataReservasi(Reservasi R, String id){
        rDao.update(R, id);
    }
    
    public void deleteDataReservasi(String id){
        rDao.delete(id);
    }
    
    public TabelReservasi showTable(String target){
        List<Reservasi> data = rDao.showData(target);
        TabelReservasi tabelReservasi = new TabelReservasi(data);

        return tabelReservasi;
    }
    
}
