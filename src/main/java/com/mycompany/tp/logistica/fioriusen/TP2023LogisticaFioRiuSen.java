/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Vulturius
 */
public class TP2023LogisticaFioRiuSen {

    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setSize(500, 400);
        ventana.setContentPane(new Menu(ventana,null));
        ventana.setVisible(true);
        
    }
}
