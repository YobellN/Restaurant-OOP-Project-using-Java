/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import interfaceDAO.ISearchData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pelanggan;
import interfaceDAO.IShowForDropdown;

public class PelangganDAO implements IDAO<Pelanggan, String>, IShowForDropdown<Pelanggan>, ISearchData<Pelanggan, String>{
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    @Override
    public void insert(Pelanggan C){
        con = dbCon.makeConnection();
        
    String sql = 
        "INSERT INTO `pelanggan` (`id_pelanggan`, `nama_pelanggan`, `alamat`, `nomor_telepon`) " +
        "VALUES ('"+C.getId_pelanggan()+"', '"+ C.getNama_pelanggan() +"', '"+ C.getAlamat_pelanggan() +"', '"+ C.getNomor_telepon() +"')";
    
        System.out.println("Adding Pelanggan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Pelanggan");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding Pelanggan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public Pelanggan search(String id_pelanggan){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM pelanggan WHEWE id_pelanggan ='"+id_pelanggan+"'";
        System.out.println("Searching customer...");
        Pelanggan c = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    c = new Pelanggan(
                        rs.getString("id_pelanggan"),
                        rs.getString("nama_pelanggan"),
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
    public List<Pelanggan> showData(String data){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM pelanggan";
        System.out.println("Fetching Data...");
        List<Pelanggan> c = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    c.add(new Pelanggan(
                        rs.getString("id_pelanggan"),
                        rs.getString("nama_pelanggan"),
                        rs.getString("alamat"),
                        rs.getString("nomor_telepon")));
            // ingat, jika tidak perlu pakai {} maka hilangkan saja (ytta)
            // selama bisa dibaca
            
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
    public void update(Pelanggan c, String id_pelanggan){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE `pelanggan` SET "
                + "`id_pelanggan`='" + c.getId_pelanggan()+ "',"
                + "`nama_pelanggan`='" + c.getNama_pelanggan()+ "',"
                + "`alamat`='" + c.getAlamat_pelanggan()+ "',"
                + "`nomor_telepon`='" + c.getNomor_telepon()+ "' "
                + "WHERE `id_pelanggan`='" + c.getAlamat_pelanggan() + "'";
        System.out.println("Updating pelanggan");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Pelanggan" + id_pelanggan);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Pelanggan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public void delete(String id_pelanggan){
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `pelanggan` WHERE `id_pelanggan` = " + id_pelanggan + "";
        System.out.println("Deleting Pelanggan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Pelanggan " + id_pelanggan);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Pelanggan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    

    public List<Pelanggan> IShowForDropdown(){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM pelanggan";
        System.out.println("Fetching Data...");
        List<Pelanggan> c = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    c.add(new Pelanggan(
                        rs.getString("id_pelanggan"),
                        rs.getString("nama_pelanggan"),
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
}