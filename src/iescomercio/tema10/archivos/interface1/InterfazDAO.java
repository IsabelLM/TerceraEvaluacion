/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.archivos.interface1;

import java.util.ArrayList;

/**
 *
 * @author VESPERTINO
 */
public interface InterfazDAO {
    
    public boolean alta(Yates y);
    
    public boolean baja(Yates y);
    
    public boolean modificar(Yates nuevo, Yates viejo);
    
    public Yates consulta(Yates y);
    
    public Yates dameSiguiente(Yates y);
    
    public Yates dameAnterior(Yates y);
    
    public Yates posicionInicial();
    
    public ArrayList cargarDatos();
    
    public void salvarDatos();
}

