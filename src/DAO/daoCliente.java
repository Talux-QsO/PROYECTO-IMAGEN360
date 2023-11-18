
package DAO;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class daoCliente  extends Conexion {
    
    
     //String sql = "INSERT INTO Cliente  (nombre, telefono , direccion , correo ) VALUES(?,?,?,?.?)";
    
    public boolean registrar(Cliente cli) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO Cliente  (nombre, telefono , direccion , correo ) VALUES(?,?,?,?.?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getTelefono());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getCorreo());
            
            ps.execute();
            return true;
        } catch (SQLException e) {
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
  
    public boolean modificar(Cliente cli) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE Cliente SET nombre=?, telefono=? , direccion=? , correo=?  WHERE idCliente=? ";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getTelefono());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getCorreo());
            ps.execute();
            return true;
        } catch (SQLException e) {
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
    
    public boolean eliminar(Cliente cli){
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM Cliente WHERE idCliente=? ";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cli.getIdCliente());
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
    
    public boolean buscar(Cliente cli){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM Cliente WHERE IdCliente=? ";
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, cli.getIdCliente());
            rs = ps.executeQuery();
            
            if (rs.next()){
                cli.setNombre(rs.getString("nombre"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setDireccion(rs.getString("direcion"));
                cli.setCorreo(rs.getString("correo"));
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
