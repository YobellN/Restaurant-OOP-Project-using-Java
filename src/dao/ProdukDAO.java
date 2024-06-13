package dao;
import connection.DbConnection;
import interfaceDAO.IDAO;
import interfaceDAO.ISearchData;
import interfaceDAO.IShowForDropdown;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Produk;
import model.Original;
import model.Titipan;

public class ProdukDAO implements IDAO<Produk, String>, IShowForDropdown<Produk>, ISearchData<Produk, String>{
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;
    
    @Override
    public void insert(Produk P){
        con = dbCon.makeConnection();

        String sql = 
                "INSERT INTO `produk`(`id_produk`, `nama_produk`, `jenis`, `harga`) "
                + "VALUES ('"+P.getId_produk()+"','"+P.getNama()+"','"+P.getJenis()+"','"+P.getHarga()+"')";

        System.out.println("Adding Produk...");

        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Produk");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding Produk...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    };
    
    @Override
    public Produk search(String id_produk){
        con = dbCon.makeConnection();
        
        String sql = "SELECT produk.*, titipan.stok, original.deskripsi FROM produk\n" +
                    "LEFT JOIN titipan ON produk.id_produk = titipan.id_produk\n" +
                    "LEFT JOIN original on produk.id_produk = original.id_produk\n" +
                    "WHERE produk.id_produk = '"
                + id_produk
                + "'";
        System.out.println("Searching Produk...");
        Produk k = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null) 
                while(rs.next()){
                    if(rs.getString("jenis").equals("Titipan")){
                        k = new Titipan(
                            rs.getInt("stok"),
                            rs.getString("id_produk"), 
                            rs.getString("nama_produk"), 
                            rs.getString("jenis"),
                            rs.getInt("harga"));
                    }
                    else{
                        k = new Original(
                            rs.getString("deskripsi"),
                            rs.getString("id_produk"), 
                            rs.getString("nama_produk"), 
                            rs.getString("jenis"),
                            rs.getInt("harga"));
                    }
                }
                
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return k;
    }
    
    @Override
    public List<Produk> showData (String jenis){
        con = dbCon.makeConnection();
        
        String sql = "SELECT produk.*, titipan.stok, original.deskripsi FROM produk\n" +
                    "LEFT JOIN titipan ON produk.id_produk = titipan.id_produk\n" +
                    "LEFT JOIN original on produk.id_produk = original.id_produk\n" +
                    "WHERE produk.jenis = '"
                + jenis
                + "';";
        System.out.println("Fetching Data...");
        
        List<Produk> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            Produk k = null;
            
            if(rs != null) 
                while(rs.next()){
                    if(rs.getString("jenis").equals("Titipan")){
                        k = new Titipan(
                            rs.getInt("stok"),
                            rs.getString("id_produk"), 
                            rs.getString("nama_produk"), 
                            rs.getString("jenis"),
                            rs.getInt("harga"));
                    }
                    else{
                        k = new Original(
                            rs.getString("deskripsi"),
                            rs.getString("id_produk"), 
                            rs.getString("nama_produk"), 
                            rs.getString("jenis"),
                            rs.getInt("harga"));
                    }
                    list.add(k);
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
    public void update (Produk k, String id_produk){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE `produk` SET "
                + "`nama_produk`='" + k.getNama() + "',"
                + "`jenis`='"+ k.getJenis() + "',"
                + "`harga`='" + k.getHarga() + "' "
                + "WHERE id_produk='" + id_produk + "'";
        System.out.println("Updating Produk...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Produk " + id_produk);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Produk...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public void delete(String id_produk){
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `produk` WHERE `id_produk` = '"+id_produk+"'";
        System.out.println("Deleting Produk...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Produk " + id_produk);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Produk...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    
    
    public int generateId(){
        con = dbCon.makeConnection();
        String sql = "SELECT MAX(CAST(SUBSTRING(id_produk, 2) AS SIGNED)) AS highest_number FROM produk WHERE id_produk LIKE 'P%';";
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
    
    public boolean cekPerubahanJenis(String jenis, String id_produk){
        con = dbCon.makeConnection();
        
        String sql = "SELECT  jenis!='"
                + jenis
                + "'"
                + "as result"
                + " FROM `produk`"
                + " WHERE id_produk = '"
                + id_produk
                + "';";
        System.out.println(sql);
        System.out.println("Checking Result...");
        boolean result = false;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null) 
                while(rs.next()){
                        result = rs.getBoolean("result");
                }
                
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        System.out.println("The result is" + result);
        return result;
    }
    
    @Override
    public List<Produk> IShowForDropdown() {
        con = dbCon.makeConnection();
        
        String sql = "SELECT PR.*, O.deskripsi, T.stok FROM produk PR "
                + "LEFT JOIN original O ON PR.id_produk = O.id_produk "
                + "LEFT JOIN titipan T ON PR.id_produk = T.id_produk;";
        
        System.out.println("Fetching Data...");
        
        List<Produk> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            Produk data = null;
            
            int i = 0;
            
            if(rs != null) 
                while(rs.next()){
                    if(rs.getString("jenis").equals("Titipan")){
                        data = new Titipan(
                            rs.getInt("T.stok"),
                            rs.getString("PR.id_produk"), 
                            rs.getString("PR.nama_produk"), 
                            rs.getString("PR.jenis"),
                            rs.getFloat("PR.harga")
                        );
                    }
                    else{
                        data = new Original(
                            rs.getString("O.deskripsi"),
                            rs.getString("PR.id_produk"), 
                            rs.getString("PR.nama_produk"), 
                            rs.getString("PR.jenis"),
                            rs.getFloat("PR.harga")
                        );
                    }
                    list.add(data);
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
    
    public void updateRole (Produk k, String id_produk){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE `"
                + k.getJenis() 
                + "` SET `deskripsi`='"
                + k.getSpecial()
                + "' WHERE `original`.id_produk = '"
                + id_produk
                + "'";
        System.out.println("Updating Jenis Produk...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Produk " + id_produk);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Produk...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
}

