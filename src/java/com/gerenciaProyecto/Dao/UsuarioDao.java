/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciaProyecto.Dao;

import com.gerenciaProyecto.Entites.Usuario;
import java.util.List;

/**
 *
 * @author Yer son
 */
public interface UsuarioDao {

    public List<Usuario> listar();

    public void crear(Usuario usuario);

    public List<Usuario> listarInactivos();

    public void modificar(Usuario usuario);

    public Usuario consultaUsuarioLogin(String login);
}
