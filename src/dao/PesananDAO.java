/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DbConnection;
import interfaceDAO.IDAOTransaksi;
import interfaceDAO.ISearchData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pesanan;

/**
 *
 * @author Tok Se Ka 220711904
 */
public class PesananDAO implements IDAOTransaksi<Pesanan, String>, ISearchData<Pesanan, String>{ // OK , i guess
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;
    
    @Override
    public void insert(Pesanan C){
        con = dbCon.makeConnection();
        
    String sql = 
        "INSERT INTO `pesanan`(`id_pesanan`, `id_menu`, `jumlah`, `sub_total`) "
            + "VALUES "
            + "('"+ C.getId_pesanan()+"',"
            + "'"+ C.getId_menu()+"',"
            + "'"+ C.getJumlah()+"'," 
            + "'"+ C.getSub_total()+"')"; // nanti di control aja setSub_total
    
        System.out.println("Adding Pesanan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Pesanan");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding Pesanan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    
    @Override
    public Pesanan search(String data){ 
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `pesanan` WHERE "
                + "id_pesanan LIKE '%" + data + "%' "
                + " OR id_menu LIKE '%" + data + "%' "
                + " OR jumlah LIKE '%" + data + "%' "
                + " OR sub_total LIKE '%" + data + "%' " + "";
        System.out.println("Searching Pesanan...");
        Pesanan c = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    c = new Pesanan( 
                        rs.getString("id_pesanan"),
                        rs.getString("id_menu"),
                        rs.getInt("jumlah"),
                        rs.getFloat("sub_total")
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
    public List<Pesanan> showData(String data){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `pesanan` WHERE "
                + "id_pesanan LIKE '%" + data + "%' "
                + " OR id_menu LIKE '%" + data + "%' "
                + " OR jumlah LIKE '%" + data + "%' "
                + " OR sub_total LIKE '%" + data + "%' " + "";
        System.out.println("Fetching Data...");
        List<Pesanan> c = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    c.add(new Pesanan(
                        rs.getString("id_pesanan"),
                        rs.getString("id_menu"),
                        rs.getInt("jumlah"),
                        rs.getFloat("sub_total"))
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
    public void update(Pesanan c, String id_pesanan, String id_menu){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE `pesanan` SET "
                + "`id_pesanan`='"+ c.getId_pesanan()+"',"
                + "`id_menu`='"+ c.getId_menu()+"',"
                + "`jumlah`='"+ c.getJumlah()+"',"
                + "`sub_total`='"+ c.getSub_total()+"' "
                + "WHERE `id_pesanan`='" + id_pesanan + "'"
                + "AND `id_menu`='" + id_menu + "'";
        System.out.println("Updating pesanan");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Pesanan " + id_pesanan);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Pesanan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public void delete(String id_pesanan, String id_menu){
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `pesanan` "
                + "WHERE `id_pesanan`='" + id_pesanan + "'"
                + "AND `id_menu`='" + id_menu + "'";
        System.out.println("Deleting Pesanan...???");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Pesanan " + id_pesanan + " Menu " + id_menu);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Deleting Pesanan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Pesanan> IShowForDropdown(String id_pesanan) { // tidak override karena butuh kondisi where
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `pesanan` WHERE "
                + "id_pesanan = "+ id_pesanan + " "; // hanya show sesuai id_pesanan saat ini
        System.out.println("Fetching Data...");
        List<Pesanan> data = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    data.add(new Pesanan(
                            rs.getString("id_pesanan"),
                            rs.getString("id_menu"),
                            rs.getInt("jumlah"),
                            rs.getFloat("sub_total")
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
