/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.daos;

import com.mycompany.tp.logistica.fioriusen.HibernateManager;
import com.mycompany.tp.logistica.fioriusen.entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author zapam
 */
public class ProductoPGDao implements ProductoDao{

    @Override
    public int guardarProducto(Producto p) {
        SessionFactory sessionFactory  = HibernateManager.Configure();
         try (Session session = sessionFactory.openSession()) {
 
            session.beginTransaction();
            session.save(p);
           
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         return p.getId();
    }

    @Override
    public Producto obtenerProducto(int id) {
           Producto p = new Producto();
         SessionFactory sessionFactory  = HibernateManager.Configure();
         try (Session session = sessionFactory.openSession()) {
 
             p = (Producto) session.get(Producto.class, id);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         return p;
           
    }

    @Override
    public List<Producto> obtenerTodosProducto() {
        List<Producto> productos = new ArrayList<>();
      SessionFactory sessionFactory  = HibernateManager.Configure();
         try (Session session = sessionFactory.openSession()) {
             productos = session.createCriteria(Producto.class).list(); 
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         return productos;
        
    }
    
}
