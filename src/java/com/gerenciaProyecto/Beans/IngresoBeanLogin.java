/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//verificar el applicationContext y verificar el bean Usuario para verifcar la
// la inyeccipon de dependecia del bean
package com.gerenciaProyecto.Beans;

import com.gerenciaProyecto.Entites.Usuario;
import com.gerenciaProyecto.Servicio.UsuarioService;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Agandio
 */
@Named("ingresoBeanLogin")
@RequestScoped
@Controller
public class IngresoBeanLogin implements Serializable {

    /**
     * Creates a new instance of IngresoBen
     */
    private String user;
    private String password;
    private String redireccion;
    private Usuario usuario;

    @Autowired
    private UsuarioBean usuarioBean;

    @Autowired
    private UsuarioService usuarioService;

    public IngresoBeanLogin() {
    }

    @PostConstruct
    public void init() {
        try {
            usuario = new Usuario();
            usuarioBean = new UsuarioBean();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//<editor-fold defaultstate="collapsed" desc="action">
    public void onLogin(ActionEvent ev) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            usuario = (Usuario) usuarioService.usuarioLogin(user);
        } catch (Exception tr) {
            tr.printStackTrace();
        }
        if (usuario.getId() != null) {
            if (usuario.getUsername().equals(user)) {
                if (usuario.getPassword().equals(password)) {
                    try {
                        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, usuario.getNombre1() + " "
                                + usuario.getNombre2() + " "
                                + usuario.getApellido1() + " "
                                + usuario.getApellido2(), " Bienvenido   "));
                        
                        context.getExternalContext().redirect("./../view/inicio.xhtml");

                    } catch (IOException ex) {
                        Logger.getLogger(IngresoBeanLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                fake();
                try {
                    context.getExternalContext().redirect("./../login/vistaInicial.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(IngresoBeanLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        fake();
        try {
            context.getExternalContext().redirect("./../login/vistaInicial.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(IngresoBeanLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onLogout(ActionEvent ev) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("./../login/vistaInicial.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(IngresoBeanLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fake() {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o Contraseña ", "No existe "));
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getter and setter">
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRedireccion() {
        return redireccion;
    }

    public void setRedireccion(String redireccion) {
        this.redireccion = redireccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
//</editor-fold>

}
