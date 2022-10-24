/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo_grafico;

import java.util.Objects;

/**
 *
 * @author Dam
 */
public class Pregunta {
    
    private Integer id_pregunta;
    private String tituloPreg;
    private Opcion opcion1, opcion2, opcion3, opcion4;

    public Pregunta(Integer id_pregunta, String tituloPreg, Opcion opcion1, Opcion opcion2, Opcion opcion3, Opcion opcion4) {
        this.id_pregunta = id_pregunta;
        this.tituloPreg = tituloPreg;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        
    }
    
    public Pregunta(String tituloPreg, Opcion opcion1, Opcion opcion2, Opcion opcion3, Opcion opcion4) {
        this.tituloPreg = tituloPreg;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        
    }
    
    public Pregunta(Integer id_pregunta, Opcion opcion1, Opcion opcion2, Opcion opcion3, Opcion opcion4) {
        this.id_pregunta = id_pregunta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
    }

    public Integer getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(Integer id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getTituloPreg() {
        return tituloPreg;
    }

    public void setTituloPreg(String tituloPreg) {
        this.tituloPreg = tituloPreg;
    }

    public Opcion getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(Opcion opcion1) {
        this.opcion1 = opcion1;
    }

    public Opcion getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(Opcion opcion2) {
        this.opcion2 = opcion2;
    }

    public Opcion getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(Opcion opcion3) {
        this.opcion3 = opcion3;
    }

    public Opcion getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(Opcion opcion4) {
        this.opcion4 = opcion4;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pregunta other = (Pregunta) obj;
        return Objects.equals(this.id_pregunta, other.id_pregunta);
    }

    @Override
    public String toString() {
        return "Pregunta{" + "tituloPreg=" + tituloPreg + ", opcion1=" + opcion1 + ", opcion2=" + opcion2 + ", opcion3=" + opcion3 + ", opcion4=" + opcion4 + '}';
    }
    
}
