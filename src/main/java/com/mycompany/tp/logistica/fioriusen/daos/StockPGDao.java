/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.daos;

import com.mycompany.tp.logistica.fioriusen.HibernateManager;
import com.mycompany.tp.logistica.fioriusen.dtos.SucursalDTO;
import com.mycompany.tp.logistica.fioriusen.entidades.Producto;
import com.mycompany.tp.logistica.fioriusen.entidades.Stock;
import com.mycompany.tp.logistica.fioriusen.entidades.Sucursal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Vulturius
 */
public class StockPGDao {
    
    private SessionFactory sessionFactory;

    
    public StockPGDao(){
        sessionFactory = HibernateManager.Configure();
    }
    
    public void crearStock(List<Stock> lista){
        //POR, CANT, sucursal
         
       for(int i=0; i<lista.size(); i++){
            
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(lista.get(i));
        session.getTransaction().commit();
          session.close();
        }
     
      
    
    }
    
}
