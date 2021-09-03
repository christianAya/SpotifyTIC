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

/**
 *
 * @author chris
 */
public class ComentarioDAO {

    Connection conn = null;

    public void borrarProducto(int idProducto) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "DELETE FROM comentario WHERE comen_pro_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, idProducto);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                //JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
                System.out.println("Registro borrado de comentario");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError Borrando Comentario:" + ex.getMessage());
        }
    }
}
