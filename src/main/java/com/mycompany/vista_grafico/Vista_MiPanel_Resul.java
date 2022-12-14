/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.vista_grafico;

import com.mycompany.modelo_grafico.Opcion;
import java.util.ArrayList;

/**
 *
 * @author PabloMiguel
 */
public class Vista_MiPanel_Resul extends javax.swing.JPanel {
    
    private Vista_MiVentana miVentana;
    private Vista_MiPanel_Inicio miPanelInicio;
    
    private ArrayList<Opcion> listaAciertos;
    private Integer contAciertos = 0;
    public Double nota;
    
    /**
     * Creates new form Vista_MiPanel_Resul
     */
    public Vista_MiPanel_Resul(Vista_MiVentana miVentana, ArrayList<Opcion> listaAciertos) {
        initComponents();
        
        this.miVentana = miVentana;
        this.miPanelInicio = new Vista_MiPanel_Inicio(miVentana);
        
        this.listaAciertos = listaAciertos;
        
        for(int i = 0; i < listaAciertos.size(); i++){
            
            if(listaAciertos.get(i).esCorrecto()){
            
                contAciertos++;
                
            }
            
        }
        
        lblResultado.setText("Resultado: " + contAciertos + " / " + listaAciertos.size());
       
        
        this.nota = Math.round(((contAciertos * 10.0) / listaAciertos.size()) * 100) / 100.0;
        
        this.miVentana.setMenuOculto();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPuntuacion = new javax.swing.JLabel();
        lblResultado = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnVolverJugar = new javax.swing.JButton();

        lblPuntuacion.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblPuntuacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPuntuacion.setText("PUNTUACION DEL TEST");

        lblResultado.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultado.setText("RESULTADO");

        btnSalir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnVolverJugar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnVolverJugar.setText("Volver a jugar");
        btnVolverJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverJugarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPuntuacion, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVolverJugar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir)
                        .addGap(51, 51, 51))))
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnVolverJugar))
                .addGap(89, 89, 89))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        
        System.exit(0);
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnVolverJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverJugarActionPerformed
        // TODO add your handling code here:
        
        this.miVentana.setMenuVisible();
        miVentana.cambiarPanel(miPanelInicio);
        
    }//GEN-LAST:event_btnVolverJugarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVolverJugar;
    private javax.swing.JLabel lblPuntuacion;
    private javax.swing.JLabel lblResultado;
    // End of variables declaration//GEN-END:variables
}
