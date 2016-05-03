/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.archivos.interface1;

import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

/**
 *
 * @author VESPERTINO
 */
public class Gui extends JInternalFrame implements ActionListener, InternalFrameListener {

    private JLabel jlDni, jlNombre, jlApellido;
    private JTextArea jtDni, jtNombre, jtApeliddo;
    private JPanel jpFlow, jpGrid;
    private Image img1, img2, img3, img4, img5, img6, img7;
    private JButton[] jbottons;
    private JButton jbBotonAnteriorPulsado;
    private Image imgs[];
    private Yates yates;
    private ImplementacionDAOObjectStream implementacion;
    private int dniTemporal = -1;

    public Gui() {
        //Me creo un objeto de cursorCliente
        implementacion = new CursorCliente();
        //inicializo los 2 arrays
        jbottons = new JButton[7];
        imgs = new Image[7];
        //Me creo el panel que se situara arriba
        jpFlow = new JPanel(new FlowLayout());
        try {
            for (int i = 0; i < imgs.length; i++) {
                //Me creo un string para poder tener la ruta bien
                String aux = i + ".png";
                //añado a cada Image la ruta necesatio
                imgs[i] = ImageIO.read(getClass().getResource(aux));
                //Inicializo los botones y les asigno un icono
                jbottons[i] = new JButton();
                jbottons[i].setIcon(new ImageIcon(imgs[i]));
                //Los meto en el JPanel
                jbottons[i].addActionListener(this);
                jpFlow.add(jbottons[i]);
            }
        } catch (Exception e) {
        }
        //Los 3  Jlabel
        jlDni = new JLabel("DNI :");
        jlNombre = new JLabel("Nombre :");
        jlApellido = new JLabel("Apellido :");
        //Los 3 JtextArea
        jtDni = new JTextArea();
        jtNombre = new JTextArea();
        jtApeliddo = new JTextArea();
        //Añadimos los componentes al panel que tiene el layout grid
        jpGrid = new JPanel(new GridLayout(3, 2, 10, 10));
        jpGrid.add(jlDni);
        jpGrid.add(jtDni);
        jpGrid.add(jlNombre);
        jpGrid.add(jtNombre);
        jpGrid.add(jlApellido);
        jpGrid.add(jtApeliddo);
        //Suscribimos al panel This al Windowlistener
        this.addWindowListener(this);
        //Añadimos los jpanel al Jframe
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jpFlow, BorderLayout.NORTH);
        getContentPane().add(jpGrid, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void vaciarTextAreas(JButton a) {
        jtDni.setText("");
        jtNombre.setText("");
        jtApeliddo.setText("");
        jbBotonAnteriorPulsado = a;
    }

    public void rellenarInical() {
        Cliente clienteAux = cursorCliente.posicionInicial();
        if (clienteAux != null) {
            jtDni.setText(clienteAux.getDni() + "");
            jtNombre.setText(clienteAux.getNombre());
            jtApeliddo.setText(clienteAux.getApellidos());
        } else {
            jtDni.setText("objeto a null");
            jtNombre.setText("objeto a null");
            jtApeliddo.setText("objeto a null");
        }
    }

    public void rellenarTextAreas(Cliente c) {
        if (c != null) {
            jtDni.setText(c.getDni() + "");
            jtNombre.setText(c.getNombre());
            jtApeliddo.setText(c.getApellidos());
        } else {
            jtDni.setText("No hay objetos en la coleccion");
            jtNombre.setText("No hay objetos en la coleccion");
            jtApeliddo.setText("No hay objetos en la coleccion");
        }
    }

    //Agrupar texareas en un objeto de tipo cliente
    public Cliente AgruparTextAreas() {
        if ((jtDni.getText() != "") && (jtNombre.getText() != "") && (jtApeliddo.getText() != "")) {
            int dniNumero = Integer.parseInt(jtDni.getText());
            return cliente = new Cliente(dniNumero, jtNombre.getText(), jtApeliddo.getText());
        } else {
            mensajePantalla("No puedo guardar un cliente sin TODOS datos");
            return null;
        }
    }

    public JButton getJbBotonAnteriorPulsado() {
        return jbBotonAnteriorPulsado;
    }

    public void setJbBotonAnteriorPulsado(JButton jbBotonAnteriorPulsado) {
        this.jbBotonAnteriorPulsado = jbBotonAnteriorPulsado;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jbottons[0]) {
            //Boton es Alta
            vaciarTextAreas(jbottons[0]);
        } else if (ae.getSource() == jbottons[1]) {
            //Boton es baja
            setJbBotonAnteriorPulsado(jbottons[1]);
            interfazOK();
        } else if (ae.getSource() == jbottons[2]) {
            //Boton Modificacion,como voy a necesitar el dni anterior me guardo el objeto antes de vaciar el texarea
            setJbBotonAnteriorPulsado(jbottons[2]);
            dniTemporal = Integer.parseInt(jtDni.getText());
            //vaciarTextAreas(jbottons[2]);
        } else if (ae.getSource() == jbottons[3]) {
            vaciarTextAreas(jbottons[3]);
        } else if (ae.getSource() == jbottons[4]) {
            setJbBotonAnteriorPulsado(jbottons[4]);
            Cliente auxCliente = cursorCliente.posicionAnterior(AgruparTextAreas());
            if (auxCliente != null) {
                rellenarTextAreas(auxCliente);
            } else {
                mensajePantalla("No hay mas registros en esa direccion");
            }

        } else if (ae.getSource() == jbottons[5]) {
            System.out.println("Has pulsado flecha");
            setJbBotonAnteriorPulsado(jbottons[5]);
            Cliente auxCliente = cursorCliente.posicionPosterior(AgruparTextAreas());
            if (auxCliente != null) {
                rellenarTextAreas(auxCliente);
            } else {
                mensajePantalla("No hay mas registros en esa direccion");
            }

        } else if (ae.getSource() == jbottons[6]) {
            interfazOK();
        }
    }

    public void interfazOK() {
        if (jbBotonAnteriorPulsado == jbottons[0]) {
            cursorCliente.alta(AgruparTextAreas());
        } else if (jbBotonAnteriorPulsado == jbottons[1]) {
            if (cursorCliente.baja(AgruparTextAreas())) {
                mensajePantalla("Borrado con exito");
            }
            vaciarTextAreas(jbottons[1]);
            rellenarInical();
        } else if (jbBotonAnteriorPulsado == jbottons[2]) {
            if (dniTemporal >= 0) {
                if (cursorCliente.modificacion(dniTemporal, AgruparTextAreas())) {
                    rellenarInical();
                }
                dniTemporal = -1;
            } else {
                mensajePantalla("No se puede realizar por que el dni esta mal");
            }
        } else if (jbBotonAnteriorPulsado == jbottons[3]) {
            rellenarTextAreas(cursorCliente.consulta(AgruparTextAreas()));
        }
    }

    public void mensajePantalla(String s) {
        JOptionPane.showMessageDialog(this, s);
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
