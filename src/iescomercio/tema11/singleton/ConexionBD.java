/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema11.singleton;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VESPERTINO
 */
public class ConexionBD {

   private String login, password, direccion, bd, driver;
    private int puerto;
    private File cfg;
    private URL url;
    private FileReader fr;
    private BufferedReader br;
    private static Connection conexion;

    public static Connection getConexion() {
        if (conexion == null) {
            new ConexionBD();
        }
        return conexion;
    }

    private ConexionBD() {
        String tira;

        try {
            url = getClass().getResource("/ficheros/conf.ini");
            cfg = new File(url.getFile());
            fr = new FileReader(cfg);
            br = new BufferedReader(fr);

            String linea;
            String[] palabras;

            linea = br.readLine();
            while (linea != null) {

                palabras = linea.split("=");

                switch (palabras[0]) {
                    case "driver":
                        this.driver = palabras[1];
                        break;
                    case "direccion":
                        this.direccion = palabras[1];
                        break;
                    case "puerto":
                        this.puerto = Integer.parseInt(palabras[1]);
                        break;
                    case "bd":
                        this.bd = palabras[1];
                        break;
                    case "login":
                        this.login = palabras[1];
                        break;
                    case "password":
                        if (palabras.length == 2) {
                            this.password = palabras[1];
                        } else {
                            this.password = "";
                        }
                        break;
                    default:
                        break;
                }
                linea = br.readLine();
            }
            // Creamos conexion
            Class.forName(getDriver());
            tira = "jdbc:mysql://" + direccion + ":" + puerto + "/" + bd;
            conexion = DriverManager.getConnection(tira, getLogin(), getPassword());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public File getCfg() {
        return cfg;
    }

    public void setCfg(File cfg) {
        this.cfg = cfg;
    }

    public static void setConexion(Connection conexion) {
        ConexionBD.conexion = conexion;
    }
}
