/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.dtos;

import com.mycompany.tp.logistica.fioriusen.enums.Estado;

/**
 *
 * @author Vulturius
 */
public class SucursalDTO {
    private Integer id;
    private String codigo;
    private String nombre;
    
    private String horaApertura;
    private String horaCierre;
private Estado estado;
    public SucursalDTO() {
    }

    public SucursalDTO(String codigo, String nombre, String horaApertura, String horaCierre, Estado estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.estado=estado;
    }
    
    
    
    
    //setters
    

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }
    
    
    
    //getters

    
    public Integer getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }
    
}
