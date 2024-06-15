package dao;

import java.sql.Statement;
import model.Menu;
import model.Makanan;
import interfaceDAO.IMenuDAO;
import java.util.List;

public class MakananDAO extends MenuDAO implements IMenuDAO{

    public void insert(Makanan mk) {
        super.insert(mk);
        insertNewJenis(mk);
    }

    public void insertNewJenis(Makanan mk) {
        con = dbCon.makeConnection();

        String sql = 
                "INSERT INTO `makanan`(`id_menu`, `catatan`) VALUES ('"
                + mk.getId_menu()
                + "','"
                + mk.getCatatan()
                + "')";

        System.out.println("Adding Menu...");

        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Menu");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding Menu...");
            System.out.println(e);
        }
        dbCon.closeConnection();  
    }

    @Override
    public void deleteOldJenis(String id_menu) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `minuman` WHERE `id_menu` = '"+id_menu+"'";
        System.out.println("Deleting makanan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Menu " + id_menu);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Menu...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void updateJenis (Makanan mk, String id_menu){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE `"
                + mk.getJenis_menu()
                + "` SET `catatan`='"
                + mk.getCatatan()
                + "' WHERE `makanan`.id_menu = '"
                + id_menu
                + "'";
        System.out.println("Updating Jenis Menu...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Menu " + id_menu);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Menu...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void update(Menu m, String id_menu, String catatan) {
        Makanan mk = new Makanan(catatan, m.getId_menu(), m.getNama_menu(), m.getJenis_menu(), m.getHarga(), m.getGambar());
        if(cekPerubahanJenis("Makanan",id_menu)){
            deleteOldJenis(id_menu);
            insertNewJenis(mk);
        }else{
            updateJenis((Makanan) m, id_menu);
        }
        super.update(m, id_menu);
    }


}
