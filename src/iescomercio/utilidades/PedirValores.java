/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.utilidades;

import java.util.Scanner;

/**
 *
 * @author VESPERTINO
 */
public class PedirValores {
    public static String pedirString(){
        Scanner s = new Scanner(System.in);
        String palabra = s.nextLine();
        return palabra;        
    }

    public static int pedirInt(){
        Scanner i = new Scanner(System.in);
        int integer = i.nextInt();
        return integer;
    }
    
    //Ambos incluidos
    public static int pedirAleatorioInt(int min,int max){   
        int num=(int) Math.floor(Math.random()*(min-(max+1))+(max+1));
        return num;
       
       
    }
//le pasas el numero de digitos que el va a rellenar con numeros aleatorios entre 0 y 9 incluidos    
    public static long pedirAleatorioLong(int numeroDeDigitos){ 
        long numeroFinal=0;
        StringBuilder numAleatorio=new StringBuilder();
        for (int i=0;i<numeroDeDigitos;i++){
            int num3 = (int) (Math.random()*10+0);
            numAleatorio.append(num3);          
        } 
        if(Utilidades.compruebaNumerosEnterosCero(numAleatorio.toString())==true){
            numeroFinal=Long.valueOf(numAleatorio.toString());            
        }
         return numeroFinal;
    }
   
    public static void main(String[] args) {
        System.out.println( pedirAleatorioInt(8,9));
         System.out.println( pedirAleatorioInt(7,9));
    }
}