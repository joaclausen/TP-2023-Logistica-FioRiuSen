/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.entidades;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Vulturius
 */
public class ListaProductos extends ArrayList<Producto> {
     public ListaProductos(Collection<? extends Producto> collection) {
        super(collection);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object item : c) {
            if (item instanceof Producto) {
                int id = ((Producto) item).getId();
                boolean found = false;
                for (Producto producto : this) {
                    if (producto.getId() == id) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}

