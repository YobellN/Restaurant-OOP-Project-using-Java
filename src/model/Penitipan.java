package model;

import model.Produk; // ganti E menjadi normal i guess
import model.Penitip;

public class Penitipan {
    
    private int id_penitipan;
    private int id_penitip;
    private String id_produk;
    private String catatan;
    private String status_penitipan;
    private String tanggal_penitipan;
    private int jumlah_titipan;
    private Penitip penitip;
    private Produk produk;

    public Penitip getPenitip() {
        return penitip;
    }

    public void setPenitip(Penitip penitip) {
        this.penitip = penitip;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }

    public Penitipan(int id_penitipan, int id_penitip, String id_produk, String catatan, String status_penitipan, String tanggal_penitipan, int jumlah_titipan, Penitip penitip, Produk produk) {
        this.id_penitipan = id_penitipan;
        this.id_penitip = id_penitip;
        this.id_produk = id_produk;
        this.catatan = catatan;
        this.status_penitipan = status_penitipan;
        this.tanggal_penitipan = tanggal_penitipan;
        this.jumlah_titipan = jumlah_titipan;
        this.penitip = penitip;
        this.produk = produk;
    }

    public Penitipan(int id_penitip, String id_produk, String catatan, String status_penitipan, String tanggal_penitipan, int jumlah_titipan, Penitip penitip, Produk produk) {
        this.id_penitip = id_penitip;
        this.id_produk = id_produk;
        this.catatan = catatan;
        this.status_penitipan = status_penitipan;
        this.tanggal_penitipan = tanggal_penitipan;
        this.jumlah_titipan = jumlah_titipan;
        this.penitip = penitip;
        this.produk = produk;
    }
    
    public int getId_penitipan() {
        return id_penitipan;
    }

    public void setId_penitipan(int id_penitipan) {
        this.id_penitipan = id_penitipan;
    }

    public int getId_penitip() {
        return id_penitip;
    }

    public void setId_penitip(int id_penitip) {
        this.id_penitip = id_penitip;
    }

    public String getId_produk() {
        return id_produk;
    }

    public void setId_produk(String id_produk) {
        this.id_produk = id_produk;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getStatus_penitipan() {
        return status_penitipan;
    }

    public void setStatus_penitipan(String status_penitipan) {
        this.status_penitipan = status_penitipan;
    }

    public String getTanggal_penitipan() {
        return tanggal_penitipan;
    }

    public void setTanggal_penitipan(String tanggal_penitipan) {
        this.tanggal_penitipan = tanggal_penitipan;
    }

    public int getJumlah_titipan() {
        return jumlah_titipan;
    }

    public void setJumlah_titipan(int jumlah_titipan) {
        this.jumlah_titipan = jumlah_titipan;
    }
}
