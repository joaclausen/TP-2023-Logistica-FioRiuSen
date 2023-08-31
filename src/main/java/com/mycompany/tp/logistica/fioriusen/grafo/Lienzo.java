/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp.logistica.fioriusen.grafo;

import com.mycompany.tp.logistica.fioriusen.dtos.CaminoDTO;
import com.mycompany.tp.logistica.fioriusen.dtos.SucursalDTO;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import javax.swing.JPanel;
import static org.apache.commons.math3.stat.inference.TestUtils.g;

/**
 *
 * @author zapam
 */
public class Lienzo extends JPanel implements MouseListener,MouseMotionListener{
    private Vector<Nodo> vectorNodos;
    private Vector<Arista> vectorAristas;
    private Vector<Nodo> nodosImportantes;
    //private Point p1,p2;
    private Nodo nodoMover;
    private int iNodo;

    public Lienzo(){
        this.vectorNodos = new Vector<>();
        this.nodosImportantes = new Vector<>();
        this.vectorAristas = new Vector<>();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void generarGrafo(List<CaminoDTO> caminos, List<SucursalDTO> sucursales){

       /* for(CaminoDTO c: caminos){
            Random random = new Random();
            Nodo o = new Nodo(random.nextInt(50), random.nextInt(50), c.getOrigen());
            Nodo d = new Nodo(random.nextInt(50), random.nextInt(50), c.getDestino());
            this.vectorNodos.add(o);
            this.vectorNodos.add(d);

            this.vectorAristas.add(new Arista(o,d, c.getCapacidadMaxima()));
            repaint();
        }*/
       //Nodo puerto = new Nodo(5, 5, sucursales.stream().filter(s->s.getNombre()="Puerto").collect(toSingleton()));
       SucursalDTO puerto = new SucursalDTO();
       SucursalDTO centro = new SucursalDTO();
       for(SucursalDTO s: sucursales){
           if(s.getNombre().equals("Puerto")) puerto=s;
           if(s.getNombre().equals("Centro")) centro=s;
       }
       Nodo p = new Nodo(25, 25, puerto.getNombre());
       Nodo c = new Nodo(200, 200, centro.getNombre());
       for(SucursalDTO s: sucursales){
           if (!s.getNombre().equals("Puerto") && !s.getNombre().equals("Centro")){
            Random random = new Random();
            Nodo o = new Nodo(random.nextInt(200 - 25 + 1)+25, random.nextInt(200 - 25 + 1)+25, s.getNombre());
            this.vectorNodos.add(o);
             repaint();
           }
       }
       nodosImportantes.add(p);
       nodosImportantes.add(c);
       
       List<Nodo> nodosAPrintear = new ArrayList<>();
       nodosAPrintear.add(p);
       nodosAPrintear.add(c);
       for(Nodo v: vectorNodos){
           nodosAPrintear.add(v);
       }
       
       Nodo origen=new Nodo(0, 0, ""); 
       Nodo destino=new Nodo(0, 0, "");
       int contador=0;
       
       for (CaminoDTO cam: caminos){
           for (Nodo n: nodosAPrintear){
               if(cam.getOrigen().equals(n.getNombre())){
                   origen=n;
                   contador++;
               } 
               if (cam.getDestino().equals(n.getNombre())){
                   destino=n;
                   contador++;
               }
               if (contador==2){
                   contador=0;
                   this.vectorAristas.add(new Arista(origen,destino, cam.getCapacidadMaxima()));
                   repaint();
                   break;
               }
           }
       }
       
      
    }
    
       
    public void paint(Graphics g){
        super.paint(g);
        for(Nodo nodos: nodosImportantes){
            nodos.pintar(g);
        }
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
