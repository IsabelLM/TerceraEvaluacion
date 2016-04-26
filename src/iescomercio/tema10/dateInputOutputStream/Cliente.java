/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.dateInputOutputStream;

/**
 *
 * @author VESPERTINO
 */
public class Cliente {

    private String nombre, apellido1, apellido2;
    private int dni;

    public Cliente(String nombre, String apellido1, String apellido2, int dni) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

        
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public boolean equals(Object obj) {
        Cliente aux = (Cliente) obj;
        if (aux.getDni() == this.getDni()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return getDni() + " " + getNombre();
    }

}
