/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema12.layout;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author VESPERTINO
 */
public class GridFormulario extends JFrame {

    private JLabel nombre, ape, edad, tel;

    public GridFormulario() {
        this.getContentPane().setLayout(new GridLayout(4, 2, 5, 5));

    }
//cambios
}
