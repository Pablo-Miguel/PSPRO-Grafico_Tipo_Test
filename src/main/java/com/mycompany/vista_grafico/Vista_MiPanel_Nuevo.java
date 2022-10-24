/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.vista_grafico;

import com.mycompany.dao_grafico.DAOPregunta;
import com.mycompany.modelo_grafico.Opcion;
import com.mycompany.modelo_grafico.Pregunta;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Dam
 */
public class Vista_MiPanel_Nuevo extends javax.swing.JPanel {

    private Vista_MiVentana miVentana;
    private Vista_MiPanel_Inicio miPanelInicio;
    private Boolean continuar;
    private ArrayList<Pregunta> listaPreguntas;

    private DefaultListModel modelo;

    /**
     * Creates new form Vista_MiPanel_Nuevo
     */
    public Vista_MiPanel_Nuevo(Vista_MiVentana miVentana) {
        initComponents();

        continuar = false;

        this.miVentana = miVentana;
        this.miPanelInicio = new Vista_MiPanel_Inicio(this.miVentana);

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

        grupoRadio = new javax.swing.ButtonGroup();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaJPreguntas = new javax.swing.JList<>();
        txtFieldPregunta = new javax.swing.JTextField();
        radioOpcion1 = new javax.swing.JRadioButton();
        radioOpcion2 = new javax.swing.JRadioButton();
        radioOpcion3 = new javax.swing.JRadioButton();
        radioOpcion4 = new javax.swing.JRadioButton();
        txtFieldOpcion1 = new javax.swing.JTextField();
        txtFieldOpcion2 = new javax.swing.JTextField();
        txtFieldOpcion3 = new javax.swing.JTextField();
        txtFieldOpcion4 = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listaJPreguntas);

