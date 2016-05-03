/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.archivos.interface1;

import java.util.ArrayList;

/**
 *
 * @author VESPERTINO
 */
public class ImplementacionDAOObjectStream implements InterfazDAO {

    private ArrayList<Yates> arrayYates;

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
    public void modificar(Yates nuevo, Yates viejo) {
        arrayYates.add(arrayYates.indexOf(viejo), nuevo);

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
    public void cargarDatos() {
    }

    @Override
    public void salvarDatos() {
    }

}
