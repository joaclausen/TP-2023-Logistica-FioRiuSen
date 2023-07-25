/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

/**
 *
 * @author Vulturius
 */
public class OrdenProvision {
    Integer id;
    LocalDate fechaEmision;
    Sucursal destino;
    LocalTime espera;
    HashMap<Producto, Integer> pedido = new HashMap<>();
    //DICCIONARIO PRODUCTO/CANTIDAD SOLICITADA (CU5)
    
    
    //setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setDestino(Sucursal destino) {
        this.destino = destino;
    }

    public void setEspera(LocalTime espera) {
        this.espera = espera;
    }
    
    
    //getters

    public Integer getId() {
        return id;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public Sucursal getDestino() {
        return destino;
    }

    public LocalTime getEspera() {
        return espera;
    }
    
}
