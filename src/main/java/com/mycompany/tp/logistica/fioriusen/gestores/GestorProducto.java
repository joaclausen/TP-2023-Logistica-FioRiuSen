/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.gestores;

import com.mycompany.tp.logistica.fioriusen.dtos.ProductoDTO;

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
    
}
