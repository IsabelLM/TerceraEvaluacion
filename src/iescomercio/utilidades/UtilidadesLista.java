/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.utilidades;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Isabel
 */
public class UtilidadesLista {
    public static void showLista(Collection collec){        
        int count=0;
        Iterator it = collec.iterator();
        while(it.hasNext()){
            
            System.out.println("(" + count+") "+it.next()); 
            count++;
        }  
        
    }    
   
    public static Collection borrarElemento(Collection collec,int numero){         
        Iterator it = collec.iterator();
        int count = 0;
        while (it.hasNext()) { 
            Object aux = it.next();
            if (count == numero) {
                collec.remove(aux);
                break;
            }
            count++;
        }             
       return collec;
    }
}
