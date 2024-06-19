/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interface_DAO;

import java.util.List;

/**
 *
 * @author yobel
 */
public interface ISearchDataMenu<T,I> {
  public List<T> search(I data);
}
