/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.dtos;



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
    private String estado;

    public CaminoDTO(String codigo, String destino, String origen, String tiempoTransito, String capacidadMaxima, String estado) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}
