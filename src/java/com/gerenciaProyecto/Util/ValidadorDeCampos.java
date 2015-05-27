/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gerenciaProyecto.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Agandio
 */
public class ValidadorDeCampos {
    /**
     * Metodo valida el ingreso de datos
     *
     * @param valor
     * @param expReg Representa el patrón
     *
     * @return boolean
     */
    public static boolean validar(String expReg, String valor) {
        Pattern patron = Pattern.compile(expReg);
        Matcher expresion = patron.matcher(valor);
        return expresion.matches();
    }

    public static boolean codigoCategoria(String valor) {
        return validar("^[0-9][A-Z]", valor);
    }

    /**
     * Metodo que verifica si el dato ingresado es un número teléfonico
     *
     * @param Valor Representa el dato a comprobar
     * @return
     */
    public static boolean isPhoneNumber(String Valor) {
        return validar("[(?\\d{1,3})?[- ]*)]*\\d{7}", Valor);
    }
   
    public static boolean isCelular(String valor){
        return validar("^[300-321]\\d{7}", valor);
    }

    /**
     * Metodo que verifica si el dato ingresado es un correo electrónico
     *
     *
     * @param valor
     * @return
     */
    public static boolean isEmail(String valor) {
        return validar("^[\\w-\\.]+\\@[\\w\\.-]+\\.[a-z]{2,4}$", valor);
    }

    /**
     * Metodo que verifica si el dato ingresado es una cadena alfanumerica
     *
     *
     * @param valor
     * @return
     */
    public static boolean isCaracteres(String valor) {
        return validar("[\\wá-úÁ-Ú\\s]*", valor);
    }

    /**
     * Metodo que verifica si el dato ingresado es un número
     *
     *
     * @param valor
     * @return
     */
    public static boolean isNumero(String valor) {
        return validar("[\\d]*", valor);
    }

    /**
     * Metodo que verifica si el dato ingresado es una cadena alfabetica
     *
     *
     * @param valor
     * @return
     */
    public static boolean isAlfabetico(String valor) {
        return validar("[a-zA-záéíóúÁÉÍÓÚ\\s]*", valor);
    }

    public static boolean isReal(String valor) {
        try {
            Double numero = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
   
    public static boolean isDirrecion(String valor){
        return validar("[\\w\\s]*" , valor);
    }  
    
    
    
    public static boolean isIdentificacionColombia(String valor) {
        return validar("^[1-9][0-9]{6,9}", valor);
    }

}
