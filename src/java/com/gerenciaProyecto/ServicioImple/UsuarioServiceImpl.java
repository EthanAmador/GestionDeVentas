/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciaProyecto.ServicioImple;

import com.gerenciaProyecto.Dao.UsuarioDao;
import com.gerenciaProyecto.Entites.Usuario;
import com.gerenciaProyecto.Servicio.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agandio
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public void crear(Usuario usuario) {
        usuarioDao.crear(usuario);
    }

    @Override
    public List<Usuario> listar() {
        return usuarioDao.listar();
    }

    @Override
    public List<Usuario> listaInactivos() {
        return usuarioDao.listarInactivos();
    }

    @Override
    public void modificar(Usuario usuario) {
        usuarioDao.modificar(usuario);
    }

    @Override
    public Usuario usuarioLogin(String login) {
        return usuarioDao.consultaUsuarioLogin(login);
    }
}
