
package Modelo;

import java.text.DecimalFormat;

public class Empleado {
    private int idEmpleado;
    private String dni;
    private String nombre;
    private String apellido;
    private String cargo;
    static int contador=0;
    //Constructor
    public Empleado(){
        contador++;
    }
    public String getDni() {return dni;}
    public void setDni(String dni) {this.dni = dni;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public String getCargo() {return cargo;}
    public void setCargo(String cargo) {this.cargo = cargo;}

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Empleado.contador = contador;
    }
    
    //Metodo para el sueldo
    public double SueldoEmpleado(){
        if(cargo.equals("VENDEDOR")) return 1500;
        if(cargo.equals("ASISTENTE")) return 1100;
        return 0;
    }
     //Creamos  un object[]
    public Object[] RegistrarDatos(){
        DecimalFormat df = new DecimalFormat("S/ #0.00");
        Object[] fila = {contador,dni,nombre,apellido,cargo,df.format(SueldoEmpleado())};
    return fila;
    }
}
