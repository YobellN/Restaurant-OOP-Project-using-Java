package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import interfaceDAO.IGenerateID;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Karyawan;
import interfaceDAO.IShowForDropdown;
import interfaceDAO.ISearchData;

public class KaryawanDAO implements IDAO<Karyawan, String>, IShowForDropdown<Karyawan>, ISearchData<Karyawan, String>, IGenerateID{ // OK , i guess
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;
    
    @Override
    public void insert(Karyawan C){
        con = dbCon.makeConnection();
        
    String sql = 
        "INSERT INTO `karyawan`(`id_karyawan`, `nama_karyawan`, `jabatan`, `gaji`, `username`, `password`) " +
        "VALUES ('"+ C.getId_karyawan()+"', '"+ C.getNama_karyawan()+"', '"+ C.getJabatan()+"', '"+ C.getGaji()+ "', '" + C.getUsername()+ "', '" + C.getPassword()+ "')";
    
        System.out.println("Adding Karyawan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Karyawan");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding Karyawan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    
    @Override
    public Karyawan search(String data){ 
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `karyawan` WHERE "
                + "id_karyawan LIKE '%" + data + "%' "
                + " OR nama_karyawan LIKE '%" + data + "%' "
                + " OR jabatan LIKE '%" + data + "%' "
                + " OR username LIKE '%" + data + "%' " + "";
        System.out.println("Searching Karyawan...");
        Karyawan c = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    c = new Karyawan( 
                        rs.getString("id_karyawan"),
                        rs.getString("nama_karyawan"),
                        rs.getString("jabatan"),
                        rs.getFloat("gaji"),
                        rs.getString("username"),
                        rs.getString("password")
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
    public List<Karyawan> showData(String data){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `karyawan` WHERE "
                + "id_karyawan LIKE '%" + data + "%' "
                + " OR nama_karyawan LIKE '%" + data + "%' "
                + " OR jabatan LIKE '%" + data + "%' "
                + " OR username LIKE '%" + data + "%' " + "";
        System.out.println("Fetching Data...");
        List<Karyawan> c = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    c.add(new Karyawan(
                        rs.getString("id_karyawan"),
                        rs.getString("nama_karyawan"),
                        rs.getString("jabatan"),
                        rs.getFloat("gaji"),
                        rs.getString("username"),
                        rs.getString("password"))
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
    public void update(Karyawan c, String id_karyawan){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE `karyawan` SET "
                + "`id_karyawan`='" + c.getId_karyawan()+ "',"
                + "`nama_karyawan`='" + c.getNama_karyawan()+ "',"
                + "`jabatan`='" + c.getJabatan()+ "',"
                + "`gaji`='" + c.getGaji()+ "', "
                + "`username`='" + c.getUsername()+ "', "
                + "`password`='" + c.getPassword()+ "' "
                + "WHERE `id_karyawan`='" + id_karyawan + "'";
        System.out.println("Updating karyawan");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Karyawan " + id_karyawan);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Karyawan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public void delete(String id_karyawan){
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `karyawan` WHERE `id_karyawan` = '" + id_karyawan + "'";
        System.out.println("Deleting Karyawan...???");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Karyawan " + id_karyawan);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Deleting Karyawan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public List<Karyawan> IShowForDropdown() {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `karyawan`;";
        System.out.println("Fetching Data...");
        List<Karyawan> data = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    data.add(new Karyawan(
                            rs.getString("id_karyawan"),
                            rs.getString("nama_karyawan"),
                            rs.getString("jabatan"),
                            rs.getFloat("gaji"),
                            rs.getString("username"),
                            rs.getString("password")
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
    
    @Override
    public int generateId(){
        con = dbCon.makeConnection();
        String sql = "SELECT MAX(CAST(SUBSTRING(id_karyawan, 2) AS SIGNED)) AS highest_number FROM karyawan WHERE id_karyawan LIKE 'K%';";
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

}