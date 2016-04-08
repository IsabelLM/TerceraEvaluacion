/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema12.eventos.raton.diana;

import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author VESPERTINO
 */
public class Diana extends JFrame implements MouseListener {

    private JLabel jlDiana;

    public Diana() {
        URL url = getClass().getResource("/imagenes/diana.jpg");
        ImageIcon aux = new ImageIcon(url);
        jlDiana = new JLabel(aux);
        getContentPane().setLayout(null);
        getContentPane().add(jlDiana);
        
        
        //this.setComponentZOrder(jlDiana, 1);
        
        
        jlDiana.setBounds(10, 10, aux.getIconWidth(), aux.getIconHeight());

        this.setSize(aux.getIconWidth() + 10, aux.getIconHeight() + 30);
        jlDiana.addMouseListener(this);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        URL url = getClass().getResource("/imagenes/DARDOS.png");
        ImageIcon aux = new ImageIcon(url);
        JLabel jlDardo = new JLabel(aux);

        jlDardo.setBounds(e.getX(), e.getY(), 48, 48);
        getContentPane().add(jlDardo);
        this.setComponentZOrder(jlDardo, 0);

        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        new Diana();

    }
}
