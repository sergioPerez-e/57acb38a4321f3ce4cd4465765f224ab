/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * 
 */
public class ClientesTest {

    
    
    /*
    Clases de equivalencia: 
    precondicion: nueco cliente no puede estar nulo
    poscondicion: el cliente queda disponible para futuros alquileres
    
    
    #CE |        CE                                           | Tipo          | Resultado 
    
    1    p!= null                                               Error               ninguno
    2    el cliente ya se encuentra 
         clientes.containsKey(p.getDocumento())==true           Dentro Frontera     No se agrega P
    3    el cliente no se encuentra 
         clientes.containsKey(p.getDocumento())==false          Dentro Frontera     Se agrega P
    4    
    
    
    */
    public ClientesTest() {
    }
    
    @Before
    public void setUp() {
    }
    
  
    @Test
    public void additems1() throws ExcepcionServiciosAlquiler{
    	
    }
    
    
    
    
    
    
    
}
