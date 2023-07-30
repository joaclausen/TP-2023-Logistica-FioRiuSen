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
    
    @Override
    public int guardarCamino(Camino c) {
         SessionFactory sessionFactory  = HibernateManager.Configure();
         try (Session session = sessionFactory.openSession()) {
 
            session.beginTransaction();
            session.saveOrUpdate(c);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         return c.getId();
    }

    @Override
    public Camino obtenerProducto(int id) {
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

    @Override
    public List<Camino> obtenerTodosCamino() {
        List<Camino> caminos = new ArrayList<>();
        SessionFactory sessionFactory  = HibernateManager.Configure();
         try (Session session = sessionFactory.openSession()) {
             caminos = session.createCriteria(Camino.class).list(); 
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         return caminos;
    }
    
}
