/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema8.maps.aprendiendoIdiomas;

import java.util.Scanner;

/**
 *
 * @author VESPERTINO
 */
public class VistaParaProgramaEnConsola {

    public void juego(ListaDePalabras lp) {
        Scanner sc = new Scanner(System.in);
        Marcador m = new Marcador();
        String ingles, frances;
        int aux = 0;

        while (true) {
            Palabras p = lp.damePalabraAleatoria();

            System.out.println("La palabra " + p.getCastellano() + " se dice en:");
            System.out.println("Ingles: ");
            ingles = sc.nextLine();
            System.out.println("Frances: ");
            frances = sc.nextLine();

            if (ingles.equals(p.getIngles())) {
                aux++;
            }
            if (frances.equals(p.getFrances())) {
                aux++;
            }
            System.out.println("Has acertado " + aux + " palabras.");
            m.ponAcierto(aux);
            aux = 0;

            System.out.println(m);
        }
    }
}
