/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciaProyecto.DaoImple;

import com.gerenciaProyecto.Dao.UsuarioDao;
import com.gerenciaProyecto.Entites.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agandio
 */
@Repository
public class UsuarioDaoImpl implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    @Transactional
    public void crear(Usuario usuario) {
        EntityManager em = getEntityManager();
        try {
            em.persist(usuario);
            em.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> listar() {
        EntityManager em = getEntityManager();
        List<Usuario> lista = new ArrayList<Usuario>();
        Query q = em.createQuery("SELECT u FROM Usuario u where u.estado= :estado ");
        q.setParameter("estado", Usuario.ESTADOS.ACTIVO.getEstado());
        lista = q.getResultList();
        return lista;
    }

    @Override
    public List<Usuario> listarInactivos() {
        EntityManager em = getEntityManager();
        List<Usuario> lista = new ArrayList<Usuario>();
        Query q = em.createQuery("SELECT u FROM Usuario u where u.estado= :estado ");
        q.setParameter("estado", 'I');
        lista = q.getResultList();
        return lista;
    }

    @Override
    @Transactional
    public void modificar(Usuario usuario) {
        EntityManager em = getEntityManager();
        try {
            em.merge(usuario);
            em.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario consultaUsuarioLogin(String login) {
        EntityManager em = getEntityManager();
        Usuario usuarioLogin = null;
        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username");
            q.setParameter("username", login);
            usuarioLogin = (Usuario) q.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return usuarioLogin;
    }
}
