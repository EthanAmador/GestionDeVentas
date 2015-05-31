/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciaProyecto.Util;

import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Agandio
 */
public class ValoresSelectOneMenu {

    private static List<SelectItem> listTipoTienda = null;
    private static List<SelectItem> listTipoProducto = null;

    public static List<SelectItem> getListTipoTienda() {
        if (listTipoTienda == null) {
            listTipoTienda = new LinkedList<>();
            listTipoTienda.add(new SelectItem("1", "CACHACO"));
            listTipoTienda.add(new SelectItem("2", "COSTEÑO"));
            listTipoTienda.add(new SelectItem("3", "ABASTO"));
            listTipoTienda.add(new SelectItem("4", "MINI MARKET"));
        }
        return listTipoTienda;
    }

    public static List<SelectItem> getListTipoProducto() {
        if (listTipoProducto == null) {
            listTipoProducto = new LinkedList<>();
            listTipoProducto.add(new SelectItem("1", "REFRESCO"));
            listTipoProducto.add(new SelectItem("2", "ACEITES"));
            listTipoProducto.add(new SelectItem("3", "HARINAS"));
            listTipoProducto.add(new SelectItem("4", "LEGUMBRES"));
            listTipoProducto.add(new SelectItem("5", "CARNES"));
            listTipoProducto.add(new SelectItem("6", "PESCADOS"));
            listTipoProducto.add(new SelectItem("7", "ASEO PERSONAL"));
        }
        return listTipoProducto;
    }

}
