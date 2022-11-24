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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dam
 */
public class DAOPregunta {

    //CRUD
    private static DAOPregunta daoPregunta = null;
    private static ArrayList<Pregunta> listaPreguntas = null;
    private static ArrayList<Usuario> listaUsuarios = null;

    public DAOPregunta() {
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

        try {
            listaUsuarios = (ArrayList<Usuario>) ConexionDB.getUsuarios();
        } catch (Exception ex) {
            return new ArrayList<Usuario>();
        }
        return listaUsuarios;

    }
    
    //Read
    public ArrayList<Pregunta> getPreguntas(Usuario usuario) {

        try {
            listaPreguntas = (ArrayList<Pregunta>) ConexionDB.getPreguntas(usuario);
        } catch (Exception ex) {
            return null;
        }
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
        } catch (Exception ex) {
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
        } catch (Exception ex) {
            return -1;
        }
        
    }

    //Update
    public int updatePregunta(Pregunta pregunta) {
        
        try {
            return ConexionDB.updatePregunta(pregunta);
        } catch (Exception ex) {
            return -1;
        }
        
    }
    
    //Update
    public int actualizarUsuario(Usuario usuario) {
        
        try {
            return ConexionDB.updateUsuario(usuario);
        } catch (Exception ex) {
            return -1;
        }
        
    }
    
    //Delete
    public int deletePregunta(Pregunta pregunta) {
        try {
            return ConexionDB.deletePregunta(pregunta);
        } catch (Exception ex) {
            return -1;
        }
    }
    
    //Delete
    public int borrarUsuario(Usuario usuario) {
        try {
            return ConexionDB.deleteUsuario(usuario);
        } catch (Exception ex) {
            return -1;
        }
    }

}


