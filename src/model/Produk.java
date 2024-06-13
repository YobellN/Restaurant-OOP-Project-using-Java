package model;

public abstract class Produk{ // OK
    private String id_produk, nama_produk, jenis_produk;
    private float harga;

    public Produk(String id_produk, String nama_produk, String jenis, float harga) {
        this.id_produk = id_produk;
        this.nama_produk = nama_produk;
        this.jenis_produk = jenis;
        this.harga = harga;
    }

    public Produk(String nama_produk, String jenis, float harga) {
        this.nama_produk = nama_produk;
        this.jenis_produk = jenis;
        this.harga = harga;
    }

    public Produk(String id_produk, String nama_produk, String jenis_produk) {
        this.id_produk = id_produk;
        this.nama_produk = nama_produk;
        this.jenis_produk = jenis_produk;
    }
    
    public void setId_produk(String id_produk) {
        this.id_produk = id_produk;
    }

    public void setNama(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public void setJenis(String jenis) {
        this.jenis_produk = jenis;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }
    
    public String getId_produk() {
        return id_produk;
    }

    public String getNama() {
        return nama_produk;
    }

    public String getJenis() {
        return jenis_produk;
    }

    public float getHarga() {
        return harga;
    }
    
    public String getString(){
        return id_produk + " | " + nama_produk + " | " + harga;
    }
    
    public abstract String getSpecial();
    
    @Override
    public String toString(){
        return getNama();
    }
}