/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema11.sqlveleros;

/**
 *
 * @author VESPERTINO
 */
public class Barco {


    int matricula, metrosEslora, precio;

    public Barco(int matricula, int metrosEsloran) {
        this.matricula = matricula;
        this.metrosEslora = metrosEslora;
    }

    public double calcularAlquiler(int numeroDias) {
        precio = (metrosEslora * 10) * numeroDias + 2;
        return precio;
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula + "\nMetros de eslora: " + metrosEslora;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getMetrosEslora() {
        return metrosEslora;
    }

    public void setMetrosEslora(int metrosEslora) {
        this.metrosEslora = metrosEslora;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
