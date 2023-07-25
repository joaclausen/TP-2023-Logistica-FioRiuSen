/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.gestores;

import com.mycompany.tp.logistica.fioriusen.dtos.CaminoDTO;

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
}
