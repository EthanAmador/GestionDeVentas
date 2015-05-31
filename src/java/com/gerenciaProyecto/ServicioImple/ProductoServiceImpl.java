/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciaProyecto.ServicioImple;

import com.gerenciaProyecto.Dao.ProductoDao;
import com.gerenciaProyecto.Entites.Producto;
import com.gerenciaProyecto.Servicio.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agandio
 */
@Service
public class ProductoServiceImpl implements ProductoService {
    
    @Autowired
    private ProductoDao productoDao;
    
    @Override
    public List<Producto> listar() {
        return productoDao.listar();
    }
    
    @Override
    public void crear(Producto producto) {
        productoDao.crear(producto);
    }
    
    @Override
    public List<Producto> listarInactivos() {
        return productoDao.listarInactivos();
    }
    
    @Override
    public void modificar(Producto producto) {
        productoDao.modificar(producto);
    }

    @Override
    public Producto ObtenerProductoId(Integer p_IdProducto) {
        return null; 
    }
}
