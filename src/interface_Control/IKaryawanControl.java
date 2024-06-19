/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interface_Control;

import model.Karyawan;
import table.TabelKaryawan;

/**
 *
 * @author yobel
 */
public interface IKaryawanControl extends ICRUDControl<Karyawan, String> {
    TabelKaryawan showTableBySearch(String search);
    Karyawan searchDataKaryawan(String id);
    boolean loginKaryawan(String user, String pass, String id);
}
