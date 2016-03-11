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

}
