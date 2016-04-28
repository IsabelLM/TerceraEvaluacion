/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.archivos.datainputoutputstream;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VESPERTINO
 */
public class CursorCliente implements Serializable {

    private ArrayList<Cliente> arrayCursor;

    public CursorCliente() {
        arrayCursor = new ArrayList();
    }

    public boolean alta(Cliente c) {
        boolean aux = false;
        if (arrayCursor.contains(c)) {
            return false;
        } else {
            arrayCursor.add(c);
            return true;
        }
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
        DataOutputStream escritor = null;
        try {
            escritor = new DataOutputStream(new FileOutputStream("E:\\clientes.dat"));
            for (Iterator<Cliente> iterator = arrayCursor.iterator(); iterator.hasNext();) {
                Cliente next = (Cliente) iterator.next();
                escritor.writeUTF(next.getDni());
                escritor.writeUTF(next.getNombre());
                escritor.writeUTF(next.getApellido1());
                escritor.writeUTF(next.getApellido2());
                escritor.writeLong(next.getTelefono());
            }
        } catch (IOException ex) {
            Logger.getLogger(CursorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void leerRegistro() {
        Cliente cliente = null;
        DataInputStream lectura = null;
        try {
            lectura = new DataInputStream(new FileInputStream("E:\\clientes.dat"));
            do {
                cliente = new Cliente(lectura.readUTF(), lectura.readUTF(), lectura.readUTF(), lectura.readUTF(), lectura.readLong());
                arrayCursor.add(cliente);
            } while (true);
        } catch (EOFException ex) {
            try {
                lectura.close();
            } catch (IOException ex1) {
                Logger.getLogger(CursorCliente.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (FileNotFoundException ex) {
            try {
                lectura.close();
            } catch (IOException ex1) {
                Logger.getLogger(CursorCliente.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (IOException ex) {
            Logger.getLogger(CursorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return "CursorCliente{" + "arrayCursor=" + arrayCursor + '}';
    }
    
    
}
