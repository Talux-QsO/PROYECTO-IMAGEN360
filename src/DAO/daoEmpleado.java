
package DAO;
import Modelo.Cliente;
import Modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class daoEmpleado extends Conexion{
    
    public boolean registrar(Empleado emp){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO CLIENTE (dni, nombre, apellido,cargo)VALUES)(?,?,?,?)";
        try{
            ps = con.prepareStatement(sql); 
            ps.setString(1,emp.getDni());
            ps.setString(2,emp.getNombre());
            ps.setString(3, emp.getApellido());
            ps.setString(4,emp.getCargo());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch (SQLException e){
                System.err.println(e);
            }
        }        
    }
    public boolean modificar(Empleado emp){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE Empleado SET dni=?,nombre=?,apellido=?,cargo=? WHERE idEmpleado=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,emp.getDni());
            ps.setString(2,emp.getNombre());
            ps.setString(3,emp.getApellido());
            ps.setString(4,emp.getCargo());
            ps.execute();
            return true;
        
        }catch(SQLException e){
            System.err.println(e);
            return false;
            
        }finally{
            try{
                con.close();
                
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    public boolean eliminar(Empleado emp){
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM Cliente WHERE idCliente=? ";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, emp.getIdEmpleado());
            ps.execute();
            return true;
        }catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
    
    public boolean buscar(Empleado emp){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM Cliente WHERE IdEmpleado=? ";
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, emp.getIdEmpleado());
            rs = ps.executeQuery();
            
            if (rs.next()){
                emp.setDni(rs.getString("DNI"));
                emp.setNombre(rs.getString("Nombre"));
                emp.setApellido(rs.getString("Apellido"));
                emp.setCargo(rs.getString("Cargo"));
                return true ; 
            }
            return false ; 
        }catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    
    }
}
