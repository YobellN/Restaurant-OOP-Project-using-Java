/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tok Se Ka 220711904
 */
public class Transaksi {
    private String id_pesanan;      // SQL : id_pesanan;
    private String id_karyawan;     // SQL : id_karyawan;
    private String id_pelanggan;    // SQL : id_pelanggan;
    private String tanggal_pesanan; // SQL : tanggal_pesanan;
    private float total_harga;      // SQL : total_harga;
    private Pelanggan pelanggan;
    private Karyawan karyawan;

    public Transaksi(String id_pesanan, String id_karyawan, String id_pelanggan, String tanggal_pesanan, float total_harga) {
        this.id_pesanan = id_pesanan;
        this.id_karyawan = id_karyawan;
        this.id_pelanggan = id_pelanggan;
        this.tanggal_pesanan = tanggal_pesanan;
        this.total_harga = total_harga;
    } // konstruktor lengkap

    public Transaksi(String id_karyawan, String id_pelanggan, String tanggal_pesanan, float total_harga) {
        this.id_karyawan = id_karyawan;
        this.id_pelanggan = id_pelanggan;
        this.tanggal_pesanan = tanggal_pesanan;
        this.total_harga = total_harga;
    } // konstuktor tanpa id_pesanan

    public Transaksi(String id_pelanggan, String tanggal_pesanan, float total_harga) {
        this.id_pelanggan = id_pelanggan;
        this.tanggal_pesanan = tanggal_pesanan;
        this.total_harga = total_harga;
    } // konstruktor tanpa id_pesanan dan id_karyawan

    public Transaksi(String id_pesanan, String id_karyawan, String id_pelanggan, String tanggal_pesanan, float total_harga, 
            Karyawan k, Pelanggan p) {
        this.id_pesanan = id_pesanan;
        this.id_karyawan = id_karyawan;
        this.id_pelanggan = id_pelanggan;
        this.tanggal_pesanan = tanggal_pesanan;
        this.total_harga = total_harga;
        this.karyawan = k;
        this.pelanggan = p;     
    } // konstruktor untuk show Table

    // getter
    public String getId_pesanan() {
        return id_pesanan;
    }

    public String getId_karyawan() {
        return id_karyawan;
    }

    public String getId_pelanggan() {
        return id_pelanggan;
    }

    public String getTanggal_pesanan() {
        return tanggal_pesanan;
    }

    public float getTotal_harga() {
        return total_harga;
    }
    
    public Karyawan getKaryawan(){
        return karyawan;
    }
    
    public Pelanggan getPelanggan(){
        return pelanggan;
    }

    // setter
    public void setId_pesanan(String id_pesanan) {
        this.id_pesanan = id_pesanan;
    }

    public void setId_karyawan(String id_karyawan) {
        this.id_karyawan = id_karyawan;
    }

    public void setId_pelanggan(String id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public void setTanggal_pesanan(String tanggal_pesanan) {
        this.tanggal_pesanan = tanggal_pesanan;
    }

    public void setTotal_harga(float total_harga) {
        this.total_harga = total_harga;
    }

    @Override
    public String toString() {
        return "Transaksi{" + "id_pesanan=" + id_pesanan + ", id_karyawan=" + id_karyawan + ", id_pelanggan=" + id_pelanggan + ", tanggal_pesanan=" + tanggal_pesanan + ", total_harga=" + total_harga + '}';
    } // menampilan semua variabel
    
    
    
    
    
    
}
