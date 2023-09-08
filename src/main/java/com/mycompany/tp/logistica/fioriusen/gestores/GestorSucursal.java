/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.gestores;

import com.mycompany.tp.logistica.fioriusen.entidades.OrdenProvision;
import com.mycompany.tp.logistica.fioriusen.daos.CaminoPGDao;
import com.mycompany.tp.logistica.fioriusen.daos.OrdenProvisionPGDao;
import com.mycompany.tp.logistica.fioriusen.daos.ProductoPGDao;

import com.mycompany.tp.logistica.fioriusen.daos.SucursalPGDao;
import com.mycompany.tp.logistica.fioriusen.dtos.OrdenProvisionDTO;
import com.mycompany.tp.logistica.fioriusen.dtos.SucursalDTO;
import com.mycompany.tp.logistica.fioriusen.entidades.DetalleOrden;
import com.mycompany.tp.logistica.fioriusen.entidades.ListaProductos;
import com.mycompany.tp.logistica.fioriusen.dtos.CaminoDTO;
import com.mycompany.tp.logistica.fioriusen.dtos.SucursalDTO;
import com.mycompany.tp.logistica.fioriusen.entidades.Camino;
import com.mycompany.tp.logistica.fioriusen.entidades.Producto;
import com.mycompany.tp.logistica.fioriusen.entidades.Stock;
import com.mycompany.tp.logistica.fioriusen.entidades.Sucursal;
import com.mycompany.tp.logistica.fioriusen.enums.Orden;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Vulturius
 */
