/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.dateInputOutputStream;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author VESPERTINO
 */
public class Interfaz extends JFrame implements ActionListener, WindowListener {

    private JButton jbAlta, jbBaja, jbModificar, jbConsulta, jbAtras, jbAdelante, jbAceptar;
    private JTextArea jtaNombre, jtaApe1, jtaApe2, jtaDni, jtaTelefono;
    private JLabel jlNombre, jlApe1, jlApe2, jlDni, jlTelefono;
    private JPanel jpFlow, jpGrid;
    private CursorCliente cursor;

    public Interfaz() {
        cursor = new CursorCliente();

        jbAlta = new JButton("Añadir");
        jbBaja = new JButton("Borrar");
        jbModificar = new JButton("Modificar");
        jbConsulta = new JButton("Consulta");
        jbAtras = new JButton("<");
        jbAdelante = new JButton(">");
        jbAceptar = new JButton("Ok");

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

        //Eventos
        this.addWindowListener(this);
        jbAlta.addActionListener(this);
        jbBaja.addActionListener(this);
        jbModificar.addActionListener(this);
        jbConsulta.addActionListener(this);
        jbAtras.addActionListener(this);
        jbAdelante.addActionListener(this);
        jbAceptar.addActionListener(this);

        pack();
        setLocationRelativeTo(null);
        setTitle("Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void permitirEditarTodo(Boolean b) {
        jtaApe1.setEditable(true);
        jtaApe2.setEditable(true);
        jtaDni.setEditable(true);
        jtaNombre.setEditable(true);
        jtaTelefono.setEditable(true);
    }

    public void editarSoloDni(Boolean b) {
        jtaDni.setEditable(true);
        jtaApe1.setEditable(false);
        jtaApe2.setEditable(false);
        jtaNombre.setEditable(false);
        jtaTelefono.setEditable(false);
    }

    public void borrarTexto() {
        jtaDni.setText("");
        jtaApe1.setText("");
        jtaApe2.setText("");
        jtaNombre.setText("");
        jtaTelefono.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbAlta) {
            borrarTexto(); //borrar lo que habia previamente escrito
            if (e.getSource() == jbAceptar) { //tras escribir los datos, si le damos a aceptar, crea un nuevo cliente y lo da de alta
                Cliente aux = new Cliente();
                long tlf;
                aux.setNombre(jtaNombre.getText());
                aux.setApellido1(jtaApe1.getText());
                aux.setApellido2(jtaApe2.getText());
                aux.setDni(jtaDni.getText());
                tlf = Long.parseLong(jtaTelefono.getText());
                aux.setTelefono(tlf);
                cursor.alta(aux);
                borrarTexto();
            }
        } else if (e.getSource() == jbBaja) {
            editarSoloDni(true);
            borrarTexto();
            if (e.getSource() == jbAceptar) {
                Cliente aux = new Cliente();
                aux.setDni(jtaDni.getText());
                cursor.baja(aux);
                borrarTexto();
            }
        } else if (e.getSource() == jbConsulta) {
            editarSoloDni(true);
            borrarTexto();
            if (e.getSource() == jbAceptar) {
                Cliente aux = new Cliente();
                aux.setDni(jtaDni.getText());
                cursor.consulta(aux);
            }
        } else if (e.getSource() == jbModificar) {
            borrarTexto();
            if (e.getSource() == jbAceptar) { //Primero se pone el dni del que queremos borrar y aceptamos
                Cliente viejo = new Cliente();
                viejo.setDni(jtaDni.getText());
                if (e.getSource() == jbAceptar) { //Ponemos los datos nuevos y aceptamos para modificarlo. 
                    borrarTexto();
                    Cliente nuevo = new Cliente();
                    long tlf;
                    nuevo.setNombre(jtaNombre.getText());
                    nuevo.setApellido1(jtaApe1.getText());
                    nuevo.setApellido2(jtaApe2.getText());
                    nuevo.setDni(jtaDni.getText());
                    tlf = Long.parseLong(jtaTelefono.getText());
                    nuevo.setTelefono(tlf);

                    cursor.modificar(nuevo, viejo);
                }
            }

        } else if (e.getSource() == jbAdelante) {

        } else if (e.getSource() == jbAtras) {

        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        // cursor.escribirRegistro();

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
