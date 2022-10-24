/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao_grafico;

import com.mycompany.modelo_grafico.Opcion;
import com.mycompany.modelo_grafico.Pregunta;
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

    private DAOPregunta() {
        //Constructor
    }

    public static DAOPregunta getInstance() {

        if (daoPregunta == null) {
            daoPregunta = new DAOPregunta();
        }

        if (listaPreguntas == null) {
            listaPreguntas = new ArrayList<Pregunta>();
        }

        return daoPregunta;
    }

    //Read
    public ArrayList<Pregunta> getDatos() {

        listaPreguntas = (ArrayList<Pregunta>) ConexionDB.getPreguntas();
        return listaPreguntas;

    }

    //Create
    public int setDatos(Pregunta pregunta) {
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

    public int updateDatos(Pregunta pregunta) {
        
        return ConexionDB.updatePregunta(pregunta);
        
    }
    
    //Delete
    public int deleteDatos(Pregunta pregunta) {
        return ConexionDB.deletePregunta(pregunta);
    }

}


