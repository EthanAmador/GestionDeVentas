/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciaProyecto.DaoImple;

import com.gerenciaProyecto.Dao.ProductoDao;
import com.gerenciaProyecto.Entites.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Agandio
 */
@Repository
public class ProductoDaoImpl implements ProductoDao {

    @PersistenceContext
    private EntityManager entityManager;

    EntityManager em = getEntityManager();

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Producto> listar() {

        List<Producto> lista = new ArrayList<Producto>();
        Query q = em.createQuery("SELECT p FROM Producto p where p.estado= :estado ");
        q.setParameter("estado", Producto.ESTADOS.ACTIVO.getEstado());
        lista = q.getResultList();
        return lista;
    }

    @Override
    public void crear(Producto producto) {
        try {
            em.persist(producto);
            em.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Producto> listarInactivos() {
        List<Producto> lista = new ArrayList<Producto>();
        Query q = em.createQuery("SELECT p FROM Producto p where p.estado= :estado ");
        q.setParameter("estado", Producto.ESTADOS.INACTIVO.getEstado());
        lista = q.getResultList();
        return lista;
    }

    @Override
    public void modificar(Producto producto) {
        try{
            em.merge(producto);
            em.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }

    @Override
    public Producto ObtenerProductoId(Integer p_IdProducto) {
        EntityManager emp = getEntityManager();
        Producto lista = new Producto();
        Query q = emp.createQuery("SELECT p FROM Producto p WHERE p.id = :id"); 
        q.setParameter("id", p_IdProducto); 
        lista = (Producto)q.getSingleResult(); 

        return lista;
    }
}
