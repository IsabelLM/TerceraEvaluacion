/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema11.singleton;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Run {

    public static void main(String[] args) {
        Connection con;
        try {
//            Class.forName("com.mysql.jdbc.Driver");
//             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/negocios2011?zeroDateTimeBehavior=convertToNull", "root", "");
            con = ConexionBD.getConexion();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT count(pc.idpedido),emp.nomempleado, year(pc.fechapedido) FROM  pedidoscabe pc natural join empleados emp group by emp.NOMEMPLEADO, year(pc.fechapedido) order by year(fechapedido)");

            while (rs.next()) {
                int nped = rs.getInt(1);
                String nemp = rs.getString("emp.nomempleado");
                int año = rs.getInt(3);
                System.out.println("Nº Pedidos: " + nped + " Nombre: " + nemp + " Año: " + año);
            }
            rs.close();
            stm.close();
            con.close();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
}
