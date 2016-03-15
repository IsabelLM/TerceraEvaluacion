/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema9.exception.jugandoConExcepciones;

import java.sql.SQLException;

/**
 *
 * @author VESPERTINO
 */
public class Ejercicio {
    /*
     Realizar un método llamado lanzar(int) que reciba un entero. Si el entero es:
     Mayor de 5 mostraremos la tabla de multiplicar de ese número. 
     Si es 1 o 3 provocaremos una excepcion mostrando el mensaje no quiero impares pequeños. 
     Si es 2 o 4 pares tampoco
     0 --> Lanzar excepcion de tipo SQLException
     */

    public void lanzar(int n) {

        try {
            if (n == 1 || n == 3) {
                throw new Exception("No pueden ser impares pequeños");
            } else if (n == 2 || n == 4) {
                throw new PruebaException("No pueden ser pares pequeños");
            } else if (n == 0) {
                throw new SQLException();
            } else {
                for (int i = 0; i < 10; i++) {
                    System.out.println(n + "*" + i + "=" + n * i);
                }
            }
        } catch (SQLException sq) {
            System.out.println("No puede ser cero");
        } catch (PruebaException pe) {
            System.out.println(pe.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
