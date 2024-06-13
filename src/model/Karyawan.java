package model;

public class Karyawan { // OK
    private int id_penitip;
    private String nama;
    private String alamat;
    private String no_telepon;

    public Karyawan(String nama, String alamat, String no_telepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
    }

    public Karyawan(int id_penitip, String nama, String alamat, String no_telepon) {
        this.id_penitip = id_penitip;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getId_penitip() {
        return id_penitip;
    }

    public String getNama() {
        return nama;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setId_penitip(int id_penitip) {
        this.id_penitip = id_penitip;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }
    
    @Override
    public String toString(){
        return getNama();
    }
}
