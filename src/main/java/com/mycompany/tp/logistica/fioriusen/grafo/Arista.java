/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.grafo;

import java.awt.Graphics;
import java.awt.geom.Line2D;

public class Arista {
     
     int x, y, x2, y2;
     Nodo nodo1, nodo2;
     private String peso;

    public Arista(Nodo n1, Nodo n2, String p) {
        this.x = n1.getX();
        this.y = n1.getY();
        this.x2 = n2.getX();
        this.y2 = n2.getY();
        this.peso = p;

    }
    public Arista(int x, int y, int x2, int y2, String p) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.peso = p;
    }
    public Line2D.Float getShape() {
        return new Line2D.Float(this.x, this.y, this.x2, this.y2);
    }

    public String getPeso() {
        return peso;
    }

    void pintar(Graphics g) {
        g.drawLine(x, y, x2, y2);
        
        if(x > x2 && y > y2){
            g.drawString(peso, x - Math.abs((x - x2)/2), y - Math.abs((y - y2)/2));
        }
        if(x < x2 && y < y2){
            g.drawString(peso, x2 - Math.abs((x - x2)/2), y2 - Math.abs((y - y2)/2));
        }
        if(x > x2 && y < y2){
            g.drawString(peso, x - Math.abs((x - x2)/2), y2 - Math.abs((y - y2)/2));
        }
        if(x < x2 && y > y2){
            g.drawString(peso, x2 - Math.abs((x - x2)/2), y2 - Math.abs((y - y2)/2));
        }
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

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
   
    
}

