/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciaProyecto.Beans;

import com.gerenciaProyecto.Entites.Producto;
import com.gerenciaProyecto.Servicio.ProductoService;
import com.gerenciaProyecto.Servicio.VentaService;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import org.springframework.stereotype.Controller;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Agandio
 */
//@Named(value = "ventaBean")
@ViewScoped
@Controller
public class VentaBean implements Serializable {

    @Autowired
    private VentaService servicioventa;
    @Autowired
    private ProductoService productoService;

    private Producto m_Producto;

    private String CodigoProducto;
    private String Cantidad;
    private String Precio;

    /**
     * Creates a new instance of VentaBean
     */
    public VentaBean() {

    }

    @PostConstruct
    public void init() {
        try {
            CodigoProducto = "";
            Cantidad = "0";
            Precio ="0"; 
            m_Producto = Producto.GetInstacia(); 
        } catch (Exception e) {
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Action">
    public void OnConsultar(ActionEvent ev) {
        Integer _codigo = 0;
        try {
            _codigo = Integer.parseInt(CodigoProducto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (_codigo != 0) {
                m_Producto = productoService.ObtenerProductoId(_codigo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void OnAgregar(ActionEvent ev)
    {
        
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Get And Set">
    public String getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public VentaService getServicioventa() {
        return servicioventa;
    }

    public void setServicioventa(VentaService servicioventa) {
        this.servicioventa = servicioventa;
    }

    public ProductoService getProductoService() {
        return productoService;
    }

    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public Producto getM_Producto() {
        return m_Producto;
    }

    public void setM_Producto(Producto m_Producto) {
        this.m_Producto = m_Producto;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }
    
      public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }
    
    //</editor-fold>
}
