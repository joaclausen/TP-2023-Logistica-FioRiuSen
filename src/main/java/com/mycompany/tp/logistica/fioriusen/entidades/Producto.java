/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.entidades;

import java.io.Serializable;
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
public class Producto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    int id;
    @Column(name="codigo")
    int codigo;
    @Column(name="nombre")
    String nombre;
    @Column(name="descripcion")
    String descripcion;
    @Column(name="preciounitario")
    Double precioUnitario;
    @Column(name="peso")
    Double peso;
    
    //setters

    public Producto(int codigo, String nombre, String descripcion, Double precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
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
    
    
}
