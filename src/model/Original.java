package model;

public class Original extends Produk {
    private String deskripsi;

    public Original(String jenis_mesin, String nama, String jenis, float harga) {
        super(nama, "Original", harga);
        this.deskripsi = jenis_mesin;
    }

    public Original(String jenis_mesin, String id_kendaraan, String nama, String jenis, float harga) {
        super(id_kendaraan, nama, "Original", harga);
        this.deskripsi = jenis_mesin;
    }

    public String getJenis_mesin() {
        return deskripsi;
    }
    
    public String getString(){
        return super.getString() + " | " + deskripsi;
    }

    @Override
    public String getSpecial() {
        return deskripsi;
    }
}
