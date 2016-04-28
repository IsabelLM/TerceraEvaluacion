/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.archivos.datainputoutputstream;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VESPERTINO
 */
public class CursorCliente {

    private ArrayList<Cliente> arrayCursor;

    public CursorCliente() {
        this.arrayCursor = arrayCursor;
    }

    public boolean alta(Cliente c) {
        boolean aux = true;
        //comprobar si el cliente existe. 
        if (arrayCursor.add(c) == false) {
            aux = false;
        }
        return aux;
    }

    public boolean baja(Cliente c) {
        boolean aux = true;
        if (arrayCursor.contains(c)) {
            arrayCursor.remove(c);
        } else {
            aux = false;
        }
        return aux;
    }

    public void modificar(Cliente nuevo, Cliente viejo) {
        arrayCursor.add(arrayCursor.indexOf(viejo), nuevo);
    }

    public Cliente consulta(Cliente c) {
        return arrayCursor.get(arrayCursor.indexOf(c));
    }

    public void escribirRegistro() {
        DataOutputStream escribir = null;
        try {
            escribir = new DataOutputStream(new FileOutputStream("E:\\clientes.dat"));
            for (int i = 0; i < arrayCursor.size(); i++) {
                escribir.writeUTF(arrayCursor.get(i).getDni());
                escribir.writeUTF(arrayCursor.get(i).getNombre());
                escribir.writeUTF(arrayCursor.get(i).getApellido1());
                escribir.writeUTF(arrayCursor.get(i).getApellido2());
                escribir.writeLong(arrayCursor.get(i).getTelefono());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CursorCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CursorCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(CursorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void leerRegistro() {
        DataInputStream lectura = null;

        try {
            lectura = new DataInputStream(new FileInputStream("E:\\clientes.dat"));
            while (true) {
                alta(new Cliente(lectura.readUTF(), lectura.readUTF(), lectura.readUTF(), lectura.readUTF(), lectura.readLong()));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CursorCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CursorCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                lectura.close();
            } catch (IOException ex) {
                Logger.getLogger(CursorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
