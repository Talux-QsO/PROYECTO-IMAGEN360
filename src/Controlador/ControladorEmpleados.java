
package Controlador;
//Librerias
import Vista.*;
import Modelo.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ControladorEmpleados implements ActionListener{
    //Atributos
    Empleados vistaEmpleados;
    DefaultTableModel modelotabla;
    String[] TituloTabla = {"Id","Dni","Nombre","Apellido","Cargo","Sueldo"};
    
    //Constructor
    public ControladorEmpleados(Empleados vistaEmpleados){
        this.vistaEmpleados=vistaEmpleados;
        //Estamos indicando que cuando se presione algun boton se van a realizar ciertas acciones
        this.vistaEmpleados.jbtnRegistrar.addActionListener(this);
        modelotabla = new DefaultTableModel(null,TituloTabla);
        this.vistaEmpleados.jtblRegistroEmpleados.setModel(modelotabla);
        this.vistaEmpleados.jbtnAtras.addActionListener(this);
        this.vistaEmpleados.jbtnActualizar.addActionListener(this);
        this.vistaEmpleados.jbtnEliminar.addActionListener(this);
    }
    void LimpiarEntradas(){
        this.vistaEmpleados.jtxtDni.setText("");
        this.vistaEmpleados.jtxtNombre.setText("");
        this.vistaEmpleados.jtxtApellido.setText(""); 
        this.vistaEmpleados.jcbxCargo.setSelectedIndex(0);
         this.vistaEmpleados.jtxtDni.requestFocus();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaEmpleados.jbtnRegistrar){
            Empleado emp = new Empleado(); 
            emp.setDni(vistaEmpleados.jtxtDni.getText());
            emp.setNombre(vistaEmpleados.jtxtNombre.getText());
            emp.setApellido(vistaEmpleados.jtxtApellido.getText());
            emp.setCargo(vistaEmpleados.jcbxCargo.getSelectedItem().toString());
            modelotabla.addRow(emp.RegistrarDatos());
            //addRow: coloca un registro debajo del otro es como un append para el JTable
            LimpiarEntradas();
        }else if(e.getSource() == vistaEmpleados.jbtnAtras){
            Panel panel= new Panel();
            panel.setVisible(true); //para enlazar con el siguiente formulario
            panel.setLocationRelativeTo(null);
            ControladorPanel controladorPanel = new ControladorPanel(panel);
        this.vistaEmpleados.dispose();
    }else if (e.getSource() == vistaEmpleados.jbtnEliminar) {
        // Lógica para eliminar un producto
        // En este ejemplo, se asume que hay al menos una fila seleccionada en la tabla
        int filaSeleccionada = vistaEmpleados.jtblRegistroEmpleados.getSelectedRow();
        if (filaSeleccionada != -1) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar al empleado", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);        
            if (pregunta == 0) {
                modelotabla.removeRow(filaSeleccionada);
                LimpiarEntradas(); 
            } 
        }
    }
    
}
}