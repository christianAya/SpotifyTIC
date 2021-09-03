/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;

import utils.ConnectionDB;
import model.AlbumModel;

/**
 *
 * @author chris
 */
public class AlbumDAO {

    private Connection conn = null;

    public void insertarAlumes(AlbumModel album) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "INSERT INTO album(al_prod_id, al_formato, al_numero_canciones) VALUES(?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, album.getProductoFK());
            statement.setString(2, album.getFormato());
            statement.setInt(3, album.getNumero_canciones());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                //JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
                System.out.println("Album agregado");
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }
    
        public void borrarAlbum(int idProducto) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "DELETE FROM album WHERE al_prod_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, idProducto);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                //JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
                System.out.println("Registro Borrado de Album");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError Borrando Albúm:" + ex.getMessage());
        }
    }
}
