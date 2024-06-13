package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Penitip;
import interfaceDAO.IShowForDropdown;
import interfaceDAO.ISearchData;

public class PenitipDAO implements IDAO<Penitip, Integer>, IShowForDropdown<Penitip>, ISearchData<Penitip, Integer>{ // OK , i guess
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;
    
    @Override
    public void insert(Penitip C){
        con = dbCon.makeConnection();
        
    String sql = 
        "INSERT INTO `penitip`(`nama_penitip`, `alamat`, `nomor_telepon`) " +
        "VALUES ('"+ C.getNama() +"', '"+ C.getAlamat() +"', '"+ C.getNo_telepon() +"')";
    
        System.out.println("Adding Penitip...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Penitip");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding Penitip...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
//    @Override
    @Override
    public Penitip search(Integer id_penitip){ 
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `penitip` WHERE id_penitip='"+id_penitip+"'";
        System.out.println("Searching Penitip...");
        Penitip c = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    c = new Penitip(
                        rs.getInt("id_penitip"),
                        rs.getString("nama_penitip"),
                        rs.getString("alamat"),
                        rs.getString("nomor_telepon"));
            
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return c;
    }
    
    @Override
    public List<Penitip> showData(Integer data){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM penitip";
        System.out.println("Fetching Data...");
        List<Penitip> c = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    c.add(new Penitip(
                        rs.getInt("id_penitip"),
                        rs.getString("nama_penitip"),
                        rs.getString("alamat"),
                        rs.getString("nomor_telepon")));
            
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return c;
    }
    
    @Override
    public void update(Penitip c, Integer id_penitip){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE `penitip` SET "
                + "`nama`='" + c.getNama() + "',"
                + "`alamat`='" + c.getAlamat() + "',"
                + "`nomor_telepon`='" + c.getNo_telepon() + "' "
                + "WHERE `id_penitip`='" + id_penitip + "'";
        System.out.println("Updating penitip");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Penitip " + id_penitip);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Penitip...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public void delete(Integer id_penitip){
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `penitip` WHERE `id_penitip` = " + id_penitip + "";
        System.out.println("Deleting Penitip...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Penitip " + id_penitip);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Penitip...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public List<Penitip> IShowForDropdown() {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `penitip`;";
        System.out.println("Fetching Data...");
        List<Penitip> data = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    data.add(new Penitip(
                            rs.getInt("id_penitip"), 
                            rs.getString("nama_penitip"), 
                            rs.getString("alamat"), 
                            rs.getString("nomor_telepon")
                        )
                    );
            
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
        return data;
    }

    

}