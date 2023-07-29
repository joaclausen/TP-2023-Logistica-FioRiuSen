/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.gestores;

import com.mycompany.tp.logistica.fioriusen.daos.SucursalPGDao;
import com.mycompany.tp.logistica.fioriusen.dtos.SucursalDTO;
import com.mycompany.tp.logistica.fioriusen.entidades.Sucursal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
        SucursalPGDao puestoPG = new SucursalPGDao();
        List<Integer> listCod = new ArrayList();
        List<String> listNom = new ArrayList();
       
        listCod = puestoPG.getCodigoAll();
        listNom = puestoPG.getNombreAll();
        
        listCod.forEach(System.out::println);
        listNom.forEach(System.out::println);
        
        if(listCod.contains(dto.getCodigo()) || listNom.contains(dto.getNombre())){
            return true;
        }
        else {
            crearSucursal(dto);
            return false;             
        }
    }
    
    private void crearSucursal(SucursalDTO dto){
        SucursalPGDao sucursalPG = new SucursalPGDao();
        Sucursal s = new Sucursal(Integer.parseInt(dto.getCodigo()), dto.getNombre(), LocalTime.parse(dto.getHoraApertura()), LocalTime.parse(dto.getHoraCierre()), dto.getEstado());
        sucursalPG.saveSucursal(s);
     }
    
    
}

    
