
package iescomercio.tema12.eventos.hilos;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author VESPERTINO
 */
public class Bola2 extends JFrame implements KeyListener, Runnable {

     //Creamos las variables que vamos a utilizar
    private JPanel jpPanel;
    private JLabel jlBola;
    private int nTecla;
    public static Bola2 b;
    
    public Bola2() {
        //Inicializamos el icono que vamos a poner en nuestro programa
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/ball.png"));
        jpPanel = new JPanel(); //Creamos un nuevo panel
        //Inicializamos la URL en la que tenemos nuestra imagen
        URL url = getClass().getResource("/imagenes/ball.png"); 
        ImageIcon bola = new ImageIcon(url); //Dicha imagen la inicializamos con la URL anterior
        jlBola = new JLabel(bola); //Inicializamos el JLabel con nuestra imagen
        
        //Hacemos el Layout de tipo BoxLayout con horientación vertical
        getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(jpPanel); //Añadimos el JPanel a la ventana
        getContentPane().setPreferredSize(new Dimension(500, 500)); //Damos unas dimensiones a nuestra ventana
                    
        //Nuestro JPanel lo vamos a hacer de tipo "null"
        jpPanel.setLayout(null);
        jpPanel.add(jlBola); //Añadimos el JLabel "jlBola"
        jlBola.setBounds(230, 230, 40, 40); //Le damos unas coordenadas inicialies a nuestro JLabel
        jpPanel.setFocusable(true); //Esto hace que los eventos de key puedan ser visibles
        
        jpPanel.addKeyListener(this); //Añadimos los eventos que vienen abajo a nuestro JPanel
        
        pack(); //Empaquetamos nuestra ventana
        setIconImage(icon); //Hacemos visible nuestro icono
        setTitle("Bola en movimiento"); //Ponemos titulo a nuestra ventana
        setVisible(true); //Hacemos visible la ventana
        setLocationRelativeTo(null); //Centramos la ventana
        setResizable(false); //Hacemos que no se pueda encoger ni expandir la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Hacemos que se cierre el programa a cerrar la ventana
    }
    
    public static void main(String[] args) {
        b = new Bola2(); //Inicializamos una variable estática de tipo "Bola"
    }
    

    @Override
    public void keyPressed(KeyEvent e) {
        nTecla = e.getKeyCode(); //Registramos la tecla pulsada
        Thread t = new Thread(b); //Inicializamos un hilo
        
        //Estos ifs que vienen a continuación hacen que dependiendo de la tecla que pulsemos, realizara diferentes funciones
        //solo estan inicializadas las flechas (arriba, abajo, derecha e izquierda).
        //Los ifs de su interior, hacen que la bola que moveremos, no salga del margen y desaparezca
        //Los "t.start()" de cada if, hace que se ejecute los hilos del metodo "run"
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(jlBola.getLocation().y > 0){
                t.start();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(jlBola.getLocation().y < 470){
                t.start();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(jlBola.getLocation().x < 470){
                t.start();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(jlBola.getLocation().x > 0){
                t.start();
            }
        }
    }
    
    //Estos métodos no los vamos a utilizar en este programa
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

    @Override
    public void run() {
        //En estos ifs, dependiendo de la tecla de las flechas que pulsemos, se movera la bola un pixer hacia el lado que 
        //indiquemos, el "sleep()" hace que este movimiento tarde un poco mas y de una sensación de movimiento mas real
        try {
            if(nTecla == 38){
                for(int i=0;i<5;i++){
                    jlBola.setLocation(jlBola.getLocation().x, jlBola.getLocation().y - i);
                    repaint();
                    sleep(25);
                }
            }else if(nTecla == 40){
                for(int i=0;i<5;i++){
                    jlBola.setLocation(jlBola.getLocation().x, jlBola.getLocation().y + i);
                    repaint();
                    sleep(25);
                }
            }else if(nTecla == 39){
                for(int i=0;i<5;i++){
                    jlBola.setLocation(jlBola.getLocation().x + i, jlBola.getLocation().y);
                    repaint();
                    sleep(25);
                }
            }else if(nTecla == 37){
                for(int i=0;i<5;i++){
                    jlBola.setLocation(jlBola.getLocation().x - i, jlBola.getLocation().y);
                    repaint();
                    sleep(25);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Bola.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

