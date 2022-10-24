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
public class Vista_MiPanel_Borrar extends javax.swing.JPanel {

    private Vista_MiVentana miVentana;
    private Vista_MiPanel_Inicio miPanelInicio;

    private ArrayList<Pregunta> listaPreguntas;

    private DefaultListModel modelo;

    /**
     * Creates new form Vista_MiPanel_Borrar
     */
    public Vista_MiPanel_Borrar(Vista_MiVentana miVentana) {
        initComponents();

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
        radioOpcion4 = new javax.swing.JRadioButton();
        radioOpcion2 = new javax.swing.JRadioButton();
        txtFieldOpcion1 = new javax.swing.JTextField();
        txtFieldOpcion2 = new javax.swing.JTextField();
        txtFieldOpcion3 = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        txtFieldOpcion4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaJPreguntas = new javax.swing.JList<>();
        btnBorrar = new javax.swing.JButton();
        txtFieldPregunta = new javax.swing.JTextField();
        radioOpcion3 = new javax.swing.JRadioButton();
        radioOpcion1 = new javax.swing.JRadioButton();
        lblId1 = new javax.swing.JLabel();
        lblId2 = new javax.swing.JLabel();
        lblId3 = new javax.swing.JLabel();
        lblId4 = new javax.swing.JLabel();

        grupoRadio.add(radioOpcion4);
        radioOpcion4.setEnabled(false);

        grupoRadio.add(radioOpcion2);
        radioOpcion2.setEnabled(false);

        txtFieldOpcion1.setEditable(false);
        txtFieldOpcion1.setText("Escriba respuesta...");

        txtFieldOpcion2.setEditable(false);
        txtFieldOpcion2.setText("Escriba respuesta...");

        txtFieldOpcion3.setEditable(false);
        txtFieldOpcion3.setText("Escriba respuesta...");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        txtFieldOpcion4.setEditable(false);
        txtFieldOpcion4.setText("Escriba respuesta...");

        listaJPreguntas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaJPreguntasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaJPreguntas);

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        txtFieldPregunta.setEditable(false);
        txtFieldPregunta.setText("Escriba una pregunta...");

        grupoRadio.add(radioOpcion3);
        radioOpcion3.setEnabled(false);

        grupoRadio.add(radioOpcion1);
        radioOpcion1.setEnabled(false);

        lblId1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblId1.setText("ID");

        lblId2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblId2.setText("ID");

        lblId3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblId3.setText("ID");
        lblId3.setToolTipText("");

