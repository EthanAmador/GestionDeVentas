/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciaProyecto.Servicio;

import com.gerenciaProyecto.Entites.Usuario;
import java.util.List;

public interface UsuarioService {

    public List<Usuario> listar();

    public void crear(Usuario usuario);

    public List<Usuario> listaInactivos();

    public void modificar(Usuario usuario);
    
    public Usuario usuarioLogin(String login);
}
