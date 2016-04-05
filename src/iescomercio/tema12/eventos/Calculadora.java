/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema12.eventos;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author VESPERTINO
 */
public class Calculadora extends JFrame {

    private javax.swing.JButton[] botones;
    private javax.swing.JButton jb1, jb2, jb3, jbIgual;
    private JLabel jlResultados;
    private JPanel jpResultados, jpIgual, jpNumeros;

    public Calculadora() {
        //Crear botones, label...
        jlResultados = new JLabel();

        botones = new JButton[9];
        for (int i = 0; i < 9; i++) {
            botones[i] = new JButton("" + (i + 1));
        }
        jb1 = new JButton("0");
        jb2 = new JButton("+");
        jb3 = new JButton("-");
        jbIgual = new JButton("=");

        //Creacion paneles
        jpResultados = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        jpIgual = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        jpResultados.add(jlResultados);
//        this.getContentPane().setLayout(new GridLayout(4, 3, 5, 5));
//        getContentPane().add(jpResultados);

        add(jb1);
        for (int i = 0; i < 9; i++) {
            this.getContentPane().add(botones[i]);
        }
        add(jb2);
        add(jb3);
        getContentPane().add(jpIgual);

        jpIgual.add(jbIgual);

        pack();
        //Mostramos la ventana
        this.setLocationRelativeTo(null);
        this.setTitle("Calculadora");
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Calculadora g = new Calculadora();
    }
}
