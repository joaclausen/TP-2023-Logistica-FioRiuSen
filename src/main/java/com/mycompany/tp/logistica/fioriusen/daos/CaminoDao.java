/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.daos;

import com.mycompany.tp.logistica.fioriusen.entidades.Camino;
import java.util.List;

/**
 *
 * @author zapam
 */
public interface CaminoDao {
    public int guardarCamino(Camino c);
    public Camino obtenerProducto(int id);
    public List<Camino> obtenerTodosCamino();
}
