/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema8.maps.aprendiendoIdiomas;

/**
 *
 * @author VESPERTINO
 */
public class Palabras {

    private String castellano, ingles, frances;

    public Palabras(String castellano, String ingles, String frances) {
        this.castellano = castellano;
        this.ingles = ingles;
        this.frances = frances;
    }

    public String getCastellano() {
        return castellano;
    }

    public void setCastellano(String castellano) {
        this.castellano = castellano;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public String getFrances() {
        return frances;
    }

    public void setFrances(String frances) {
        this.frances = frances;
    }

}
