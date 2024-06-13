package model;

public class Makanan extends Menu {
    private String catatan;

    public Makanan(String catatan, String nama_menu, String jenis_produk, float harga) {
        super(nama_menu, jenis_produk, harga);
        this.catatan = catatan;
    } //Konstruktor tanpa id

    public Makanan(String catatan, String id_menu, String nama_menu, String jenis_produk, float harga) {
        super(id_menu, nama_menu, jenis_produk, harga);
        this.catatan = catatan;
    } //Konstruktor lengkap
    
    //
    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    @Override
    public String getSpecial() {
        return catatan;
    } 
}
