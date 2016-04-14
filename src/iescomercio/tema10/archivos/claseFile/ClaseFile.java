/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.archivos.claseFile;

import java.io.File;

/**
 *
 * @author VESPERTINO
 */
public class ClaseFile {

    private File f;

    public ClaseFile() {

    }

    public void propiedadesArchivo(String nombre) {
        f = new File("E:\\EjercicioProgramacion\\" + nombre);
        System.out.println("El nombre del archivo es: " + f.getName());
        System.out.println("El path del archivo es: " + f.getPath());
        System.out.println("El tamaño del archivo es: " + f.length());
        System.out.println("Tiene permisos de lectura? " + f.canRead());
        System.out.println("Es ejecutable?: " );
    }

    public void propiedadesDirectorio(String nombre) {
        f = new File("E:\\EjercicioProgramacion\\" + nombre);
        if(f.isDirectory()){
            for (int i = 0; i < f.listFiles().length; i++) {
                System.out.println(f.listFiles()[i]);
                
            }


        }
    }

}
