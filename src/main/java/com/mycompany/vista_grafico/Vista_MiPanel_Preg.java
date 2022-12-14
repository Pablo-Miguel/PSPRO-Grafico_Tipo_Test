/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.vista_grafico;

import com.mycompany.modelo_grafico.Opcion;
import com.mycompany.modelo_grafico.Pregunta;
import com.mycompany.servicio_grafico.Servicio;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dam
 */
public class Vista_MiPanel_Preg extends javax.swing.JPanel {

    private Vista_MiVentana miVentana;
    private Vista_MiPanel_Resul miPanelResul;
    private Boolean continuar;
    private Integer pregunta = 0;
    private ArrayList<Pregunta> listaPreguntas;
    private ArrayList<Opcion> listaAciertos;

    /**
     * Creates new form Vista_MiPanel_Preg1
     */
    public Vista_MiPanel_Preg(Vista_MiVentana miVentana, ArrayList<Pregunta> listaPreguntas) {
        initComponents();

        continuar = false;

        this.miVentana = miVentana;

        listaAciertos = new ArrayList<Opcion>();

        this.listaPreguntas = listaPreguntas;

        lblPregunta.setText(listaPreguntas.get(pregunta).getTituloPreg());

        radioOpcion1.setText(listaPreguntas.get(pregunta).getOpcion1().getTxtOpcion());

        radioOpcion2.setText(listaPreguntas.get(pregunta).getOpcion2().getTxtOpcion());

        radioOpcion3.setText(listaPreguntas.get(pregunta).getOpcion3().getTxtOpcion());

        radioOpcion4.setText(listaPreguntas.get(pregunta).getOpcion4().getTxtOpcion());
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
        lblPregunta = new javax.swing.JLabel();
        radioOpcion1 = new javax.swing.JRadioButton();
        radioOpcion2 = new javax.swing.JRadioButton();
        radioOpcion3 = new javax.swing.JRadioButton();
        radioOpcion4 = new javax.swing.JRadioButton();
        btnSiguiente = new javax.swing.JButton();
        lblTimer = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(574, 339));

        lblPregunta.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPregunta.setText("Pregunta");

        grupoRadio.add(radioOpcion1);
        radioOpcion1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        radioOpcion1.setText("Opcion1");
        radioOpcion1.setToolTipText("");

        grupoRadio.add(radioOpcion2);
        radioOpcion2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        radioOpcion2.setText("Opcion2");

        grupoRadio.add(radioOpcion3);
        radioOpcion3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        radioOpcion3.setText("Opcion3");

        grupoRadio.add(radioOpcion4);
        radioOpcion4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        radioOpcion4.setText("Opcion4");

        btnSiguiente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        lblTimer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTimer.setText("TIMER:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioOpcion2)
                    .addComponent(radioOpcion1)
                    .addComponent(radioOpcion3)
                    .addComponent(radioOpcion4))
                .addGap(220, 220, 220))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSiguiente)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnSiguiente)
                .addGap(96, 96, 96))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(radioOpcion1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioOpcion2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioOpcion3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioOpcion4)
                .addGap(141, 141, 141))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed

        if (radioOpcion1.isSelected()) {

            listaAciertos.add(listaPreguntas.get(pregunta).getOpcion1());
            continuar = true;
        } else if (radioOpcion2.isSelected()) {

            listaAciertos.add(listaPreguntas.get(pregunta).getOpcion2());
            continuar = true;
        } else if (radioOpcion3.isSelected()) {

            listaAciertos.add(listaPreguntas.get(pregunta).getOpcion3());
            continuar = true;
        } else if (radioOpcion4.isSelected()) {

            listaAciertos.add(listaPreguntas.get(pregunta).getOpcion4());
            continuar = true;
        }

        if (continuar) {
            pregunta++;

            if (pregunta < listaPreguntas.size()) {

                lblPregunta.setText(listaPreguntas.get(pregunta).getTituloPreg());
                
                grupoRadio.clearSelection();
                
                radioOpcion1.setText(listaPreguntas.get(pregunta).getOpcion1().getTxtOpcion());
                
                radioOpcion2.setText(listaPreguntas.get(pregunta).getOpcion2().getTxtOpcion());
                
                radioOpcion3.setText(listaPreguntas.get(pregunta).getOpcion3().getTxtOpcion());
                
                radioOpcion4.setText(listaPreguntas.get(pregunta).getOpcion4().getTxtOpcion());
                
                this.updateUI();
            } else {

                miPanelResul = new Vista_MiPanel_Resul(miVentana, listaAciertos);

                miVentana.cambiarPanel(miPanelResul);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Porfavor, seleccione una de las opciones para avanzar");
        }

        continuar = false;

    }//GEN-LAST:event_btnSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente;
    private javax.swing.ButtonGroup grupoRadio;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JRadioButton radioOpcion1;
    private javax.swing.JRadioButton radioOpcion2;
    private javax.swing.JRadioButton radioOpcion3;
    private javax.swing.JRadioButton radioOpcion4;
    // End of variables declaration//GEN-END:variables
}
