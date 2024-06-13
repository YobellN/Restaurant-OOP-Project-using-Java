package model;

public class Karyawan { // OK
    private int id_karyawan;
    private String nama_karyawan;
    private String jabatan;
    private float gaji;

    public Karyawan(String nama_karyawan, String jabatan, float gaji) {
        this.nama_karyawan = nama_karyawan;
        this.jabatan = jabatan;
        this.gaji = gaji;
    } // konstruktor tanpa id_karyawan

    public Karyawan(int id_karyawan, String nama_karyawan, String jabatan, float gaji) {
        this.id_karyawan = id_karyawan;
        this.nama_karyawan = nama_karyawan;
        this.jabatan = jabatan;
        this.gaji = gaji;
    } // konstruktor lengkap

    // getter
    public int getId_karyawan() {
        return id_karyawan;
    }

    public String getNama_karyawan() {
        return nama_karyawan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public float getGaji() {
        return gaji;
    }

    // setter
    public void setId_karyawan(int id_karyawan) {
        this.id_karyawan = id_karyawan;
    }

    public void setNama_karyawan(String nama_karyawan) {
        this.nama_karyawan = nama_karyawan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public void setGaji(float gaji) {
        this.gaji = gaji;
    }
    
    @Override
    public String toString(){
        return getNama_karyawan();
    } // toString untuk return nama karyawan
}
