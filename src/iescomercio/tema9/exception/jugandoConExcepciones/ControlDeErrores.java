/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema9.exception.jugandoConExcepciones;

import iescomercio.utilidades.PedirValores;
import java.util.LinkedList;

/**
 *
 * @author VESPERTINO
 */
public class ControlDeErrores {

    public Retorno metodo1(int dividendo, int divisor) {
        Retorno r = new Retorno();
        int cociente;
        int resto;

        if (divisor == 0) {
            return null;
        }
        cociente = dividendo / divisor;
        resto = dividendo % divisor;

        r.setResto(resto);
        r.setCociente(cociente);

        return r;
    }

    public int[] metodo1_bis(int dividendo, int divisor) {
        int[] aux = new int[2];

        if (divisor == 0) {
            return null;
        }
        aux[0] = dividendo / divisor;
        aux[1] = dividendo % divisor;
        return aux;
    }

    public Retorno metodo2(int dividendo, int divisor) {
        Retorno r = new Retorno();
        int cociente = 0;
        int resto = 0;

        try {
            cociente = dividendo / divisor;
            resto = dividendo % divisor;
        } catch (ArithmeticException ae) {
            System.out.println("Divisor no puede ser 0");
            return null;
        }

        r.setResto(resto);
        r.setCociente(cociente);

        return r;
    }

    public Object metodo3(int indice) {
        LinkedList lista = new LinkedList();

        for (int i = 0; i < 100; i++) {
            Integer numero = PedirValores.pedirAleatorioInt(0, 100);
            lista.add(i, numero);
        }

        try {
            return lista.get(indice);
        } catch (IndexOutOfBoundsException ie) {
            System.out.println("Indice no puede ser negativo o mayor de 100");
            return null;
        }
        
        
    }
}