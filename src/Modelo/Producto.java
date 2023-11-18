
package Modelo;

public class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio_venta;
    private int stock;
    
    public Producto() {}

    public Producto(String codigo, String nombre,String descripcion, double precio_venta, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_venta = precio_venta;
        this.stock = stock;
    }   

    public String getCodigo() {return codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public double getPrecio_venta() {return precio_venta;}
    public void setPrecio_venta(double precio_venta) {this.precio_venta = precio_venta;}
    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}
       
    //Creamos  un object[]
     public Object[] RegistrarDatos(){
        Object[] fila = {codigo,nombre,descripcion,precio_venta,stock};
    return fila;
    }
}
