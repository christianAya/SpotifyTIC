/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import model.ProductoModel;
import utils.ConnectionDB;

/**
 *
 * @author chris
 */
public class ProductoDAO {

    private Connection conn = null;

    /**
     *
     * @return
     */
    public ArrayList<ProductoModel> getProductos() {
        ArrayList<ProductoModel> productos = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "SELECT producto.pro_id as ID, autor.au_nombre as Autor, producto.pro_nombre,\n"
                    + "CASE\n"
                    + "WHEN cancion.can_id IS NOT NULL THEN 'Cancion'\n"
                    + "WHEN album.al_id IS NOT NULL THEN 'Album'\n"
                    + "ELSE 'No Asociado'\n"
                    + "END as Tipo,\n"
                    + "CASE\n"
                    + "WHEN comentario.comen_id IS NULL THEN 'Sin comentario'\n"
                    + "ELSE comentario.comen_opinion\n"
                    + "END AS Opinion,\n"
                    + "CASE\n"
                    + "WHEN usuario.us_documento IS NULL THEN '------'\n"
                    + "ELSE CONCAT(usuario.us_nombre,\" \", usuario.us_apellido)\n"
                    + "END AS Nombre,\n"
                    + "CASE\n"
                    + "WHEN usuario.us_documento IS NULL THEN '------'\n"
                    + "ELSE usuario.us_correo\n"
                    + "END AS Correo\n"
                    + "FROM producto\n"
                    + "LEFT JOIN cancion ON cancion.can_pro_id = producto.pro_id\n"
                    + "LEFT JOIN album ON album.al_prod_id = producto.pro_id\n"
                    + "LEFT JOIN comentario ON comentario.comen_pro_id = producto.pro_id\n"
                    + "LEFT JOIN usuario ON comentario.comen_us_documento = usuario.us_documento \n"
                    + "JOIN autor ON autor.au_id = producto.pro_au_id\n"
                    + "ORDER BY autor.au_nombre ASC;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                ProductoModel producto = new ProductoModel(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7));
                productos.add(producto);
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return productos;
    }

    public ArrayList<ProductoModel> getProductosFiltrados(
            int tipo,
            int comentario,
            String autor) {
        ArrayList<ProductoModel> productos = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "SELECT producto.pro_id as ID, autor.au_nombre as Autor, producto.pro_nombre,\n"
                    + "CASE\n"
                    + "WHEN cancion.can_id IS NOT NULL THEN 'Cancion'\n"
                    + "WHEN album.al_id IS NOT NULL THEN 'Album'\n"
                    + "ELSE 'No Asociado'\n"
                    + "END as Tipo,\n"
                    + "CASE\n"
                    + "WHEN comentario.comen_id IS NULL THEN 'Sin comentario'\n"
                    + "ELSE comentario.comen_opinion\n"
                    + "END AS Opinion,\n"
                    + "CASE\n"
                    + "WHEN usuario.us_documento IS NULL THEN '------'\n"
                    + "ELSE CONCAT(usuario.us_nombre,\" \", usuario.us_apellido)\n"
                    + "END AS Nombre,\n"
                    + "CASE\n"
                    + "WHEN usuario.us_documento IS NULL THEN '------'\n"
                    + "ELSE usuario.us_correo\n"
                    + "END AS Correo\n"
                    + "FROM producto\n"
                    + "LEFT JOIN cancion ON cancion.can_pro_id = producto.pro_id\n"
                    + "LEFT JOIN album ON album.al_prod_id = producto.pro_id\n"
                    + "LEFT JOIN comentario ON comentario.comen_pro_id = producto.pro_id\n"
                    + "LEFT JOIN usuario ON comentario.comen_us_documento = usuario.us_documento \n"
                    + "JOIN autor ON autor.au_id = producto.pro_au_id\n"
                    + "WHERE autor.au_nombre LIKE ?";

            if (tipo != 0 && comentario == 0) {
                sql += retornoTipo(tipo) + ";";
            } else if (tipo == 0 && comentario != 0) {
                sql += (comentario == 1) ? " AND usuario.us_documento IS NOT NULL;" : " AND usuario.us_documento IS NULL;";
            } else if (tipo != 0 && comentario != 0) {
                sql += retornoTipo(tipo);
                sql += (comentario == 1) ? " AND usuario.us_documento IS NOT NULL;" : " AND usuario.us_documento IS NULL;";
            } else {
                sql += "ORDER BY autor.au_nombre ASC;";
            }

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + autor + "%");
            //System.out.println(statement.toString());
            //System.out.println("------------------------------------------------------");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                ProductoModel producto = new ProductoModel(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7));
                productos.add(producto);
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return productos;
    }

    public int getUnico() {
        int prod_id = 0;
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT pro_id FROM producto ORDER BY pro_id DESC LIMIT 1;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                prod_id = result.getInt(1);
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return prod_id;
    }

    public int getTipo(int id) {
        int idTipo = 0;
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT\n"
                    + "CASE\n"
                    + "WHEN cancion.can_id IS NOT NULL THEN 1\n"
                    + "WHEN album.al_id IS NOT NULL THEN 2\n"
                    + "ELSE 0\n"
                    + "END AS Tipo\n"
                    + "FROM producto\n"
                    + "LEFT JOIN cancion ON cancion.can_pro_id = producto.pro_id\n"
                    + "LEFT JOIN album ON album.al_prod_id = producto.pro_id\n"
                    + "WHERE producto.pro_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                idTipo = result.getInt(1);
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return idTipo;
    }

    public void insertarProductos(ProductoModel producto) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "INSERT INTO producto(pro_au_id, pro_nombre, pro_anio, pro_reproducciones) VALUES(?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, producto.getAutorFK());
            statement.setString(2, producto.getNombreProducto());
            statement.setInt(3, producto.getAnio());
            statement.setInt(4, producto.getReproducciones());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
            }
            //conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void updateAutor(int idAutor, int idProducto) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "UPDATE producto SET pro_au_id = ? WHERE pro_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, idAutor);
            statement.setInt(2, idProducto);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void borrarProducto(int id) {
        try {            
            if (conn == null) {
                conn = ConnectionDB.getConnection();
                
            }
            String sql = "DELETE FROM producto WHERE pro_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
            }
            //conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError Borrando Producto:" + ex.getMessage());
        }
    }

    private String retornoTipo(int tipo) {
        String cadena = null;
        switch (tipo) {
            case 1:
                cadena = " AND cancion.can_id IS NOT NULL";
                break;
            case 2:
                cadena = " AND album.al_id IS NOT NULL";
                break;
            case 3:
                cadena = " AND album.al_id IS NULL AND cancion.can_id IS NULL";
                break;
            default:
                break;
        }
        return cadena;
    }
}
