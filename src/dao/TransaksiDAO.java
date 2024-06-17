/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import interfaceDAO.IGenerateID;
import interfaceDAO.IShowForDropdown;
import interfaceDAO.ISearchData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Transaksi;

/**
 *
 * @author Tok Se Ka 220711904
 */
public class TransaksiDAO implements IDAO<Transaksi, String>, IShowForDropdown<Transaksi>, IGenerateID, ISearchData<Transaksi, String>{
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;
    
    @Override
    public int generateId(){
        con = dbCon.makeConnection();
        String sql = "SELECT MAX(CAST(SUBSTRING(id_pesanan, 2) AS SIGNED)) AS highest_number FROM transaksi WHERE id_pesanan LIKE 'T%';";
        //mendapatkan nilai tertinggi dari id yang ada di database
        
        System.out.println("Generating Id...");
        int id=0;
        
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
    
    @Override
    public void insert(Transaksi C){
        con = dbCon.makeConnection();
        
    String sql = 
        "INSERT INTO `transaksi`(`id_pesanan`, `id_karyawan`, `id_pelanggan`, `tanggal_pesanan`, `total_harga`) "
            + "VALUES "
            + "('"+ C.getId_pesanan()+"',"
            + "'"+ C.getId_karyawan()+"',"
            + "'"+ C.getId_pelanggan()+"'," 
            + "'"+ C.getTanggal_pesanan()+"',"
            + "'"+ 0 +"'" // set 0 biar default aja
            + ")"; 
    
        System.out.println("Adding Transaksi...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Transaksi");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    
    @Override
    public Transaksi search(String data){ 
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `transaksi` WHERE "
                + "id_pesanan LIKE '%" + data + "%' "
                + " OR id_karyawan LIKE '%" + data + "%' "
                + " OR id_pelanggan LIKE '%" + data + "%' "
                + " OR total_harga LIKE '%" + data + "%' "
                + " OR tanggal_pesanan LIKE '%" + data + "%' " + "";
        System.out.println("Searching Transaksi...");
        Transaksi c = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    c = new Transaksi( 
                        rs.getString("id_pesanan"),
                        rs.getString("id_karyawan"),
                        rs.getString("id_pelanggan"),
                        rs.getString("tanggal_pesanan"),
                        rs.getFloat("total_harga")
                    );
            
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
    public List<Transaksi> showData(String data){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `transaksi` WHERE "
                + "id_pesanan LIKE '%" + data + "%' "
                + " OR id_karyawan LIKE '%" + data + "%' "
                + " OR id_pelanggan LIKE '%" + data + "%' "
                + " OR total_harga LIKE '%" + data + "%' "
                + " OR tanggal_transaksi LIKE '%" + data + "%' " + "";
        System.out.println("Fetching Data...");
        List<Transaksi> c = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    c.add(new Transaksi(
                        rs.getString("id_pesanan"),
                        rs.getString("id_karyawan"),
                        rs.getString("id_pelanggan"),
                        rs.getString("tanggal_pesanan"),
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
        return c;
    }
    
    @Override
    public void update(Transaksi c, String id_pesanan){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE `transaksi` SET "
                + "`id_pesanan`='"+ c.getId_pesanan()+"',"
                + "`id_karyawan`='"+ c.getId_karyawan()+"',"
                + "`id_pelanggan`='"+ c.getId_pelanggan()+"',"
                + "`tanggal_pesanan`='"+ c.getTanggal_pesanan()+"' "
                + "WHERE `id_pesanan`='" + id_pesanan + "'";
        System.out.println("Updating transaksi");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Transaksi " + id_pesanan);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public void delete(String id_pesanan){
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `transaksi` WHERE `id_pesanan`='" + id_pesanan + "'";
        System.out.println("Deleting Transaksi...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Transaksi " + id_pesanan);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Deleting Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    @Override
    public List<Transaksi> IShowForDropdown() { // tidak override karena butuh kondisi where
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `transaksi` "; // hanya show sesuai id_pesanan saat ini
        System.out.println("Fetching Data...");
        List<Transaksi> data = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    data.add(new Transaksi(
                        rs.getString("id_pesanan"),
                        rs.getString("id_karyawan"),
                        rs.getString("id_pelanggan"),
                        rs.getString("tanggal_pesanan"),
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
    
}