/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.gestores;

import com.mycompany.tp.logistica.fioriusen.daos.ProductoPGDao;
import com.mycompany.tp.logistica.fioriusen.dtos.ProductoDTO;
import com.mycompany.tp.logistica.fioriusen.entidades.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vulturius
 */
public class GestorProducto {

    public GestorProducto() {
    }
    
    
    public int[] validarDatos(ProductoDTO dto){
        int[] mensajes = new int[6];
        
       if(dto.getNombre().isEmpty() || dto.getCodigo().isEmpty() ||  dto.getPeso().isEmpty() ||  dto.getPrecioUnitario().isEmpty() || dto.getDescripcion().isEmpty())
         mensajes[0] = 1;
       
       if(dto.getNombre().matches(".*[^aA-zZ]+$.*"))
           mensajes[1]= 1;
        if(dto.getCodigo().matches(".*[^0-9].*" ))
           mensajes[2] = 1;
        if(dto.getPeso().matches(".*[^.0-9].*" ))//ver PESO Y PRECIO admite mas de un punto decimal
           mensajes[3] = 1;
        if(dto.getPrecioUnitario().matches(".*[^.0-9].*" ))
           mensajes[4] = 1;
        if(!dto.getDescripcion().matches("^[a-zA-Z0-9]+$")){
           mensajes[5] = 1;}

       return mensajes;
    }
    
    public boolean crearProducto(ProductoDTO p){
        
        if(existeProducto(p) == true){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean existeProducto(ProductoDTO p){
        ProductoPGDao productoPG = new ProductoPGDao(); 
        List<Producto> listaProductos = productoPG.obtenerTodosProducto();
        List<Integer> listCod = new ArrayList();
        List<String> listNom = new ArrayList();
        for(Producto prod: listaProductos){
            listNom.add(prod.getNombre());
        }
        for(Producto prod: listaProductos){
            listCod.add(prod.getCodigo());
        }
        
        //estoy comparando una lista de 
        if(listCod.contains(p.getCodigo()) || listNom.contains(p.getNombre())){
            return true;
        }
        else {
            guardarProducto(p);
            return false;             
        }
    }

    private void guardarProducto(ProductoDTO p) {
       ProductoPGDao productoPG = new ProductoPGDao();
       Producto prod = new Producto();
       prod.setCodigo(Integer.parseInt(p.getCodigo()));
       prod.setNombre(p.getNombre());
       prod.setPeso(Double.parseDouble(p.getPeso()));
       prod.setPrecioUnitario(Double.parseDouble(p.getPrecioUnitario()));
       prod.setDescripcion(p.getDescripcion());
       
       productoPG.guardarProducto(prod);
    }

    public List<Producto> buscarSegunCriterio(ProductoDTO dto) {
        ProductoPGDao puestoPG = new ProductoPGDao();
        List<Producto> listaProductos= new ArrayList();
        listaProductos = puestoPG.buscarProductos(dto);
        return listaProductos;
    }

}
