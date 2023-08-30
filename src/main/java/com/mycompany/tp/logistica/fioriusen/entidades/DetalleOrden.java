/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author zapam
 */
@Entity
@Table(name="detalleorden")
public class DetalleOrden {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
   @ManyToOne()
    @JoinColumn(name="id_orden_provision")
    private OrdenProvision ordenProvision;
    
     @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name="id_producto")
    private Producto producto;
    
    //@JoinColumn(name="cantidad")
    @Column(name="cantidad")
    private int cantidad;
    
    
    //setters

    public void setId(int id) {
        this.id = id;
    }

    public void setOrdenProvision(OrdenProvision ordenProvision) {
        this.ordenProvision = ordenProvision;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    //getters

    public int getId() {
        return id;
    }

    public OrdenProvision getOrdenProvision() {
        return ordenProvision;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

   

   

    
    
}
