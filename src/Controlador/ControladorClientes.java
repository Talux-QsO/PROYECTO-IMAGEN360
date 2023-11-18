
package Controlador;
//Librerias
import Vista.*;
import Modelo.Cliente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
public class ControladorClientes implements ActionListener{
    //Atributos
    Clientes vistaClientes;
    DefaultTableModel modelotabla;
    String[] TituloTabla = {"Id","Nombre","Telefono","Correo","Direccion"};
    
    //Constructor
    public ControladorClientes(Clientes vistaClientes){
        this.vistaClientes=vistaClientes;
        //Estamos indicando que cuando se presione algun boton se van a realizar ciertas acciones
        this.vistaClientes.jbtnRegistrar.addActionListener(this);
        modelotabla = new DefaultTableModel(null,TituloTabla);
        this.vistaClientes.jtblRegistrarClientes.setModel(modelotabla);
        this.vistaClientes.jbtnAtras.addActionListener(this);
    }
    void LimpiarEntradas(){
        this.vistaClientes.jtxtNombres.setText("");
        this.vistaClientes.jtxtTelefono.setText("");  
        this.vistaClientes.jtxtCorreo.setText("");
        this.vistaClientes.jtxtDireccion.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaClientes.jbtnRegistrar){
            Cliente cl = new Cliente();  
            cl.setNombre(vistaClientes.jtxtNombres.getText());
            cl.setTelefono(vistaClientes.jtxtTelefono.getText());
            cl.setDireccion(vistaClientes.jtxtDireccion.getText());
            cl.setCorreo(vistaClientes.jtxtCorreo.getText()); 
            modelotabla.addRow(cl.RegistrarDatos());
            //addRow: coloca un registro debajo del otro es como un append para el JTable
            LimpiarEntradas();
        }else if(e.getSource() == vistaClientes.jbtnAtras){
            Panel panel= new Panel();
            panel.setVisible(true); //para enlazar con el siguiente formulario
            panel.setLocationRelativeTo(null);
        this.vistaClientes.dispose();
        }
        }
    }
    

