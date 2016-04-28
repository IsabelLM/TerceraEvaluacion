/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.archivos.datainputoutputstream;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author VESPERTINO
 */
public class Interfaz extends JFrame implements ActionListener, WindowListener {

    private JButton jbAlta, jbBaja, jbModificar, jbConsulta, jbAtras, jbAdelante, jbAceptar, jbPulsado;
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

    public JButton getJbPulsado() {
        return jbPulsado;
    }

    public void setJbPulsado(JButton jbPulsado) {
        this.jbPulsado = jbPulsado;
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

    public void rellenarConDatosCliente(Cliente c) {
        if (c != null) {
            jtaDni.setText(c.getDni());
            jtaApe1.setText(c.getApellido1());
            jtaApe2.setText(c.getApellido2());
            jtaNombre.setText(c.getNombre());
            jtaTelefono.setText(String.valueOf(c.getTelefono()));
        } else {
            JOptionPane.showMessageDialog(rootPane, "No hay clientes");
        }
    }

    public Cliente crearCliente() {
        Cliente aux = new Cliente();
        long tlf;
        aux.setNombre(jtaNombre.getText());
        aux.setApellido1(jtaApe1.getText());
        aux.setApellido2(jtaApe2.getText());
        aux.setDni(jtaDni.getText());
        tlf = Long.parseLong(jtaTelefono.getText());
        aux.setTelefono(tlf);
        return aux;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbAlta) {
            permitirEditarTodo(true);
            borrarTexto(); //borrar lo que habia previamente escrito
            setJbPulsado(jbAlta); //Guardamos el botón que hemos pulsado ahora, para utilizarlo al presionar el botón de aceptar
        } else if (e.getSource() == jbBaja) {
            JOptionPane.showMessageDialog(rootPane, "Introduce el dni del cliente que quieres borrar");
            editarSoloDni(true);
            // jtaDni.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            borrarTexto();
            setJbPulsado(jbBaja);

        } else if (e.getSource() == jbConsulta) {
            JOptionPane.showMessageDialog(rootPane, "Introduce el dni del cliente que quieres consultar");
            editarSoloDni(true);
            borrarTexto();
            setJbPulsado(jbConsulta);

        } else if (e.getSource() == jbModificar) {
            borrarTexto();
            editarSoloDni(true);
            JOptionPane.showMessageDialog(rootPane, "Introduce primero el dni, acepta e introduce los datos nuevos.");
            setJbPulsado(jbModificar);

        } else if (e.getSource() == jbAdelante) {

        } else if (e.getSource() == jbAtras) {

        } else if (e.getSource() == jbAceptar) {
            accionesAceptar();
        }
    }

    public void accionesAceptar() {
        //Hay que comprobar qué botón hemos pulsado antes para saber qué es lo que tiene que pasar al aceptar en cada caso
        if (jbPulsado == jbAlta) {
            //tras escribir los datos, si le damos a aceptar, crea un nuevo cliente y lo da de alta
            cursor.alta(crearCliente());
            JOptionPane.showMessageDialog(rootPane, "Se ha dado de alta.");

        } else if (jbPulsado == jbBaja) {
            //al aceptar borra el cliente que hemos señalado
            Cliente aux = new Cliente();
            aux.setDni(jtaDni.getText());
            cursor.baja(aux);
            JOptionPane.showMessageDialog(rootPane, "Se ha dado de baja.");

        } else if (jbPulsado == jbConsulta) {
            Cliente aux = new Cliente();
            aux.setDni(jtaDni.getText());
            rellenarConDatosCliente(cursor.consulta(aux)); //Se rellenan los campos con los datos del ciente

        } else if (jbPulsado == jbModificar) {
            Cliente viejo = new Cliente();
            viejo.setDni(jtaDni.getText());
            borrarTexto();
            permitirEditarTodo(true);
            //Tras introducir los datos del cliente viejo, aceptamos y llamamos a este metodo
            aceptarAlModificar2(viejo);

        }
    }

    public void aceptarAlModificar2(Cliente viejo) {
        //Método que actúa cuando pulsamos por segunda vez en aceptar
        //recibe el cliente viejo y crea uno nuevo a partir de los datos que hemos metido.
        cursor.modificar(crearCliente(), viejo);
        JOptionPane.showMessageDialog(rootPane, "Se ha modificado el cliente.");
        borrarTexto();
    }

    @Override
    public void windowOpened(WindowEvent e
    ) {
        //cursor.leerRegistro();
    }

    @Override
    public void windowClosing(WindowEvent e
    ) {
        cursor.escribirRegistro();

    }

    @Override
    public void windowClosed(WindowEvent e
    ) {

    }

    @Override
    public void windowIconified(WindowEvent e
    ) {
    }

    @Override
    public void windowDeiconified(WindowEvent e
    ) {
    }

    @Override
    public void windowActivated(WindowEvent e
    ) {
    }

    @Override
    public void windowDeactivated(WindowEvent e
    ) {
    }

}
