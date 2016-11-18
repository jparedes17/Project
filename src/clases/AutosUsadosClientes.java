/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author pared
 */
public class AutosUsadosClientes extends Autos {
    private AutosUsados auto;
    private String telefono;
    
    public AutosUsadosClientes (String nombre, String apellido, String cedula, AutosUsados auto, String telefono){
       super(nombre, apellido, cedula);
       this.telefono = telefono;
       this.auto = auto;
   }

    public AutosUsados getAuto() {
        return auto;
    }

    public void setAuto(AutosUsados auto) {
        this.auto = auto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void guardar(ObjectOutputStream salida) throws IOException{
        salida.writeObject(this);
    }
}
