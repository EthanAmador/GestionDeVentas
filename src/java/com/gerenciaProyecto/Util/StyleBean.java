package com.gerenciaProyecto.Util;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author agandio
 */
@ManagedBean
@ViewScoped
public class StyleBean implements Serializable {

    public static String icono_arrow_ff = "/resources/Imagenes/arrow-ff.gif";
    public static String icono_arrow_fr = "/resources/Imagenes/arrow-fr.gif";
    public static String icono_arrow_next = "/resources/Imagenes/arrow-next.gif";
    public static String icono_arrow_previous = "/resources/Imagenes/arrow-previous.gif";

    public String getIcono_arrow_ff() {
        return icono_arrow_ff;
    }

    public String getIcono_arrow_fr() {
        return icono_arrow_fr;
    }

    public String getIcono_arrow_next() {
        return icono_arrow_next;
    }

    public String getIcono_arrow_previous() {
        return icono_arrow_previous;
    }

}
