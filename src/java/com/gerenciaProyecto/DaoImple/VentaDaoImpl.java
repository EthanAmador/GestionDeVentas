/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciaProyecto.DaoImple;

import com.gerenciaProyecto.Dao.VentaDao;
import com.gerenciaProyecto.Entites.Venta;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agandio
 */
@Repository
public class VentaDaoImpl implements VentaDao {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    @Transactional
    public void AgregarVenta(Venta p_Venta) {
        EntityManager em = getEntityManager(); 
        try {
            em.persist(p_Venta);
            em.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
