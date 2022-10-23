/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao_grafico;

import com.mycompany.modelo_grafico.Opcion;
import com.mycompany.modelo_grafico.Pregunta;
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
    static Statement st = null;
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

            st = conn.createStatement();

            ArrayList<Integer> listaIds = new ArrayList<Integer>();
            String sql = "";

            ArrayList<Opcion> listaOpciones = new ArrayList<Opcion>();
            listaOpciones.add(pregunta.getOpcion1());
            listaOpciones.add(pregunta.getOpcion2());
            listaOpciones.add(pregunta.getOpcion3());
            listaOpciones.add(pregunta.getOpcion4());

            for (int i = 0; i < listaOpciones.size(); i++) {

                sql = "SELECT MAX(Id_opcion) + 1 AS ID_MAX FROM Opciones_table;";
                stmt = conn.prepareStatement(sql);
                System.out.println(stmt.toString());
                rs = stmt.executeQuery();

                if (rs.next()) {
                    listaIds.add(rs.getInt("ID_MAX"));
                }

                sql = "INSERT INTO Opciones_table (Id_opcion, Texto, Correcto) VALUES (?, ?, ?);";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, listaIds.get(i));
                stmt.setString(2, listaOpciones.get(i).getTxtOpcion());
                stmt.setBoolean(3, listaOpciones.get(i).isCorrecto());
                System.out.println(stmt.toString());
                stmt.execute();

            }

            sql = "INSERT INTO Pregunta_table (Pregunta) VALUES (?);";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pregunta.getTituloPreg());
            System.out.println(stmt.toString());
            stmt.execute();

            for (int i = 0; i < listaIds.size(); i++) {
                sql = "INSERT INTO preguntaopciones_table (Pregunta, Id_opcion) VALUES (?, ?);";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, pregunta.getTituloPreg());
                stmt.setInt(2, listaIds.get(i));
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

        cerrarSesion();

    }

    public static List<Pregunta> getPreguntas() {

        enlace();
        List<Pregunta> listaPreguntas = null;

        try {
            st = conn.createStatement();

            listaPreguntas = new ArrayList<Pregunta>();
            ArrayList<String> listaPreguntasTxt = new ArrayList<String>();
            ArrayList<Opcion> listaOpciones = new ArrayList<Opcion>();

            String sql = "SELECT * FROM Pregunta_table;";
            stmt = conn.prepareStatement(sql);
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();

            while (rs.next()) {

                listaPreguntasTxt.add(rs.getString("Pregunta"));

            }

            for (int i = 0; i < listaPreguntasTxt.size(); i++) {
                listaOpciones = new ArrayList<Opcion>();

                sql = "\nSELECT \n"
                        + "    OT.Texto,\n"
                        + "    OT.Correcto\n"
                        + "FROM\n"
                        + "    Pregunta_table PT \n"
                        + "    JOIN PreguntaOpciones_table POT ON PT.Pregunta = POT.Pregunta\n"
                        + "    JOIN Opciones_table OT ON POT.Id_opcion = OT.Id_opcion\n"
                        + "WHERE\n"
                        + "    PT.Pregunta=?;\n";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, listaPreguntasTxt.get(i));
                System.out.println(stmt.toString());
                rs = stmt.executeQuery();

                while (rs.next()) {
                    listaOpciones.add(new Opcion(rs.getString("Texto"), rs.getBoolean("Correcto")));
                }

                listaPreguntas.add(new Pregunta(listaPreguntasTxt.get(i), new Opcion(listaOpciones.get(0).getTxtOpcion(), listaOpciones.get(0).isCorrecto()), new Opcion(listaOpciones.get(1).getTxtOpcion(), listaOpciones.get(1).isCorrecto()), new Opcion(listaOpciones.get(2).getTxtOpcion(), listaOpciones.get(2).isCorrecto()), new Opcion(listaOpciones.get(3).getTxtOpcion(), listaOpciones.get(3).isCorrecto())));

            }

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
            ex.printStackTrace();
        }

        cerrarSesion();

        return listaPreguntas;

    }

    public static Pregunta getPregunta(Pregunta pregunta) {

        Pregunta preguntaDB = null;
        enlace();

        try {
            st = conn.createStatement();

            ArrayList<Opcion> listaOpciones = new ArrayList<Opcion>();

            String sql = "\nSELECT \n"
                        + "    OT.Texto,\n"
                        + "    OT.Correcto\n"
                        + "FROM\n"
                        + "    Pregunta_table PT \n"
                        + "    JOIN PreguntaOpciones_table POT ON PT.Pregunta = POT.Pregunta\n"
                        + "    JOIN Opciones_table OT ON POT.Id_opcion = OT.Id_opcion\n"
                        + "WHERE\n"
                        + "    PT.Pregunta=?;\n";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pregunta.getTituloPreg());
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();

            while (rs.next()) {
                listaOpciones.add(new Opcion(rs.getString("Texto"), rs.getBoolean("Correcto")));
            }
            
            if(!listaOpciones.isEmpty()){
            
                preguntaDB = new Pregunta(pregunta.getTituloPreg(), new Opcion(listaOpciones.get(0).getTxtOpcion(), listaOpciones.get(0).isCorrecto()), new Opcion(listaOpciones.get(1).getTxtOpcion(), listaOpciones.get(1).isCorrecto()), new Opcion(listaOpciones.get(2).getTxtOpcion(), listaOpciones.get(2).isCorrecto()), new Opcion(listaOpciones.get(3).getTxtOpcion(), listaOpciones.get(3).isCorrecto()));
            
            }
            
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
            ex.printStackTrace();
        }

        cerrarSesion();

        return preguntaDB;
    }
    
    /*
    public static Pregunta updatePregunta(String matriculaAntigua, String matriculaNueva, String marca, String modelo) {
        enlace();

        try {
            st = conn.createStatement();

            String sql = "UPDATE vehiculo SET Marca = ?, Modelo = ?, Matricula = ? WHERE Matricula = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, marca);
            stmt.setString(2, modelo);
            stmt.setString(3, matriculaNueva);
            stmt.setString(4, matriculaAntigua);
            System.out.println(stmt.toString());
            stmt.executeUpdate();

            return new Vehiculo(marca, modelo, matriculaNueva);

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
            ex.printStackTrace();
        }

        cerrarSesion();

        return null;
    }

    public static Integer deletePregunta(String matricula) {

        enlace();

        try {
            st = conn.createStatement();

            String sql = "DELETE FROM vehiculo WHERE matricula = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, matricula);
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

    */

    private static void cerrarSesion() {
        try {
            rs.close();

            st.close();

            stmt.close();

            conn.close();

            System.out.println("Conexión cerrada \n");

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
