/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciaProyecto.Util;

import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.Appear;
import com.icesoft.faces.context.effects.EffectQueue;
import com.icesoft.faces.context.effects.Fade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author admin
 */
@ManagedBean
@ViewScoped
public class PanelBean extends PanelPopup implements Serializable {

    private boolean rendered;
    private String styleClass;
    private String style;
    private EffectQueue effectQueue;
    private String estilo;
    private String titulo;
    private String mensaje;
    private String icono;
    private final String styleClassOK = "popPerfect";
    private final String styleClassInfo = "popInfo";
    private final String styleClassWarn = "popWarnig";
    private final String styleClassError = "popError";

    public enum ICONOS {

        ICONO_OK("/resources/Imagenes/tick_32.png"),
        ICONO_INFO("/resources/Imagenes/info_32.png"),
        ICONO_WARNING("/resources/Imagenes/warning_32.png"),
        ICONO_ERROR("/resources/Imagenes/user_32.png");
        private String url;

        ICONOS(String url) {
            ICONOS.this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    public PanelBean() {
//        init();
    }

    @PostConstruct
    public void init() {
        setStyleClass("popPerfect");
        estilo = "z-index: 100000; position: fixed; width:auto; top: 85%; left: 65%;";
        setStyle(estilo);
        setRendered(false);
    }

    public void show(ICONOS icono, String titulo, String mensaje) {
        setRendered(true);
        setIcono(icono.getUrl());
        setTitulo(titulo != null ? titulo : "");
        setMensaje(mensaje != null ? mensaje : "");
        if (icono == ICONOS.ICONO_OK) {
            setStyleClass(styleClassOK);
        }
        if (icono == ICONOS.ICONO_INFO) {
            setStyleClass(styleClassInfo);
        }
        if (icono == ICONOS.ICONO_ERROR) {
            setStyleClass(styleClassError);
        }
        if (icono == ICONOS.ICONO_WARNING) {
            setStyleClass(styleClassWarn);
        }
        lanzarEfecto(4);
    }

    public void show(ICONOS icono, String titulo, String mensaje, int delay) {
        show(icono, titulo, mensaje);
        lanzarEfecto(delay);
    }

    public void showOk(String titulo, String mensaje) {
        show(ICONOS.ICONO_OK, titulo, mensaje);
    }

    public void showInfo(String titulo, String mensaje) {
        show(ICONOS.ICONO_INFO, titulo, mensaje);
    }

    public void showWarning(String titulo, String mensaje) {
        show(ICONOS.ICONO_WARNING, titulo, mensaje);
    }

    public void showError(String titulo, String mensaje) {
        show(ICONOS.ICONO_ERROR, titulo, mensaje);
    }

    public void showOk(String mensaje) {
        show(ICONOS.ICONO_OK, "Mensaje de Confirmación", mensaje);
    }

    public void showInfo(String mensaje) {
        show(ICONOS.ICONO_INFO, "Mensaje de Información", mensaje);
    }

    public void showWarning(String mensaje) {
        show(ICONOS.ICONO_WARNING, "Advertencia", mensaje);
    }

    public void showError(String mensaje) {
        show(ICONOS.ICONO_ERROR, "Error", mensaje);
    }

    private void lanzarEfecto(int delay) {
        EffectQueue eq = new EffectQueue("effectFadeAppear");
        Appear ap = new Appear();

        Fade f = new Fade();
        f.setDelay(delay);
        eq.add(ap);
        eq.add(f);
        setEffectQueue(eq);
    }

    public void cerrar(ActionEvent e) {
        rendered = false;
    }

    public void abrir(ActionEvent e) {
        rendered = true;
    }

    // <editor-fold defaultstate="collapsed" desc="GET & SET">
    public EffectQueue getEffectQueue() {
        return effectQueue;
    }

    public void setEffectQueue(EffectQueue effectQueue) {
        this.effectQueue = effectQueue;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public boolean isRendered() {
        return rendered;
    }

    @Override
    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    @Override
    public String getStyleClass() {
        return styleClass;
    }

    @Override
    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getStyle() {
        return style;
    }

    @Override
    public void setStyle(String style) {
        this.style = style;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    // </editor-fold>
}
