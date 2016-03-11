/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema9.exception.jugandoConExcepciones;

/**
 *
 * @author VESPERTINO
 */
public class Main {

    public static void main(String[] args) {
        ControlDeErrores c = new ControlDeErrores();
        ControlDeErrores c1 = new ControlDeErrores();

        System.out.println(c.metodo2(5, 0));
        System.out.println(c1.metodo2(5, -2));
    }
}
