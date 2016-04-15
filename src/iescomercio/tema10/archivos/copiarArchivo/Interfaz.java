/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.archivos.copiarArchivo;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author VESPERTINO
 */
public class Interfaz extends JFrame implements ActionListener {

    private JPanel jpColumna;
    private JLabel jlOrigen, jlRutaOrigen, jlDestino, jlRutaDestino;
    private JFileChooser jfcElegirArchivo, jfcDestino;
    private JButton boton, abrirO, guardarO, abrirD, guardarD;
    private JProgressBar barra;

    public Interfaz() {
        jlOrigen = new JLabel("Origen");
        jlDestino = new JLabel("Destino");
        jlRutaOrigen = new JLabel();
        jlRutaDestino = new JLabel();
        jfcElegirArchivo = new JFileChooser();
        jfcDestino = new JFileChooser();

        //Para poder elegir solo el directorio
        jfcDestino.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        boton = new JButton("Copiar");

        abrirO = new JButton("Elige el archivo a copiar...");
        abrirD = new JButton("Elige el destino...");
        barra = new JProgressBar(1, 100);

        jlRutaDestino.setBackground(Color.WHITE);
        jlRutaOrigen.setBackground(Color.WHITE);

        jpColumna = new JPanel(new GridLayout(2, 3));
        jpColumna.add(jlOrigen);
        jpColumna.add(jlRutaOrigen);
        jpColumna.add(abrirO);
        jpColumna.add(jlDestino);
        jpColumna.add(jlRutaDestino);
        jpColumna.add(abrirD);

        abrirO.addActionListener(this);
        abrirD.addActionListener(this);
        boton.addActionListener(this);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(jpColumna);
        getContentPane().add(boton);
        getContentPane().add(barra);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        Interfaz in = new Interfaz();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == abrirO) {
            int returnVal = jfcElegirArchivo.showOpenDialog(Interfaz.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = jfcElegirArchivo.getSelectedFile();
                jlRutaOrigen.setText(file.getPath());
            }
        } else if (e.getSource() == abrirD) {
            int returnVal = jfcDestino.showOpenDialog(Interfaz.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = jfcDestino.getSelectedFile();
                jlRutaDestino.setText(file.getPath());

            }
        }
    }
}
