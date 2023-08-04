/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.grafo;

import com.mycompany.tp.logistica.fioriusen.dtos.CaminoDTO;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author zapam
 */
public class Lienzo extends JPanel implements MouseListener,MouseMotionListener{
    private Vector<Nodo> vectorNodos;
    private Vector<Arista> vectorAristas;
    //private Point p1,p2;
    private Nodo nodoMover;
    private int iNodo;
    
    public Lienzo(){
        this.vectorNodos = new Vector<>();
        this.vectorAristas = new Vector<>();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
    public void generarGrafo(List<CaminoDTO> caminos){
        
        for(CaminoDTO c: caminos){
            Random random = new Random();
            Nodo o = new Nodo(random.nextInt(50), random.nextInt(50), c.getOrigen());
            Nodo d = new Nodo(random.nextInt(50), random.nextInt(50), c.getDestino());
            this.vectorNodos.add(o);
            this.vectorNodos.add(d);
            
            this.vectorAristas.add(new Arista(o,d, c.getCapacidadMaxima()));
            repaint();
        }
        
        
    }
    
    public void paint(Graphics g){
        super.paint(g);
        for(Nodo nodos: vectorNodos){
            nodos.pintar(g);
        }
        for(Arista aristas: vectorAristas){
            aristas.pintar(g);
        }
            
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
       int iN=0;
       for(Nodo n: vectorNodos){
           if(new Rectangle(n.getX() - Nodo.d/2, n.getY() - Nodo.d/2, Nodo.d, Nodo.d).contains(e.getPoint())){
               nodoMover = n;
               iNodo = iN;
               break;
           }
           iN++;
       }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        nodoMover = null;
        iNodo = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(nodoMover != null){
            this.vectorNodos.set(iNodo, new Nodo(e.getX(), e.getY(), nodoMover.getNombre()));
            int iE = 0;
            for(Arista a: vectorAristas){
                if(new Rectangle(a.getX() - Nodo.d/2, a.getY() - Nodo.d/2, Nodo.d, Nodo.d).contains(e.getPoint())){
                    this.vectorAristas.set(iE, new Arista(e.getX(), e.getY(), a.getX2(), a.getY2(), a.getPeso()));
                }
                else if(new Rectangle(a.getX2() - Nodo.d/2, a.getY2() - Nodo.d/2, Nodo.d, Nodo.d).contains(e.getPoint())){
                    this.vectorAristas.set(iE, new Arista(a.getX(), a.getY(),e.getX(), e.getY(), a.getPeso()));
                }
                iE++;
            }
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       
    }
    
}
