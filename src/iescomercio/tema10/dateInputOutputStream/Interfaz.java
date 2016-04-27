/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.dateInputOutputStream;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author VESPERTINO
 */
public class Interfaz extends JFrame {

    private JButton jbAlta, jbBaja, jbModificar, jbConsulta, jbAtras, jbAdelante, jbAceptar;
    private JTextArea jtaNombre, jtaApe1, jtaApe2, jtaDni, jtaTelefono;
    private JLabel jlNombre, jlApe1, jlApe2, jlDni, jlTelefono;
    private JPanel jpFlow, jpGrid;

    public Interfaz() {
        jbAlta = new JButton("A");
        jbBaja = new JButton("B");
        jbModificar = new JButton("M");
        jbConsulta = new JButton("C");
        jbAtras = new JButton("<");
        jbAdelante = new JButton(">");
        jbAceptar = new JButton("V");

        jlNombre = new JLabel("Nombre:");
        jtaNombre = new JTextArea();

        jlApe1 = new JLabel("Apellido 1:");
        jtaApe1 = new JTextArea();

        jlApe2 = new JLabel("Apellido 2:");
        jtaApe2 = new JTextArea();

        jlDni = new JLabel("Dni:");
        jtaDni = new JTextArea();

        jlTelefono = new JLabel("Telefono:");
        jtaTelefono = new JTextArea();

        jpGrid = new JPanel(new GridLayout(5, 2, 10, 10));
        jpFlow = new JPanel(new FlowLayout());

        jpGrid.add(jlNombre);
        jpGrid.add(jtaNombre);
        jpGrid.add(jlApe1);
        jpGrid.add(jtaApe1);
        jpGrid.add(jlApe2);
        jpGrid.add(jtaApe2);
        jpGrid.add(jlDni);
        jpGrid.add(jtaDni);
        jpGrid.add(jlTelefono);
        jpGrid.add(jtaTelefono);

        jpFlow.add(jbAlta);
        jpFlow.add(jbBaja);
        jpFlow.add(jbModificar);
        jpFlow.add(jbConsulta);
        jpFlow.add(jbAtras);
        jpFlow.add(jbAdelante);
        jpFlow.add(jbAceptar);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jpFlow, BorderLayout.NORTH);
        getContentPane().add(jpGrid, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
