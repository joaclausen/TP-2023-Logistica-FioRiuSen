/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.dtos;

/**
 *
 * @author Vulturius
 */
public class OrdenProvisionDTO {
    
    private Integer id;
    private String fechaEmision;
    private String destino;
    private String espera;
    private Integer codigoSucursal;

    
    //setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setEspera(String espera) {
        this.espera = espera;
    }

    public void setCodigoSucursal(Integer codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }
    
    
    
    //getters

    public Integer getId() {
        return id;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public String getDestino() {
        return destino;
    }

    public String getEspera() {
        return espera;
    }

    public Integer getCodigoSucursal() {
        return codigoSucursal;
    }
    
    
    
}
