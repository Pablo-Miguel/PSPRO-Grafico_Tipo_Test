/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.servicio_grafico;

import com.mycompany.dao_grafico.DAOPregunta;
import com.mycompany.modelo_grafico.Pregunta;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Dam
 */
public class Servicio {
    
    private static Servicio servicio;
    private ArrayList<Pregunta> listaPreguntas;

    private Servicio() {
        this.listaPreguntas = DAOPregunta.getInstance().getDatos();
    }
    
    public static Servicio getInstance(){
        
        if(servicio == null){
            servicio = new Servicio();    
        }
        
        return servicio;
    }

    public ArrayList<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

    public void setListaPreguntas(ArrayList<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }
    
    public ArrayList<Pregunta> getListaPreguntasShuffle() {
        Collections.shuffle(listaPreguntas);
        return listaPreguntas;
    }
    
    
    
    @Override
    public String toString() {
        return "Servicio{" + "listaPreguntas=" + listaPreguntas + '}';
    }
    
}
