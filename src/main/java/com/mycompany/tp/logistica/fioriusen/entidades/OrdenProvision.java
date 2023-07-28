/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Vulturius
 */
@Entity
@Table(name="ordenProvision")
public class OrdenProvision implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Basic
    @Column(name="fechaEmision")
    LocalDate fechaEmision;
    @JoinColumn(name="id_sucursal_destino")
    Sucursal destino;
    @Basic
    @Column(name="espera")
    LocalTime espera;
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id_orden_provision")
    List<DetalleOrden> lista;
    //HashMap<Producto, Integer> pedido = new HashMap<>();
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
