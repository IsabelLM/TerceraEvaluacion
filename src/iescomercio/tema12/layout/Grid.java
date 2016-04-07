/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema12.layout;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author VESPERTINO
 */
public class Grid extends JFrame {
    
    private javax.swing.JButton[] botones;
    private javax.swing.JButton jb1, jb2, jb3;
    
    public Grid() {
        botones = new JButton[9];
        
        for (int i = 0; i < 9; i++) {
            botones[i] = new JButton("" + (i + 1));
        }
        jb1 = new JButton("0");
        jb2 = new JButton("+");
        jb3 = new JButton("-");
        
        this.getContentPane().setLayout(new GridLayout(4, 3, 5, 5));
        for (int i = 0; i < 9; i++) {
            this.getContentPane().add(botones[i]);
        }
        add(jb1);
        add(jb2);
        add(jb3);
        
        pack();
        //Mostramos la ventana
        this.setLocationRelativeTo(null);
        this.setTitle("Calculadora");
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
    }
    
    public static void main(String[] args) {
        Grid g = new Grid();
    }
}
