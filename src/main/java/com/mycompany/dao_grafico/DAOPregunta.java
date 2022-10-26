/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao_grafico;

import com.mycompany.modelo_grafico.Opcion;
import com.mycompany.modelo_grafico.Pregunta;
import com.mycompany.modelo_grafico.Usuario;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

/**
 *
 * @author Dam
 */
public class DAOPregunta {

    //CRUD
    private static DAOPregunta daoPregunta = null;
    private static ArrayList<Pregunta> listaPreguntas = null;
    private static ArrayList<Usuario> listaUsuarios = null;

    private DAOPregunta() {
        //Constructor
    }

    public static DAOPregunta getInstance() {

        if (daoPregunta == null) {
            daoPregunta = new DAOPregunta();
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
    public ArrayList<Usuario> getUsuarios() {

        listaUsuarios = (ArrayList<Usuario>) ConexionDB.getUsuarios();
        return listaUsuarios;

    }
    
    //Read
    public ArrayList<Pregunta> getPreguntas() {

        listaPreguntas = (ArrayList<Pregunta>) ConexionDB.getPreguntas();
        return listaPreguntas;

    }

    //Create
    public int setPregunta(Pregunta pregunta) {
        try {
            ConexionDB.insertarPregunta(pregunta);
            return 0;
        } catch (SQLIntegrityConstraintViolationException ex) {
            return 1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    //Update

    public int updatePregunta(Pregunta pregunta) {
        
        return ConexionDB.updatePregunta(pregunta);
        
    }
    
    //Delete
    public int deletePregunta(Pregunta pregunta) {
        return ConexionDB.deletePregunta(pregunta);
    }

}


