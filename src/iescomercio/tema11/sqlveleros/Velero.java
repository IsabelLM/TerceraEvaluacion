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
public class Velero extends Barco {

    private int numeroMastiles;

    public Velero(int numeroMastiles, int matricula, int metrosEsloran) {
        super(matricula, metrosEsloran);
        this.numeroMastiles = numeroMastiles;
    }

    @Override
    public double calcularAlquiler(int numeroDias) {
        return super.calcularAlquiler(numeroDias) + (numeroMastiles * 5);
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula + "\nMetros de eslora: " + metrosEslora + "numeroMastiles=" + numeroMastiles;
    }

    public int getNumeroMastiles() {
        return numeroMastiles;
    }

    public void setNumeroMastiles(int numeroMastiles) {
        this.numeroMastiles = numeroMastiles;
    }

}