        txtFieldPregunta.setText("Escriba una pregunta...");
        txtFieldPregunta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFieldPreguntaMouseClicked(evt);
            }
        });

        grupoRadio.add(radioOpcion1);

        grupoRadio.add(radioOpcion2);

        grupoRadio.add(radioOpcion3);

        grupoRadio.add(radioOpcion4);

        txtFieldOpcion1.setText("Escriba respuesta...");
        txtFieldOpcion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFieldOpcion1MouseClicked(evt);
            }
        });

        txtFieldOpcion2.setText("Escriba respuesta...");
        txtFieldOpcion2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFieldOpcion2MouseClicked(evt);
            }
        });

        txtFieldOpcion3.setText("Escriba respuesta...");
        txtFieldOpcion3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFieldOpcion3MouseClicked(evt);
            }
        });

        txtFieldOpcion4.setText("Escriba respuesta...");
        txtFieldOpcion4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFieldOpcion4MouseClicked(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFieldPregunta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioOpcion2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(radioOpcion1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(radioOpcion3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(radioOpcion4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFieldOpcion4)
                                    .addComponent(txtFieldOpcion3)
                                    .addComponent(txtFieldOpcion2)
                                    .addComponent(txtFieldOpcion1, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFieldPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFieldOpcion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioOpcion1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFieldOpcion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioOpcion2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioOpcion3)
                            .addComponent(txtFieldOpcion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioOpcion4)
                            .addComponent(txtFieldOpcion4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 149, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnGuardar))
                .addGap(81, 81, 81))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:

        txtFieldPregunta.setText("Escriba una pregunta...");
        txtFieldOpcion1.setText("Escriba respuesta...");
        txtFieldOpcion2.setText("Escriba respuesta...");
        txtFieldOpcion3.setText("Escriba respuesta...");
        txtFieldOpcion4.setText("Escriba respuesta...");

        this.miVentana.cambiarPanel(this.miPanelInicio);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtFieldPreguntaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldPreguntaMouseClicked
        // TODO add your handling code here:
        txtFieldPregunta.setText("");
    }//GEN-LAST:event_txtFieldPreguntaMouseClicked

    private void txtFieldOpcion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldOpcion1MouseClicked
        // TODO add your handling code here:
        txtFieldOpcion1.setText("");
    }//GEN-LAST:event_txtFieldOpcion1MouseClicked

    private void txtFieldOpcion2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldOpcion2MouseClicked
        // TODO add your handling code here:
        txtFieldOpcion2.setText("");
    }//GEN-LAST:event_txtFieldOpcion2MouseClicked

    private void txtFieldOpcion3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldOpcion3MouseClicked
        // TODO add your handling code here:
        txtFieldOpcion3.setText("");
    }//GEN-LAST:event_txtFieldOpcion3MouseClicked

    private void txtFieldOpcion4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldOpcion4MouseClicked
        // TODO add your handling code here:
        txtFieldOpcion4.setText("");
    }//GEN-LAST:event_txtFieldOpcion4MouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (!(txtFieldPregunta.getText().equals("Escriba una pregunta...") || txtFieldPregunta.getText().equals("")
                || txtFieldOpcion1.getText().equals("Escriba respuesta...") || txtFieldOpcion1.getText().equals("")
                || txtFieldOpcion2.getText().equals("Escriba respuesta...") || txtFieldOpcion2.getText().equals("")
                || txtFieldOpcion3.getText().equals("Escriba respuesta...") || txtFieldOpcion3.getText().equals("")
                || txtFieldOpcion4.getText().equals("Escriba respuesta...") || txtFieldOpcion4.getText().equals(""))) {

            if (radioOpcion1.isSelected()) {
                int comp = DAOPregunta.getInstance().setDatos(new Pregunta(txtFieldPregunta.getText(), new Opcion(txtFieldOpcion1.getText(), true), new Opcion(txtFieldOpcion2.getText(), false), new Opcion(txtFieldOpcion3.getText(), false), new Opcion(txtFieldOpcion4.getText(), false)));
                
                if (comp == 0) {
                    continuar = true;
                } else if (comp == 1) {
                    JOptionPane.showMessageDialog(this, "La pregunta ya está en la base de datos");
                } else if (comp == -1){
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error al insertar la pregunta");
                }
                
            } else if (radioOpcion2.isSelected()) {

                int comp = DAOPregunta.getInstance().setDatos(new Pregunta(txtFieldPregunta.getText(), new Opcion(txtFieldOpcion1.getText(), false), new Opcion(txtFieldOpcion2.getText(), true), new Opcion(txtFieldOpcion3.getText(), false), new Opcion(txtFieldOpcion4.getText(), false)));
                
                if (comp == 0) {
                    continuar = true;
                } else if (comp == 1) {
                    JOptionPane.showMessageDialog(this, "La pregunta ya está en la base de datos");
                } else if (comp == -1){
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error al insertar la pregunta");
                }
                
            } else if (radioOpcion3.isSelected()) {

                int comp = DAOPregunta.getInstance().setDatos(new Pregunta(txtFieldPregunta.getText(), new Opcion(txtFieldOpcion1.getText(), false), new Opcion(txtFieldOpcion2.getText(), false), new Opcion(txtFieldOpcion3.getText(), true), new Opcion(txtFieldOpcion4.getText(), false)));
                
                if (comp == 0) {
                    continuar = true;
                } else if (comp == 1) {
                    JOptionPane.showMessageDialog(this, "La pregunta ya está en la base de datos");
                } else if (comp == -1){
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error al insertar la pregunta");
                }
                
            } else if (radioOpcion4.isSelected()) {

                int comp = DAOPregunta.getInstance().setDatos(new Pregunta(txtFieldPregunta.getText(), new Opcion(txtFieldOpcion1.getText(), false), new Opcion(txtFieldOpcion2.getText(), false), new Opcion(txtFieldOpcion3.getText(), false), new Opcion(txtFieldOpcion4.getText(), true)));
                
                if (comp == 0) {
                    continuar = true;
                } else if (comp == 1) {
                    JOptionPane.showMessageDialog(this, "La pregunta ya está en la base de datos");
                } else if (comp == -1){
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error al insertar la pregunta");
                }
                
            }

            if (continuar) {
                this.actualizarLista();

                Integer opcion = JOptionPane.showConfirmDialog(this, "Se ha guardado la pregunta correctamente", "Guardado correcto", JOptionPane.DEFAULT_OPTION);

                txtFieldPregunta.setText("Escriba una pregunta...");
                txtFieldOpcion1.setText("Escriba respuesta...");
                txtFieldOpcion2.setText("Escriba respuesta...");
                txtFieldOpcion3.setText("Escriba respuesta...");
                txtFieldOpcion4.setText("Escriba respuesta...");   
            }
            else{
                JOptionPane.showMessageDialog(this, "Porfavor, seleccione la opcion correcta para guardar");
            }

        } else {

            Integer opcion = JOptionPane.showConfirmDialog(this, "No se ha añadido nueva pregunta a la bbdd", "Error al añadir", JOptionPane.DEFAULT_OPTION);

        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.ButtonGroup grupoRadio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaJPreguntas;
    private javax.swing.JRadioButton radioOpcion1;
    private javax.swing.JRadioButton radioOpcion2;
    private javax.swing.JRadioButton radioOpcion3;
    private javax.swing.JRadioButton radioOpcion4;
    private javax.swing.JTextField txtFieldOpcion1;
    private javax.swing.JTextField txtFieldOpcion2;
    private javax.swing.JTextField txtFieldOpcion3;
    private javax.swing.JTextField txtFieldOpcion4;
    private javax.swing.JTextField txtFieldPregunta;
    // End of variables declaration//GEN-END:variables

    private void actualizarLista() {
        listaPreguntas = DAOPregunta.getInstance().getDatos();

        this.modelo = new DefaultListModel();

        for (int i = 0; i < listaPreguntas.size(); i++) {
            this.modelo.addElement(listaPreguntas.get(i).getId_pregunta() + "-" + listaPreguntas.get(i).getTituloPreg());
        }

        this.listaJPreguntas.setModel(this.modelo);

        this.listaJPreguntas.setEnabled(false);

        this.updateUI();
    }
}