        lblId4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblId4.setText("ID");
        lblId4.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioOpcion2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(radioOpcion1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(radioOpcion3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(radioOpcion4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblId1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblId2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblId3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblId4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFieldOpcion2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                    .addComponent(txtFieldOpcion3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtFieldOpcion4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtFieldOpcion1)))
                            .addComponent(txtFieldPregunta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFieldOpcion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(radioOpcion1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtFieldOpcion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblId2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(radioOpcion2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioOpcion3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtFieldOpcion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblId3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioOpcion4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtFieldOpcion4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblId4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lblId1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 149, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnBorrar))
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

    private void listaJPreguntasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaJPreguntasMouseClicked
        // TODO add your handling code here:

        if (listaJPreguntas.getModel().getSize() != 0) {
            this.txtFieldPregunta.setText(listaPreguntas.get(listaJPreguntas.getSelectedIndex()).getTituloPreg());
            this.lblId1.setText(listaPreguntas.get(listaJPreguntas.getSelectedIndex()).getOpcion1().getId_opcion() + "");
            this.lblId2.setText(listaPreguntas.get(listaJPreguntas.getSelectedIndex()).getOpcion2().getId_opcion() + "");
            this.lblId3.setText(listaPreguntas.get(listaJPreguntas.getSelectedIndex()).getOpcion3().getId_opcion() + "");
            this.lblId4.setText(listaPreguntas.get(listaJPreguntas.getSelectedIndex()).getOpcion4().getId_opcion() + "");
            if (listaPreguntas.get(listaJPreguntas.getSelectedIndex()).getOpcion1().isCorrecto()) {
                radioOpcion1.setSelected(true);
            } else if (listaPreguntas.get(listaJPreguntas.getSelectedIndex()).getOpcion2().isCorrecto()) {
                radioOpcion2.setSelected(true);
            } else if (listaPreguntas.get(listaJPreguntas.getSelectedIndex()).getOpcion3().isCorrecto()) {
                radioOpcion3.setSelected(true);
            } else if (listaPreguntas.get(listaJPreguntas.getSelectedIndex()).getOpcion4().isCorrecto()) {
                radioOpcion4.setSelected(true);
            }

            txtFieldOpcion1.setText(listaPreguntas.get(listaJPreguntas.getSelectedIndex()).getOpcion1().getTxtOpcion());
            txtFieldOpcion2.setText(listaPreguntas.get(listaJPreguntas.getSelectedIndex()).getOpcion2().getTxtOpcion());
            txtFieldOpcion3.setText(listaPreguntas.get(listaJPreguntas.getSelectedIndex()).getOpcion3().getTxtOpcion());
            txtFieldOpcion4.setText(listaPreguntas.get(listaJPreguntas.getSelectedIndex()).getOpcion4().getTxtOpcion());
        }

    }//GEN-LAST:event_listaJPreguntasMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        if (!(txtFieldPregunta.getText().equals("Escriba una pregunta...") || txtFieldPregunta.getText().equals("")
                || txtFieldOpcion1.getText().equals("Escriba respuesta...") || txtFieldOpcion1.getText().equals("")
                || txtFieldOpcion2.getText().equals("Escriba respuesta...") || txtFieldOpcion2.getText().equals("")
                || txtFieldOpcion3.getText().equals("Escriba respuesta...") || txtFieldOpcion3.getText().equals("")
                || txtFieldOpcion4.getText().equals("Escriba respuesta...") || txtFieldOpcion4.getText().equals(""))) {
            int comp = DAOPregunta.getInstance().deleteDatos(new Pregunta(Integer.parseInt(listaJPreguntas.getSelectedValue().charAt(0) + ""), new Opcion(Integer.parseInt(lblId1.getText())), new Opcion(Integer.parseInt(lblId2.getText())), new Opcion(Integer.parseInt(lblId3.getText())), new Opcion(Integer.parseInt(lblId4.getText()))));

            if (comp == 0) {
                this.actualizarLista();

                JOptionPane.showConfirmDialog(this, "Se ha borrado la pregunta correctamente", "Borrado correcto", JOptionPane.DEFAULT_OPTION);

                txtFieldPregunta.setText("Escriba una pregunta...");
                txtFieldOpcion1.setText("Escriba respuesta...");
                txtFieldOpcion2.setText("Escriba respuesta...");
                txtFieldOpcion3.setText("Escriba respuesta...");
                txtFieldOpcion4.setText("Escriba respuesta...");
                this.lblId1.setText("ID");
                this.lblId2.setText("ID");
                this.lblId3.setText("ID");
                this.lblId4.setText("ID");
                
            } else {
                JOptionPane.showConfirmDialog(this, "Se ha producido un error al borrar la bbdd", "Borrado correcto", JOptionPane.DEFAULT_OPTION);
            }

        } else {
            JOptionPane.showConfirmDialog(this, "No se ha borrado la bbdd", "Borrado erroneo", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void actualizarLista() {
        listaPreguntas = DAOPregunta.getInstance().getDatos();

        this.modelo = new DefaultListModel();

        for (int i = 0; i < listaPreguntas.size(); i++) {
            this.modelo.addElement(listaPreguntas.get(i).getId_pregunta() + "-" + listaPreguntas.get(i).getTituloPreg());
        }

        this.listaJPreguntas.setModel(this.modelo);

        this.updateUI();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.ButtonGroup grupoRadio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId1;
    private javax.swing.JLabel lblId2;
    private javax.swing.JLabel lblId3;
    private javax.swing.JLabel lblId4;
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
}
