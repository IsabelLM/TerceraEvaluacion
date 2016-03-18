/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema12.layout;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author VESPERTINO
 */
public class Box extends JFrame {

    private javax.swing.JButton[] botones;

    public Box() {
        //Poner el layout que queremos utilizar. En este caso uno de tipo Box
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        botones = new JButton[25];
        
        //Crear botones automaticamente
        for (int i = 0; i < 25; i++) {
            botones[i] = new JButton("Botón " + i);
            add((botones[i]));
        }
        
        //Empaqueta los botones en el JFrame
        pack();
        //Mostramos la ventana
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Box b = new Box();
    }

}
