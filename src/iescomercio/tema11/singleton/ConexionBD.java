/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema11.singleton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VESPERTINO
 */
public class ConexionBD {

    private String user, password, ip, puerto, linea;
    private static Connection miConnection;

    public static Connection getConfigurador() {
        if (miConnection == null) {
            new ConexionBD();
        }
        return miConnection;
    }

    private ConexionBD() {
        String linea;
        File f;
        FileReader fr = null;
        URL url;
        BufferedReader br = null;
        int cont = 0;

        url = getClass().getResource("/iescomercio/tema11/singleton/configuracion.txt");
        f = new File(url.getFile());

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            linea = br.readLine();
            while (linea != null) {
                switch (cont) {
                    case 0:
                        user = linea;
                        break;
                    case 1:
                        password = linea;
                        break;
                    case 2:
                        ip = linea;
                        break;
                    case 3:
                        puerto = linea;
                }
                cont++;
                linea = br.readLine();
            }

            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getIp() {
        return ip;
    }

    public String getPuerto() {
        return puerto;
    }
    
    @Override
    public String toString() {
        return "ConexionBD{" + "user=" + user + ", password=" + password + ", ip=" + ip + ", puerto=" + puerto + '}';
    }
    
    
}
