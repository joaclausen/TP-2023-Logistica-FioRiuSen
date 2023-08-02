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
        int[] mensajes = new int[9];

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
           if (!dto.getTiempoTransito().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]"))
        {
            mensajes[4] = 1;
        }
        if(dto.getOrigen().equals(dto.getDestino())){
            mensajes[5] = 1;
        }
        if(dto.getCodigo().isEmpty() && dto.getOrigen().isEmpty() && dto.getDestino().isEmpty()){
             mensajes[6] = 1;
        }
        if(dto.getOrigen().matches(".*[aA-zZ]+$.*")){
            mensajes[7]=1;
        }
        if(dto.getDestino().matches(".*[aA-zZ]+$.*")){
            mensajes[8]=1;
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
        List<Integer> listCod = new ArrayList<>();
        
       
        listCod = caminoPG.getCodigoAll();
        listCod.forEach(System.out::println);
        if(listCod.contains(Integer.parseInt(c.getCodigo()))){
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
       camino.setDestino(destino);
       camino.setOrigen(origen);
       camino.setEstado(c.getEstado());
       camino.setCapacidadMaxima(Integer.parseInt(c.getCapacidadMaxima()));
       
       camino.setTiempoTransito(LocalTime.parse(c.getTiempoTransito()));
       
       caminoPG.guardarCamino(camino);
    }
    
     public List<Camino> buscarCaminoSegunCriterio(CaminoDTO dto) {
       CaminoPGDao caminoPG = new CaminoPGDao();
        List<Camino> listaCaminos = new ArrayList();
        listaCaminos = caminoPG.buscarCaminos(dto);
        return listaCaminos;
     }
    
     public void actualizarCamino(CaminoDTO dto, String id){
         CaminoPGDao caminoPG = new CaminoPGDao();
         Integer identificado = Integer.parseInt(id);
         SucursalPGDao sucursalPG = new SucursalPGDao();
          Sucursal origen = sucursalPG.obtenerPorNombre(dto.getOrigen());
        Sucursal destino = sucursalPG.obtenerPorNombre(dto.getDestino());
        Camino camino = new Camino();
       //del string de origen y destino tengo q obtener las instancias de sucursal y setearlas
       //cómo parseo el estado? y el tiempo?
       camino.setCodigo(Integer.parseInt(dto.getCodigo()));
       camino.setDestino(destino);
       camino.setOrigen(origen);
       camino.setEstado(dto.getEstado());
       camino.setCapacidadMaxima(Integer.parseInt(dto.getCapacidadMaxima()));
       
       camino.setTiempoTransito(LocalTime.parse(dto.getTiempoTransito()));
         caminoPG.modificarCamino(camino, identificado);
             }
     
     public void eliminarCamino(String id){
         CaminoPGDao caminoPG = new CaminoPGDao();
         Integer ID = Integer.parseInt(id);
         caminoPG.borrarCamino(ID);
     }
}
