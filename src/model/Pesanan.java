/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import table.TabelPesanan;


public class Pesanan {
    private String id_pesanan; // SQL : id_pesanan
    private String id_menu; // SQL : id_menu
    private int jumlah; // SQL : jumlah
    private float sub_total; // SQL : sub_total;
    private String namaMenu; // buat konstruktor di show aja, nanti buat kontruktor khusus yang ada nama menu
    private Menu menu;
    
    public Pesanan(String id_pesanan, String id_menu, int jumlah, float sub_total, Menu menu) {
        this.id_pesanan = id_pesanan;
        this.id_menu = id_menu;
        this.jumlah = jumlah;
        this.sub_total = sub_total;
        this.menu = menu;
    } // konstruktor lengkap
    
    public Pesanan(String id_pesanan, String id_menu, int jumlah, float sub_total) {
        this.id_pesanan = id_pesanan;
        this.id_menu = id_menu;
        this.jumlah = jumlah;
        this.sub_total = sub_total;
    }
    
    public Pesanan(String id_pesanan, String id_menu, String nama_menu, int jumlah, float sub_total) {
        this.id_pesanan = id_pesanan;
        this.id_menu = id_menu;
        this.jumlah = jumlah;
        this.sub_total = sub_total;
        this.namaMenu = nama_menu;
    }
    
    public Pesanan(String id_menu, int jumlah, float sub_total) {
        this.id_menu = id_menu;
        this.jumlah = jumlah;
        this.sub_total = sub_total;
    } // konstruktor tanpa id_pesanan


    // getter
    public String getId_pesanan() {
        return id_pesanan;
    }

    public String getId_menu() {
        return id_menu;
    }

    public int getJumlah() {
        return jumlah;
    }

    public float getSub_total() {
        return sub_total;
    }
    
    public Menu getMenu(){
        return menu;
    }
    public String getNamaMenu(){
        return namaMenu;
    }
    // setter
    public void setId_pesanan(String id_pesanan) {
        this.id_pesanan = id_pesanan;
    }

    public void setId_menu(String id_menu) {
        this.id_menu = id_menu;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setSub_total(float sub_total) {
        this.sub_total = sub_total;
    }

    @Override
    public String toString() {
        return "Pesanan{" + "id_pesanan=" + id_pesanan + ", id_menu=" + id_menu + ", jumlah=" + jumlah + ", sub_total=" + sub_total + '}';
    } // toString menampilkan seluruh variabel
    
    public TabelPesanan showTable(List<Pesanan> p) {
        TabelPesanan tabelPesanan = new TabelPesanan(p);
        return tabelPesanan;
    }
}
