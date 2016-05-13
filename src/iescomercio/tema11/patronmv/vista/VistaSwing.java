/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema11.patronmv.vista;

import iescomercio.tema11.patronmv.modelo.InterfazVistas;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author VESPERTINO
 */
public class VistaSwing extends JFrame implements InterfazVistas, ActionListener {

    private JLabel jlOperando1, jlOperador, jlOperando2, jlResultado, jlResultado2;
    private JTextArea jtaOperando1, jtaOperando2;
    private JComboBox jcbOperador;
    private JButton jbCalcular, jbSalir;
    private JPanel jpizda, jpdcha;

    public VistaSwing() {
        jlOperando1 = new JLabel("Operando 1");
        jlOperador = new JLabel("Operador");
        jlOperando2 = new JLabel("Operando 2");
        jlResultado = new JLabel("Resultado");
        jlResultado2 = new JLabel("");
        jtaOperando1 = new JTextArea("");
        jtaOperando2 = new JTextArea("");
        jbCalcular = new JButton("Calcular");
        jbSalir = new JButton("Salir");

        String[] array = new String[4];
        array[0] = "+";
        array[1] = "-";
        array[2] = "*";
        array[3] = "/";

        jcbOperador = new JComboBox(array);
        this.getContentPane().setLayout(new FlowLayout());
        jpizda = new JPanel(new GridLayout(4, 2));

        jpdcha = new JPanel();
        jpdcha.setLayout(new BoxLayout(jpdcha, BoxLayout.Y_AXIS));

        jpizda.add(jlOperando1);
        jpizda.add(jtaOperando1);
        jpizda.add(jlOperador);
        jpizda.add(jcbOperador);
        jpizda.add(jlOperando2);
        jpizda.add(jtaOperando2);
        jpizda.add(jlResultado);
        jpizda.add(jlResultado2);

        jpdcha.add(jbCalcular);
        jpdcha.add(jbSalir);

        getContentPane().add(jpizda);
        getContentPane().add(jpdcha);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        VistaSwing v = new VistaSwing();
    }

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
    public void setControlador(CalculadoraControlador aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
