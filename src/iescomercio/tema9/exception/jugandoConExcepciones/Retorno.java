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
public class Retorno {

    private int cociente, resto;

    public Retorno() {
    }

    public int getCociente() {
        return cociente;
    }

    public void setCociente(int cociente) {
        this.cociente = cociente;
    }

    public int getResto() {
        return resto;
    }

    public void setResto(int resto) {
        this.resto = resto;
    }

    @Override
    public String toString() {
        return "Cociente: " + cociente + " Resto: " + resto;
    }
    
    
    
}
