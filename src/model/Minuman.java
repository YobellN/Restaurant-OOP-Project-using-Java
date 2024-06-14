package model;

public class Minuman extends Menu {
    private String ukuran;
    private byte[] gambar;
    
    public Minuman(String ukuran, String id_menu, String nama_menu, String jenis_menu, float harga, byte[] gambar) {
        super(id_menu, nama_menu, jenis_menu, harga, gambar);
        this.ukuran = ukuran;
    }//Konstruktor lengkap
    
    public Minuman(String ukuran, String nama_menu, String jenis_menu, float harga, byte[] gambar) {
        super(nama_menu, jenis_menu, harga, gambar);
        this.ukuran = ukuran;
    }//Konstruktor tanpa id

    //getter
    public String getUkuran() {
        return ukuran;
    }

    //setter
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
