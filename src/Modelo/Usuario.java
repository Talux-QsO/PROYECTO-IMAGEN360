
package Modelo;

public class Usuario {
    private int id;
    private String usuario;
    private String nombre;
    private String contraseña;
    private String caja;
    private String rol;
    private String estado;
    public Usuario() {
    } 
    public Usuario(int id, String usuario, String nombre, String contraseña, String caja, String rol, String estado) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.caja = caja;
        this.rol = rol;
        this.estado = estado;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getUsuario() {return usuario;}
    public void setUsuario(String usuario) {this.usuario = usuario;}
    public String getNombre() {return nombre; }
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getContraseña() {return contraseña;}
    public void setContraseña(String contraseña) {this.contraseña = contraseña;}
    public String getCaja() {return caja;}
    public void setCaja(String caja) {this.caja = caja;}
    public String getRol() {return rol;}
    public void setRol(String rol) {this.rol = rol;}
    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}
   
}
