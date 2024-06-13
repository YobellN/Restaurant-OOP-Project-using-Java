/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.PenitipanDAO;
import java.util.List;
import model.Penitipan;
import table.TableJunction;

public class PenitipanControl {
    private PenitipanDAO dDao = new PenitipanDAO();
    
    public void insertData(Penitipan data){
        dDao.insert(data);
    }
   
    public TableJunction showTable(String target){
        List<Penitipan> fetchData = dDao.showData(target);
        TableJunction tableData = new TableJunction(fetchData);
        
        for (Penitipan asData : fetchData) {
            System.out.println(asData.getJumlah_titipan());
        }
        
        return tableData;
    }
    
    public void updateData(Penitipan data, int dataId){
        dDao.update(data, Integer.toString(dataId));
    }
    
    public void deleteData(int dataId){
        dDao.delete(Integer.toString(dataId));
    }
}
