/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.daos;

import com.mycompany.tp.logistica.fioriusen.HibernateManager;
import com.mycompany.tp.logistica.fioriusen.entidades.Sucursal;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Vulturius
 */
public class SucursalPGDao implements SucursalDao{
    
    private SessionFactory sessionFactory;

    
    public SucursalPGDao(){
        sessionFactory = HibernateManager.Configure();
    }
    
     public Sucursal Get(int id){
        Session session = sessionFactory.openSession();
       
       Sucursal sucursal = (Sucursal) session.get(Sucursal.class, id);
        session.close();
        return sucursal;
    }
    
    public void saveSucursal(Sucursal s){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(s);
        session.getTransaction().commit();
        session.close();
        //return s.getId();
    }

    public List<Integer> getCodigoAll(){
        Session session = sessionFactory.openSession();
        return session.createQuery("SELECT codigo FROM Sucursal").getResultList();
        
    }
    public List<String> getNombreAll(){
        Session session = sessionFactory.openSession();
        return session.createQuery("SELECT nombre FROM Sucursal").getResultList();
    }
    
    public Sucursal obtenerPorNombre(String nombre){
        
         Sucursal s = new Sucursal();
         SessionFactory sessionFactory  = HibernateManager.Configure();
         try (Session session = sessionFactory.openSession()) {
 
             s = (Sucursal) session.get(Sucursal.class, nombre);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         return s;
    }
    
}
