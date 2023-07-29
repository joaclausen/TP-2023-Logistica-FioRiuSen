/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.daos;

import com.mycompany.tp.logistica.fioriusen.entidades.Producto;
import java.util.List;

/**
 *
 * @author zapam
 */
public interface ProductoDao {
    
    public int guardarProducto(Producto p);
    public Producto obtenerProducto(int id);
    public List<Producto> obtenerTodosProducto();
    
}
