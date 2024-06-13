package model;

public abstract class Menu{ 
    private String id_menu, nama_menu, jenis_menu;
    private float harga;

    public Menu(String id_menu, String nama_menu, String jenis_menu, float harga) {
        this.id_menu = id_menu;
        this.nama_menu = nama_menu;
        this.jenis_menu = jenis_menu;
        this.harga = harga;
    } //Konstruktor lengkap

    public Menu(String nama_menu, String jenis_menu, float harga) {
        this.nama_menu = nama_menu;
        this.jenis_menu = jenis_menu;
        this.harga = harga;
    } //Konstukror tanpa id
    
    //getter and setter
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

    public String getJenis_menu() {
        return jenis_menu;
    }

    public void setJenis_menu(String jenis_menu) {
        this.jenis_menu = jenis_menu;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }
    
    @Override
    public String toString(){
        return getNama_menu();
    }
    
    public abstract String getSpecial();
}