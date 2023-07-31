/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.daos;

import com.mycompany.tp.logistica.fioriusen.HibernateManager;
import com.mycompany.tp.logistica.fioriusen.entidades.Camino;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author zapam
 */
public class CaminoPGDao implements CaminoDao{

    private SessionFactory sessionFactory;
    
    public CaminoPGDao(){
        sessionFactory = HibernateManager.Configure();
    }
    
    @Override
    public void guardarCamino(Camino c) {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(c);
        session.getTransaction().commit();
        session.close();
        
    }

    @Override
    public Camino obtenerCamino(int id) {
          Camino c = new Camino();
         SessionFactory sessionFactory  = HibernateManager.Configure();
         try (Session session = sessionFactory.openSession()) {
 
             c = (Camino) session.get(Camino.class, id);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         return c;
    }

  
    public List<Integer> getCodigoAll(){
        Session session = sessionFactory.openSession();
        return session.createQuery("SELECT codigo FROM Camino").getResultList();
        
    }

    public List<Camino> obtenerTodos() {
         List<Camino> productos = new ArrayList<>();
        SessionFactory sessionFactory  = HibernateManager.Configure();
         try (Session session = sessionFactory.openSession()) {
             productos = session.createCriteria(Camino.class).list(); 
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         return productos;
    }
    
}
