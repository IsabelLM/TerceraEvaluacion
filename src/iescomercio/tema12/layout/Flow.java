/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema12.layout;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author VESPERTINO
 */

/*El FlowLayout es bastante sencillo de usar. 
 Nos coloca los componente en fila. Hace que todos quepan 
 (si el tamaño de la ventana lo permite). Es adecuado para barras de herramientas,
 filas de botones, etc.
 */
public class Flow extends JFrame {

    private javax.swing.JButton jb1, jb2, jb3, jb4;

    public Flow() {
        //Poner el layout que queremos utilizar. En este caso uno de tipo Flow
        this.getContentPane().setLayout(new FlowLayout());

        //instanciar componentes
        jb1 = new JButton("boton 1");
        jb2 = new JButton("boton 2");
        jb3 = new JButton("boton 3");
        jb4 = new JButton("boton 4");

        //Meter los botones
        add(jb1);
        add(jb2);
        add(jb3);
        add(jb4);
        //Empaqueta los botones en el JFrame
        pack();
        //Mostramos la ventana
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Flow f = new Flow();
    }

}
