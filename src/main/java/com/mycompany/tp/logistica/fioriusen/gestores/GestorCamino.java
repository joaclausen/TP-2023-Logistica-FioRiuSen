/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.gestores;

import com.mycompany.tp.logistica.fioriusen.daos.CaminoPGDao;
import com.mycompany.tp.logistica.fioriusen.daos.SucursalPGDao;
import com.mycompany.tp.logistica.fioriusen.dtos.CaminoDTO;
import com.mycompany.tp.logistica.fioriusen.entidades.Camino;
import com.mycompany.tp.logistica.fioriusen.entidades.Sucursal;
import com.mycompany.tp.logistica.fioriusen.enums.Estado;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vulturius
 */
public class GestorCamino {

    public GestorCamino() {
    }
    public int[] validarDatos(CaminoDTO dto){
        int[] mensajes = new int[6];

        if (dto.getCodigo().isEmpty() || dto.getOrigen().isEmpty() || dto.getDestino().isEmpty() || dto.getCapacidadMaxima().isEmpty() || dto.getTiempoTransito().isEmpty()) {
            mensajes[0] = 1;
        }

        if (dto.getCodigo().matches(".*[^0-9].*")) {
            mensajes[1] = 1;
        }
        if (dto.getOrigen().matches(".*[^aA-zZ]+$.*") || dto.getDestino().matches(".*[^aA-zZ]+$.*")) {
            mensajes[2] = 1;
        }
        if (dto.getCapacidadMaxima().matches(".*[^0-9].*"))//ver esto al igual que en producto va a admitir mas de un .
        {
            mensajes[3] = 1;
        }
       if(!dto.getTiempoTransito().isEmpty()){
           if (!dto.getTiempoTransito().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]"))//USAMOS SOLO 99 HOURS?
        {
            mensajes[4] = 1;//NO FUNCA
        }
        if(dto.getOrigen().equals(dto.getDestino())){
            mensajes[5] = 1;
        }
       }
        
        return mensajes;
    }

    public boolean crearCamino(CaminoDTO c) {
        
        if(existeCamino(c) == true){
            return false;
        }
        else{
            return true;
        }
    }

    private boolean existeCamino(CaminoDTO c) {
        CaminoPGDao caminoPG = new CaminoPGDao(); 
        List<Integer> listaCaminos = new ArrayList<>();
               listaCaminos= caminoPG.obtenerTodosCamino();
        /*List<Integer> listCod = new ArrayList();
        for(Camino cami: listaCaminos){
            listCod.add(cami.getCodigo());
        }*/
        if(listaCaminos.contains(Integer.parseInt(c.getCodigo()))){
            return true;
        }
        else {
            guardarCamino(c);
            return false;             
        }
    }

    private void guardarCamino(CaminoDTO c) {
        CaminoPGDao caminoPG = new CaminoPGDao();
        SucursalPGDao sucursalPG = new SucursalPGDao();
        Camino camino = new Camino();
        Sucursal origen = sucursalPG.obtenerPorNombre(c.getOrigen());
        Sucursal destino = sucursalPG.obtenerPorNombre(c.getDestino());
        
       //del string de origen y destino tengo q obtener las instancias de sucursal y setearlas
       //cómo parseo el estado? y el tiempo?
       camino.setCodigo(Integer.parseInt(c.getCodigo()));
       camino.setDestino(origen);
       camino.setOrigen(destino);
       camino.setEstado(c.getEstado());
       camino.setCapacidadMaxima(Integer.parseInt(c.getCapacidadMaxima()));
       
       camino.setTiempoTransito(LocalTime.parse(c.getTiempoTransito()));
       
       caminoPG.guardarCamino(camino);
    }
    
    
    
}
