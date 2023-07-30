/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.entidades;

import com.mycompany.tp.logistica.fioriusen.enums.Estado;
import java.time.LocalTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    Integer id;
    @Column(name="codigo")
    Integer codigo;
    @JoinColumn(name="id_sucursal_destino")
    Sucursal destino;
    @JoinColumn(name="id_sucursal_origen")
    Sucursal origen;
    @Basic
    @Column(name="tiempoTransito")
    LocalTime tiempoTransito;
    @Column(name="capacidadMaxima")
    Integer capacidadMaxima;
    @Enumerated(EnumType.STRING)
    @Column(name="estado")
    Estado estado;
    
    //setters

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
