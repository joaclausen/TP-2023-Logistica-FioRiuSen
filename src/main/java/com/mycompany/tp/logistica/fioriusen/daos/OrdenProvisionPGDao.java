/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.daos;

import com.mycompany.tp.logistica.fioriusen.HibernateManager;
import com.mycompany.tp.logistica.fioriusen.dtos.OrdenProvisionDTO;
import com.mycompany.tp.logistica.fioriusen.entidades.DetalleOrden;
import com.mycompany.tp.logistica.fioriusen.entidades.OrdenProvision;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Vulturius
 */
public class OrdenProvisionPGDao {
    
    private SessionFactory sessionFactory;

    
    public OrdenProvisionPGDao(){
        sessionFactory = HibernateManager.Configure();
    }
    
    public void guardarOrden(OrdenProvision orden){
        Session session = sessionFactory.openSession();
        
        session.saveOrUpdate(orden);
        List<DetalleOrden> detalleOrden = new ArrayList<>();
        detalleOrden = orden.getDetalleOrden();
        session.beginTransaction();
       /* for(int i = 0; i<detalleOrden.size(); i++){
            session.beginTransaction();
            session.saveOrUpdate(detalleOrden.get(i));
            session.getTransaction().commit();
        }*/
        
         session.getTransaction().commit();
        session.close();
    }
    
    
    public OrdenProvision get(OrdenProvisionDTO dto){
         Session session = sessionFactory.openSession();
         
         OrdenProvision orden = (OrdenProvision) session.get(OrdenProvision.class, dto.getId());
        session.close();
        return orden;
    }
}
