/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema12.eventos;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author VESPERTINO
 */
//cuarta forma
public class Encuesta extends JFrame {

    private JLabel jlbPregunta, jlbSies, jlbNoes;
    private JButton jbSi, jbNo;
    private JPanel jpSiNo;
    private int si, no;

    public Encuesta() {
        si = no = 0;
        //instanciar objetos
        jlbPregunta = new JLabel("¿Sabes programar?");
        jlbSies = new JLabel("Sies: ");
        jlbNoes = new JLabel("Noes: ");
        jbNo = new JButton("No");
        jbSi = new JButton("Si");
        jpSiNo = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        //Meter botones dentro del panel
        jpSiNo.add(jbSi);
        jpSiNo.add(jbNo);

        //Configurar ventana
        getContentPane().setLayout(new GridLayout(4, 1, 10, 10));
        getContentPane().add(jlbPregunta);
        getContentPane().add(jpSiNo);
        getContentPane().add(jlbSies);
        getContentPane().add(jlbNoes);

        //Evento botones Si/No
        jbSi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                metodoAlHacerClickEnBoton1();
            }
        });

        jbNo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                metodoAlHacerClickEnBoton2();
            }
        });

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void metodoAlHacerClickEnBoton1() {
        si++;
        jlbSies.setText("Sies: "+si);
    }

    public void metodoAlHacerClickEnBoton2() {
        no++;
        jlbNoes.setText("Noes: " +no);
    }

    public static void main(String[] args) {
        Encuesta e = new Encuesta();
    }

}
