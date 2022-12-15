/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.vista_grafico;

import com.mycompany.dao_grafico.DAOPregunta;
import com.mycompany.modelo_grafico.Opcion;
import com.mycompany.modelo_grafico.Usuario;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author Nitro
 */
@RunWith(MockitoJUnitRunner.class)
public class Vista_MiPanel_ResulTest {
    
    //@Test(expected=BRException.class)
    //fail("Lanzada excepcion no esperada BOException");
    
    //@InjectMocks
    //@Mock
    //Mockito.when(mockedList.get(1)).thenThrow(new RuntimeException());
    //Mockito.verify(outputClass).printOutput("Hello - World");
    
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Opcion> lista1;
    private ArrayList<Opcion> lista2;
    private ArrayList<Opcion> lista3;
    
    public Vista_MiPanel_ResulTest() {
        this.listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios.add(new Usuario(1, "Pablo Miguel"));
        lista1 = new ArrayList<Opcion>();
        lista1.add(new Opcion("", true));
        lista1.add(new Opcion("", true));
        lista1.add(new Opcion("", false));
        lista1.add(new Opcion("", true));
        lista2 = new ArrayList<Opcion>();
        lista2.add(new Opcion("", false));
        lista2.add(new Opcion("", true));
        lista2.add(new Opcion("", false));
        lista2.add(new Opcion("", true));
        lista3 = new ArrayList<Opcion>();
        lista3.add(new Opcion("", false));
        lista3.add(new Opcion("", true));
        lista3.add(new Opcion("", false));
        lista3.add(new Opcion("", true));
        lista3.add(new Opcion("", true));
        lista3.add(new Opcion("", true));
        lista3.add(new Opcion("", true));
        lista3.add(new Opcion("", false));
        lista3.add(new Opcion("", true));
        lista3.add(new Opcion("", true));
        lista3.add(new Opcion("", false));
        lista3.add(new Opcion("", true));
        lista3.add(new Opcion("", true));
        lista3.add(new Opcion("", false));
        lista3.add(new Opcion("", true));
    }
    
    @BeforeEach
    public void setUp() {
        
    }
    
     @Test
    public void comprobarResultadoNota1() {
        
        DAOPregunta daoPregunta = mock(DAOPregunta.class);
        when(daoPregunta.getUsuarios()).thenReturn(this.listaUsuarios);
        
        Vista_MiVentana ventana = new Vista_MiVentana();
        ventana.setDaoPregunta(daoPregunta);
        Vista_MiPanel_Resul panel = new Vista_MiPanel_Resul(ventana, lista1);
        
        System.out.println("USUARIO: " + ventana.getDaoPregunta().getUsuarios().get(0).toString());
        
        assertEquals(7.5, panel.nota, 0.1);
    }
    
    @Test
    public void comprobarResultadoNota2() {
        
        DAOPregunta daoPregunta = mock(DAOPregunta.class);
        when(daoPregunta.getUsuarios()).thenReturn(this.listaUsuarios);
        
        Vista_MiVentana ventana = new Vista_MiVentana();
        ventana.setDaoPregunta(daoPregunta);
        Vista_MiPanel_Resul panel = new Vista_MiPanel_Resul(ventana, lista2);
        
        System.out.println("USUARIO: " + ventana.getDaoPregunta().getUsuarios().get(0).toString());
        
        assertEquals(5.0, panel.nota, 0.1);
    }
    
    @Test
    public void comprobarResultadoNota3() {
        
        DAOPregunta daoPregunta = mock(DAOPregunta.class);
        when(daoPregunta.getUsuarios()).thenReturn(this.listaUsuarios);
        
        Vista_MiVentana ventana = new Vista_MiVentana();
        ventana.setDaoPregunta(daoPregunta);
        Vista_MiPanel_Resul panel = new Vista_MiPanel_Resul(ventana, lista3);
        
        System.out.println("USUARIO: " + ventana.getDaoPregunta().getUsuarios().get(0).toString());
        
        assertEquals(6.67, panel.nota, 0.1);
    }
    
}
