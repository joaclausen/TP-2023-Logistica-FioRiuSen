/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.daos;

import com.mycompany.tp.logistica.fioriusen.HibernateManager;
import com.mycompany.tp.logistica.fioriusen.dtos.CaminoDTO;
import com.mycompany.tp.logistica.fioriusen.entidades.Camino;
import com.mycompany.tp.logistica.fioriusen.enums.Estado;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

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
    
    
    
     public List<Camino> buscarCaminos(CaminoDTO dto){
        Session session = sessionFactory.openSession();
        Query<Camino> query;
         Estado estado = dto.getEstado();
         
         if(dto.getCodigo().isEmpty()==false){
            int codigo=Integer.parseInt(dto.getCodigo());
         query = session.createQuery("SELECT c FROM Camino c WHERE c.codigo=:codigo", Camino.class);
            query.setParameter("codigo", codigo);
       
        }else if(dto.getDestino().isEmpty()==false && dto.getOrigen().isEmpty()==false)
         {
             int origen = Integer.parseInt(dto.getOrigen());
             int destino = Integer.parseInt(dto.getDestino());
              query = session.createQuery("SELECT c FROM Camino c WHERE c.destino=:destino AND  c.origen=:origen", Camino.class);
            query.setParameter("destino", destino);
            query.setParameter("origen", origen);
        
         }
         
         else if(dto.getOrigen().isEmpty()==false)
         {
             int origen = Integer.parseInt(dto.getOrigen());
              query = session.createQuery("SELECT c FROM Camino c WHERE c.id_sucursal_origen=:origen", Camino.class);
              query.setParameter("origen", origen);
          //ACA DEBO PEDIREL EL ID A SUCURSAL PORQUE CAMINO GUARDA IDS Y NO NOMBRES
         }else if(dto.getDestino().isEmpty()==false)
         {
              int destino = Integer.parseInt(dto.getDestino());
              query = session.createQuery("SELECT c FROM Camino c WHERE c.destino=:destino", Camino.class);
             query.setParameter("destino", destino);
         
         } else{
           
             query = session.createQuery("SELECT c FROM Camino c WHERE c.estado=:estado", Camino.class);
            query.setParameter("estado", estado);
         }
         
         return query.getResultList();
    }
     
      public void modificarCamino(Camino c, Integer id){
         Session session = sessionFactory.openSession();
         c.setId(id);
        session.beginTransaction();
        session.saveOrUpdate(c);
        session.getTransaction().commit();
        session.close();
        //return s.getId();
    }
 
      public void borrarCamino(Integer id){
          Session session = sessionFactory.openSession();
          Camino camino = new Camino();
           camino.setId(id);
          session.delete(camino);
          //session.remove(camino);
      }
}
