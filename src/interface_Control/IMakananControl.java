/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interface_Control;

import model.Makanan;
import table.TabelMakanan;

/**
 *
 * @author yobel
 */
public interface IMakananControl extends ICRUDControl<Makanan, String> {
    TabelMakanan showTableBySearch(String search);
}
