/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo_grafico;

/**
 *
 * @author Dam
 */
public class Opcion {
    
    private String txtOpcion;
    private boolean correcto;

    public Opcion(String txtOpcion, boolean correcto) {
        this.txtOpcion = txtOpcion;
        this.correcto = correcto;
    }

    public String getTxtOpcion() {
        return txtOpcion;
    }

    public void setTxtOpcion(String txtOpcion) {
        this.txtOpcion = txtOpcion;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }
    
    public boolean esCorrecto(){
        return this.correcto;
    }

    @Override
    public String toString() {
        return "Opcion{" + "txtOpcion=" + txtOpcion + ", correcto=" + correcto + '}';
    }
}
