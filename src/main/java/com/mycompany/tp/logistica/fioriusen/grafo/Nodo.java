/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.grafo;



import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zapam
 */
public class Nodo {
    private int x, y;
    private String nombre;
    public static final int d =30;
    private int radio; // Radio del nodo

    public Nodo(int x, int y, String n) {
        this.x = x;
        this.y = y;
        this.nombre = n;
    }
   
    public int getRadio() {
        return radio;
    }
    
    public void pintar(Graphics g){
        g.drawOval(this.x - d/2, this.y - d/2, d, d);
        g.drawString(nombre, x, y);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
     public boolean contiene(Point punto) {
        double distancia = Math.sqrt(Math.pow(punto.x - x, 2) + Math.pow(punto.y - y, 2));
        return distancia <= radio;
    }
    
}
