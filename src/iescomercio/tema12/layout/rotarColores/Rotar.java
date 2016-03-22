/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema12.layout.rotarColores;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author VESPERTINO
 */
public class Rotar extends JFrame {

    private JPanel panel1, panel2, panel3, panel4, panel5;
    private Color[] colores;

    public Rotar() {
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        colores = new Color[4];
        BorderLayout b1 = new BorderLayout();

    }
}
