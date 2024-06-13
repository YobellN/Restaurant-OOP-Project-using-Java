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
import model.Menu;
import model.Makanan;
import model.Minuman;

public class MenuDAO implements IDAO<Menu, String>, IShowForDropdown<Menu>, ISearchData<Menu, String>{
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;
    
    @Override
    public void insert(Menu M){
        con = dbCon.makeConnection();

        String sql = 
                "INSERT INTO `menu`(`id_menu`, `nama_menu`, `jenis_menu`, `harga`) "
                + "VALUES ('"+M.getId_menu()+"','"+M.getNama_menu()+"','"+M.getJenis_menu()+"','"+M.getHarga()+"')";

        System.out.println("Adding Menu...");

        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Menu");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding Menu...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    };
    
    @Override
    public Menu search(String id_menu){
        con = dbCon.makeConnection();
        
        String sql = "SELECT menu.*, minuman.ukuran, makanan.catatan FROM menu\n" + 
                    "LEFT JOIN minuman ON menu.id_menu = minuman.id_menu\n" + //Constraint FK id_menu
                    "LEFT JOIN makanan on menu.id_menu = makanan.id_menu\n" + 
                    "WHERE menu.id_menu = '"
                + id_menu
                + "'";
        System.out.println("Searching Produk...");
        Menu m = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null) 
                while(rs.next()){
                    if(rs.getString("jenis_menu").equals("Minuman")){
                        m = new Minuman(
                            rs.getString("ukuran"), //SQL ukuran
                            rs.getString("id_menu"), //SQL id_menu
                            rs.getString("nama_menu"), //SQL nama_menu
                            rs.getString("jenis_menu"), //SQL jenis_menu
                            rs.getFloat("harga")); //SQL harga
                    }
                    else{
                        m = new Makanan(
                            rs.getString("catatan"), //SQL catatan
                            rs.getString("id_menu"), //SQL id_menu
                            rs.getString("nama_menu"), //SQL nama_menu
                            rs.getString("jenis_menu"), //SQL jenis_menu
                            rs.getFloat("harga")); //SQL harga
                    }
                }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return m;
    }
    
    @Override
    public List<Menu> showData (String jenis_menu){
        con = dbCon.makeConnection();
        
        String sql = "SELECT menu.*, minuman.ukuran, makanan.catatan FROM menu\n" +
                    "LEFT JOIN minuman ON menu.id_menu = minuman.id_menu\n" + //Constraint FK id_menu
                    "LEFT JOIN makanan on menu.id_menu = makanan.id_menu\n" +
                    "WHERE menu.jenis_menu = '"
                + jenis_menu
                + "';";
        System.out.println("Fetching Data...");
        
        List<Menu> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            Menu m = null;
            
            if(rs != null) 
                while(rs.next()){
                    if(rs.getString("jenis_menu").equals("Minuman")){
                        m = new Minuman(
                            rs.getString("ukuran"), //SQL ukuran
                            rs.getString("id_menu"), //SQL id_menu
                            rs.getString("nama_menu"), //SQL nama_menu
                            rs.getString("jenis_menu"), //SQL jenis_menu
                            rs.getFloat("harga")); //SQL harga
                    }
                    else{
                        m = new Makanan(
                            rs.getString("catatan"), //SQL catatan
                            rs.getString("id_menu"), //SQL id_menu
                            rs.getString("nama_menu"), //SQL nama_menu
                            rs.getString("jenis_menu"), //SQL jenis_menu
                            rs.getFloat("harga")); //SQL harga
                    }
                    list.add(m);
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
    public void update (Menu m, String id_menu){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE `menu` SET " 
                + "`nama_menu`='" + m.getNama_menu()+ "',"
                + "`jenis_menu`='"+ m.getJenis_menu()+ "',"
                + "`harga`='" + m.getHarga()+ "' "
                + "WHERE id_menu='" + id_menu + "'";
        System.out.println("Updating Menu...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Menu " + id_menu);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Menu...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public void delete(String id_menu){
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `menu` WHERE `id_menu` = '"+id_menu+"'";
        System.out.println("Deleting Produk...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Menu " + id_menu);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Produk...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    
    
    public int generateId(){
        con = dbCon.makeConnection();
        String sql = "SELECT MAX(CAST(SUBSTRING(id_menu, 2) AS SIGNED)) AS highest_number FROM produk WHERE id_produk LIKE 'M%';";
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
    
    public boolean cekPerubahanJenis(String jenis_menu, String id_menu){
        con = dbCon.makeConnection();
        
        String sql = "SELECT  jenis_menu!='"
                + jenis_menu
                + "'"
                + "as result"
                + " FROM `menu`"
                + " WHERE id_menu = '"
                + id_menu
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
    public List<Menu> IShowForDropdown() {
        con = dbCon.makeConnection();
        
        String sql = "SELECT M.*, MK.catatan, MN.ukuran FROM menu M "
                + "LEFT JOIN makanan MK ON M.id_menu = MK.id_menu "
                + "LEFT JOIN minuman MN ON M.id_menu = MK.id_menu;";
        
        System.out.println("Fetching Data...");
        
        List<Menu> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            Menu data = null;
            
            int i = 0;
            
            if(rs != null) 
                while(rs.next()){
                    if(rs.getString("jenis_menu").equals("Minuman")){
                        data = new Minuman(
                            rs.getString("ukuran"), //SQL ukuran
                            rs.getString("id_menu"), //SQL id_menu
                            rs.getString("nama_menu"), //SQL nama_menu
                            rs.getString("jenis_menu"), //SQL jenis_menu
                            rs.getFloat("harga")); //SQL harga
                    }
                    else{
                        data = new Makanan(
                            rs.getString("catatan"), //SQL catatan
                            rs.getString("id_menu"), //SQL id_menu
                            rs.getString("nama_menu"), //SQL nama_menu
                            rs.getString("jenis_menu"), //SQL jenis_menu
                            rs.getFloat("harga")); //SQL harga
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
    
    public void updateJenis (Menu m, String id_menu){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE `"
                + m.getJenis_menu()
                + "` SET `deskripsi`='"
                + m.getSpecial()
                + "' WHERE `original`.id_produk = '"
                + id_menu
                + "'";
        System.out.println("Updating Jenis Produk...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Menu " + id_menu);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Menu...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
}

