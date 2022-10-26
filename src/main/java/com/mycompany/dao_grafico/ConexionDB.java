/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao_grafico;

import com.mycompany.modelo_grafico.Opcion;
import com.mycompany.modelo_grafico.Pregunta;
import com.mycompany.modelo_grafico.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nitro
 */
public class ConexionDB {

    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement stmt = null;
    static String bd = "graficotest";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/" + bd;

    private static void enlace() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            System.out.println("Conexión exitosa");
        } catch (SQLException ex) {
            System.out.println("Excepicon en la conexión");
        } catch (ClassNotFoundException ex) {
            System.out.println("No se encuentra la clase");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void insertarPregunta(Pregunta pregunta) throws SQLException, SQLIntegrityConstraintViolationException {

        enlace();

        try {

            ArrayList<Integer> listaIds = new ArrayList<Integer>();
            String sql = "SELECT MAX(Id_pregunta) + 1 AS ID_MAX FROM Pregunta;";
            stmt = conn.prepareStatement(sql);
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();
            
            Integer id_pregunta = null;
            if (rs.next()) {
                id_pregunta = rs.getInt("ID_MAX");
            }
            
            pregunta.setId_pregunta(id_pregunta);

            ArrayList<Opcion> listaOpciones = new ArrayList<Opcion>();
            listaOpciones.add(pregunta.getOpcion1());
            listaOpciones.add(pregunta.getOpcion2());
            listaOpciones.add(pregunta.getOpcion3());
            listaOpciones.add(pregunta.getOpcion4());
            
            sql = "INSERT INTO Pregunta (Id_pregunta, Pregunta) VALUES (?, ?);";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pregunta.getId_pregunta());
            stmt.setString(2, pregunta.getTituloPreg());
            System.out.println(stmt.toString());
            stmt.execute();

            for (int i = 0; i < listaOpciones.size(); i++) {

                sql = "SELECT MAX(Id_opcion) + 1 AS ID_MAX FROM Opcion;";
                stmt = conn.prepareStatement(sql);
                System.out.println(stmt.toString());
                rs = stmt.executeQuery();

                if (rs.next()) {
                    listaIds.add(rs.getInt("ID_MAX"));
                }

                sql = "INSERT INTO Opcion (Id_opcion, Id_pregunta, Texto, Correcto) VALUES (?, ?, ?, ?);";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, listaIds.get(i));
                stmt.setInt(2, pregunta.getId_pregunta());
                stmt.setString(3, listaOpciones.get(i).getTxtOpcion());
                stmt.setBoolean(4, listaOpciones.get(i).isCorrecto());
                System.out.println(stmt.toString());
                stmt.execute();

            }

        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("Error SQL: " + ex.toString());
            throw new SQLIntegrityConstraintViolationException();
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
            throw new SQLException();
        }
        finally{
            cerrarSesion();
        }

    }

    public static List<Pregunta> getPreguntas() {

        enlace();
        List<Pregunta> listaPreguntas = null;

        try {

            listaPreguntas = new ArrayList<Pregunta>();
            ArrayList<Integer> listaPreguntasIds = new ArrayList<Integer>();
            ArrayList<Opcion> listaOpciones = new ArrayList<Opcion>();

            String sql = "SELECT Id_pregunta FROM Pregunta;";
            stmt = conn.prepareStatement(sql);
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();

            while (rs.next()) {

                listaPreguntasIds.add(rs.getInt("Id_pregunta"));

            }

            for (int i = 0; i < listaPreguntasIds.size(); i++) {
                listaOpciones = new ArrayList<Opcion>();

                sql = "\nSELECT \n"
                        + "    OT.Id_opcion,\n"
                        + "    OT.Texto,\n"
                        + "    OT.Correcto\n"
                        + "FROM\n"
                        + "    Pregunta PT \n"
                        + "    JOIN Opcion OT ON PT.Id_pregunta = OT.Id_pregunta\n"
                        + "WHERE\n"
                        + "    PT.Id_pregunta=?;\n";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, listaPreguntasIds.get(i));
                System.out.println(stmt.toString());
                rs = stmt.executeQuery();

                while (rs.next()) {
                    listaOpciones.add(new Opcion(rs.getInt("Id_opcion"), rs.getString("Texto"), rs.getBoolean("Correcto")));
                }

                sql = "SELECT Pregunta FROM Pregunta WHERE Id_pregunta=?;";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, listaPreguntasIds.get(i));
                System.out.println(stmt.toString());
                rs = stmt.executeQuery();

                if (rs.next()) {
                    listaPreguntas.add(new Pregunta(listaPreguntasIds.get(i), rs.getString("Pregunta"), listaOpciones.get(0), listaOpciones.get(1), listaOpciones.get(2), listaOpciones.get(3)));
                }

            }

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
            ex.printStackTrace();
        }

        cerrarSesion();

        return listaPreguntas;

    }
    
    public static List<Usuario> getUsuarios() {

        enlace();
        List<Usuario> listaUsuarios = null;

        try {

            listaUsuarios = new ArrayList<Usuario>();

            String sql = "SELECT Id_usuario, Nombre FROM Usuario;";
            stmt = conn.prepareStatement(sql);
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                listaUsuarios.add(new Usuario(rs.getInt("Id_usuario"), rs.getString("Nombre")));
                
            }

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
            ex.printStackTrace();
        }

        cerrarSesion();

        return listaUsuarios;

    }

    public static Pregunta getPregunta(Pregunta pregunta) {

        Pregunta preguntaDB = null;
        enlace();

        try {

            ArrayList<Opcion> listaOpciones = new ArrayList<Opcion>();

            String sql = "\nSELECT \n"
                    + "    OT.Id_opcion,\n"
                    + "    OT.Texto,\n"
                    + "    OT.Correcto\n"
                    + "FROM\n"
                    + "    Pregunta PT \n"
                    + "    JOIN Opcion OT ON PT.Id_pregunta = OT.Id_pregunta\n"
                    + "WHERE\n"
                    + "    PT.Id_pregunta=?;\n";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pregunta.getId_pregunta());
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();

            while (rs.next()) {
                listaOpciones.add(new Opcion(rs.getInt("Id_opcion"), rs.getString("Texto"), rs.getBoolean("Correcto")));
            }

            if (!listaOpciones.isEmpty()) {

                preguntaDB = new Pregunta(pregunta.getId_pregunta(), pregunta.getTituloPreg(), listaOpciones.get(0), listaOpciones.get(1), listaOpciones.get(2), listaOpciones.get(3));

            }

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
            ex.printStackTrace();
        }

        cerrarSesion();

        return preguntaDB;
    }

    public static int updatePregunta(Pregunta pregunta) {
        enlace();

        try {

            String sql = "UPDATE Pregunta SET Pregunta=? WHERE Id_pregunta=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pregunta.getTituloPreg());
            stmt.setInt(2, pregunta.getId_pregunta());
            System.out.println(stmt.toString());
            stmt.executeUpdate();
            
            ArrayList<Opcion> listaOpciones = new ArrayList<Opcion>();
            listaOpciones.add(pregunta.getOpcion1());
            listaOpciones.add(pregunta.getOpcion2());
            listaOpciones.add(pregunta.getOpcion3());
            listaOpciones.add(pregunta.getOpcion4());
            
            for(int i = 0; i < listaOpciones.size(); i++){
                sql = "UPDATE Opcion SET Texto=?, Correcto=? WHERE Id_opcion=?;";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, listaOpciones.get(i).getTxtOpcion());
                stmt.setBoolean(2, listaOpciones.get(i).isCorrecto());
                stmt.setInt(3, listaOpciones.get(i).getId_opcion());
                System.out.println(stmt.toString());
                stmt.executeUpdate();
            }

        } catch (SQLIntegrityConstraintViolationException ex){
            System.out.println("Error SQL: " + ex.getMessage());
            return 1;
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
            ex.printStackTrace();
            return -1;
        } finally {
            cerrarSesion();
        }
        
        return 0;
    }
    
    public static Integer deletePregunta(Pregunta pregunta) {

        enlace();

        try {
            
            String sql = "";
            ArrayList<Opcion> listaOpciones = new ArrayList<Opcion>();
            listaOpciones.add(pregunta.getOpcion1());
            listaOpciones.add(pregunta.getOpcion2());
            listaOpciones.add(pregunta.getOpcion3());
            listaOpciones.add(pregunta.getOpcion4());
            
            for (int i = 0; i < listaOpciones.size(); i++) {

                sql = "DELETE FROM Opcion WHERE Id_opcion=?;";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, listaOpciones.get(i).getId_opcion());
                System.out.println(stmt.toString());
                stmt.execute();

            }

            sql = "DELETE FROM Pregunta WHERE Id_pregunta=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pregunta.getId_pregunta());
            System.out.println(stmt.toString());
            stmt.execute();

            return 0;

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
            ex.printStackTrace();
        }

        cerrarSesion();

        return -1;
    }

    private static void cerrarSesion() {
        try {
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Conexión cerrada \n");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
