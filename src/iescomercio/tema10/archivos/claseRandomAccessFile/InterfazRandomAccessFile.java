    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.archivos.claseRandomAccessFile;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author VESPERTINO
 */
public class InterfazRandomAccessFile extends JFrame implements ActionListener, WindowListener {

    private JPanel jpColumna;
    private JLabel jlOrigen, jlOrigenRuta, jlDestino, jlDestinoRuta, jlTamano;
    private JFileChooser jfOrigen, jfDestino;
    private JTextArea jlTamanoIndicado;
    private JButton jbGo, jbOrigen, jbDestino;
    private File fileLectura, fileEscritura;
    private RandomAccessFile raLeer, raEscribir;

    public InterfazRandomAccessFile() {

        jpColumna = new JPanel(new GridLayout(3, 3));
        jfOrigen = new JFileChooser();
        jfDestino = new JFileChooser();
        fileEscritura = new File("");
        fileLectura = new File("");
        //Para poder elegir solo el directorio
//        jfDestino.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        jlOrigen = new JLabel("Origen");

        jlOrigenRuta = new JLabel("");
        jlOrigenRuta.setBackground(Color.WHITE);

        jlTamanoIndicado = new JTextArea("");
        jlTamanoIndicado.setBackground(Color.WHITE);

        jlTamano = new JLabel("Tamaño");

        jlDestino = new JLabel("Destino");

        jlDestinoRuta = new JLabel("");
        jlDestinoRuta.setBackground(Color.WHITE);

        jbOrigen = new JButton("Selecionar");
        jbOrigen.addActionListener(this);
        jbOrigen.setAlignmentX(CENTER_ALIGNMENT);

        jbDestino = new JButton("Guardar donde");
        jbDestino.addActionListener(this);
        jbDestino.setAlignmentX(CENTER_ALIGNMENT);

        jbGo = new JButton("empezar!!!");
        jbGo.setAlignmentX(CENTER_ALIGNMENT);
        jbGo.addActionListener(this);

        jpColumna.add(jlOrigen);
        jpColumna.add(jlOrigenRuta);
        jpColumna.add(jbOrigen);
        jpColumna.add(jlDestino);
        jpColumna.add(jlDestinoRuta);
        jpColumna.add(jbDestino);
        jpColumna.add(jlTamano);
        jpColumna.add(jlTamanoIndicado);
        this.addWindowListener(this);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(jpColumna);

        getContentPane().add(jbGo);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public JFileChooser getJfOrigen() {
        return jfOrigen;
    }

    public void setJfOrigen(JFileChooser jfOrigen) {
        this.jfOrigen = jfOrigen;
    }

    public JFileChooser getJfDestino() {
        return jfDestino;
    }

    public void setJfDestino(JFileChooser jfDestino) {
        this.jfDestino = jfDestino;
    }

    public File getFileLectura() {
        return fileLectura;
    }

    public File getFileEscritura() {
        return fileEscritura;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int returnVal;
        if (e.getSource() == jbOrigen) {
            returnVal = jfOrigen.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    fileLectura = jfOrigen.getSelectedFile();
                    jlOrigenRuta.setText(fileLectura.getPath());
                    raLeer = new RandomAccessFile(fileLectura, "r");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(InterfazRandomAccessFile.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                jlOrigenRuta.setText("fallo al cargar el archivo");
            }
        } else if (e.getSource() == jbDestino) {
            returnVal = jfDestino.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    fileEscritura = jfDestino.getSelectedFile();
                    jlDestinoRuta.setText(fileEscritura.getPath());
                    raEscribir = new RandomAccessFile(fileEscritura, "rw");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(InterfazRandomAccessFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                jlDestinoRuta.setText("fallo al cargar el archivo");
            }
        } else {
            if ((jlOrigenRuta.getText() != "") && (jlDestinoRuta.getText() != "")) {
                try {
                    if (fileLectura.length() >= fileEscritura.length()) {
                        int aux = Integer.parseInt(jlTamanoIndicado.getText());
                        byte datos[] = new byte[aux];

                        //posicionar y leer
                        raLeer.seek(fileEscritura.length());
                        raLeer.read(datos);
                        //posicionar y escribir
                        raEscribir.seek(fileEscritura.length());
                        raEscribir.write(datos);

                    } else {
                        System.out.println("El fichero esta completo puedes copiar " + (fileLectura.length() - fileEscritura.length()) + "byte más ");
                    }
                } catch (FileNotFoundException ex) {
                    System.out.println("Fichero no encontrado");
                } catch (IOException ex) {
                    System.out.println("Fallo de la IO");
                }
            }
        }
    }

    public static void main(String[] args) {
        InterfazRandomAccessFile a = new InterfazRandomAccessFile();
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            JOptionPane.showMessageDialog(this, "Cerrando los ficheros");
            raLeer.close();
            raEscribir.close();
        } catch (IOException ex) {
            Logger.getLogger(InterfazRandomAccessFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}