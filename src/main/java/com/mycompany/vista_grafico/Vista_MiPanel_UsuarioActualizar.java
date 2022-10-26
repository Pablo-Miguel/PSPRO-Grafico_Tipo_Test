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
public class Vista_MiPanel_UsuarioActualizar extends javax.swing.JPanel {
    
    private Vista_MiVentana miVentana;
    
    private DefaultListModel modelo;
    
    private ArrayList<Usuario> listaUsuarios;
    
    /**
     * Creates new form Vista_MiPanel_UsuarioActualizar
     */
    public Vista_MiPanel_UsuarioActualizar(Vista_MiVentana miVentana) {
        initComponents();
        
        this.miVentana = miVentana;
        
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

        txtFieldUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaJUsuarios = new javax.swing.JList<>();
        txtFieldUsuarioNuevo = new javax.swing.JTextField();
        lblUsuarioNuevo = new javax.swing.JLabel();

        txtFieldUsuario.setEditable(false);

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario.setText("Nombre del usuario");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        listaJUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaJUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaJUsuarios);

        lblUsuarioNuevo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuarioNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuarioNuevo.setText("Nuevo nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFieldUsuarioNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsuarioNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUsuarioNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFieldUsuarioNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(btnVolver)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        this.miVentana.cambiarPanel(new Vista_MiPanel_Inicio(miVentana));
    }//GEN-LAST:event_btnVolverActionPerformed

    private void listaJUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaJUsuariosMouseClicked
        // TODO add your handling code here:
        
        txtFieldUsuario.setText(listaUsuarios.get(listaJUsuarios.getSelectedIndex()).getNombre());
        
    }//GEN-LAST:event_listaJUsuariosMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        
        if (!txtFieldUsuario.getText().equals("") && !txtFieldUsuarioNuevo.getText().equals("")) {
            int comp = DAOPregunta.getInstance().actualizarUsuario(new Usuario(listaUsuarios.get(listaJUsuarios.getSelectedIndex()).getIdUsuario(), txtFieldUsuarioNuevo.getText()));
            
            if (comp == 0) {
                JOptionPane.showMessageDialog(this, "El usuario se ha actualizado correctamente");
                miVentana.setUsuarioActual(new Usuario(listaUsuarios.get(listaJUsuarios.getSelectedIndex()).getIdUsuario(), txtFieldUsuarioNuevo.getText()));
            } else if (comp == 1) {
                JOptionPane.showMessageDialog(this, "El usuario ya está en la base de datos");
            } else if (comp == -1) {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado al actualizar el usuario");
            }
            
            txtFieldUsuario.setText("");
            txtFieldUsuarioNuevo.setText("");
            this.actualizarLista();
        
        } else {
            JOptionPane.showConfirmDialog(this, "Seleccione un nombre para actualizar un usuario", "Campo vacío", JOptionPane.DEFAULT_OPTION);
        }
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void actualizarLista() {
        listaUsuarios = DAOPregunta.getInstance().getUsuarios();
        
        this.modelo = new DefaultListModel();
        
        for (int i = 0; i < listaUsuarios.size(); i++) {
            this.modelo.addElement(listaUsuarios.get(i).getNombre());
        }
        
        this.listaJUsuarios.setModel(this.modelo);
        
        this.updateUI();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuarioNuevo;
    private javax.swing.JList<String> listaJUsuarios;
    private javax.swing.JTextField txtFieldUsuario;
    private javax.swing.JTextField txtFieldUsuarioNuevo;
    // End of variables declaration//GEN-END:variables
}
