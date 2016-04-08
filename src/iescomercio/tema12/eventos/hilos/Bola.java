/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema12.eventos.hilos;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author VESPERTINO
 */
public class Bola extends JFrame implements KeyListener {

    private JPanel jpPanel;
    private JLabel jlbBola;

    public Bola() throws HeadlessException {
        jpPanel = new JPanel();

        URL url = getClass().getResource("/imagenes/ball.png");
        ImageIcon aux = new ImageIcon(url);
        jlbBola = new JLabel(aux);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(jpPanel);
        getContentPane().setPreferredSize(new Dimension(300, 200));

        jpPanel.setLayout(null);
        jpPanel.addKeyListener(this);

        jpPanel.add(jlbBola);
        jlbBola.setBounds(10, 10, 10, 10);

        jpPanel.setFocusable(true);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

//    public JPanel getJpPanel() {
//        return jpPanel;
//    }
    
    public JLabel getJlbBola() {
        return jlbBola;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        HiloBola hb = new HiloBola(this);
        Thread t = new Thread(hb);
        t.start();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        Bola b = new Bola();
    }
}
