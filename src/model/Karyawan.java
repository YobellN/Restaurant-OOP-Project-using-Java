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
=======
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
>>>>>>> origin/Progress1
}
