/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao_grafico;

import com.mycompany.modelo_grafico.Opcion;
import com.mycompany.modelo_grafico.Pregunta;
import java.util.ArrayList;

/**
 *
 * @author Dam
 */
public class DAOPregunta {
    //CRUD
    private static DAOPregunta daoPregunta = null;
    private static ArrayList<Pregunta> listaPreguntas = null;

    private DAOPregunta() {
        //Constructor
    }
    
    public static DAOPregunta getInstance(){
        
        if(daoPregunta == null){
            daoPregunta = new DAOPregunta();    
        }
        
        if(listaPreguntas == null){
            listaPreguntas = new ArrayList<Pregunta>();    
        }
        
        return daoPregunta;
    }
    
    //Read
    public ArrayList<Pregunta> getDatos(){
        
        if(listaPreguntas.isEmpty()){
            listaPreguntas.add(new Pregunta("¿De qué color es el caballo blanco de Santiago?", 
            new Opcion("Negro", false), new Opcion("No tiene caballo", false), 
            new Opcion("Rojo", false), new Opcion("Blanco", true)));

            listaPreguntas.add(new Pregunta("¿Como se llama el dueño de Tesla?", 
            new Opcion("Elon Musk", true), new Opcion("Jonny Deep", false), 
            new Opcion("Tom Holland", false), new Opcion("Pablo Motos", false)));

            listaPreguntas.add(new Pregunta("¿Que es Java?", 
            new Opcion("Una manzana", false), new Opcion("Software", true), 
            new Opcion("Hardware", false), new Opcion("Una marca de coche", false)));

            listaPreguntas.add(new Pregunta("La intensidad de corriente eléctrica se mide utilizando:", 
            new Opcion("Amperímetro", true), new Opcion("Barómetro", false), 
            new Opcion("Nivómetro", false), new Opcion("Altímetro", false)));

            listaPreguntas.add(new Pregunta("¿Cuál es el único número que es par y primo?", 
            new Opcion("4", false), new Opcion("1", false), 
            new Opcion("0", false), new Opcion("2", true)));

            return listaPreguntas;
        }
        else{
            return listaPreguntas;
        }
        
    }
    
    
    //Create
    public void setDatos(Pregunta pregunta){
        if(listaPreguntas != null){
                
            if(!listaPreguntas.contains(pregunta)){

                listaPreguntas.add(pregunta);
            }
        }
    }
    
    //Update
    
    //Crear metodo
    
    //Delete
    public void deleteDatos(Pregunta pregunta){
        if(listaPreguntas != null){
            
            if(listaPreguntas.contains(pregunta)){
                    
                listaPreguntas.remove(pregunta);
            }
        }
    }
    
    
}
