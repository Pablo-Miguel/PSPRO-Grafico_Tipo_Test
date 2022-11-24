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
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author Nitro
 */
@RunWith(MockitoJUnitRunner.class)
public class Vista_MiPanel_ResulTest {
    
    @InjectMocks
    private MockVista_MiVentana miVista;
    
    @Mock
    private DAOPregunta daoPreguntas;
    
    public Vista_MiPanel_ResulTest() {
    }
    
    @BeforeEach
    public void setUp() {
        
    }
    
     @Test
    public void comprobarResultadoNota1() {
        ArrayList<Opcion> lista = new ArrayList<Opcion>();
        lista.add(new Opcion("", true));
        lista.add(new Opcion("", true));
        lista.add(new Opcion("", false));
        lista.add(new Opcion("", true));
        
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios.add(new Usuario(1, "Pablo Miguel"));
        
        when(new Vista_MiVentana()).thenReturn(miVista);
        when(miVista.getUsuarioActual()).thenReturn(listaUsuarios.get(0));
        
        assertEquals(7.5, new Vista_MiPanel_Resul(new Vista_MiVentana(),  lista).nota);
    }
    
    @Test
    public void comprobarResultadoNota2() {
        ArrayList<Opcion> lista = new ArrayList<Opcion>();
        lista.add(new Opcion("", false));
        lista.add(new Opcion("", true));
        lista.add(new Opcion("", false));
        lista.add(new Opcion("", true));
        
        Vista_MiPanel_Resul panel = new Vista_MiPanel_Resul(new MockVista_MiVentana(),  lista);
        
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
        
        Vista_MiPanel_Resul panel = new Vista_MiPanel_Resul(new MockVista_MiVentana(),  lista);
        
        assertEquals(6.67, panel.nota);
    }
    
}
