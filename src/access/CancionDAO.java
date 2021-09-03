/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import utils.ConnectionDB;
import model.CancionModel;

/**
 *
 * @author chris
 */
public class CancionDAO {

    private Connection conn = null;

    public void insertarAlumes(CancionModel cancion) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "INSERT INTO cancion(can_pro_id, can_duracion, can_genero) VALUES(?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cancion.getProductoFK());
            statement.setInt(2, cancion.getDuracion());
            statement.setString(3, cancion.getGenero());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                //JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
                System.out.println("Canción agregada");
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }
    
        public void borrarCancion(int idProducto) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "DELETE FROM cancion WHERE can_pro_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, idProducto);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                //JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
                System.out.println("Registro Borrado de Canción");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError Borrando Canción:" + ex.getMessage());
        }
    }
}
