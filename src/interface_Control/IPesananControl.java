/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interface_Control;

import java.util.List;
import model.Pesanan;
import table.TabelPesanan;

/**
 *
 * @author yobel
 */
public interface IPesananControl {
    void insertDataPesanan(List<Pesanan> pesananList);
    void updateDataPesanan(Pesanan pesanan);
    void deleteDataPesanan(String idPesanan, String idMenu);
}
