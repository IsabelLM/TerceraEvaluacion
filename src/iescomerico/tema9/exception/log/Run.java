/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomerico.tema9.exception.log;

/**
 *
 * @author VESPERTINO
 */
public class Run {

    public static void main(String[] args) {
        Log l = new Log("Error1");

        l.añadir("Error 2");
        for (int i = 0; i < 100; i++) {
            System.out.println("  ");
        }
        l.añadir("Error dsd");
        
        System.out.println(l.leerMensajes("17/2/2016"));
    }
}
