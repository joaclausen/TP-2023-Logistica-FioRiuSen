/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen;

import com.mycompany.tp.logistica.fioriusen.dtos.SucursalDTO;
import com.mycompany.tp.logistica.fioriusen.gestores.GestorSucursal;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Vulturius
 */
public class ModificarSucursal extends javax.swing.JPanel {

    /**
     * Creates new form ModificarSucursal
     */
    private JFrame ventana;
    private JPanel padre;
    public ModificarSucursal(JFrame ventana, JPanel padre) {
       this.ventana = ventana;
        this.padre = padre;
        ventana.setTitle("Gestionar sucursales - Modificar sucursal");
        ventana.setSize(800, 600);
       
        initComponents();
         ventana.setVisible(true);
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
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        labelCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtApertura = new javax.swing.JTextField();
        labelHorarioApertura = new javax.swing.JLabel();
        labelEstado = new javax.swing.JLabel();
        comboBoxEstado = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        txtCierre = new javax.swing.JTextField();
        labelHorarioCierre = new javax.swing.JLabel();

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Edición de datos de la sucursal"));

        labelCodigo.setText("Código:");

        txtCodigo.setEditable(false);

        txtApertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAperturaActionPerformed(evt);
            }
        });

        labelHorarioApertura.setText("Horario apertura:");

        labelEstado.setText("Estado:");

        comboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OPERATIVA", "NO OPERATIVA", " " }));

        labelNombre.setText("Nombre:");

        labelHorarioCierre.setText("Horario cierre:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelEstado)
                    .addComponent(labelHorarioApertura)
                    .addComponent(labelCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(labelNombre))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboBoxEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)
                            .addComponent(txtApertura, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelHorarioCierre)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtCierre))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHorarioApertura)
                    .addComponent(txtCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHorarioCierre))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEstado)
                    .addComponent(comboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addGap(27, 27, 27)
                        .addComponent(btnCancelar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap(62, Short.MAX_VALUE))
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

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        GestorSucursal gs =  new GestorSucursal();
        Boolean control = true;

        SucursalDTO dto = new SucursalDTO(txtCodigo.getText(), txtNombre.getText(), txtApertura.getText(), txtCierre.getText(), comboBoxEstado.getSelectedItem().toString());

        int[] mensaje = gs.validarDatos(dto);
        if(mensaje[0]==1){
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            control=false;
            Toolkit.getDefaultToolkit().beep();

        }
        if(mensaje[1] == 1){
            JOptionPane.showMessageDialog(this, "El campo codigo solo puede contener números", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            control=false;
            Toolkit.getDefaultToolkit().beep();
        }
        if(mensaje[2] == 1){
            JOptionPane.showMessageDialog(this, "El campo nombre debe ser alfabético", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            control=false;
            Toolkit.getDefaultToolkit().beep();
        }
        if(mensaje[3] == 1){
            JOptionPane.showMessageDialog(this, "Los campos hora de apertura de apertura y hora de cierre deben de seguir el siguiente formato HH:MM", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            control=false;
            Toolkit.getDefaultToolkit().beep();
        }

        if(control == true){
            int result = JOptionPane.showConfirmDialog(this,"¿Desea crear esta nueva sucursal?", "CONFIRMACION", JOptionPane.YES_NO_OPTION);
            switch (result){
                case JOptionPane.YES_OPTION:
                //MAGIA

                JOptionPane.showMessageDialog(this, "La sucursal se creo exitosamente.", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                break;
                case JOptionPane.NO_OPTION:
                break;
            }
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       int result = JOptionPane.showConfirmDialog(this, "¿Desea regresar a la ventana de Gestionar Sucursal?", "CONFIRMACION", JOptionPane.YES_NO_OPTION);
        switch (result) {
            case JOptionPane.YES_OPTION:
                ventana.setContentPane(new GestionarSucursal(ventana, this));
                ventana.revalidate();
                break;
            case JOptionPane.NO_OPTION:
                break;
        }

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtAperturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAperturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAperturaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> comboBoxEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelHorarioApertura;
    private javax.swing.JLabel labelHorarioCierre;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JTextField txtApertura;
    private javax.swing.JTextField txtCierre;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}