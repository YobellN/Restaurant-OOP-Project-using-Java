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
import static java.util.Collections.list;
import java.util.List;
import model.Makanan;
import model.Menu;
import model.Minuman;
import model.Pesanan;

/**
 *
 * @author Tok Se Ka 220711904
 */
public class PesananDAO implements IDAOTransaksi<Pesanan, String>{
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
    public List<Pesanan> showData(String data){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM "
                + "pesanan P LEFT JOIN menu M ON P.id_menu = M.id_menu "
                + "LEFT JOIN makanan MK ON M.id_menu = MK.id_menu "
                + "LEFT JOIN minuman MN ON M.id_menu = MN.id_menu "
                + "WHERE (P.id_pesanan LIKE '%" + data + "%' "
                + "OR M.id_menu LIKE '%" + data + "%' "
                + "OR M.nama_menu LIKE '%" + data + "%' "
                + "OR MK.catatan LIKE '%" + data + "%' "
                + "OR MN.ukuran LIKE '%" + data + "%');";
        System.out.println("Fetching Data...");
        List<Pesanan> list = new ArrayList();
        Menu m = null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs != null){
                while(rs.next()){
                    if(rs.getString("jenis_menu").equals("Minuman")){
                        m = new Minuman(
                            rs.getString("ukuran"), //SQL ukuran
                            rs.getString("id_menu"), //SQL id_menu
                            rs.getString("nama_menu"), //SQL nama_menu
                            rs.getString("jenis_menu"), //SQL jenis_menu
                            rs.getFloat("harga"), //SQL harga
                            rs.getBytes("gambar"));
                    }else{
                        m = new Makanan(
                            rs.getString("catatan"), //SQL catatan
                            rs.getString("id_menu"), //SQL id_menu
                            rs.getString("nama_menu"), //SQL nama_menu
                            rs.getString("jenis_menu"), //SQL jenis_menu
                            rs.getFloat("harga"), //SQL harga
                            rs.getBytes("gambar"));
                    }
                    Pesanan p = new Pesanan(
                            rs.getString("id_pesanan"),
                            rs.getString("id_menu"),
                            rs.getInt("jumlah"),
                            rs.getFloat("sub_total"),
                            m
                    );     
                    list.add(p);
                }    
            }                    
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return list;
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
    
    
}
