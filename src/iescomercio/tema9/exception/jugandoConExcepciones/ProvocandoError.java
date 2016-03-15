/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema9.exception.jugandoConExcepciones;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 *
 * @author VESPERTINO
 */
public class ProvocandoError {

    public ProvocandoError() {
    }

    public ProvocandoError(File aFile) throws Exception {
        try {
            if (aFile == null) {
                throw new Exception("No me puedes pasar un null");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
