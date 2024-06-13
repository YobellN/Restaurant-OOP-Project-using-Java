package model;

public class Titipan extends Produk {
    private int stok;

    public Titipan(int stok, String nama, String jenis, float harga) {
        super(nama, "Titipan", harga);
        this.stok = stok;
    }

    public Titipan(int stok, String id_kendaraan, String nama, String jenis, float harga) {
        super(id_kendaraan, nama, jenis, harga);
        this.stok = stok;
    }

    public int getStok() {
        return stok;
    }
    
    public String getString(){
        return super.getString() + " | " + stok;
    }

    @Override
    public String getSpecial() {
        return stok + "";
    }
}
