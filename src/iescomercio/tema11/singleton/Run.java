/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema11.singleton;

import java.sql.Connection;

/**
 *
 * @author VESPERTINO
 */
public class Run {
    public static void main(String[] args) {
        Connection c = ConexionBD.getConfigurador();
        
        System.out.println(c.toString());
        
             
    }
 
}
