/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.gestores;

import com.mycompany.tp.logistica.fioriusen.daos.CaminoPGDao;
import com.mycompany.tp.logistica.fioriusen.daos.ProductoPGDao;
import com.mycompany.tp.logistica.fioriusen.daos.StockPGDao;
import com.mycompany.tp.logistica.fioriusen.daos.SucursalPGDao;
import com.mycompany.tp.logistica.fioriusen.dtos.SucursalDTO;
import com.mycompany.tp.logistica.fioriusen.entidades.Producto;
import com.mycompany.tp.logistica.fioriusen.entidades.Stock;
import com.mycompany.tp.logistica.fioriusen.entidades.Sucursal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Vulturius
 */
public class GestorSucursal {

    public GestorSucursal() {
    }
    
    
    public int[] validarDatos(SucursalDTO dto){
        int[] mensajes = new int[4];
        
       if(dto.getCodigo().isEmpty() || dto.getNombre().isEmpty() ||  dto.getHoraApertura().isEmpty() ||  dto.getHoraCierre().isEmpty())
         mensajes[0] = 1;
       if(dto.getCodigo().matches(".*[^0-9].*" ))
           mensajes[1] = 1;
       if(dto.getNombre().matches(".*[^aA-zZ]+$.*"))
           mensajes[2]=1;
       if(!dto.getHoraApertura().isEmpty() && !dto.getHoraCierre().isEmpty()){
           if(!dto.getHoraApertura().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]") || !dto.getHoraCierre().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")){
           mensajes[3]=1;
       }
       }
       
       return mensajes;
    }
    
    public Boolean existeSucursal(SucursalDTO dto){
        SucursalPGDao sucursalPG = new SucursalPGDao();
        List<Integer> listCod = new ArrayList<>();
        List<String> listNom = new ArrayList<>();
       
        listCod = sucursalPG.getCodigoAll();
        listNom = sucursalPG.getNombreAll();
        
        listCod.forEach(System.out::println);
        listNom.forEach(System.out::println);
        
        if(listCod.contains(Integer.parseInt(dto.getCodigo())) || listNom.contains(dto.getNombre())){
            return true;
        }
        else {
            crearSucursal(dto);
            return false;             
        }
    }
    
    public void crearSucursal(SucursalDTO dto){
        SucursalPGDao sucursalPG = new SucursalPGDao();
        Sucursal s = new Sucursal(Integer.parseInt(dto.getCodigo()), dto.getNombre(), LocalTime.parse(dto.getHoraApertura()), LocalTime.parse(dto.getHoraCierre()), dto.getEstado());
        sucursalPG.saveSucursal(s);
     }
    
    

    public List<Sucursal> buscarSucursalSegunCriterio(SucursalDTO dto) {
       SucursalPGDao sucursalPG = new SucursalPGDao();
        List<Sucursal> listaSucursales = new ArrayList();
        listaSucursales = sucursalPG.buscarSucursal(dto);
        return listaSucursales;
    }

    public void actualizarSucursal(SucursalDTO dto, String id) {
        SucursalPGDao sucursalPG = new SucursalPGDao();
        Integer identificado = Integer.parseInt(id);
        Sucursal s = new Sucursal(Integer.parseInt(dto.getCodigo()), dto.getNombre(), LocalTime.parse(dto.getHoraApertura()), LocalTime.parse(dto.getHoraCierre()), dto.getEstado());
        sucursalPG.modificarSucursal(s,identificado);
    }

    public void eliminarSucursal(String id) {
     SucursalPGDao sucursalPG = new SucursalPGDao();
         Integer ID = Integer.parseInt(id);
         sucursalPG.borrarSucursal(ID);
        
    }

    public void crearStock(String codigo, Map<Integer, Integer> productos) {
        
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setCodigo(codigo);
        Sucursal sucursal = buscarSucursalSegunCriterio(sucursalDTO).get(0);
         
        ProductoPGDao productoPG = new ProductoPGDao();
        
        List<Producto> listaProductos = new ArrayList<>();
        for(Integer key: productos.keySet()){
           listaProductos.add(productoPG.obtenerProducto(key));
      }
        
        List<Stock> listaStock = new ArrayList<>();
        int i=0;
          for(Integer key: productos.keySet()){
              
         Stock s = new Stock();
        s.setProducto(listaProductos.get(i));
        s.setCantidad(productos.get(key));
        s.setSucursal(sucursal);
        listaStock.add(s);
        i++;
    }
          
          
          
         StockPGDao stockPG = new StockPGDao();
        stockPG.crearStock(listaStock);
        
     }
    
    
    
}

    
