/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema8.maps.aprendiendoIdiomas;

import java.util.HashMap;

/**
 *
 * @author VESPERTINO
 */
public class ListaDePalabras {

    private HashMap<Integer, Palabras> lista;

    public ListaDePalabras() {
        lista = new HashMap();
    }

    public void añadir(Integer indice, Palabras p1) {
        lista.put(indice, p1);
    }

    public Palabras damePalabraAleatoria() {
        int tam = lista.values().size();
        int nAleatorio = Math.random();
    }

}
