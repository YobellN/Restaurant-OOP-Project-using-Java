/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interface_Control;

import model.Minuman;
import table.TabelMinuman;

/**
 *
 * @author yobel
 */
public interface IMinumanControl extends ICRUDControl<Minuman, String> {
    TabelMinuman showTableBySearch(String search);
}
