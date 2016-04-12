/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema12.eventos.hilos;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author VESPERTINO
 */
public class BolaMovimiento extends JFrame implements Runnable {

    private JPanel jpPanel;
    private JLabel jlbBola;

    public BolaMovimiento() {
        jpPanel = new JPanel();

        URL url = getClass().getResource("/imagenes/magic_ball.png");
        ImageIcon aux = new ImageIcon(url);
        jlbBola = new JLabel(aux);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(jpPanel);
        getContentPane().setPreferredSize(new Dimension(600, 400));

        jpPanel.setLayout(null);
        jpPanel.add(jlbBola);
        jlbBola.setBounds(10, 10, 10, 10);

        jpPanel.setFocusable(true);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void run() {
        int aux = 0;
        try {
            while (aux == 0) {
                    jlbBola.setLocation(jlbBola.getLocation().x + 1, jlbBola.getLocation().y);
                    repaint();
                    sleep(25);
                    if (jlbBola.getLocation().x == 600){
                        jlbBola.setLocation(jlbBola.getLocation().x -1, jlbBola.getLocation().y);
                    repaint();
                    sleep(25);
                    }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Bola.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        BolaMovimiento bm = new BolaMovimiento();
        Thread t = new Thread(bm);
        t.start();
    }
}
