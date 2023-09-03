/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.daos;

import com.mycompany.tp.logistica.fioriusen.HibernateManager;
import com.mycompany.tp.logistica.fioriusen.dtos.SucursalDTO;
import com.mycompany.tp.logistica.fioriusen.entidades.Camino;
import com.mycompany.tp.logistica.fioriusen.entidades.Sucursal;
import com.mycompany.tp.logistica.fioriusen.enums.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
        
         Session session = sessionFactory.openSession();
         Sucursal aux = new Sucursal();
        Query<Sucursal> query = session.createQuery("FROM Sucursal s WHERE s.nombre =:nombre", Sucursal.class);
        query.setParameter("nombre", nombre);
        aux= query.uniqueResult();
        session.close();
         return aux;
    }
    

    public List<Sucursal> buscarSucursal(SucursalDTO dto){
        Session session = sessionFactory.openSession();
        Query<Sucursal> query;
        List<Sucursal> sadsda = new ArrayList<Sucursal>();
         Estado estado = dto.getEstado();
         if(dto.getCodigo().isEmpty()==false){
            int codigo=Integer.parseInt(dto.getCodigo());
         query = session.createQuery("SELECT s FROM Sucursal s WHERE s.codigo=:codigo", Sucursal.class);
            query.setParameter("codigo", codigo);
       
        }else if(dto.getNombre().isEmpty()==false)
         {
              query = session.createQuery("SELECT s FROM Sucursal s WHERE s.nombre LIKE :nombre ", Sucursal.class);
            query.setParameter("nombre", dto.getNombre() +"%");
        
         }else{
           
             query = session.createQuery("SELECT s FROM Sucursal s WHERE s.estado=:estado", Sucursal.class);
            query.setParameter("estado", estado);
         }
         sadsda = query.getResultList();
         session.close();
         return sadsda;
    }

   /* public void modificarSucursal(SucursalDTO dto) {
      Session session = sessionFactory.openSession();
        Query<Sucursal> query;
        query = session.createQuery("update Sucursal s set s.nombre=:'Parque' where s.codigo=:codigo");
         query.setParameter("codigo", dto.getCodigo());
          query.setParameter("nombre",dto.getCodigo());
          
       
        
    }*/
    
     public void modificarSucursal(Sucursal s, Integer id){
         Session session = sessionFactory.openSession();
         s.setId(id);
        session.beginTransaction();
        session.saveOrUpdate(s);
        session.getTransaction().commit();
        session.close();
        //return s.getId();
    }
     
      public void borrarSucursal(Integer id){
          Session session = sessionFactory.openSession();
          Sucursal sucursal = new Sucursal();
          sucursal.setId(id);
         // session.delete(sucursal);
          session.remove(sucursal);
        session.close();
      }
      
      public Sucursal getSucursalById(Integer id){
         Session  session = sessionFactory.openSession();
            Sucursal sucursal =  (Sucursal) session.get(Sucursal.class, id);
            return sucursal;
      }

    public List<Sucursal> obtenerTodos() {
        List<Sucursal> sucursales = new ArrayList<>();
        SessionFactory sessionFactory  = HibernateManager.Configure();
         try (Session session = sessionFactory.openSession()) {
             sucursales = session.createCriteria(Sucursal.class).list(); 
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         return sucursales;
    }
    public List<Sucursal> getTodas(){
          Session  session = sessionFactory.openSession();
        return session.createQuery("SELECT s FROM Sucursal s").getResultList();
    }
}
