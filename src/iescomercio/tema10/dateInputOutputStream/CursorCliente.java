/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.dateInputOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VESPERTINO
 */
public class CursorCliente {

    private ArrayList<Cliente> arrayList;

    public CursorCliente() {
        this.arrayList = arrayList;
    }

    public boolean alta(Cliente c) {
        boolean aux = true;
        //comprobar si el cliente existe. 
        if (arrayList.add(c) == false) {
            aux = false;
        }
        return aux;
    }

    public boolean baja(Cliente c) {
        boolean aux = true;
        if (arrayList.contains(c) == false) {
            aux = false;
        } else {
            arrayList.remove(arrayList.indexOf(c));
        }
        return aux;
    }

    public void modificar(Cliente nuevo, Cliente viejo) {
        arrayList.add(arrayList.indexOf(viejo), nuevo);
    }

    public void consulta(Cliente c) {
        arrayList.get(arrayList.indexOf(c));
    }

    public void escribirRegistro() {
        try {
            DataOutputStream escribir = new DataOutputStream(new FileOutputStream("E:\\clientes.dat"));
            Iterator it = arrayList.iterator();
            
            for (Iterator<Cliente> iterator = arrayList.iterator(); iterator.hasNext();) {
                Cliente next = iterator.next();
                escribir.writeChars(next.getDni());
                escribir.writeChars(next.getNombre());
                escribir.writeChars(next.getApellido1());
                escribir.writeChars(next.getApellido2());
                escribir.writeLong(next.getTelefono());
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CursorCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CursorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
