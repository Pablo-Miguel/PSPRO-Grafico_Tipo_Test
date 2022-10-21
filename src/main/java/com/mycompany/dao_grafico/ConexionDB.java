/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao_grafico;

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
    static String bd = "vehiculos";
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

            String sql = "INSERT INTO vehiculo (Marca, Modelo, Matricula) VALUES (?, ?, ?);";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, vehiculo.getMarca());
            stmt.setString(2, vehiculo.getModelo());
            stmt.setString(3, vehiculo.getMatricula());
            System.out.println(stmt.toString());
            stmt.execute();
            //rs = st.executeQuery("INSERT INTO vehiculo (Marca, Modelo, Matricula) VALUES (\"" + vehiculo.getMarca() + "\", \"" + vehiculo.getModelo()+ "\", \"" + vehiculo.getMatricula()+ "\");");
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
        List<Vehiculo> listaVehiculos = null;

        try {
            st = conn.createStatement();

            rs = st.executeQuery("SELECT * FROM vehiculo");
            System.out.println("SELECT * FROM vehiculo");

            listaVehiculos = new ArrayList<Vehiculo>();
            while (rs.next()) {
                listaVehiculos.add(new Vehiculo(rs.getString("Marca"), rs.getString("Modelo"), rs.getString("Matricula")));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
            ex.printStackTrace();
        }

        cerrarSesion();

        return listaVehiculos;

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
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
