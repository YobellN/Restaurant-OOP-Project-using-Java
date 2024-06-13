package dao;

import java.sql.Statement;
import model.Produk;
import model.Original;
import interfaceDAO.IProdukDAO;

public class OriginalDAO extends ProdukDAO implements IProdukDAO{

    public void insert(Original org) {
        super.insert(org);
        insertNewRole(org);
    }

    public void insertNewRole(Original org) {
        con = dbCon.makeConnection();

        String sql = 
                "INSERT INTO `original`(`id_produk`, `deskripsi`) VALUES ('"
                + org.getId_produk()
                + "','"
                + org.getJenis_mesin()
                + "')";

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
    }

    @Override
    public void deleteOldRole(String id_produk) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `titipan` WHERE `id_produk` = '"+id_produk+"'";
        System.out.println("Deleting original...");
        
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

    public void update(Produk k, String id_produk, String deskripsi) {
        Original m = new Original(deskripsi, k.getId_produk(), k.getNama(), k.getJenis(), k.getHarga());
        if(cekPerubahanJenis("Original",id_produk)){
            deleteOldRole(id_produk);
            insertNewRole(m);
        }else{
            updateRole(k, id_produk);
        }
        super.update(k, id_produk);
    }
}
