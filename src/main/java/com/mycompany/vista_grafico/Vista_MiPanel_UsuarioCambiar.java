/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.vista_grafico;

import com.mycompany.dao_grafico.DAOPregunta;
import com.mycompany.modelo_grafico.Usuario;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Nitro
 */
public class Vista_MiPanel_UsuarioCambiar extends javax.swing.JPanel {
    
    private Vista_MiVentana miVentana;
    
    private DefaultListModel modelo;
    
    private ArrayList<Usuario> listaUsuarios;
    
    /**
     * Creates new form Vista_MiPanel_Usuario
     */
    public Vista_MiPanel_UsuarioCambiar(Vista_MiVentana miVentana) {
        initComponents();
        
        this.miVentana = miVentana;
        
        if(miVentana.getUsuarioActual() != null){
            txtFieldUsuario.setText(miVentana.getUsuarioActual().getNombre());
        }
        
        this.actualizarLista();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaJUsuarios = new javax.swing.JList<>();
        txtFieldUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        btnCambiar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        listaJUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaJUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaJUsuarios);

        txtFieldUsuario.setEditable(false);

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario.setText("Usuario actual");

        btnCambiar.setText("Cambiar");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnVolver)
                            .addComponent(txtFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVolver))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        
        this.miVentana.cambiarPanel(new Vista_MiPanel_Inicio(miVentana));
        
    }//GEN-LAST:event_btnVolverActionPerformed

    private void listaJUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaJUsuariosMouseClicked
        
        txtFieldUsuario.setText(listaUsuarios.get(listaJUsuarios.getSelectedIndex()).getNombre());
        
    }//GEN-LAST:event_listaJUsuariosMouseClicked

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        // TODO add your handling code here:
        
        if(listaJUsuarios.getSelectedIndex() != -1){
            miVentana.setUsuarioActual(listaUsuarios.get(listaJUsuarios.getSelectedIndex()));
            JOptionPane.showConfirmDialog(this, "Se ha entrado en la sesión de " + miVentana.getUsuarioActual().getNombre(), "Sesión", JOptionPane.DEFAULT_OPTION);
        }
        else {
            JOptionPane.showConfirmDialog(this, "Por favor, seleccione un usuario y pulse 'Cambiar'", "No hay usuario", JOptionPane.DEFAULT_OPTION);
        }
        
    }//GEN-LAST:event_btnCambiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JList<String> listaJUsuarios;
    private javax.swing.JTextField txtFieldUsuario;
    // End of variables declaration//GEN-END:variables

    private void actualizarLista() {
        listaUsuarios = DAOPregunta.getInstance().getUsuarios();
        
        this.modelo = new DefaultListModel();
        
        for (int i = 0; i < listaUsuarios.size(); i++) {
            this.modelo.addElement(listaUsuarios.get(i).getNombre());
        }
        
        this.listaJUsuarios.setModel(this.modelo);
        
        this.updateUI();
    }

}