package dao;

import java.sql.Statement;
import model.Produk;
import model.Titipan;
import interfaceDAO.IProdukDAO;

public class TitipanDAO extends ProdukDAO implements IProdukDAO{
    public void insert(Titipan T){
        super.insert(T);
        insertNewRole(T);
    }
    
    public void insertNewRole(Titipan P) {
        con = dbCon.makeConnection();

        String sql = 
                "INSERT INTO `titipan`(`id_produk`, `stok`) VALUES ('"
                + P.getId_produk()
                + "','"
                + P.getStok()
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
        String sql = "DELETE FROM `original` WHERE `id_produk` = '"+id_produk+"'";
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
    
    public void update(Produk k, String id_produk, int stok) {
        Titipan m = new Titipan(stok, k.getId_produk(), k.getNama(), k.getJenis(), k.getHarga());
        if(cekPerubahanJenis("Titipan",id_produk)){
            deleteOldRole(id_produk);
            insertNewRole(m);
        }else{
            updateRole(k, id_produk);
        }
        super.update(k, id_produk);
    }
}
