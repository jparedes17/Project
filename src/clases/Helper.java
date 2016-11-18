/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import interfaz.AgregarAutosUsados;
import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author pared
 */
public class Helper {
    public static void mensaje(Component ventana, String mensaje, int tipo) {
        switch (tipo) {
            case 1:
                JOptionPane.showMessageDialog(ventana, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(ventana, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(ventana, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                break;

        }
    }
    
    public static void limpiadoTabla(JTable tabla1) {
        int nf, nc;
        nc = tabla1.getColumnCount();
        nf = tabla1.getRowCount();
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {
                tabla1.setValueAt("", i, j);
            }
        }
    }

    public static void porDefectoTabla(JTable tabla1) {
        DefaultTableModel tm;
        tm = (DefaultTableModel) tabla1.getModel();
        tm.setColumnCount(0);
        tm.setRowCount(0);
    }
    
    public static void habilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(true);

        }
    }

    public static void deshabilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(false);

        }
    }
    
    public static void llenarTablaCarrosNuevos(JTable tabla, String ruta){
        DefaultTableModel tm;
        int nf;
        ArrayList <Autos> auto = traerDatos(ruta);
        tm = (DefaultTableModel)tabla.getModel();
        limpiadoTabla(tabla);
        nf = auto.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
           tabla.setValueAt(auto.get(i).getMarca(), i, 0);
           tabla.setValueAt(auto.get(i).getTipomarca(), i, 1);
           tabla.setValueAt(auto.get(i).getModelo(), i, 2);
           tabla.setValueAt(auto.get(i).getPrecio(), i, 3);
        }
    }
    
    public static void llenarTablaCarrosNuevos(JTable tabla, ArrayList <Autos> auto){
        DefaultTableModel tm;
        int nf;
        tm = (DefaultTableModel)tabla.getModel();
        limpiadoTabla(tabla);
        nf = auto.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
           tabla.setValueAt(auto.get(i).getMarca(), i, 0);
           tabla.setValueAt(auto.get(i).getTipomarca(), i, 1);
           tabla.setValueAt(auto.get(i).getModelo(), i, 2);
           tabla.setValueAt(auto.get(i).getPrecio(), i, 3);
        }
    }
    
   
    public static void llenarTablaAutosUsadosClientes(JTable tabla, String ruta){
        int nf;
        DefaultTableModel tm;
        ArrayList<AutosUsadosClientes> carros = traerDatos(ruta);
        tm = (DefaultTableModel)tabla.getModel();
        nf = carros.size();
        tm.setRowCount(nf);
        limpiadoTabla(tabla);
        for (int i = 0; i < nf; i++) {
           tm.setValueAt(carros.get(i).getCedula(), i, 0);
           tm.setValueAt(carros.get(i).getNombre(), i, 1);
           tm.setValueAt(carros.get(i).getApellido(), i, 2);
           tm.setValueAt(carros.get(i).getAuto().getMarca(), i, 3);
           tm.setValueAt(carros.get(i).getAuto().getTipomarca(), i, 4);
           tm.setValueAt(carros.get(i).getAuto().getModelo(), i, 5);
           tm.setValueAt(carros.get(i).getTelefono(), i, 6);
        }
    
    }
    
    public static void llenarTablaUsadosListar(JTable tabla, String ruta){
        int nf;
        DefaultTableModel tm;
        ArrayList<AutosUsados> carros = traerDatos(ruta);
        tm = (DefaultTableModel)tabla.getModel();
        nf = carros.size();
        tm.setRowCount(nf);
        limpiadoTabla(tabla);
        for (int i = 0; i < nf; i++) {
           tm.setValueAt(carros.get(i).getModelo(), i, 0);
           tm.setValueAt(carros.get(i).getCodigo(), i, 1);
           tm.setValueAt(carros.get(i).getMarca(), i, 2);
           tm.setValueAt(carros.get(i).getTipomarca(), i, 3);
           
           
        }
    }
    
    public static void llenarTablaUsadosListar(JTable tabla, ArrayList <AutosUsados> carros){
        int nf;
        DefaultTableModel tm;
        tm = (DefaultTableModel)tabla.getModel();
        nf = carros.size();
        tm.setRowCount(nf);
        limpiadoTabla(tabla);
        for (int i = 0; i < nf; i++) {
           tm.setValueAt(carros.get(i).getModelo(), i, 0);
           tm.setValueAt(carros.get(i).getCodigo(), i, 1);
           tm.setValueAt(carros.get(i).getMarca(), i, 2);
           tm.setValueAt(carros.get(i).getTipomarca(), i, 3);
           
           
        }
    }
    
    public static void llenarTablaAutosUsadosClientes(JTable tabla, ArrayList <AutosUsadosClientes> carros){
        int nf;
        DefaultTableModel tm;
        tm = (DefaultTableModel)tabla.getModel();
        nf = carros.size();
        tm.setRowCount(nf);
        limpiadoTabla(tabla);
        for (int i = 0; i < nf; i++) {
           tm.setValueAt(carros.get(i).getCedula(), i, 0);
           tm.setValueAt(carros.get(i).getNombre(), i, 1);
           tm.setValueAt(carros.get(i).getApellido(), i, 2);
           tm.setValueAt(carros.get(i).getAuto().getMarca(), i, 3);
           tm.setValueAt(carros.get(i).getAuto().getTipomarca(), i, 4);
           tm.setValueAt(carros.get(i).getAuto().getModelo(), i, 5);
           tm.setValueAt(carros.get(i).getTelefono(), i, 6);
        }
    }
    
     public static void llenarTablaAlquilar (JTable tabla, String ruta){
        DefaultTableModel tm;
        int nf;
        ArrayList <AutosAlquilados> auto = traerDatos(ruta);
        tm = (DefaultTableModel)tabla.getModel();
        limpiadoTabla(tabla);
        nf = auto.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
           tabla.setValueAt(auto.get(i).getNombre(), i, 0);
           tabla.setValueAt(auto.get(i).getApellido(), i, 1);
           tabla.setValueAt(auto.get(i).getCedula(), i, 2);
           tabla.setValueAt(auto.get(i).getMarca(), i, 3);
           tabla.setValueAt(auto.get(i).getFecha(), i, 4);
           tabla.setValueAt(auto.get(i).getHorasalquiladas(), i, 5);
           tabla.setValueAt(auto.get(i).getHoraspagar(), i, 6);
        }
     }
     
     public static void llenarTablaAlquilar (JTable tabla, ArrayList <AutosAlquilados> auto){
        DefaultTableModel tm;
        int nf;
        tm = (DefaultTableModel)tabla.getModel();
        limpiadoTabla(tabla);
        nf = auto.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
           tabla.setValueAt(auto.get(i).getNombre(), i, 0);
           tabla.setValueAt(auto.get(i).getApellido(), i, 1);
           tabla.setValueAt(auto.get(i).getCedula(), i, 2);
           tabla.setValueAt(auto.get(i).getMarca(), i, 3);
           tabla.setValueAt(auto.get(i).getFecha(), i, 4);
           tabla.setValueAt(auto.get(i).getHorasalquiladas(), i, 5);
           tabla.setValueAt(auto.get(i).getHoraspagar(), i, 6);
           tabla.setValueAt(auto.get(i).getTipomarca(), i, 7);
        }
     }
     
     public static void llenarTablaAutosNuevos(JTable tabla, String ruta){
        DefaultTableModel tm;
        int nf;
        ArrayList <Autos> auto = traerDatos(ruta);
        tm = (DefaultTableModel)tabla.getModel();
        limpiadoTabla(tabla);
        nf = auto.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
           tabla.setValueAt(auto.get(i).getNombre(), i, 0);
           tabla.setValueAt(auto.get(i).getApellido(), i, 1);
           tabla.setValueAt(auto.get(i).getCedula(), i, 2);
           tabla.setValueAt(auto.get(i).getMarca(), i, 3);
           tabla.setValueAt(auto.get(i).getModelo(), i, 4);
        }
     }
     
     public static void llenarTablaAutosNuevos(JTable tabla, ArrayList <Autos> auto){
        DefaultTableModel tm;
        int nf;
        tm = (DefaultTableModel)tabla.getModel();
        limpiadoTabla(tabla);
        nf = auto.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
           tabla.setValueAt(auto.get(i).getNombre(), i, 0);
           tabla.setValueAt(auto.get(i).getApellido(), i, 1);
           tabla.setValueAt(auto.get(i).getCedula(), i, 2);
           tabla.setValueAt(auto.get(i).getMarca(), i, 3);
           tabla.setValueAt(auto.get(i).getModelo(), i, 4);
        }
     }
     
     public static void llenarTabla(JTable tabla, ArrayList <Autos> auto){
        DefaultTableModel tm;
        int nf;
        tm = (DefaultTableModel)tabla.getModel();
        limpiadoTabla(tabla);
        nf = auto.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
           tabla.setValueAt(auto.get(i).getMarca(), i, 0);
           tabla.setValueAt(auto.get(i).getTipomarca(), i, 1);
           tabla.setValueAt(auto.get(i).getModelo(), i, 2);
           tabla.setValueAt(auto.get(i).getPrecio(), i, 3);
        }
    }
     
      public static void llenarTablaAutosUsados(JTable tabla, String ruta){
        DefaultTableModel tm;
        int nf;
        ArrayList <AutosUsados> auto = traerDatos(ruta);
        tm = (DefaultTableModel)tabla.getModel();
        limpiadoTabla(tabla);
        nf = auto.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
           tabla.setValueAt(auto.get(i).getCodigo(), i, 0);
           tabla.setValueAt(auto.get(i).getMarca(), i, 1);
           tabla.setValueAt(auto.get(i).getTipomarca(), i, 2);
           tabla.setValueAt(auto.get(i).getModelo(), i, 3);
           tabla.setValueAt(auto.get(i).getNodueños(), i, 4);
           tabla.setValueAt(auto.get(i).getNollantas(), i, 5);
           tabla.setValueAt(auto.get(i).getPrecio(), i, 6);
        }
    }
      
       public static void llenarTablaAutosUsados(JTable tabla, ArrayList <AutosUsados> auto){
        DefaultTableModel tm;
        int nf;
        tm = (DefaultTableModel)tabla.getModel();
        limpiadoTabla(tabla);
        nf = auto.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
           tabla.setValueAt(auto.get(i).getCodigo(), i, 0);
           tabla.setValueAt(auto.get(i).getMarca(), i, 1);
           tabla.setValueAt(auto.get(i).getTipomarca(), i, 2);
           tabla.setValueAt(auto.get(i).getModelo(), i, 3);
           tabla.setValueAt(auto.get(i).getNodueños(), i, 4);
           tabla.setValueAt(auto.get(i).getNollantas(), i, 5);
        }
    }
    
    public static ArrayList traerDatos(String ruta){
        FileInputStream archivo;
        ObjectInputStream entrada;
        ArrayList auto = new ArrayList();
        Object p;
        
        try {
            archivo = new FileInputStream(ruta);
            entrada = new ObjectInputStream(archivo);
            while((p=entrada.readObject())!=null){
                auto.add(p);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
             System.out.println(ex.getMessage());
        }
           return auto;
    } 
    
    public static void volcado(ObjectOutputStream salida,ArrayList personas ){
        for (int i = 0; i < personas.size(); i++) {
            try {
                salida.writeObject(personas.get(i));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
        }
    }
    
     public static void listadoPorModelo(JTable tabla, String ruta, String modelo ){
      ArrayList <AutosUsados> auto = traerDatos(ruta);
      ArrayList <AutosUsados> modelosFiltrados = new ArrayList();
        for (int i = 0; i < auto.size(); i++) {
            if (auto.get(i).getModelo().equals(modelo)){
                modelosFiltrados.add(auto.get(i));
            }
        }
        llenarTablaUsadosListar(tabla, modelosFiltrados);
    }
     
    public static void listadoPorMarca(JTable tabla, String ruta, String marca ){
      ArrayList <Autos> auto = traerDatos(ruta);
      ArrayList <Autos> marcasFiltradas = new ArrayList();
        for (int i = 0; i < auto.size(); i++) {
            if (auto.get(i).getMarca().equals(marca)){
                marcasFiltradas.add(auto.get(i));
            }
        }
        llenarTabla(tabla, marcasFiltradas);
    }
    
    public static boolean buscarAutoCedula(String cedula, String ruta) {
        ArrayList<Autos> auto = traerDatos(ruta);
        for (int i = 0; i < auto.size(); i++) {
            if (auto.get(i).getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
   }
    
    public static boolean buscarAutoCedulaUsados(String cedula, String ruta) {
        ArrayList<AutosUsadosClientes> auto = traerDatos(ruta);
        for (int i = 0; i < auto.size(); i++) {
            if (auto.get(i).getCedula().equals(cedula)){
                return true;
        }
        }
        return false;
    }
    
     public static boolean buscarAutoCodigoUsados(String codigo, String ruta) {
        ArrayList<AutosUsados> auto = traerDatos(ruta);
        for (int i = 0; i < auto.size(); i++) {
            if (auto.get(i).getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
   }
    
    public static boolean buscarAutoCedulaAlquilados(String cedula, String ruta) {
        ArrayList<AutosAlquilados> auto = traerDatos(ruta);
        for (int i = 0; i < auto.size(); i++) {
            if (auto.get(i).getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
   }
    
    public static Autos traerPersonaCedula(String cedula, String ruta){
         ArrayList<Autos> auto = traerDatos(ruta);
         for (int i = 0; i < auto.size(); i++) {
            if (auto.get(i).getCedula().equals(cedula)) {
                return auto.get(i);
            }
            
        }
         return null;
    }
    
     public static AutosUsados traerAutoCodigo(String codigo, String ruta){
         ArrayList<AutosUsados> auto = traerDatos(ruta);
         for (int i = 0; i < auto.size(); i++) {
            if (auto.get(i).getCodigo().equals(codigo)) {
                return auto.get(i);
            }
            
        }
         return null;
    }
     
     public static AutosUsadosClientes traerAutoUsadosCedula(String cedula, String ruta){
         ArrayList<AutosUsadosClientes> auto = traerDatos(ruta);
         for (int i = 0; i < auto.size(); i++) {
            if (auto.get(i).getCedula().equals(cedula)) {
                return auto.get(i);
            }
            
        }
         return null;
    }
    
    public static AutosAlquilados traerPersonaCedulaAlquilados(String cedula, String ruta){
         ArrayList<AutosAlquilados> auto = traerDatos(ruta);
         for (int i = 0; i < auto.size(); i++) {
            if (auto.get(i).getCedula().equals(cedula)) {
                return auto.get(i);
            }
            
        }
         return null;
    }
    
    public static ArrayList<Autos> modificarAuto(String ruta, String cedula,String nombre, String apellido){
         ArrayList<Autos> auto = traerDatos(ruta);
         for (int i = 0; i < auto.size(); i++) {
            if(auto.get(i).getCedula().equals(cedula)){
                auto.get(i).setNombre(nombre);
                auto.get(i).setApellido(apellido);
                return auto;
            }
         
        }
         return null;
    } 
    
    public static ArrayList<AutosUsados> modificarAuto(String ruta, String codigo, String marca, String tipomarca, String modelo, int nodueños, int nollantas, String precio){
         ArrayList<AutosUsados> auto = traerDatos(ruta);
         for (int i = 0; i < auto.size(); i++) {
            if(auto.get(i).getCodigo().equals(codigo)){
                auto.get(i).setMarca(marca);
                auto.get(i).setTipomarca(tipomarca);
                auto.get(i).setModelo(modelo);
                auto.get(i).setNodueños(nodueños);
                auto.get(i).setNollantas(nollantas);
                auto.get(i).setPrecio(precio);
                return auto;
            }
         
        }
         return null;
    } 
    
     public static ArrayList<AutosUsadosClientes> modificarAuto(String ruta, String cedula, String nombre, String apellido, AutosUsados auto, String telefono){
         ArrayList<AutosUsadosClientes> autos = traerDatos(ruta);
         for (int i = 0; i < autos.size(); i++) {
            if(autos.get(i).getCedula().equals(cedula)){
                autos.get(i).setNombre(nombre);
                autos.get(i).setApellido(apellido);
                autos.get(i).setAuto(auto);
                autos.get(i).setTelefono(telefono);
                return autos;
            }
         
        }
         return null;
    } 
    
    public static ArrayList<AutosAlquilados> modificarAuto(String ruta, String cedula,String nombre, String apellido, String marca, String tipomarca, String fecha, int horasalquilar, int precioalquilar){
         ArrayList<AutosAlquilados> auto = traerDatos(ruta);
         for (int i = 0; i < auto.size(); i++) {
            if(auto.get(i).getCedula().equals(cedula)){
                auto.get(i).setNombre(nombre);
                auto.get(i).setApellido(apellido);
                auto.get(i).setMarca(marca);
                auto.get(i).setTipomarca(tipomarca);
                auto.get(i).setFecha(fecha);
                auto.get(i).setHorasalquiladas(horasalquilar);
                auto.get(i).setPrecioalquilada(precioalquilar);
                

                return auto;
            }
         
        }
         return null;
    } 
        public static void llenarComboPersonas(JComboBox combo, String ruta){
        ArrayList<AutosUsados> autos = traerDatos(ruta);
        DefaultComboBoxModel dcbm = (DefaultComboBoxModel) combo.getModel();
        dcbm.removeAllElements();
        AutosUsados p;
        for (int i = 0; i < autos.size(); i++) {
            p = autos.get(i);
            dcbm.addElement(p.getCodigo()+" - "+p.getMarca()+" - "+p.getModelo());
        }
    }
    
}

