/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.entidades;

import com.mycompany.tp.logistica.fioriusen.enums.Estado;
import java.io.Serializable;
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
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vulturius
 */
@Entity
@Table(name="sucursal")
public class Sucursal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="codigo")
    private Integer codigo;
    
    @Column(name="nombre")
    private String nombre;
    
    @Basic
   // @Temporal(TemporalType.TIME)
    @Column(name="horario_apertura")
    private LocalTime horarioApertura;
    
    @Basic
    //@Temporal(TemporalType.TIME)
    @Column(name="horario_cierre")
    private LocalTime horarioCierre;
    
    @Enumerated(EnumType.STRING)
    @Column(name="estado")
    private Estado estado;
    
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    //@JoinColumn(name="id_sucursal")
    private List<Stock> listaProductos;
   
   @OneToMany(
           
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
   // @JoinColumn(name = "id_sucursal")
   private  List<OrdenProvision> ordenProvision;
    
    public Sucursal() {
    }

    public Sucursal(Integer codigo, String nombre, LocalTime horarioApertura, LocalTime horarioCierre, Estado estado) {
        this.codigo=codigo;
        this.nombre = nombre;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.estado = estado;
      
    }
    
    
    //setters
   
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

   public void setOrdenProvision(List<OrdenProvision> ordenProvision) {
        this.ordenProvision = ordenProvision;
    }

    public void setListaProductos(List<Stock> listaProductos) {
        this.listaProductos = listaProductos;
    }
   
    
   //getters
    
    public Integer getId() {
        return id;
    }

    public Integer getCodigo() {
        return codigo;
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

   public List<OrdenProvision> getOrdenProvision() {
        return ordenProvision;
    }

    public List<Stock> getListaProductos() {
        return listaProductos;
    }
    
    
    
}
