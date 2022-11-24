/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vista_grafico;

import com.mycompany.dao_grafico.DAOPregunta;
import com.mycompany.dao_grafico.MockDAOPregunta;
import com.mycompany.modelo_grafico.Usuario;

/**
 *
 * @author Nitro
 */
public class MockVista_MiVentana extends Vista_MiVentana{
    
    private Usuario usuarioActual;
    
    public MockVista_MiVentana() {
        super();
        
        if(!MockDAOPregunta.getInstance().getUsuarios().isEmpty()){
            usuarioActual = MockDAOPregunta.getInstance().getUsuarios().get(0);
        }
        
    }
    
    @Override
    public Usuario getUsuarioActual(){
        return this.usuarioActual;
    }
    
    @Override
    public void setUsuarioActual(Usuario usuario){
        this.usuarioActual = usuario;
    }
    
}
