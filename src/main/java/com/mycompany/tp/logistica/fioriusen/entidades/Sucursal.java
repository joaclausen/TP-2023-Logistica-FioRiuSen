/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.entidades;

import com.mycompany.tp.logistica.fioriusen.enums.Estado;
import java.time.LocalTime;
import java.util.HashMap;

/**
 *
 * @author Vulturius
 */
public class Sucursal {
    Integer id;
    String nombre;
    LocalTime horarioApertura;
    LocalTime horarioCierre;
    Estado estado;
    HashMap<Producto, Integer> stock = new HashMap<>(); //sin getters ni setter
    
    
    
    //setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHorarioApertura(LocalTime horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public void setHorarioCierre(LocalTime horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    
   //getters
    
    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalTime getHorarioApertura() {
        return horarioApertura;
    }

    public LocalTime getHorarioCierre() {
        return horarioCierre;
    }

    public Estado getEstado() {
        return estado;
    }
    
    
}
