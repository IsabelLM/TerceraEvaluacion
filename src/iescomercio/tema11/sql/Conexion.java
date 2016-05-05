/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema11.sql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VESPERTINO
 */
public class Conexion {

    public static void main(String[] args) {
        Connection con;

        try {

            //cargar drive
            Class.forName("com.mysql.jdbc.Driver");

            //obtener conexion            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/negocios2011?zeroDateTimeBehavior=convertToNull", "root", "");

            //Cursor
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT nomempleado, idempleado from empleados");

            while (rs.next()) {
                String s = rs.getString("nomempleado");
                int i = rs.getInt("idempleado");
                System.out.println("Nombre: " + s + " Id: " + i);
            }

            rs.close();
            stm.close();
            con.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
