/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema12.layout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author VESPERTINO
 */
public class Border extends JFrame {
    /*Implementar un programa haciendo uso de Swing 
     que muestre una ventana con un borderlayout donde en el 
     Arriba amarillo
     Izda: azul
     Derecho: Verde
     Abajo: naranja
     posteriormente en el central mediente border layout, mostrará otra vez, que rote*/

//panel 1 grid 2*2 
// 2 label y 1 jtextfield
    private JPanel jpSup, jpSur, jpDcha, jpIzda, jpCentro, panel1, panel2, panel3;
    private JButton[] botones;
    private JLabel[] label;
    private JCheckBox[] checkb;
    private JRadioButton[] radio;
    private JTextField jtf;

    public Border() {
        jpSup = new JPanel();
        jpSur = new JPanel();
        jpDcha = new JPanel();
        jpIzda = new JPanel();
        jpCentro = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        BorderLayout b1 = new BorderLayout();

        jpSup.setBackground(Color.red);
        jpSur.setBackground(Color.blue);
        jpDcha.setBackground(Color.green);
        jpIzda.setBackground(Color.pink);
        jpCentro.setBackground(Color.GRAY);

        this.getContentPane().setLayout(b1);
        getContentPane().add(jpSup, BorderLayout.NORTH);
        getContentPane().add(jpSur, BorderLayout.SOUTH);
        getContentPane().add(jpDcha, BorderLayout.EAST);
        getContentPane().add(jpIzda, BorderLayout.WEST);
        getContentPane().add(jpCentro, BorderLayout.CENTER);

        //Superior
        jpSup.setLayout(new FlowLayout());
        botones = new JButton[10];
        for (int i = 0; i < 10; i++) {
            botones[i] = new JButton(i + "");
            jpSup.add(botones[i]);
        }

        //Izquierda
        jpIzda.setLayout(new BoxLayout(jpIzda, BoxLayout.Y_AXIS));
        label = new JLabel[10];
        for (int i = 0; i < 10; i++) {
            label[i] = new JLabel("Opcion " + i);
            jpIzda.add(label[i]);
        }

        //Derecha
        jpDcha.setLayout(new BoxLayout(jpDcha, BoxLayout.Y_AXIS));
        checkb = new JCheckBox[10];
        for (int i = 0; i < 10; i++) {
            checkb[i] = new JCheckBox("Opcion " + i);
            jpDcha.add(checkb[i]);
        }

        //Sur
        jpSur.setLayout(null);
        jpSur.setPreferredSize(new Dimension(80, 30));
        radio = new JRadioButton[3];
        for (int i = 0; i < 3; i++) {
            radio[i] = new JRadioButton("Opcion " + i);
            radio[i].setBounds(i * 100, 0, 80, 20);
            jpSur.add(radio[i]);
        }

        //Panel1
        panel1.setLayout(new GridLayout(4, 3, 2, 2));
        label = new JLabel[2];
        for (int i = 0; i < 2; i++) {
            label[i] = new JLabel("Opcion " + i);
            panel1.add(label[i]);
        }

        //Panel 2
        panel2.setLayout(new GridLayout(4, 3, 5, 5));
        label = new JLabel[2];
        for (int i = 0; i < 2; i++) {
            label[i] = new JLabel("Opc" + i);
            panel2.add(label[i]);
        }

        //Panel 3 
        panel3.setLayout(new GridLayout(4, 3, 5, 5));
        label = new JLabel[1];
        for (int i = 0; i < 1; i++) {
            label[i] = new JLabel("Opcion " + i);
            panel3.add(label[i]);
            jtf = new JTextField("Nombre: ");
            panel3.add(jtf);
        }

        //Centro
        jpCentro.setLayout(new CardLayout());
        jpCentro.add(panel1);
        jpCentro.add(panel2);
        jpCentro.add(panel3);

        pack();
        this.setLocationRelativeTo(null);
        this.setTitle("Uso del borderLayout");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        Border b = new Border();
    }

}