public class GestorSucursal {
    private SessionFactory sessionFactory;
    
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
        s.setEliminado(Boolean.FALSE);
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
         Sucursal s = sucursalPG.Get(ID);
         s.setEliminado(Boolean.TRUE);
         sucursalPG.borrarSucursal(s);
        
    }

    public void crearStock(String codigo, Map<Integer, Integer> productos) {
        
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setCodigo("");
        //sucursalDTO.setEstado("");
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
       // s.setSucursal(sucursal);
       
        listaStock.add(s);
        sucursal.getListaProductos().add(s);
        
        i++;
    }
          sucursal.setListaProductos(listaStock);
          SucursalPGDao sucursalPG = new SucursalPGDao();
          sucursalPG.saveSucursal(sucursal);
          
          
        /* StockPGDao stockPG = new StockPGDao();
        stockPG.crearStock(listaStock);*/
       
        
     }
        public List<SucursalDTO> obtenerParaGrafo() {
        SucursalPGDao sucursalPG = new SucursalPGDao();
        List<SucursalDTO> sucursales = new ArrayList<SucursalDTO>();
        //obtengo todos los obj camino,  por c/u creo unos dto para pasarle a la interfaz, con qué atributos??
        List<Sucursal> lasSucursalesOG = new ArrayList<>();
        lasSucursalesOG = sucursalPG.obtenerTodos();
        
        for(Sucursal s: lasSucursalesOG){
            SucursalDTO sDTO = new SucursalDTO();
            sDTO.setNombre(s.getNombre());
            sucursales.add(sDTO);
        }
        
        
        return sucursales;
    }
    
    
    public void crearOrdenDeProvision(OrdenProvisionDTO ordenDTO, Map<Integer, Integer> productos){
        
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setNombre(ordenDTO.getDestino());
        sucursalDTO.setCodigo(ordenDTO.getCodigoSucursal().toString());
        List<Sucursal> sucursales = buscarSucursalSegunCriterio(sucursalDTO);
        Sucursal sucursal = sucursales.get(0);
        
        ProductoPGDao productoPG = new ProductoPGDao();
        
        List<Producto> listaProductos = new ArrayList<>();
        for(Integer key: productos.keySet()){
           listaProductos.add(productoPG.obtenerProducto(key));
      }
        
        List<DetalleOrden> listaDetalleOrden = new ArrayList<>();
        
        OrdenProvision orden = new OrdenProvision();
        orden.setFechaEmision(LocalDate.parse(ordenDTO.getFechaEmision()));
        //orden.setSucursal(sucursal);
        orden.setEspera(LocalTime.parse(ordenDTO.getEspera()));
        orden.setEstado(Orden.PENDIENTE);
        
        int i =0;
        for(Integer key: productos.keySet()){
              
        DetalleOrden d = new DetalleOrden();
        d.setProducto(listaProductos.get(i));
        d.setCantidad(productos.get(key));
        //d.setOrdenProvision(orden);
        listaDetalleOrden.add(d);
        i++;
    }
         
       //orden.setDetalleOrden(listaDetalleOrden);
       orden.setDetalleOrden(listaDetalleOrden);
       List<OrdenProvision> ordenDeProvision = new ArrayList<>();
       ordenDeProvision.add(orden);
       
         /*OrdenProvisionPGDao ordenPG = new OrdenProvisionPGDao();
        ordenPG.guardarOrden(orden);*/
          sucursal.setOrdenProvision(ordenDeProvision);
          SucursalPGDao sucursalPG = new SucursalPGDao();
          sucursalPG.saveSucursal(sucursal);
          
          

    }
     
     public List<Sucursal> getAll(){
        SucursalPGDao sucursalPG = new SucursalPGDao();
        List<Sucursal> sucursales = sucursalPG.getTodas();
       return sucursales;
     }
     
     
     
     public List<SucursalDTO> buscarStockEnSucursales(SucursalDTO dto, OrdenProvisionDTO ordenSeleccionada){
         
         //ESTOS ERRORES SON PORQUE TENGO QUE BUSCAR LA ORDENTAMBIEN
        Sucursal s = buscarSucursalSegunCriterio(dto).get(0);
        
        OrdenProvision ordenProvision = new OrdenProvision();
        OrdenProvisionPGDao ordenPG = new OrdenProvisionPGDao();
        
        ordenProvision = ordenPG.get(ordenSeleccionada);
        
        List<Sucursal> sucursales = getAll();
        
        List<Producto> productosPedidos = new ArrayList<>();
        
        /////////////////
       
        
        for (int i = 0; i < ordenProvision.getDetalleOrden().size(); i++) {
            productosPedidos.add(ordenProvision.getDetalleOrden().get(i).getProducto());
        }
        
         
         
        System.out.println("El ID es: " + ordenProvision.getDetalleOrden().size());
        System.out.println("Cantidad de sucursales: " + sucursales.size());
        System.out.println("Cantidad de producto pedidos:" + productosPedidos.size());
        
        List<Producto> productosDisponibles = new ArrayList<>();
        List<SucursalDTO> sucursalesConStock = new ArrayList<>();
        
        for (int k = 0; k < sucursales.size(); k++) {
            System.out.println("PUEDO SACAR EL STOCK DE UNA SUC: " + sucursales.get(k).getListaProductos().size());
            
            for (int h = 0; h < sucursales.get(k).getListaProductos().size(); h++) {
                
                productosDisponibles.add(sucursales.get(k).getListaProductos().get(h).getProducto());
                
            }
             ListaProductos prodPedidos = new ListaProductos(productosDisponibles);
              boolean todosDisponibles = prodPedidos.containsAll(productosPedidos);
            if (todosDisponibles) {
                SucursalDTO sdto = new SucursalDTO();
                sdto.setId(sucursales.get(k).getId());
                sdto.setCodigo(sucursales.get(k).getCodigo().toString());
                sdto.setNombre(sucursales.get(k).getNombre());
                sdto.setEstado(sucursales.get(k).getEstado());
                System.out.println("La sucursal es :" + sucursales.get(k).getNombre());
                sucursalesConStock.add(sdto);
            } else {
                productosDisponibles.clear();
            }
        }
        
        ordenProvision.setEstado(Orden.EN_PROCESO);
        ordenPG.guardarOrden(ordenProvision);
        
        return sucursalesConStock;
    }
}

    
