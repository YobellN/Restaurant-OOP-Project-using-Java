package model;

public class Minuman extends Menu {
    private String ukuran;

    public Minuman(String ukuran, String id_menu, String nama_menu, String jenis_produk, float harga) {
        super(id_menu, nama_menu, jenis_produk, harga);
        this.ukuran = ukuran;
    }//Konstruktor lengkap
    
    public Minuman(String ukuran, String nama_menu, String jenis_produk, float harga) {
        super(nama_menu, jenis_produk, harga);
        this.ukuran = ukuran;
    }//Konstruktor tanpa id

    //getter & setter
    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }
    
    @Override
    public String getSpecial() {
        return ukuran;
    }

    @Override
    public String toString() {
        return "Minuman{" + "ukuran=" + ukuran + '}';
    }
    
}
