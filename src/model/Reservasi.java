/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class Reservasi {
    private String id_reservasi; // SQL : id_reservasi
    private String id_pelanggan; // SQL : id_pelanggan
    private String tanggal_reservasi; // SQL : tanggal_reservasi
    private String jenis_reservasi; // SQL : jenis_reservasi
    private String paket_reservasi; // SQL : paket_reservasi
    private float total_harga; // SQL : total_harga

    public Reservasi(String id_reservasi, String id_pelanggan, String tanggal_reservasi, String jenis_reservasi, String paket_reservasi, float total_harga) {
        this.id_reservasi = id_reservasi;
        this.id_pelanggan = id_pelanggan;
        this.tanggal_reservasi = tanggal_reservasi;
        this.jenis_reservasi = jenis_reservasi;
        this.paket_reservasi = paket_reservasi;
        this.total_harga = total_harga;
    } // konstruktor lengkap

    public Reservasi(String id_reservasi, String tanggal_reservasi, String jenis_reservasi, String paket_reservasi, float total_harga) {
        this.id_reservasi = id_reservasi;
        this.tanggal_reservasi = tanggal_reservasi;
        this.jenis_reservasi = jenis_reservasi;
        this.paket_reservasi = paket_reservasi;
        this.total_harga = total_harga;
    } // konstruktor tanpa id_reservasi

    public Reservasi(String tanggal_reservasi, String jenis_reservasi, String paket_reservasi, float total_harga) {
        this.tanggal_reservasi = tanggal_reservasi;
        this.jenis_reservasi = jenis_reservasi;
        this.paket_reservasi = paket_reservasi;
        this.total_harga = total_harga;
    } // konstruktor tanpa id_reservasi dan id_pelanggan

    
    // getter
    public String getId_reservasi() {
        return id_reservasi;
    }

    public String getId_pelanggan() {
        return id_pelanggan;
    }

    public String getTanggal_reservasi() {
        return tanggal_reservasi;
    }

    public String getJenis_reservasi() {
        return jenis_reservasi;
    }

    public String getPaket_reservasi() {
        return paket_reservasi;
    }

    public float getTotal_harga() {
        return total_harga;
    }

    // setter
    public void setId_reservasi(String id_reservasi) {
        this.id_reservasi = id_reservasi;
    }

    public void setId_pelanggan(String id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public void setTanggal_reservasi(String tanggal_reservasi) {
        this.tanggal_reservasi = tanggal_reservasi;
    }

    public void setJenis_reservasi(String jenis_reservasi) {
        this.jenis_reservasi = jenis_reservasi;
    }

    public void setPaket_reservasi(String paket_reservasi) {
        this.paket_reservasi = paket_reservasi;
    }

    public void setTotal_harga(float total_harga) {
        this.total_harga = total_harga;
    }

    @Override
    public String toString() {
        return "Reservasi{" + "id_reservasi=" + id_reservasi + ", id_pelanggan=" + id_pelanggan + ", tanggal_reservasi=" + tanggal_reservasi + ", jenis_reservasi=" + jenis_reservasi + ", paket_reservasi=" + paket_reservasi + ", total_harga=" + total_harga + '}';
    } // toString menampilkan seluruh variabel
    
    
}
