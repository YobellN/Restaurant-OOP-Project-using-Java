package model;

public class Makanan extends Menu {
    private String catatan;

    public Makanan(String catatan, String id_menu, String nama_menu, String jenis_menu, float harga) {
        super(id_menu, nama_menu, jenis_menu, harga);
        this.catatan = catatan;
    } //Konstruktor lengkap
    
    public Makanan(String catatan, String nama_menu, String jenis_menu, float harga) {
        super(nama_menu, jenis_menu, harga);
        this.catatan = catatan;
    } //Konstruktor tanpa id

    //getter
    public String getCatatan() {
        return catatan;
    }
    
    //setter
    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    @Override
    public String getSpecial() {
        return catatan;
    }

    @Override
    public String toString() {
        return "Makanan{" + "catatan=" + catatan + '}';
    }
    
}
