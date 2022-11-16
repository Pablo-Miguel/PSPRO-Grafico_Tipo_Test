/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao_grafico;

import com.mycompany.modelo_grafico.Opcion;
import com.mycompany.modelo_grafico.Pregunta;
import com.mycompany.modelo_grafico.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Nitro
 */
public class MockDAOPregunta extends DAOPregunta{
    //CRUD
    private static MockDAOPregunta daoPregunta = null;
    private static ArrayList<Pregunta> listaPreguntas = null;
    private static ArrayList<Usuario> listaUsuarios = null;

    protected MockDAOPregunta() {
        super();
        
    }
    
    public static MockDAOPregunta getInstance() {

        if (daoPregunta == null) {
            daoPregunta = new MockDAOPregunta();
        }
        
        if(listaUsuarios == null){
            listaUsuarios = new ArrayList<Usuario>();
        }

        if (listaPreguntas == null) {
            listaPreguntas = new ArrayList<Pregunta>();
        }

        return daoPregunta;
    }
    
    //Read
    @Override
    public ArrayList<Usuario> getUsuarios() {

        if(!listaUsuarios.isEmpty()){
            listaUsuarios.add(new Usuario(1, "Pablo Miguel"));
        }
        
        return listaUsuarios;

    }
    
    //Read
    @Override
    public ArrayList<Pregunta> getPreguntas(Usuario usuario) {
        
        if(!listaPreguntas.isEmpty()){
            listaPreguntas.add(new Pregunta(1, "De que color es el caballo blanco de santiago", 
                    new Opcion(1, "Negro", false), 
                    new Opcion(2, "Blanco", true), 
                    new Opcion(3, "Rojo", false), 
                    new Opcion(4, "Verde", false), usuario));
            listaPreguntas.add(new Pregunta(2, "Como es el mote español del hermano de Napoleon", 
                    new Opcion(5, "Juan Botella", false), 
                    new Opcion(6, "Ibai", false), 
                    new Opcion(7, "Bonaparte", false), 
                    new Opcion(8, "Pepe Botella", true), usuario));
            listaPreguntas.add(new Pregunta(3, "Mejor jugador de Valorant 2022", 
                    new Opcion(9, "Koldamenta", false), 
                    new Opcion(10, "HitboxKing", false), 
                    new Opcion(11, "Mixwell", true), 
                    new Opcion(12, "Ibai", false), usuario));
        }
        
        return listaPreguntas;

    }

    //Create
    public int setPregunta(Pregunta pregunta, Usuario usuario) {
        return 0;
    }
    
    //Create
    public int insertarUsuario(Usuario usuario) {
        return 0;
    }

    //Update
    public int updatePregunta(Pregunta pregunta) {
        
        return 0;
        
    }
    
    //Update
    public int actualizarUsuario(Usuario usuario) {
        
        return 0;
        
    }
    
    //Delete
    public int deletePregunta(Pregunta pregunta) {
        return 0;
    }
    
    //Delete
    public int borrarUsuario(Usuario usuario) {
        return 0;
    }
}
