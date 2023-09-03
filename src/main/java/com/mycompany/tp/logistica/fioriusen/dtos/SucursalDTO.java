/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.dtos;

import com.mycompany.tp.logistica.fioriusen.enums.Estado;
import java.util.ArrayList;
import java.util.List;

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
    private List<CaminoDTO> caminosAdy;
    private int pagerank;
    
    public SucursalDTO() {
        this.caminosAdy = new ArrayList<CaminoDTO>();
    }

    public SucursalDTO(String codigo, String nombre, String horaApertura, String horaCierre, Estado estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.estado=estado;
        this.pagerank=0;
    }
    public void setPagerank(int pg){
        this.pagerank=pg;
    }

    public int getPagerank() {
        return pagerank;
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
    
    public List<CaminoDTO> getCaminosAdy() {
        return caminosAdy;
    }
    

    public int getCaminosSinMarcar(List<CaminoDTO> pendientes) {
        int cantidad=0;
        for (CaminoDTO p: pendientes){
            if (p.getOrigen().equals(this.nombre)) cantidad++;
        }
        return cantidad;
    }
    
    //posiblemente explote:
    public void asociarCaminos(List<CaminoDTO> caminos){
        for (CaminoDTO c: caminos){
            if (c.getOrigen().equals(this.nombre)) this.caminosAdy.add(c);
        }
    }
    
}
