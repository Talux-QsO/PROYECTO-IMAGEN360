
package Principal;
//LIBRERIAS
import Controlador.*;
import Modelo.*;
import Vista.*;
public class Main {
    static Vista_Producto producto;
    static ControladorProducto controladorProducto;
    static Empleados empleados;
    static ControladorEmpleados controladorEmpleados;
    static Panel panel;
    static ControladorPanel controladorpanel;
    static Usuario us;
    static LoginFormulario f1;
    static ControladorLogin controlf1;
    static Clientes clientes;
    static ControladorClientes controladorClientes;
    public static void main(String[] args) {
        //mostramos el formulario
        f1= new LoginFormulario();
        controlf1 = new ControladorLogin(us,f1);
        panel = new Panel();
        controladorpanel = new ControladorPanel(panel);
        clientes = new Clientes();
        controladorClientes = new ControladorClientes(clientes);
        empleados = new Empleados();
        controladorEmpleados = new ControladorEmpleados(empleados);
        producto = new Vista_Producto();
        controladorProducto = new ControladorProducto(producto);
    }
    
}
