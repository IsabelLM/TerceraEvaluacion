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

    private int cociente;
    private int resto;

    public Retorno() {
    }

    public Retorno(int cociente, int resto) {
        this.cociente = cociente;
        this.resto = resto;
    }

    public float getCociente() {
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
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Retorno other = (Retorno) obj;
        if (Float.floatToIntBits(this.cociente) != Float.floatToIntBits(other.cociente)) {
            return false;
        }
        if (this.resto != other.resto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cociente: " + cociente + " Resto: " + resto;
    }
    
    

}
