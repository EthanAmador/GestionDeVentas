/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gerenciaProyecto.Dao;

import com.gerenciaProyecto.Entites.Producto;
import java.util.List;

/**
 *
 * @author Yer son
 */
public interface ProductoDao {
    
     public List<Producto> listar();

    public void crear(Producto producto);

    public List<Producto> listarInactivos();

    public void modificar(Producto producto);
   
}
