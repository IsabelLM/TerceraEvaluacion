/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.archivos.interface1;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VESPERTINO
 */
public class ImplementacionDAOObjectStream implements InterfazDAO {

    private ArrayList<Yates> arrayYates;
    private ObjectInputStream leer;
    private ObjectOutputStream escribir;

    public ImplementacionDAOObjectStream() {
        arrayYates = new ArrayList();
    }

    @Override
    public boolean alta(Yates y) {
        boolean aux = false;
        if (arrayYates.contains(y)) {
            return false;
        } else {
            arrayYates.add(y);
            return true;
        }
    }

    @Override
    public boolean baja(Yates y) {
        boolean aux = true;
        if (arrayYates.contains(y)) {
            arrayYates.remove(y);
        } else {
            aux = false;
        }
        return aux;
    }

    @Override
    public boolean modificar(Yates nuevo, Yates viejo) {

        if (arrayYates.contains(viejo)) {
            //DUDA ,aqui dejaria una posicion a null ¿para borrarlao correrla? -->arrayList.remove(null);
            //si pongo return al array list no funciona
            arrayYates.add(arrayYates.indexOf(viejo), nuevo);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Yates consulta(Yates y) {
        if (arrayYates.contains(y)) {
            return arrayYates.get(arrayYates.indexOf(y));
        } else {
            return null;
        }
    }

    @Override
    public Yates dameSiguiente(Yates y) {
        if (arrayYates.contains(y)) {
            int posicionActual = arrayYates.indexOf(y);
            int posicionPosterior = posicionActual + 1;

            try {
                return arrayYates.get(posicionPosterior);
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public Yates dameAnterior(Yates y) {
        if (arrayYates.contains(y)) {
            int posicionActual = arrayYates.indexOf(y);
            int posicionPosterior = posicionActual - 1;

            try {
                return arrayYates.get(posicionPosterior);
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public ArrayList cargarDatos() {

        try {
            leer = new ObjectInputStream(new FileInputStream("E:\\a.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("Fallo al abrir el archivo");
        } catch (IOException ex) {
            System.out.println("Fallo al abrir el archivo");
        }
        try {
            do {
                arrayYates.add((Yates) leer.readObject());
            } while (true);
        } catch (Exception exa) {
            System.out.println("Fallo al leer el objeto");
            try {
                leer.close();
            } catch (IOException ex) {
                System.out.println("Fallo al cerrar el archivo");
            }
        }

        return arrayYates;
    }

    @Override
    public void salvarDatos() {

        try {
            escribir = new ObjectOutputStream(new FileOutputStream("E:\\a.txt"));
        } catch (IOException ex) {
            Logger.getLogger(ImplementacionDAOObjectStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            escribir.writeObject(arrayYates);
        } catch (IOException ex) {
            Logger.getLogger(ImplementacionDAOObjectStream.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(ImplementacionDAOObjectStream.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Yates posicionInicial() {
        if (arrayYates.size() > 0) {
            return arrayYates.get(0);
        } else {
            return null;
        }
    }
}
