/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciaProyecto.Beans;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Agandio
 */
@Named(value = "productoBean")
@ViewScoped
@Controller
public class ProductoBean implements Serializable{

    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
    }
    
}
