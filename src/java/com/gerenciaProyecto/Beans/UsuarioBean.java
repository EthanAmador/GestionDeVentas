/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciaProyecto.Beans;

import com.gerenciaProyecto.Entites.Control;
import com.gerenciaProyecto.Entites.Usuario;
import com.gerenciaProyecto.Servicio.UsuarioService;
import com.gerenciaProyecto.Util.PanelBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Agandio
 */
@ViewScoped
@Controller
public class UsuarioBean implements Serializable {

    @Autowired
    private UsuarioService usuarioService;

//    @ManagedProperty(value = "#{panelBean}")
//    private PanelBean panelBean;

    private List<Usuario> usuarios;
    private List<Usuario> listaTablaUsuriosInactivos;
    private Control control;
    private Usuario usuario;
    private String estado;
    private Boolean activo;
    private Boolean inactivo;
    private Boolean nuevo;
    private Boolean listar;

    private final String reqColor = "redRS";
    private final String optColor = "greenRS";

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }

    @PostConstruct
    public void init() {
        try {
            listar = true;
            nuevo = false;
            activo = false;
            inactivo = false;

            control = new Control(3, Control.ESTADOS.ACTIVO.getEstado());
            usuario = new Usuario();
            usuarios = usuarioService.listar();
            listaTablaUsuriosInactivos = usuarioService.listaInactivos();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //<editor-fold defaultstate="collapsed" desc="action">
    public void onCrear(ActionEvent ev) {
        usuario.setEstado(Usuario.ESTADOS.ACTIVO.getEstado());
        if (control != null) {
            usuario.setIdControl(control);
        } else {
//              panelBean.showError("No se ha encontrado registro de control");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Informacion:  ", "No se ha encontrado registro de control"));
        }
        try {
            usuarioService.crear(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
        usuarios = usuarioService.listar();
        usuario = new Usuario();
//        panelBean.showOk("Usuario Creado de forma exitosa");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro :  ", "Creado de forma exitosa"));
    }

    public void onEliminar(ActionEvent event) {
        usuario = (Usuario) event.getComponent().getAttributes().get("action");
        usuario.setEstado(Usuario.ESTADOS.INACTIVO.getEstado());
        usuarioService.modificar(usuario);
        usuarios = usuarioService.listar();
        listaTablaUsuriosInactivos = usuarioService.listaInactivos();
        usuario = new Usuario();
    }

    public void onActivar(ActionEvent event) {
        usuario = (Usuario) event.getComponent().getAttributes().get("action");
        usuario.setEstado(Usuario.ESTADOS.ACTIVO.getEstado());
        usuarioService.modificar(usuario);
        listaTablaUsuriosInactivos = usuarioService.listaInactivos();
        usuarios = usuarioService.listar();
        usuario = new Usuario();
//          panelBean.showInfo("Registro modificado  de forma exitosa");
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
        usuarioService.modificar(usuario);
        usuario = new Usuario();
    }

//    public void onListarxCodigo(ActionEvent ev) {
//        String codigo = usuario.getCodigo();
//        usuario = usuarioService.listarxcodigo(codigo);
//    }
    public void onSeleccionarUsuario(ActionEvent ae) {
        usuario = (Usuario) ae.getComponent().getAttributes().get("action");
        onNuevoRegistro(ae);
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="getter y setter">
    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;

    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }

    public List<Usuario> getListaTablaUsuriosInactivos() {
        return listaTablaUsuriosInactivos;
    }

    public void setListaTablaUsuriosInactivos(List<Usuario> listaTablaUsuriosInactivos) {
        this.listaTablaUsuriosInactivos = listaTablaUsuriosInactivos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getReqColor() {
        return reqColor;
    }

    public String getOptColor() {
        return optColor;
    }
}
//</editor-fold>
