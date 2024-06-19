/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DbConnection;
import interface_DAO.IDAO;
import interface_DAO.ISearchData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Reservasi;
import interface_DAO.IShowDataList;

/**
 *
 * @author Lenovo
 */
public class ReservasiDAO implements IDAO<Reservasi, String>, IShowDataList<Reservasi>, ISearchData<Reservasi, String>{
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;
    
    @Override
    public void insert(Reservasi C){
        con = dbCon.makeConnection();
        
    String sql = 
        "INSERT INTO `reservasi`(`id_reservasi`, `tanggal_reservasi`, `jenis_reservasi`, `paket_reservasi`, `total_harga`) " +
        "VALUES ('" + C.getId_reservasi()+"', '" + C.getTanggal_reservasi() + "', '" + C.getJenis_reservasi()+"', '" + C.getPaket_reservasi() + "', '" + C.getTotal_harga() + "')";
    
        System.out.println("Adding Reservasi...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Reservasi");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding Reservasi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    
    @Override
    public Reservasi search(String id_reservasi){ 
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `reservasi` WHERE id_reservasi='"+id_reservasi+"'";
        System.out.println("Searching Reservasi...");
        Reservasi c = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    c = new Reservasi(
                        rs.getString("id_reservasi"),
                        rs.getString("tanggal_reservasi"),
                        rs.getString("jenis_reservasi"),
                        rs.getString("paket_reservasi"),
                        rs.getFloat("total_harga"));
            
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
    public List<Reservasi> showData(String data){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM reservasi";
        System.out.println("Fetching Data...");
        List<Reservasi> c = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    c.add(new Reservasi(
                        rs.getString("id_reservasi"),
                        rs.getString("tanggal_reservasi"),
                        rs.getString("jenis_reservasi"),
                        rs.getString("paket_reservasi"),
                        rs.getFloat("total_harga")));
            
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
    public void update(Reservasi c, String id_reservasi){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE `reservasi` SET "
                + "`id_reservasi`='" + c.getId_reservasi()+ "',"
                + "`tanggal_reservasi`='" + c.getTanggal_reservasi()+ "',"
                + "`jenis_reservasi`='" + c.getJenis_reservasi()+ "',"
                + "`paket_reservasi`='" + c.getPaket_reservasi()+ "',"
                + "`total_harga`='" + c.getTotal_harga()+ "' "
                + "WHERE `id_reservasi`='" + id_reservasi + "'";
        System.out.println("Updating Reservasi");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Reservasi " + id_reservasi);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Reservasi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public void delete(String id_reservasi){
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `reservasi` WHERE `id_reservasi` = " + id_reservasi + "";
        System.out.println("Deleting Reservasi...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Reservasi " + id_reservasi);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Reservasi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public List<Reservasi> showDataList() {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `reservasi`;";
        System.out.println("Fetching Data...");
        List<Reservasi> data = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    data.add(new Reservasi(
                            rs.getString("id_reservasi"),
                            rs.getString("tanggal_reservasi"),
                            rs.getString("jenis_reservasi"),
                            rs.getString("paket_reservasi"),
                            rs.getFloat("total_harga")
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

    public int generateId(){
        con = dbCon.makeConnection();
        String sql = "SELECT MAX(CAST(SUBSTRING(id_reservasi, 2) AS SIGNED)) AS highest_number FROM reservasi WHERE id_reservasi LIKE 'K%';";
        //mendapatkan nilai tertinggi dari id yang ada di database
        
        System.out.println("Generating Id...");
        int id = 0;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null && rs.next()){
                if(!rs.wasNull())
                    id = rs.getInt("highest_number")+1;
            }
                    
            //memasukan id terakhir ke dalam variabel id
                
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return id;
    }
}
