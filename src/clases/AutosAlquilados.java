/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 *
 * @author pared
 */
public class AutosAlquilados extends Autos
{
  private int precioalquilada;
  private int horasalquiladas;
  private int horaspagar;
  
  public AutosAlquilados (String nombre, String apellido, String Cedula, String marca,String tipomarca, String fecha, int horasalquiladas, int precioalquilada)
{
   super(nombre, apellido, Cedula, marca, tipomarca, fecha);
   this.horasalquiladas = horasalquiladas;
   this.precioalquilada = precioalquilada;
}
  
    public int getPrecioalquilada() {
        return precioalquilada;
    }

    public void setPrecioalquilada(int precioalquilada) {
        this.precioalquilada = precioalquilada;
    }

    public int getHorasalquiladas() {
        return horasalquiladas;
    }

    public void setHorasalquiladas(int horasalquiladas) {
        this.horasalquiladas = horasalquiladas;
    }

    public int getHoraspagar() {
        return horaspagar;
    }

    public void setHoraspagar(int horaspagar) {
        this.horaspagar = horaspagar;
    }
  
   public void Operacion ()
    {
        int aux;
        aux = this.precioalquilada*this.horasalquiladas;
        this.setHoraspagar(aux);
    }
    
       public void guardar(ObjectOutputStream salida) throws IOException{
        salida.writeObject(this);
    }
}
