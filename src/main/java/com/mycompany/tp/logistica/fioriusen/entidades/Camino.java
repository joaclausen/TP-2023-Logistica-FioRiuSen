/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.entidades;

import com.mycompany.tp.logistica.fioriusen.enums.Estado;
import java.time.LocalTime;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Vulturius
 */
@Entity
@Table(name="camino")
public class Camino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="codigo")
    private Integer codigo;
    
    @OneToOne(fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    @JoinColumn(name="id_sucursal_destino", referencedColumnName = "id")
    private Sucursal destino;
     
    @OneToOne(fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    @JoinColumn(name="id_sucursal_origen", referencedColumnName = "id")
    private Sucursal origen;
     
    @Basic
    @Column(name="tiempo_transito")
    private LocalTime tiempoTransito;
    
    @Column(name="capacidad_maxima")
    private Integer capacidadMaxima;
    
    @Enumerated(EnumType.STRING)
    @Column(name="estado")
    private Estado estado;
    
    //setters
public Camino(){
    
}
    public Camino(Integer codigo, Sucursal origen, Sucursal destino, LocalTime tiempoTransito, Integer capacidadMaxima, Estado estado) {
        this.codigo = codigo;
        this.destino = destino;
        this.origen = origen;
        this.tiempoTransito = tiempoTransito;
        this.capacidadMaxima = capacidadMaxima;
        this.estado = estado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    

    

    public void setDestino(Sucursal destino) {
        this.destino = destino;
    }

    public void setOrigen(Sucursal origen) {
        this.origen = origen;
    }

    public void setTiempoTransito(LocalTime tiempoTransito) {
        this.tiempoTransito = tiempoTransito;
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    //getters

    public Integer getId() {
        return id;
    }

    public Sucursal getDestino() {
        return destino;
    }

    public Sucursal getOrigen() {
        return origen;
    }

    public LocalTime getTiempoTransito() {
        return tiempoTransito;
    }

    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public Estado getEstado() {
        return estado;
    }
    
}
