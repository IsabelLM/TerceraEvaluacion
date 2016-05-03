/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.archivos.interface1;

import java.util.GregorianCalendar;
import java.util.Objects;

/**
 *
 * @author VESPERTINO
 */
public class Barco {

    private String matricula;
    private float eslora;
    private GregorianCalendar añoFabricacion;

    public Barco(String matricula, float eslora, int añoFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        //this.añoFabricacion = new GregorianCalendar(añoFabricacion, mesFabricacion, diaFabricacion);
        this.añoFabricacion = new GregorianCalendar(añoFabricacion, 0, 0);

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getEslora() {
        return eslora;
    }

    public void setEslora(float eslora) {
        this.eslora = eslora;
    }

    public GregorianCalendar getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(GregorianCalendar añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Barco other = (Barco) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

    
    
    //método que calcula cuanto se paga un día
    public float calcularAlquiler() {
        float precioDia;
        precioDia = (eslora * 10);
        return precioDia;

    }
}
