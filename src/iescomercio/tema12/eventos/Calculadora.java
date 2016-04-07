/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema12.eventos;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author VESPERTINO
 */
public class Calculadora extends JFrame implements ActionListener{

   private JPanel jpPantalla, jpBotonera, jpIgual;
    private JLabel jlPantalla;
    private JButton[] jbBotonera;
    private JButton jbIgual;
    private StringBuilder sb;
    private int operando1, operando2;
    private char operador;

    public Calculadora() {
        //Indicamos el Layout que deseamos
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        sb = new StringBuilder();   // Inicialimazos el StringBuilder

        jpPantalla = new JPanel(new GridLayout(1, 1));  //Creamos un JPanel para la pantalla de tipo GridLayout
        jlPantalla = new JLabel("", SwingConstants.CENTER);   //Inicalizamos el JLabel a 0 y que aparezca en el centro
        jpPantalla.add(jlPantalla);   //Añadimos el JLabel al JPanel
        this.add(jpPantalla);   //Añadimos el JPanel al Layout

        jpBotonera = new JPanel(new GridLayout(4, 3, 2, 2)); //Creamos un JPanel para la botonera de tipo GridLayout
        jbBotonera = new JButton[12];   //Inicializamos el array de JButton con 12 botones

        //En el siguiente bucle inicializamos y añadimos los 10 primeros botones, con valores de 0 a 9, al JPanel botonera
        for (int i = 0; i < 10; i++) {
            jbBotonera[i] = new JButton(Integer.toString(i));
            jpBotonera.add(jbBotonera[i]);
        }
        //Inicializamos y añadimos dos dos botones restantes de "+" y "-" al JPanel de botonera
        jbBotonera[10] = new JButton("+");
        jbBotonera[11] = new JButton("-");
        jpBotonera.add(jbBotonera[10]);
        jpBotonera.add(jbBotonera[11]);
        this.add(jpBotonera);   //Añadimos el JPanel botonera al Layout

        //Creamos un JPanel para el boton igual de tipo GridLayout
        jpIgual = new JPanel(new GridLayout(1, 1, 3, 3));
        jbIgual = new JButton("="); //Inicializamos el boton igual
        jpIgual.add(jbIgual);  //Añadimos el boton igual al JPanel igual
        this.add(jpIgual);  //Añadimos el JPanel igual a Layout

        //Añadimos los eventos de cada boton con un bucle
        for (int i = 0; i < 12; i++) {
            jbBotonera[i].addActionListener(this);
        }
        jbIgual.addActionListener(this);

        //Ponemos un icono al programa
        Image icon = new ImageIcon(getClass().getResource("/imagenes/award_star_gold_2.png")).getImage();
        setIconImage(icon);
        setLocationRelativeTo(null); //Centramos la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Se termina el programa al cerrar la ventana
        pack();
        setTitle("Calculadora");  //Añadimos un título
        setVisible(true); //Lo hacemos visible
        setSize(175, 250); //Dimensiones de la ventana
        setResizable(false); //Hacemos que no se pueda ampliar

    }

    //Metodo para crear los eventos
    @Override
    public void actionPerformed(ActionEvent e) {
        //Cada uno de los ifs hara que al clicar en cada boton, aparezca en el JLabel su número correspondiente o
        //su simbolo
        JButton aux = (JButton) e.getSource();
        if (aux.getText().equals("+")) {
            // Guardamos el primer operando
            operando1 = Integer.parseInt(jlPantalla.getText());
            operador = '+';
            // Borramos el label
            jlPantalla.setText("");
        }else if (aux.getText().equals("-")){
            operando1 = Integer.parseInt(jlPantalla.getText());
            operador = '-';
            jlPantalla.setText("");
        }else if (aux.getText().equals("=")) {
            if (operador == '+') {
                int dato = operando1 + Integer.parseInt(jlPantalla.getText());
                jlPantalla.setText(dato+"");
                operando1 = 0;
                operando2 = 0;
            }else if(operador ==  '-'){
                int dato = operando1 - Integer.parseInt(jlPantalla.getText());
                jlPantalla.setText(dato+"");
                operando1 = 0;
                operando2 = 0;
            }
        } else {
            String s = jlPantalla.getText();
            jlPantalla.setText(s + aux.getText());
        }

    }

    public static void main(String[] args) {
        //Inicializamos el programa en el main
        Calculadora c = new Calculadora();
    }
}
