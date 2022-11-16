/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.vista_grafico;

import com.mycompany.modelo_grafico.Opcion;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nitro
 */
public class Vista_MiPanel_ResulTest {
    
    private MockVista_MiVentana miVista;
    
    public Vista_MiPanel_ResulTest() {
    }
    
    @BeforeEach
    public void setUp() {
        miVista = new MockVista_MiVentana();
    }
    
     @Test
    public void comprobarResultadoNota1() {
        ArrayList<Opcion> lista = new ArrayList<Opcion>();
        lista.add(new Opcion("", true));
        lista.add(new Opcion("", true));
        lista.add(new Opcion("", false));
        lista.add(new Opcion("", true));
        
        Vista_MiPanel_Resul panel = new Vista_MiPanel_Resul(miVista,  lista);
        
        assertEquals(7.5, panel.nota);
    }
    
    @Test
    public void comprobarResultadoNota2() {
        ArrayList<Opcion> lista = new ArrayList<Opcion>();
        lista.add(new Opcion("", false));
        lista.add(new Opcion("", true));
        lista.add(new Opcion("", false));
        lista.add(new Opcion("", true));
        
        Vista_MiPanel_Resul panel = new Vista_MiPanel_Resul(new Vista_MiVentana(),  lista);
        
        assertEquals(5.0, panel.nota);
    }
    
    @Test
    public void comprobarResultadoNota3() {
        ArrayList<Opcion> lista = new ArrayList<Opcion>();
        lista.add(new Opcion("", false));
        lista.add(new Opcion("", true));
        lista.add(new Opcion("", false));
        lista.add(new Opcion("", true));
        lista.add(new Opcion("", true));
        lista.add(new Opcion("", true));
        lista.add(new Opcion("", true));
        lista.add(new Opcion("", false));
        lista.add(new Opcion("", true));
        lista.add(new Opcion("", true));
        lista.add(new Opcion("", false));
        lista.add(new Opcion("", true));
        lista.add(new Opcion("", true));
        lista.add(new Opcion("", false));
        lista.add(new Opcion("", true));
        
        Vista_MiPanel_Resul panel = new Vista_MiPanel_Resul(new Vista_MiVentana(),  lista);
        
        assertEquals(6.67, panel.nota);
    }
    
}
