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
public class Autos implements java.io.Serializable{
      private String nombre;
      private String apellido;
      private String Cedula;
      private String sexo;
      private String Modelo;
      private String Marca;
      private String precio;
      private String tipomarca;
      private String telefono;
      private String fecha;
      private int nodueños;

    public Autos(String nombre, String apellido, String cedula) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.Cedula = cedula;
    }

    public Autos(String Modelo, String Marca, int nodueños, String tipomarca) {
        this.Modelo = Modelo;
        this.Marca = Marca;
        this.tipomarca = tipomarca;
        this.nodueños = nodueños;
    }
    
    
 public Autos(String Modelo, String Marca, String tipomarca, String precio) {
        this.Modelo = Modelo;
        this.Marca = Marca;
        this.tipomarca = tipomarca;
        this.precio = precio;
    }
 
  public Autos(String nombre, String apellido, String Cedula, String marca, String modelo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.Cedula = Cedula;
        this.Marca = marca;
        this.Modelo = modelo;
  }

    public Autos(String nombre, String apellido, String Cedula, String Marca, String tipomarca, String fecha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.Cedula = Cedula;
        this.Marca = Marca;
        this.tipomarca = tipomarca;
        this.fecha = fecha;
    }

    public int getNodueños() {
        return nodueños;
    }

    public void setNodueños(int nodueños) {
        this.nodueños = nodueños;
    }

    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
 
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
  
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getTipomarca() {
        return tipomarca;
    }

    public void setTipomarca(String tipomarca) {
        this.tipomarca = tipomarca;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
       public void guardar(ObjectOutputStream salida) throws IOException{
        salida.writeObject(this);
    }
    
    }
    

