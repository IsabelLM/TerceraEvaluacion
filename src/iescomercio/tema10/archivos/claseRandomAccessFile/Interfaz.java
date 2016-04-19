/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.archivos.claseRandomAccessFile;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

/**
 *
 * @author VESPERTINO
 */
public class Interfaz extends JFrame implements ActionListener{
//    private JProgressBar jpBarra;
    private JPanel jpColumna;
    private JLabel jlOrigen,jlOrigenRuta,jlDestino,jlDestinoRuta, jlTamaño;
    private JFileChooser jfOrigen,jfDestino;
    private JButton jbGo,jbOrigen,jbDestino;   
    private JTextArea jtaTamaño;
    static private final String newline = "\n";
    private File fileLectura,fileEscritura;
//si lo quiero en balnco Texarea
    public Interfaz() {
        
//        jpBarra = new JProgressBar(0,100);
//        jpBarra.setStringPainted(true);//NECESARIO PARA QUE MEUSTRA EL % EN EL JPRrogressBar
        jpColumna=new JPanel(new GridLayout(3,3));
        jfOrigen=new JFileChooser();
        jfDestino=new JFileChooser();
        fileEscritura=new File("");
        fileLectura=new File("");
        //Para poder elegir solo el directorio
//        jfDestino.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                
        jlOrigen=new JLabel("Origen");
        
        jlOrigenRuta=new JLabel("");
        jlOrigenRuta.setBackground(Color.WHITE);
        
        jlDestino=new JLabel("Destino");
        
        jlDestinoRuta=new JLabel("");
        jlDestinoRuta.setBackground(Color.WHITE);
        
        jbOrigen = new JButton("Selecionar");
        jbOrigen.addActionListener(this);
        jbOrigen.setAlignmentX(CENTER_ALIGNMENT);
        
        jbDestino = new JButton("Guardar donde");
        jbDestino.addActionListener(this);
        jbDestino.setAlignmentX(CENTER_ALIGNMENT);
        
        jlTamaño = new JLabel("Tamaño");
        jtaTamaño = new JTextArea();
        
        jbGo = new JButton("Enviar Datos");
        jbGo.setAlignmentX(CENTER_ALIGNMENT);
        jbGo.addActionListener(this);
        
        
        jpColumna.add(jlOrigen);
        jpColumna.add(jlOrigenRuta);
        jpColumna.add(jbOrigen);
        jpColumna.add(jlDestino);
        jpColumna.add(jlDestinoRuta);
        jpColumna.add(jbDestino);
        jpColumna.add(jlTamaño);
        jpColumna.add(jtaTamaño);
        
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(jpColumna);
      
        getContentPane().add(jbGo);
//        getContentPane().add(jpBarra);
       
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
//    public JProgressBar getBarra() {
//        return jpBarra;
//    }
    public File getFileLectura(){
        return fileLectura;
    }
    public File getFileEscritura(){
        return fileEscritura;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {    
        int returnVal;
        if (e.getSource() == jbOrigen) {
            returnVal = jfOrigen.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                fileLectura = jfOrigen.getSelectedFile();
                jlOrigenRuta.setText(fileLectura.getPath());             
            } else {
                jlOrigenRuta.setText("fallo al cargar el archivo");                 
            }
            //System.out.println(returnVal);
        }else if(e.getSource() == jbDestino){     
            returnVal = jfDestino.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
               fileEscritura = jfDestino.getSelectedFile();
                jlDestinoRuta.setText(fileEscritura.getPath());             
            } else {
                jlDestinoRuta.setText("fallo al cargar el archivo");                 
            }
           // System.out.println(returnVal);
        }else{
            if((jlOrigenRuta.getText()!="")&& (jlDestinoRuta.getText()!="")){
                jtaTamaño.getText();
                try {
                    RandomAccessFile raf = new RandomAccessFile(fileLectura, "rw");
                    
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }             
        }
    }
    
    public static void main(String[] args) {
        Interfaz a = new Interfaz();
    }

    
  
}