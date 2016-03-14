/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.utilidadesArray;

import java.util.Random;

/**
 *
 * @author VESPERTINO
 */
public class UtilidadesArray {

    //Rellena un array float con números aleatorios
    public static void rellenaArrayConAleatorios(float[] datos, float inicio, float fin) {
        Random r = new Random();
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (float) Math.floor(Math.random() * (fin - inicio + 1) + inicio);
        }
    }

    public static void rellenaArrayConAleatoriosInt(int[] datos, int inicio, int fin) {
        Random r = new Random();
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int) Math.floor(Math.random() * (fin - inicio + 1) + inicio);
        }
    }

    //Generar numero aleatorio en array multidimensional
    public static void rellenaArrayConAleatoriosDosF(float[][] datos, float inicio, float fin) {
        Random r = new Random();
        for (int i = 0; i < datos.length; i++) {
            datos[i][i] = (float) Math.floor(Math.random() * (fin - inicio + 1) + inicio);
        }
    }

    public static void rellenaArrayConAleatoriosDosI(int[][] datos, int inicio, int fin) {
        Random r = new Random();
        for (int i = 0; i < datos.length; i++) {
            datos[i][i] = (int) Math.floor(Math.random() * (fin - inicio + 1) + inicio);
        }
    }


//Calcula la media del array
public static double calculaMedia(float[] datos) {
        double suma = 0;
        for (float i : datos) {
            suma = suma + i;
        }
        return suma / datos.length;
    }

    //Calcula el número máximo del array
    public static double calcularMaximo(float[] datos) {
        float max = Float.MIN_VALUE;
        for (float i : datos) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    public static double calcularMaximo(int[] datos) {
        int max = Integer.MIN_VALUE;
        for (int i : datos) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    //calcula el numero minimo de un array
    public static double calcularMinimo(float[] datos) {
        float min = Float.MAX_VALUE;
        for (float i : datos) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    public static double calcularMinimo(int[] datos) {
        int min = Integer.MAX_VALUE;
        for (int i : datos) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    public static void borrar(float[] datos, int posicion) {
        float x = Float.MAX_VALUE + 1;

        datos[posicion] = x;
    }

    public static int calculaIndiceMin(int[] datos) {
        int min = datos[0];
        if (datos.length > 1) {
            for (int i = 1; i < datos.length; i++) {
                if (datos[i] < min) {
                    min = i;
                }
            }
        }
        return min;
    }

    public static float calculaIndiceMin(float[] datos) {
        float min = datos[0];
        if (datos.length > 1) {
            for (int i = 1; i < datos.length; i++) {
                if (datos[i] < min) {
                    min = i;
                }
            }
        }
        return min;
    }

    //ordena de menor a mayor
    public static void ordenarArrayMenorMayor(int lista[]) {
        //Usamos un bucle anidado
        for (int i = 0; i < (lista.length - 1); i++) {
            for (int j = i + 1; j < lista.length; j++) {
                if (lista[i] > lista[j]) {
                    //Intercambiamos valores
                    int variableauxiliar = lista[i];
                    lista[i] = lista[j];
                    lista[j] = variableauxiliar;

                }
            }
        }
    }

    public static int[] ordenarArrayMayorMenor(int n[]) {
        int fin[] = new int[n.length];
        int cont, id;
        cont = id = 0;
        boolean salir = true;

        do {
            for (int i = 0; i < n.length; i++) {
                if (n[i] == calcularMaximo(n)) {
                    fin[id] = n[i];
                    n[i] = Integer.MIN_VALUE;
                    id++;
                    cont++;
                }
            }
            if (cont == n.length - 1) {
                break;
            }
        } while (salir != false);

        return fin;
    }

}
