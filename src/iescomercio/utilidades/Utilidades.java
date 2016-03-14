/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.utilidades;

/**
 *
 * @author Isabel
 */
public class Utilidades {

    public static boolean compruebaNumerosEnterosCero(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                System.out.println("Solo se permiten numeros enteros o el cero.");
                return false;
            }
        }
        return true;
    }
    
  
    

}
