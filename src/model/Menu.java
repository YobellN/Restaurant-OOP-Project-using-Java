package model;

public abstract class Menu{ 
    private String id_menu, nama_menu, jenis_produk;
    private float harga;

    public Menu(String id_menu, String nama_menu, String jenis_produk, float harga) {
        this.id_menu = id_menu;
        this.nama_menu = nama_menu;
        this.jenis_produk = jenis_produk;
        this.harga = harga;
    } //Konstruktor lengkap

    public Menu(String nama_menu, String jenis_produk, float harga) {
        this.nama_menu = nama_menu;
        this.jenis_produk = jenis_produk;
        this.harga = harga;
    } //Konstukror tanpa id

    public String getId_menu() {
        return id_menu;
    }

    public void setId_menu(String id_menu) {
        this.id_menu = id_menu;
    }

    public String getNama_menu() {
        return nama_menu;
    }

    public void setNama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    public String getJenis_produk() {
        return jenis_produk;
    }

    public void setJenis_produk(String jenis_produk) {
        this.jenis_produk = jenis_produk;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }
    
    
    public abstract String getSpecial();
    
    @Override
    public String toString(){
        return getNama_menu();
    }
}