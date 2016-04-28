/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.archivos.objectoutputstream;

import iescomercio.tema10.archivos.datainputoutputstream.Cliente;
import iescomercio.tema10.archivos.datainputoutputstream.CursorCliente;
import java.io.*;
import java.util.logging.*;

/**
 *
 * @author VESPERTINO
 */
public class Main {

    public static void main(String[] args) {
        try {
            ObjectOutputStream salida = null;
            ObjectInputStream lectura = null;
            CursorCliente cc = new CursorCliente();
            Cliente c = new Cliente("Isabel", "Lavieja", "Martin", "11616", 622622622);
            Cliente c2 = new Cliente("Daniel", "Mena", "Martin", "244", 63636363);
            
            cc.alta(c);
            cc.alta(c2);
            
            salida = new ObjectOutputStream(new FileOutputStream("E:\\clientes.txt"));
            salida.writeObject(cc);
            salida.close();
            
            lectura = new ObjectInputStream(new FileInputStream("E:\\clientes.txt"));
            try {
                CursorCliente c1 = (CursorCliente)lectura.readObject();
                System.out.println(c1.toString());
                lectura.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
