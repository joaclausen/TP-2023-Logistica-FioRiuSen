/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Vulturius
 */
public class Menu extends javax.swing.JPanel {

    /**
     * Creates new form Menu
     */
    private JFrame ventana;
    private JPanel padre;
    
    public Menu(JFrame ventana, JPanel padre) {
       this.ventana = ventana;
        this.padre = padre;
        ventana.setTitle("Menu Principal");
        ventana.setSize(570, 700);
       
        initComponents();
         ventana.setVisible(true);
        this.ventana = ventana;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnGestionarSucursal = new javax.swing.JButton();
        btnGestionarCaminos = new javax.swing.JButton();
        btnGestionarProductos = new javax.swing.JButton();
        btnMapa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        btnGestionarSucursal.setText("Gestionar Sucursales");
        btnGestionarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarSucursalActionPerformed(evt);
            }
        });

        btnGestionarCaminos.setText("Gestionar Caminos");
        btnGestionarCaminos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarCaminosActionPerformed(evt);
            }
        });

        btnGestionarProductos.setText("Gestionar Productos");
        btnGestionarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarProductosActionPerformed(evt);
            }
        });

        btnMapa.setText("Mapa Sucursales");

        jButton1.setText("BOTON DE PRUEBA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(btnMapa)
                    .addComponent(btnGestionarProductos)
                    .addComponent(btnGestionarCaminos)
                    .addComponent(btnGestionarSucursal))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnGestionarSucursal)
                .addGap(18, 18, 18)
                .addComponent(btnGestionarCaminos)
                .addGap(18, 18, 18)
                .addComponent(btnGestionarProductos)
                .addGap(18, 18, 18)
                .addComponent(btnMapa)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarSucursalActionPerformed
        ventana.setContentPane(new GestionarSucursal(ventana, this));
        ventana.revalidate();
    }//GEN-LAST:event_btnGestionarSucursalActionPerformed

    private void btnGestionarCaminosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarCaminosActionPerformed
       ventana.setContentPane(new GestionarCamino(ventana, this));
    }//GEN-LAST:event_btnGestionarCaminosActionPerformed

    private void btnGestionarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarProductosActionPerformed
        ventana.setContentPane(new GestionarProducto(ventana, this));
        ventana.revalidate();
    }//GEN-LAST:event_btnGestionarProductosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGestionarCaminos;
    private javax.swing.JButton btnGestionarProductos;
    private javax.swing.JButton btnGestionarSucursal;
    private javax.swing.JButton btnMapa;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}