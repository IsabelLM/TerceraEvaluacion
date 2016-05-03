/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema10.archivos.interface1;

/**
 *
 * @author VESPERTINO
 */
public interface InterfazDAO {
    
    public boolean alta(Yates y);
    
    public boolean baja(Yates y);
    
    public void modificar(Yates nuevo, Yates viejo);
    
    public Yates consulta(Yates y);
    
    public Yates dameSiguiente(Yates y);
    
    public Yates dameAnterior(Yates y);
    
    public void cargarDatos();
    
    public void salvarDatos();
}

