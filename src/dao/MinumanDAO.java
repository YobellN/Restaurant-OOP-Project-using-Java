package dao;

import java.sql.Statement;
import model.Menu;
import model.Minuman;
import interface_DAO.IMenuDAO;

public class MinumanDAO extends MenuDAO implements IMenuDAO{
    public void insert(Minuman mn){
        super.insert(mn);
        insertNewJenis(mn);
    }
    
    public void insertNewJenis(Minuman mn) {
        con = dbCon.makeConnection();

        String sql = 
                "INSERT INTO `minuman`(`id_menu`, `ukuran`) VALUES ('"
                + mn.getId_menu()
                + "','"
                + mn.getSpecial()
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
    
    public void updateJenis (Minuman mn, String id_menu){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE `"
                + mn.getJenis_menu()
                + "` SET `ukuran`='"
                + mn.getUkuran()
                + "' WHERE `minuman`.id_menu = '"
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
    
   
    
    @Override
    public void deleteOldJenis(String id_menu) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `makanan` WHERE `id_menu` = '"+id_menu+"'";
        System.out.println("Deleting original...");
        
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
    
    public void update(Menu m, String id_menu, String ukuran) {
        Minuman mn = new Minuman(ukuran, m.getId_menu(), m.getNama_menu(), m.getJenis_menu(), m.getHarga(), m.getGambar());
        if(cekPerubahanJenis("Minuman",id_menu)){
            deleteOldJenis(id_menu);
            insertNewJenis(mn);
        }else{
            updateJenis((Minuman) m, id_menu);
        }
        super.update(m, id_menu);
    }
}
