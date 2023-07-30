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
        int[] mensajes = new int[5];

        if (dto.getCodigo().isEmpty() || dto.getOrigen().isEmpty() || dto.getDestino().isEmpty() || dto.getCapacidadMaxima().isEmpty() || dto.getTiempoTransito().isEmpty()) {
            mensajes[0] = 1;
        }

        if (dto.getCodigo().matches(".*[^0-9].*")) {
            mensajes[1] = 1;
        }
        if (dto.getOrigen().matches(".*[^aA-zZ]+$.*") || dto.getDestino().matches(".*[^aA-zZ]+$.*")) {
            mensajes[2] = 1;
        }
        if (dto.getCapacidadMaxima().matches(".*[^0-9.].*"))//ver esto al igual que en producto va a admitir mas de un .
        {
            mensajes[3] = 1;
        }
       
        if (!dto.getTiempoTransito().matches("[0-9][0-9]:[0-5][0-9]"))//USAMOS SOLO 99 HOURS?
        {
            mensajes[4] = 1;//NO FUNCA
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
        CaminoPGDao productoPG = new CaminoPGDao(); 
        List<Camino> listaCaminos = productoPG.obtenerTodosCamino();
        List<Integer> listCod = new ArrayList();
        for(Camino prod: listaCaminos){
            listCod.add(prod.getCodigo());
        }
        if(listCod.contains(c.getCodigo())){
            return true;
        }
        else {
            guardarProducto(c);
            return false;             
        }
    }

    private void guardarProducto(CaminoDTO c) {
        CaminoPGDao productoPG = new CaminoPGDao();
        SucursalPGDao sucursalPG = new SucursalPGDao();
        Camino camino = new Camino();
        Sucursal origen = sucursalPG.obtenerPorNombre(c.getOrigen());
        Sucursal destino = sucursalPG.obtenerPorNombre(c.getDestino());
        
       //del string de origen y destino tengo q obtener las instancias de sucursal y setearlas
       //cómo parseo el estado? y el tiempo?
       camino.setCodigo(Integer.parseInt(c.getCodigo()));
       camino.setDestino(origen);
       camino.setOrigen(destino);
       camino.setEstado(Estado.valueOf(c.getEstado()));
       /*
       camino.setTiempoTransito(c.getTiempoTransito());
       */
       productoPG.guardarCamino(camino);
    }
    
    
    
}
