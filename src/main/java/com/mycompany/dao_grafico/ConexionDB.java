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
            
            for (int i = 1; i <= 4; i++) {

                sql = "SELECT MAX(Id_opcion) + 1 AS ID_MAX FROM Opciones_table;";
                stmt = conn.prepareStatement(sql);
                System.out.println(stmt.toString());
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    listaIds.add(rs.getInt("ID_MAX"));
                }

                sql = "INSERT INTO Opciones_table (Id_opcion, Texto, Correcto) VALUES (?, ?, ?);";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, listaIds.get(i));
                stmt.setString(2, pregunta.getOpcion1().getTxtOpcion());
                stmt.setBoolean(3, pregunta.getOpcion1().isCorrecto());
                System.out.println(stmt.toString());
                stmt.execute();

            }

            sql = "INSERT INTO Pregunta_table (Pregunta, Id_opcion1, Id_opcion2, Id_opcion3, Id_opcion4) VALUES (?, ?, ?, ?, ?);";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pregunta.getTituloPreg());
            stmt.setInt(2, listaIds.get(0));
            stmt.setInt(3, listaIds.get(1));
            stmt.setInt(4, listaIds.get(2));
            stmt.setInt(5, listaIds.get(3));
            System.out.println(stmt.toString());
            stmt.execute();

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

            String sql = "SELECT CONT(Id_pregunta) AS CONT FROM Pregunta_table";
            stmt = conn.prepareStatement(sql);
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();

            Integer cont = 0;
            if (rs.next()) {
                cont = rs.getInt("CONT");
            }

            if (cont != 0) {

                listaPreguntas = new ArrayList<Pregunta>();
                ArrayList<Opcion> listaOpciones = new ArrayList<Opcion>();

                for (int i = 1; i <= cont; i++) {

                    for (int j = 1; j <= 4; j++) {
                        listaOpciones = new ArrayList<Opcion>();

                        sql = "SELECT Pregunta, Texto, Correcto FROM Pregunta_table JOIN Opciones_table ON Pregunta_table.Id_opcion" + j + " = Opciones_table.Id_opcion WHERE Id_opcion = Id_opcion" + j + " AND Id_pregunta = ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setInt(1, i);
                        System.out.println(stmt.toString());
                        rs = stmt.executeQuery();

                        if (rs.next()) {
                            listaOpciones.add(new Opcion(rs.getString("Texto"), rs.getBoolean("Correcto")));
                        }
                    }

                    listaPreguntas.add(new Pregunta(rs.getString("Pregunta"), listaOpciones.get(0), listaOpciones.get(1), listaOpciones.get(2), listaOpciones.get(3)));
                }

            }

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
            ex.printStackTrace();
        }

        cerrarSesion();

        return listaPreguntas;

    }

    public static Pregunta getPregunta(String matricula) {

        Vehiculo vehiculo = null;
        enlace();

        try {
            st = conn.createStatement();

            String sql = "SELECT * FROM vehiculo WHERE matricula = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, matricula);
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();

            if (rs.next()) {
                vehiculo = new Vehiculo(rs.getString("Marca"), rs.getString("Modelo"), rs.getString("Matricula"));
            }

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
            ex.printStackTrace();
        }

        cerrarSesion();

        return vehiculo;
    }

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
