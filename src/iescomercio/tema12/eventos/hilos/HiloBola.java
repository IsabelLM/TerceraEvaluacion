/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema12.eventos.hilos;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VESPERTINO
 */
public class HiloBola implements Runnable {

    private Bola b;

    public HiloBola(Bola b) {
        this.b = b;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                b.getJlbBola().setLocation(b.getJlbBola().getLocation().x + i, b.getJlbBola().getLocation().y);
                b.repaint();
                sleep(100);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloBola.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}