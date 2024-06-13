package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class PenitipanDAO implements IDAO<Penitipan, String>{
    private DbConnection dbCon = new DbConnection();
    private Connection con;

    @Override
    public void insert(Penitipan data) {
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO `penitipan` "
                + "(`id_penitip`, `id_produk`, `catatan`, "
                + "`status_penitipan`, `tanggal_penitipan`, `jumlah_titipan`) "
                + "VALUES "
                + "('" + data.getId_penitip() + "', '" + data.getId_produk() + "', '" + data.getCatatan() + "', "
                + "'" + data.getStatus_penitipan()+ "', '" + data.getTanggal_penitipan() + "', '" + data.getJumlah_titipan() + "');";
        
        System.out.println("Adding Data...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Data");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding Data...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }

    @Override
    public List<Penitipan> showData(String data) {
        con = dbCon.makeConnection();
        
        
        String sql = "SELECT PE.*, PR.*, P.*, O.deskripsi, T.stok "
           + "FROM penitipan PE "
           + "JOIN produk PR ON PE.id_produk = PR.id_produk "
           + "LEFT JOIN penitip P ON PE.id_penitip = P.id_penitip "
           + "LEFT JOIN original O ON PE.id_produk = O.id_produk "
           + "LEFT JOIN titipan T ON PE.id_produk = T.id_produk "
           + "WHERE P.nama_penitip LIKE '%" + data + "%' "
           + "OR P.nomor_telepon LIKE '%" + data + "%' "
           + "OR P.alamat LIKE '%" + data + "%' "
           + "OR PE.catatan LIKE '%" + data + "%' "
           + "OR PE.status_penitipan LIKE '%" + data + "%';";
        
        System.out.println("Mengambil data Pembelian Kendaraan...");
        List<Penitipan> list = new ArrayList();
        
        Karyawan targetSingleData = null;
        Produk targetMultiData = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    targetSingleData = new Karyawan(
                        rs.getInt("P.id_penitip"),
                        rs.getString("P.nama_penitip"),
                        rs.getString("P.nomor_telepon"),
                        rs.getString("P.alamat")
                    );
                    
                    if(rs.getString("jenis").equals("Titipan")){
                        targetMultiData = new Titipan(
                            rs.getInt("T.stok"),
                            rs.getString("PR.id_produk"), 
                            rs.getString("PR.nama_produk"), 
                            rs.getString("PR.jenis"),
                            rs.getFloat("PR.harga")
                        );
                    }
                    else{
                        targetMultiData = new Original(
                            rs.getString("O.deskripsi"),
                            rs.getString("PR.id_produk"), 
                            rs.getString("PR.nama_produk"), 
                            rs.getString("PR.jenis"),
                            rs.getFloat("PR.harga")
                        );
                    };
                
                    Penitipan dataCreation = new Penitipan(
                            rs.getInt("PE.id_penitipan"),
                            rs.getInt("PE.id_penitip"),
                            rs.getString("PE.id_produk"),
                            rs.getString("PE.catatan"),
                            rs.getString("PE.status_penitipan"),
                            rs.getString("PE.tanggal_penitipan"),
                            rs.getInt("PE.jumlah_titipan"),
                            targetSingleData,
                            targetMultiData
                    );       
                    
                    list.add(dataCreation);
                }
            }
            
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        
        System.out.println("Berhasil");
        dbCon.closeConnection();
        return list;
    }

    @Override
    public void update(Penitipan data, String data2) {
        con = dbCon.makeConnection();
        
        String sql = "UPDATE `penitipan` SET "
                + "`id_penitip` = " + data.getId_penitip() + ", "
                + "`id_produk` = '" + data.getId_produk() + "', "
                + "`catatan` = '" + data.getCatatan() + "', "
                + "`status_penitipan` = '" + data.getStatus_penitipan() + "', "
                + "`tanggal_penitipan` = '" + data.getTanggal_penitipan() + "', "
                + "`jumlah_titipan` = " + data.getJumlah_titipan() + " "
                + "WHERE id_penitipan = " + data2 + "";
        
        System.out.println("Editing Data...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Data " + data2);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Data...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }

    @Override
    public void delete(String data) {
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM `penitipan` "
                + "WHERE `id_penitipan` = " + data + ";";
        
        System.out.println("Deleting Data...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete" + result + " Data " + data);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Deleting Data...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
}
