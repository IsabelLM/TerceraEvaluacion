/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomerico.tema9.exception.log;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author VESPERTINO
 */
public class Log {
    
    private LinkedHashMap<GregorianCalendar, String> mapa;
    private String nombre;
    
    public Log(String nombre) {
        mapa = new LinkedHashMap();
        this.nombre = nombre;
    }
    
    public void añadir(String mensaje) {
        GregorianCalendar gc = new GregorianCalendar();
        mapa.put(gc, mensaje);
    }
    
    @Override
    public String toString() {
        Set s = mapa.keySet();
        Iterator it = s.iterator();
        GregorianCalendar aux;
        String msj;
        StringBuilder sb = new StringBuilder();

        //cojo la primera clave de la colección Set
        while (it.hasNext()) {
            aux = (GregorianCalendar) it.next();
            msj = mapa.get(aux);
            sb.append(msj + "\n");
        }
        return sb.toString();
    }
    
    public void almacenaFichero() {
        Set s = mapa.keySet();
        Iterator it = s.iterator();
        GregorianCalendar aux;
        String msj;
        StringBuilder fecha = new StringBuilder();

        //cojo la primera clave de la colección Set
        while (it.hasNext()) {
            aux = (GregorianCalendar) it.next();
            msj = mapa.get(aux);
            fecha.append(aux.get(Calendar.DAY_OF_MONTH) + "/" + aux.get(Calendar.MONTH) + "/" + aux.get(Calendar.YEAR));
            //Metemos en el fichero aux + mensaje;
        }
    }
    //Abrir el fichero
    //Cargar toda la informacion que tiene en el mapa. 

    public void leerFichero() {
        
    }

    //Método que dada un String de tipo dd/mm/yyyy
    //Devuelve todos los mensajes de ese dia
    public String leerMensajes(String fecha) {
        Set s = mapa.keySet();
        Iterator it = s.iterator();
        GregorianCalendar aux;
        String fechaAux, f;
        StringBuilder mensaje = new StringBuilder();
        
        while (it.hasNext()) {
            aux = (GregorianCalendar) it.next();
            fechaAux = (aux.get(Calendar.DAY_OF_MONTH)
                    + "/" + aux.get(Calendar.MONTH)
                    + "/" + aux.get(Calendar.YEAR));
            
            if (fechaAux.equals(fecha)) {
                mensaje.append(mapa.get(aux) + "\n");
            } else {
                mensaje.append("No hay ningun error en esa fecha");
            }
        }
        return mensaje.toString();
    }
}
