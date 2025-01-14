package dao;

import com.mysql.jdbc.PreparedStatement;
import connection.DbConnection;
import interface_DAO.IDAO;
import interface_DAO.IGenerateID;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Menu;
import model.Makanan;
import model.Minuman;
import interface_DAO.IShowDataList;

public class MenuDAO implements IDAO<Menu, String>, IShowDataList<Menu>, IGenerateID {

    protected DbConnection dbCon = new DbConnection();
    protected Connection con;

    @Override
    public void insert(Menu M) {
        con = dbCon.makeConnection();

        String sql = "INSERT INTO menu (id_menu, nama_menu, jenis_menu, harga, gambar) VALUES (?, ?, ?, ?, ?)";
        System.out.println("Adding Menu...");

        PreparedStatement st = null;
        FileInputStream fis = null;

        try {
            st = (PreparedStatement) con.prepareStatement(sql);
            st.setString(1, M.getId_menu());
            st.setString(2, M.getNama_menu());
            st.setString(3, M.getJenis_menu());
            st.setFloat(4, M.getHarga());
            byte[] imageBytes = M.getGambar();
            if (imageBytes != null && imageBytes.length > 0) {
                st.setBytes(5, imageBytes);
            } else {
                st.setNull(5, java.sql.Types.BLOB);
            }

            int result = st.executeUpdate();
            System.out.println("Added " + result + " Menu");

        } catch (Exception e) {
            System.out.println("Error adding Menu...");
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (st != null) {
                    st.close();
                }
                dbCon.closeConnection();
            } catch (Exception ex) {
                System.out.println("Error closing resources...");
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Menu> showData(String search) {
        con = dbCon.makeConnection();

        String sql = "SELECT menu.*, minuman.ukuran, makanan.catatan FROM menu\n"
                + "LEFT JOIN minuman ON menu.id_menu = minuman.id_menu\n"
                + "LEFT JOIN makanan on menu.id_menu = makanan.id_menu\n"
                + "WHERE menu.id_menu LIKE '%" + search + "%' "
                + "OR menu.nama_menu LIKE '%" + search + "%' "
                + "OR menu.jenis_menu LIKE '%" + search + "%' ";
        System.out.println("Searching Menu...");
        Menu m = null;
        List<Menu> list = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    if (rs.getString("jenis_menu").equals("Minuman")) {
                        m = new Minuman(
                                rs.getString("ukuran"), //SQL ukuran
                                rs.getString("id_menu"), //SQL id_menu
                                rs.getString("nama_menu"), //SQL nama_menu
                                rs.getString("jenis_menu"), //SQL jenis_menu
                                rs.getFloat("harga"), //SQL harga
                                rs.getBytes("gambar"));
                    } else {
                        m = new Makanan(
                                rs.getString("catatan"), //SQL catatan
                                rs.getString("id_menu"), //SQL id_menu
                                rs.getString("nama_menu"), //SQL nama_menu
                                rs.getString("jenis_menu"), //SQL jenis_menu
                                rs.getFloat("harga"), //SQL harga
                                rs.getBytes("gambar"));
                    }
                    list.add(m);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }

    @Override
    public void update(Menu m, String id_menu) {
        con = dbCon.makeConnection();

        String sql = "UPDATE menu SET nama_menu = ?, jenis_menu = ?, harga = ?, gambar = ? WHERE id_menu = ?";
        System.out.println("Updating Menu...");

        PreparedStatement st = null;

        try {
            st = (PreparedStatement) con.prepareStatement(sql);
            st.setString(1, m.getNama_menu());
            st.setString(2, m.getJenis_menu());
            st.setFloat(3, m.getHarga());

            byte[] imageBytes = m.getGambar();
            if (imageBytes != null && imageBytes.length > 0) {
                st.setBytes(4, imageBytes);
            } else {
                st.setNull(4, java.sql.Types.BLOB);
            }

            st.setString(5, id_menu);

            int result = st.executeUpdate();
            System.out.println("Updated " + result + " Menu with id_menu " + id_menu);

        } catch (Exception e) {
            System.out.println("Error updating Menu...");
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                dbCon.closeConnection();
            } catch (Exception ex) {
                System.out.println("Error closing resources...");
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String id_menu) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `menu` WHERE `id_menu` = '" + id_menu + "'";
        System.out.println("Deleting Menu...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Menu " + id_menu);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Menu...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public int generateId() {
        con = dbCon.makeConnection();
        String sql = "SELECT MAX(CAST(SUBSTRING(id_menu, 2) AS SIGNED)) AS highest_number FROM menu WHERE id_menu LIKE 'M%';";
        //mendapatkan nilai tertinggi dari id yang ada di database

        System.out.println("Generating Id...");
        int id = 0;

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null && rs.next()) {
                if (!rs.wasNull()) {
                    id = rs.getInt("highest_number") + 1;
                }
            }

            //memasukan id terakhir ke dalam variabel id
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return id;
    }

    public boolean cekPerubahanJenis(String jenis_menu, String id_menu) {
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

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    result = rs.getBoolean("result");
                }
            }

            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        System.out.println("The result is" + result);
        return result;
    }

    @Override
    public List<Menu> showDataList() {
        con = dbCon.makeConnection();

        String sql = "SELECT M.*, MK.catatan, MN.ukuran FROM menu M "
                + "LEFT JOIN makanan MK ON M.id_menu = MK.id_menu "
                + "LEFT JOIN minuman MN ON M.id_menu = MN.id_menu;";

        System.out.println("Fetching Data...");

        List<Menu> list = new ArrayList();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            Menu data = null;

            int i = 0;

            if (rs != null) {
                while (rs.next()) {
                    if (rs.getString("jenis_menu").equals("Minuman")) {
                        data = new Minuman(
                                rs.getString("ukuran"), //SQL ukuran
                                rs.getString("id_menu"), //SQL id_menu
                                rs.getString("nama_menu"), //SQL nama_menu
                                rs.getString("jenis_menu"), //SQL jenis_menu
                                rs.getFloat("harga"),//SQL harga
                                rs.getBytes("gambar"));
                    } else {
                        data = new Makanan(
                                rs.getString("catatan"), //SQL catatan
                                rs.getString("id_menu"), //SQL id_menu
                                rs.getString("nama_menu"), //SQL nama_menu
                                rs.getString("jenis_menu"), //SQL jenis_menu
                                rs.getFloat("harga"),
                                rs.getBytes("gambar")); //SQL harga
                    }
                    list.add(data);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }

        dbCon.closeConnection();
        return list;
    }

    public float searchHarga(String data) { // khusus mencari harga menu
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM `menu` WHERE id_menu = '" + data + "' ";
        System.out.println("Searching Harga Menu...");
        float c = 0;

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    c = rs.getFloat("harga");
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

}
