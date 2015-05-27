/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciaProyecto.Beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Agandio
 */
@Named(value = "tiendaBean")
@ViewScoped
@Controller
public class TiendaBean implements Serializable {

    /**
     * Creates a new instance of TiendaBean
     */
    public TiendaBean() {
    }
    
}
