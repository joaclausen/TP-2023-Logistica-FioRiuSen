/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen.dtos;

/**
 *
 * @author Vulturius
 */
public class ProductoDTO {
      private Integer id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String precioUnitario;
    private String peso;

    public ProductoDTO(String n, String c, String p, String pp, String d) {
        this.nombre = n;
        this.codigo = c;
        this.peso = p;
        this.precioUnitario = pp;
        this.descripcion = d;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

}
