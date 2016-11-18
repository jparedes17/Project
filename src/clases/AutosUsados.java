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
public class AutosUsados extends Autos
{
   private String codigo;
   private String telefono;
   private String precio;
   private int nollantas;
   private Autos auto;
   
   public AutosUsados (String codigo, String marca, String tipomarca, String modelo, int nodueños, int nollantas, String precio)
   {
      super(modelo, marca, nodueños, tipomarca);
      this.codigo = codigo;
      this.nollantas = nollantas;
      this.precio = precio;
   }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getNollantas() {
        return nollantas;
    }

    public void setNollantas(int nollantas) {
        this.nollantas = nollantas;
    }

    public Autos getAuto() {
        return auto;
    }

    public void setAuto(Autos auto) {
        this.auto = auto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
   public void guardar(ObjectOutputStream salida) throws IOException{
        salida.writeObject(this);
    }
    
}
