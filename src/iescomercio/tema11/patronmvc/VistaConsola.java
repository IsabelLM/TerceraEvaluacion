/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema11.patronmvc;

import java.awt.event.ActionEvent;

/**
 *
 * @author VESPERTINO
 */
public class VistaConsola implements InterfazVistas {

    @Override
    public String getOperando1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOperando2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOperador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setResultado(String dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setControlador(CalculadoraControlador objeto) {

        objeto.actionPerformed(new ActionEvent(this, 1, "BotonCalcular"));
        objeto.actionPerformed(new ActionEvent(this, 2, "BotonSalir"));
    }

}
