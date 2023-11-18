
package Modelo;

public class Cliente {
    private int idCliente ;
    private String nombre;
    private String telefono;
    private String direccion;
    private String correo;
    static int contador=0;

    public Cliente(){
        contador++;
    }
    

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public String getCorreo() {return correo;}
    public void setCorreo(String correo) { this.correo = correo;}
     //Creamos  un object[]
    public Object[] RegistrarDatos(){
        Object[] fila = {contador,nombre,telefono,direccion,correo};
    return fila;
    }

    public int getIdCliente() {return idCliente;}

    public void setIdCliente(int idCliente) {this.idCliente = idCliente;}
}
