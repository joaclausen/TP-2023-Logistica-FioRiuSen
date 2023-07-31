/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.dtos;

import com.mycompany.tp.logistica.fioriusen.enums.Estado;



/**
 *
 * @author zapam
 */
public class CaminoDTO {
    private String codigo;
    private String destino;
    private String origen;
    private String tiempoTransito;
    private String capacidadMaxima;
    private Estado estado;

    public CaminoDTO(){
    }
    
    
    public CaminoDTO(String codigo, String destino, String origen, String tiempoTransito, String capacidadMaxima, Estado estado) {
        this.codigo = codigo;
        this.destino = destino;
        this.origen = origen;
        this.tiempoTransito = tiempoTransito;
        this.capacidadMaxima = capacidadMaxima;
        this.estado = estado;
    }

    
    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getTiempoTransito() {
        return tiempoTransito;
    }

    public void setTiempoTransito(String tiempoTransito) {
        this.tiempoTransito = tiempoTransito;
    }

    public String getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(String capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
    
    
}
