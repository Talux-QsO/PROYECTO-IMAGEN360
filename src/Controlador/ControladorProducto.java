
package Controlador;
import Vista.*;
import Modelo.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.SpinnerNumberModel;
public class ControladorProducto implements ActionListener {
    //Atributos
    Vista_Producto vista_Producto;
    DefaultTableModel modelotabla;
    String[] TituloTabla = {"Codigo","Nombre","Descripcion","Precio","Stock"};
    //Constructor
    public ControladorProducto(Vista_Producto vista_Producto){
        this.vista_Producto=vista_Producto;
        //Estamos indicando que cuando se presione algun boton se van a realizar ciertas acciones
        this.vista_Producto.jbtnRegistrar.addActionListener(this);
        modelotabla = new DefaultTableModel(null,TituloTabla);
        this.vista_Producto.jtblRegistroProducto.setModel(modelotabla);
        this.vista_Producto.jbtnAtras.addActionListener(this);
        this.vista_Producto.jbtnActualizar.addActionListener(this);
        this.vista_Producto.jbtnEliminar.addActionListener(this);
        SpinnerNumberModel num = new SpinnerNumberModel();
        num.setMaximum(20);
        num.setMinimum(0);
        this.vista_Producto.jspnStock.setModel(num);
        
    }
    void LimpiarEntradas(){
        this.vista_Producto.jtxtCodigo.setText("");
        this.vista_Producto.jtxtNombre.setText("");
        this.vista_Producto.jtxtDescripcion.setText(""); 
        this.vista_Producto.jtxtPrecio.setText("");
        this.vista_Producto.jspnStock.setValue(0);
        this.vista_Producto.jtxtCodigo.requestFocus();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista_Producto.jbtnRegistrar){
            Producto prod = new Producto(); 
            prod.setCodigo(vista_Producto.jtxtCodigo.getText());
            prod.setNombre(vista_Producto.jtxtNombre.getText());
            prod.setDescripcion(vista_Producto.jtxtDescripcion.getText());
            prod.setPrecio_venta(Double.parseDouble(vista_Producto.jtxtPrecio.getText().toString()));
            prod.setStock(Integer.parseInt(vista_Producto.jspnStock.getValue().toString()));
            modelotabla.addRow(prod.RegistrarDatos());
            //addRow: coloca un registro debajo del otro es como un append para el JTable
            LimpiarEntradas();
            
        }else if(e.getSource() == vista_Producto.jbtnAtras){
            Panel panel= new Panel();
            panel.setVisible(true); //para enlazar con el siguiente formulario
            panel.setLocationRelativeTo(null);
            ControladorPanel controladorPanel = new ControladorPanel(panel);
            this.vista_Producto.dispose();    
    } else if (e.getSource() == vista_Producto.jbtnEliminar) {
        // Lógica para eliminar un producto
        // En este ejemplo, se asume que hay al menos una fila seleccionada en la tabla
        int filaSeleccionada = vista_Producto.jtblRegistroProducto.getSelectedRow();
        if (filaSeleccionada != -1) {            
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar el producto", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);        
            if (pregunta == 0) {
                modelotabla.removeRow(filaSeleccionada);
                LimpiarEntradas(); 
            }    
            
        }
    }else if (e.getSource() == vista_Producto.jbtnActualizar) {
        // Lógica para modificar un producto
        int filaSeleccionada = vista_Producto.jtblRegistroProducto.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente para modificar");
            return;
        }         
        modelotabla.setValueAt(vista_Producto.jtxtCodigo.getText(), filaSeleccionada, 0);
        modelotabla.setValueAt(vista_Producto.jtxtNombre.getText(), filaSeleccionada, 1);
        modelotabla.setValueAt(vista_Producto.jtxtDescripcion.getText(), filaSeleccionada, 2);
        modelotabla.setValueAt(vista_Producto.jtxtPrecio.getText(), filaSeleccionada, 3);
        modelotabla.setValueAt(vista_Producto.jspnStock.getValue().toString(), filaSeleccionada, 4);
        LimpiarEntradas(); // Puedes ajustar según tus necesidades 
        vista_Producto.jtblRegistroProducto.clearSelection();
        }

}
}

