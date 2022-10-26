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
    public ArrayList<Pregunta> getPreguntas(Usuario usuario) {

        listaPreguntas = (ArrayList<Pregunta>) ConexionDB.getPreguntas(usuario);
        return listaPreguntas;

    }

    //Create
    public int setPregunta(Pregunta pregunta, Usuario usuario) {
        try {
            ConexionDB.insertarPregunta(pregunta, usuario);
            return 0;
        } catch (SQLIntegrityConstraintViolationException ex) {
            return 1;
        } catch (SQLException ex) {
            return -1;
        }
    }
    
    //Create
    public int insertarUsuario(Usuario usuario) {
        try {
            ConexionDB.insertarUsuario(usuario);
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
    
    //Update
    public int actualizarUsuario(Usuario usuario) {
        
        return ConexionDB.updateUsuario(usuario);
        
    }
    
    //Delete
    public int deletePregunta(Pregunta pregunta) {
        return ConexionDB.deletePregunta(pregunta);
    }
    
    //Delete
    public int borrarUsuario(Usuario usuario) {
        return ConexionDB.deleteUsuario(usuario);
    }

}


