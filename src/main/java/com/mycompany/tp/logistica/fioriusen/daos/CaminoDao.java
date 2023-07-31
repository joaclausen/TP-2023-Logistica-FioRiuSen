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
    public void guardarCamino(Camino c);
    public Camino obtenerCamino(int id);

   
    //public List<Integer> obtenerTodosCamino();
}
