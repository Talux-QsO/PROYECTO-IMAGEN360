/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Cliente;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class daoProducto extends Conexion{
    
    public boolean registrar(Producto pro){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO CLIENTE (codigo, nombre, descripcion,precio_venta,stock)VALUES)(?,?,?,?,?)";
        try{
            ps = con.prepareStatement(sql); 
            ps.setString(1,pro.getCodigo());
            ps.setString(2,pro.getNombre());
            ps.setString(3, pro.getDescripcion());
            ps.setDouble(4,pro.getPrecio_venta());
            ps.setInt(5,pro.getStock());
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
    public boolean modificar(Producto pro){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE Producto SET codigo=?,nombre=?,descripcion=?,precio_venta=?,stock=? WHERE idProducto=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,pro.getCodigo());
            ps.setString(2,pro.getNombre());
            ps.setString(3,pro.getDescripcion());
            ps.setDouble(4,pro.getPrecio_venta());
            ps.setInt(5,pro.getStock());
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
    public boolean eliminar(Producto pro){
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM Producto WHERE idCliente=? ";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getIdProducto());
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
    public boolean buscar(Producto pro){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM Cliente WHERE IdProducto=? ";
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, pro.getIdProducto());
            rs = ps.executeQuery();
            
            if (rs.next()){
                pro.setCodigo(rs.getString("Codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setDescripcion(rs.getString("Descripccion"));
                pro.setPrecio_venta(rs.getInt("Precio de Venta"));
                pro.setStock(rs.getInt("Stock"));
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
