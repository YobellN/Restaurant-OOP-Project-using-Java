/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interface_Control;

import model.Transaksi;
import table.TabelTransaksi;

/**
 *
 * @author yobel
 */
public interface ITransaksiControl extends ICRUDControl<Transaksi, String> {
    TabelTransaksi showTableBySearch(String search);
    void insertTotalHarga(Transaksi transaksi);
}
