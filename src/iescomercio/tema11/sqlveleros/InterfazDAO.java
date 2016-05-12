/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iescomercio.tema11.sqlveleros;

/**
 *
 * @author VESPERTINO
 */
public interface InterfazDAO {
    public boolean alta(Object v);
    
    public boolean baja(Object v);
    
    public boolean modificar(Object vNuevo, Object vViejo);
    
    public Object consulta(Object v);
    
    public Object dameSiguiente(Object v);
    
    public Object  dameAnterior(Object v);
    
    public Object posicionInicial();
    
}
