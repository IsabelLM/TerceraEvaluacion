/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.archivos.Buffered;

import java.io.*;
import java.net.URL;

/**
 *
 * @author VESPERTINO
 */
public class Ejercicio {

    public Ejercicio() throws FileNotFoundException, IOException {
        FileReader fr = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        BufferedReader br = null;
        File f;
        URL url;
        String linea;

        url = getClass().getResource("ficheros/4_CallejeroValencia.TXT");
        f = new File(url.getFile());
        fr = new FileReader(f);
        br = new BufferedReader(fr);
        linea = br.readLine();

        while (linea != null) {
            
            
        }

    }

}
