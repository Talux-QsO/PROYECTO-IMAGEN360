
package Controlador;
//LIBRERIAS
import Vista.LoginFormulario;
import Vista.Panel;
import Modelo.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
public class ControladorLogin implements ActionListener, KeyListener{

    private Usuario us;
 // private final UsuariosDao usDao;
    private final LoginFormulario f1;

    public ControladorLogin(Usuario us, LoginFormulario f1) {
        this.us = us;
      //this.usDao = usDao;
        this.f1 = f1;
        this.f1.jbtnLogin.addActionListener(this);
        this.f1.jbtnSalir.addActionListener(this);
        this.f1.jtxtUsuario.addKeyListener(this);
        this.f1.jtxtContraseña.addKeyListener(this);
        this.f1.setTitle("LOG IN - IMAGEN 360");
        this.f1.setVisible(true);
        this.f1.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == f1.jbtnLogin) {
            iniciar();
        } else {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro que desea salir", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (pregunta == 0) {
                System.exit(0);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char caracter = e.getKeyChar();
        if (Character.isLowerCase(caracter)) {
            e.setKeyChar(Character.toUpperCase(caracter));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    if (e.getSource() == f1.jtxtUsuario) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                f1.jtxtContraseña.requestFocus();
            }
        } else {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                iniciar();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    //Metodo para Log in
     private void iniciar() {
        String usuario  = f1.jtxtUsuario.getText();
        String contraseña = f1.jtxtContraseña.getText();
        //Condicional
        if (f1.jtxtUsuario.getText().equals("") || String.valueOf(f1.jtxtContraseña.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(null, "Rellene los campos");
        }else{
            if(usuario.equals("JERSON")&& contraseña.equals("1234")){
                JOptionPane.showMessageDialog(null, "Bienvenido!!");  
                Panel panel= new Panel();
                ControladorPanel controladorPanel = new ControladorPanel(panel);
                panel.setVisible(true); //para enlazar con el siguiente formulario
                panel.setLocationRelativeTo(null);
                panel.setTitle("PANEL DE LA EMPRESA");
                this.f1.dispose();
            }else{
                    JOptionPane.showMessageDialog(null, "Su usuario o contraseña es incorrecto!");
                    f1.jtxtContraseña.setText("");
                    f1.jtxtContraseña.requestFocus();
                }       

        }
}
}
 
    
    
    

