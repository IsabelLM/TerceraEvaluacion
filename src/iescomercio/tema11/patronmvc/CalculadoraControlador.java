/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema11.patronmvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author VESPERTINO
 */
public class CalculadoraControlador implements ActionListener {
    private InterfazVistas vista;
    private Modelo modelo;

    public CalculadoraControlador(InterfazVistas vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("BotonCalcular")) {

        } else if (e.getActionCommand().equals("BotonSalir")) {
            System.exit(0);
        }

    }

}
