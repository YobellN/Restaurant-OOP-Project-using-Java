/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DbConnection;
import interface_DAO.IDAO;
import interface_Control.IGenerateID;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Karyawan;
import model.Pelanggan;
import model.Transaksi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Tok Se Ka 220711904
 */
public class TransaksiDAO implements IDAO<Transaksi, String>, IGenerateID{
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
    
    public double hitungTotalHarga(String id_pesanan) {
        Connection con = dbCon.makeConnection();

        String sql = "SELECT SUM(sub_total) AS sub " +
                     "FROM pesanan " +
                     "WHERE id_pesanan = '" + id_pesanan + "'";

        System.out.println("Hitung Total Harga...");
        double total = 0;

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                total = rs.getDouble("sub");
            }

            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Fetching data...");
            e.printStackTrace();
        } finally {
            dbCon.closeConnection();
        }

        return total;
    }

    public void updateHarga(Transaksi C){
        con = dbCon.makeConnection();
        String sql = "UPDATE transaksi " +
             "SET total_harga = '" + hitungTotalHarga(C.getId_pesanan()) + "' " +
             "WHERE id_pesanan = '" + C.getId_pesanan() + "'";

        System.out.println("Adding Insert Harga...");

        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Transaksi");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding Harga Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    
    @Override
    public void insert(Transaksi C){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO transaksi (id_pesanan, id_karyawan, id_pelanggan, tanggal_pesanan, total_harga) VALUES ('" 
                + C.getId_pesanan() + "', '" 
                + C.getId_karyawan() + "', '" 
                + C.getId_pelanggan() + "', '" 
                + C.getTanggal_pesanan() + "', '"
                + C.getTotal_harga() + "')";
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
    public List<Transaksi> showData(String data) {
        con = dbCon.makeConnection();

        String sql = "SELECT t.id_pesanan, t.id_karyawan, t.id_pelanggan, t.tanggal_pesanan, t.total_harga, " 
                 + "k.nama_karyawan, k.jabatan, k.gaji, " 
                 + "p.nama_pelanggan, p.alamat, p.nomor_telepon " 
                 + "FROM transaksi t " 
                 + "JOIN karyawan k ON t.id_karyawan = k.id_karyawan " 
                 + "JOIN pelanggan p ON t.id_pelanggan = p.id_pelanggan " 
                 + "WHERE t.id_pesanan LIKE '%" + data + "%' " 
                 + "OR t.id_karyawan LIKE '%" + data + "%' " 
                 + "OR t.id_pelanggan LIKE '%" + data + "%' " 
                 + "OR k.nama_karyawan LIKE '%" + data + "%' " 
                 + "OR p.nama_pelanggan LIKE '%" + data + "%'"
                 + "ORDER BY t.id_pesanan";
        System.out.println("Fetching Data...");
        List<Transaksi> c = new ArrayList<>();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    Karyawan k = new Karyawan(
                            rs.getString("id_karyawan"),
                            rs.getString("nama_karyawan"),
                            rs.getString("jabatan"),
                            rs.getFloat("gaji")
                    );
                    Pelanggan p = new Pelanggan(
                            rs.getString("id_pelanggan"),
                            rs.getString("nama_pelanggan"),
                            rs.getString("alamat"),
                            rs.getString("nomor_telepon")
                    );
                    
                    c.add(new Transaksi(
                            rs.getString("id_pesanan"),
                            rs.getString("id_karyawan"),
                            rs.getString("id_pelanggan"),
                            rs.getString("tanggal_pesanan"),
                            rs.getFloat("total_harga"),
                            k,
                            p
                    ));
                }
            }

            rs.close();
            statement.close();
        } catch (Exception e) {
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
   
    public void createReceipt(String id_pesanan) {
        con = dbCon.makeConnection();
        try {
            String reportSrcFile = "C:\\Users\\yobel"
                    + "\\OneDrive - Universitas Atma Jaya Yogyakarta\\"
                    + "Documents\\tugas\\PBO\\TubesPBO\\"
                    + "TubesPBO_Restoran\\src\\report\\transaksiReport.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("id_pesanan", id_pesanan);

            

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);

            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
