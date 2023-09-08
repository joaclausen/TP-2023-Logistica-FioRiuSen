/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.entidades;

import com.mycompany.tp.logistica.fioriusen.enums.Orden;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vulturius
 */
@Entity
@Table(name="ordenprovision")
public class OrdenProvision implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Basic
    @Column(name="fecha_emision")
    private LocalDate fechaEmision;
    
    @Basic
     @Column(name="espera")
    private  LocalTime espera;
    
   /* @ManyToOne()
    @JoinColumn(name="id_sucursal")
    private Sucursal sucursal;*/

     
     @OneToMany(
   
            fetch = FetchType.EAGER, //DISYUNTIVA, SI PONGO EAGER NO ANDA EL MAPA,
             //PERO SI PONGO LAZY SI ANDA EL MAPA, PERO PUEDO CARGAR LAS ORDENES DE PROVISION
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name="id_orden_provision")
    private List<DetalleOrden> detalleOrden;
   
    @Enumerated(EnumType.STRING)
    @Column(name="estado")
    private Orden estado;
     

    public OrdenProvision() {
    }
    
    
    //setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }


    public void setEspera(LocalTime espera) {
        this.espera = espera;
    }

 /*   public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }*/

    
    
    public void setDetalleOrden(List<DetalleOrden> detalleOrden) {
       //this.detalleOrden.addAll(detalleOrden);
       this.detalleOrden = detalleOrden;
    }

    public void setEstado(Orden estado) {
        this.estado = estado;
    }
    
    
    
    //getters

    public Integer getId() {
        return id;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }


    public LocalTime getEspera() {
        return espera;
    }

  /*  public Sucursal getSucursal() {
        return sucursal;
    }*/

    
    
   public List<DetalleOrden> getDetalleOrden() {
        return detalleOrden;
    }

    public Orden getEstado() {
        return estado;
    }
    
   
    
}
