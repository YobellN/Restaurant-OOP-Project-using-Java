/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interface_Control;

import model.Pelanggan;
import table.TabelPelanggan;

/**
 *
 * @author yobel
 */
public interface IPelangganControl extends ICRUDControl<Pelanggan, String> {
    TabelPelanggan showTableBySearch(String search);
    Pelanggan searchDataPelanggan(String id);
}
