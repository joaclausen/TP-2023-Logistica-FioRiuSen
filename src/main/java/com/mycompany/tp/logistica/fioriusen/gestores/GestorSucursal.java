/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.gestores;

import com.mycompany.tp.logistica.fioriusen.dtos.SucursalDTO;

/**
 *
 * @author Vulturius
 */
public class GestorSucursal {

    public GestorSucursal() {
    }
    
    
    public int[] validarDatos(SucursalDTO dto){
        int[] mensajes = new int[4];
        
       if(dto.getCodigo().isEmpty() || dto.getEstado().isEmpty() ||  dto.getHoraApertura().isEmpty() ||  dto.getHoraCierre().isEmpty())
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
    
}
