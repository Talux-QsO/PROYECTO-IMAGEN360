
package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.*;
import Controlador.*;
public class ControladorPanel implements ActionListener{
    
    private Panel vistapanel;
    
    public ControladorPanel(Panel vistapanel){
        this.vistapanel=vistapanel;
        this.vistapanel.jbtnEmpleados.addActionListener(this);
        this.vistapanel.jbtnClientes.addActionListener(this);
        this.vistapanel.jbtnProductos.addActionListener(this);
        this.vistapanel.jbtnNuevaVenta.addActionListener(this);
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Botón presionado: " + e.getActionCommand());
        if (e.getSource() == vistapanel.getjbtnClientes()) {
              System.out.println("Abriendo Clientes...");
            abrirClientes();
        } else if (e.getSource() == vistapanel.getjbtnEmpleados()) {
            System.out.println("Abriendo Empleados...");
            abrirEmpleados();
        } else if (e.getSource() == vistapanel.getjbtnProductos()) {
            System.out.println("Abriendo Productos...");
            abrirProductos();
        } else if (e.getSource() == vistapanel.getjbtnNuevaVenta()) {
            System.out.println("Abriendo Nueva Venta...");
            abrirNuevaVenta();
        }
    }
    private void abrirClientes(){   
        Clientes clie = new Clientes();
        ControladorClientes controladorClientes = new ControladorClientes(clie);
        clie.setVisible(true); //para enlazar con el siguiente formulario
        clie.setLocationRelativeTo(null);
        clie.setTitle("REGISTRO DE LOS CLIENTES");
        vistapanel.dispose();
    }
     private void abrirEmpleados() {
        Empleados empleados = new Empleados();
        empleados.setVisible(true);
        empleados.setLocationRelativeTo(null);
        empleados.setTitle("REGISTRO DE LOS EMPLEADOS");
        vistapanel.dispose();
    }
     private void abrirProductos() {
        Vista_Producto productos = new Vista_Producto();
        productos.setVisible(true);
        productos.setLocationRelativeTo(null);
        productos.setTitle("REGISTRO DE LOS PRODUCTOS");
        vistapanel.dispose();
    }

    private void abrirNuevaVenta() {
        Vista_Venta ventas = new Vista_Venta();
        ventas.setVisible(true);
        ventas.setLocationRelativeTo(null);
        ventas.setTitle("NUEVA VENTA");
        vistapanel.dispose();
    }
    
}
