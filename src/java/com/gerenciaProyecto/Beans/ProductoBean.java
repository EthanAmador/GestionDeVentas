/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciaProyecto.Beans;

import com.gerenciaProyecto.Entites.Control;
import com.gerenciaProyecto.Entites.Producto;
import com.gerenciaProyecto.Entites.Tienda;
import com.gerenciaProyecto.Entites.Tipoproducto;
import com.gerenciaProyecto.Servicio.ProductoService;
import com.gerenciaProyecto.Util.PanelBean;
import com.gerenciaProyecto.Util.ValoresSelectOneMenu;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Agandio
 */
@ViewScoped
@Controller
public class ProductoBean implements Serializable {

    @Autowired
    private ProductoService productoService;

    @ManagedProperty(value = "#{panelBean}")
    private PanelBean panelBean;

    private List<Producto> productos;
    private List<Producto> productosInactivos;
    private Producto producto;
    private Control control;
    private Tienda tienda;
    private Tipoproducto tipoProducto;
    private String estado;
    private Boolean activo;
    private Boolean inactivo;
    private Boolean nuevo;
    private Boolean listar;

    private String idTienda;
    private String idTipoProducto;

    private final String reqColor = "redRS";
    private final String optColor = "greenRS";

    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
    }

    @PostConstruct
    public void init() {
        try {
            listar = true;
            nuevo = false;
            activo = false;
            inactivo = false;

            producto = new Producto();
            control = new Control(3, Control.ESTADOS.ACTIVO.getEstado());
            productos = productoService.listar();
            productosInactivos = productoService.listarInactivos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //<editor-fold defaultstate="collapsed" desc="action">
    public void onCrear(ActionEvent ev) {
        producto.setEstado(Producto.ESTADOS.ACTIVO.getEstado());

        if (control != null) {
            producto.setIdControl(control);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Informacion:  ", "No se ha encontrado registro de control o de tiedas"));
        }

        if (getIdTienda() != null || !getIdTienda().isEmpty()) {
            tienda = new Tienda(Integer.parseInt(getIdTienda()), Tienda.ESTADOS.ACTIVO.getEstado());
            producto.getIdTienda();
        } else {
            panelBean.showWarning("Debe selecionar una tienda para asociar el producto");
        }

        if (getIdTipoProducto() != null || !getIdTipoProducto().isEmpty()) {
            tipoProducto = new Tipoproducto(Integer.parseInt(getIdTipoProducto()), estado, Producto.ESTADOS.ACTIVO.getEstado());
        } else {
            panelBean.showWarning("Debe selecionar una tipo de producto");
        }
        producto.getIdTipoproducto();

        try {
            productoService.crear(producto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        productos = productoService.listar();
        producto = new Producto();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro :  ", "Creado de forma exitosa"));
    }

    public void onEliminar(ActionEvent event) {
        producto = (Producto) event.getComponent().getAttributes().get("action");
        producto.setEstado(Producto.ESTADOS.INACTIVO.getEstado());
        productoService.modificar(producto);
        productos = productoService.listar();
        productosInactivos = productoService.listarInactivos();
        producto = new Producto();
    }

    public void onActivar(ActionEvent event) {
        producto = (Producto) event.getComponent().getAttributes().get("action");
        producto.setEstado(Producto.ESTADOS.ACTIVO.getEstado());
        productoService.modificar(producto);
        productosInactivos = productoService.listarInactivos();
        productos = productoService.listar();
        producto = new Producto();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro :  ", "Modificado de forma exitosa"));
    }

    public void onListarxEstado(ActionEvent event) {
        if (getEstado().compareTo("1") == 0) {
            activo = true;
            inactivo = false;
        } else if ((getEstado().compareTo("2") == 0)) {
            inactivo = true;
            activo = false;
        }
    }

    public void onNuevoRegistro(ActionEvent ae) {
        listar = false;
        nuevo = true;
        activo = true;
        inactivo = false;
    }

    public void onVolver(ActionEvent event) {
        listar = true;
        nuevo = false;
        activo = false;
    }

    public void onModificar(ActionEvent ae) {
        productoService.modificar(producto);
        producto = new Producto();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getter y setter">
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public ProductoService getProductoService() {
        return productoService;
    }

    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public List<Producto> getProductosInactivos() {
        return productosInactivos;
    }

    public void setProductosInactivos(List<Producto> productosInactivos) {
        this.productosInactivos = productosInactivos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(Boolean inactivo) {
        this.inactivo = inactivo;
    }

    public Boolean getNuevo() {
        return nuevo;
    }

    public void setNuevo(Boolean nuevo) {
        this.nuevo = nuevo;
    }

    public Boolean getListar() {
        return listar;
    }

    public void setListar(Boolean listar) {
        this.listar = listar;
    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }

    public String getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(String idTienda) {
        this.idTienda = idTienda;
    }

    public String getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(String idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Tipoproducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(Tipoproducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getReqColor() {
        return reqColor;
    }

    public String getOptColor() {
        return optColor;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="itemList">
    public List<SelectItem> onListTienda() {
        List<SelectItem> list = new LinkedList<SelectItem>();
        try {
            list = ValoresSelectOneMenu.getListTipoTienda();
        } catch (Exception e) {
//            e.printStackTrace();
            panelBean.showError("Error al cargar las tiendas");
        }
        return list;
    }

    public List<SelectItem> onListTipoProducto() {
        List<SelectItem> list = new LinkedList<SelectItem>();
        try {
            list = ValoresSelectOneMenu.getListTipoProducto();
        } catch (Exception e) {
//            e.printStackTrace();
            panelBean.showError("Error al cargar las tipos de productos");
        }
        return list;
    }
//</editor-fold>
}
