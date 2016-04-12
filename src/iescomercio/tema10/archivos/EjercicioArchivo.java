/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.archivos;

import java.io.*;
import java.net.URL;

/**
 *
 * @author VESPERTINO
 */
public class EjercicioArchivo {
    /*Realizar un programa en Java que lea de un fichero de caracteres 
     con numeros y calcule y muestre esa suma*/

    public void leerFichero() throws IOException {
        int aux = 0, count = 0;
        FileInputStream fis = null;

       // URL url = getClass().getResource("/ficheros/numeros.txt"); 
        try {
            fis = new FileInputStream("E:/Users/VESPERTINO/Documents/Isabel/numeros.txt");
            while (fis.read() != -1) {
                aux = fis.read();
                count = count + aux;
            }
            fis.close();
            System.out.println(count);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        EjercicioArchivo ea = new EjercicioArchivo();

        ea.leerFichero();
    }

}
