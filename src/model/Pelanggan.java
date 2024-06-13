/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tok Se Ka 220711904
 */
public class Pelanggan { // tabel : pelanggan
    private String id_pelanggan; // SQL : id_pelanggan 
    private String nama_pelanggan; // SQL : nama_pelanggan
    private String alamat_pelanggan; // SQL : alamat
    private String nomor_telepon; // SQL : nomor_telepon

    public Pelanggan(String id_pelanggan, String nama_pelanggan, String alamat_pelanggan, String nomor_telepon) {
        this.id_pelanggan = id_pelanggan;
        this.nama_pelanggan = nama_pelanggan;
        this.alamat_pelanggan = alamat_pelanggan;
        this.nomor_telepon = nomor_telepon;
    } // konstruktor lengkap

    public Pelanggan(String nama_pelanggan, String alamat_pelanggan, String nomor_telepon) {
        this.nama_pelanggan = nama_pelanggan;
        this.alamat_pelanggan = alamat_pelanggan;
        this.nomor_telepon = nomor_telepon;
    } // konstruktor tanpa id_pelanggan

    // Getter
    public String getId_pelanggan() {
        return id_pelanggan;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public String getAlamat_pelanggan() {
        return alamat_pelanggan;
    }

    public String getNomor_telepon() {
        return nomor_telepon;
    }
    
    // Setter
    public void setId_pelanggan(String id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public void setAlamat_pelanggan(String alamat_pelanggan) {
        this.alamat_pelanggan = alamat_pelanggan;
    }

    public void setNomor_telepon(String nomor_telepon) {
        this.nomor_telepon = nomor_telepon;
    }

    @Override
    public String toString() {
        return nama_pelanggan + ' ';
    } // toString untuk menampilkan nama pelanggan
    
    
}
