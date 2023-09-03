/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Vulturius
 */
@Entity
@Table (name = "producto")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="codigo")
    private Integer codigo;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="descripcion")
    private String descripcion;
    
    @Column(name="precio_unitario")
    private Double precioUnitario;
    
    @Column(name="peso")
    private Double peso;
    
    public Producto(int codigo, String nombre, String descripcion, Double peso, Double precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.peso = peso;
        this.precioUnitario = precioUnitario;
         
    }

    public Producto() {
    }
 
    public int getCodigo() {
        return codigo;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
    
    //getters

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public Double getPeso() {
        return peso;
    }
    
    
    
    ///AUXILIARES
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
    

