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
import model.AutorModel;
import utils.ConnectionDB;

/**
 *
 * @author chris
 */
public class AutorDAO {

    private Connection conn = null;

    public ArrayList<AutorModel> getAutores() {
        ArrayList<AutorModel> autores = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT au_id, au_nombre, au_nacionalidad, au_edad FROM autor"
                    + " order by autor.au_nombre asc;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                AutorModel autor = new AutorModel(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4));
                autores.add(autor);
            }
            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return autores;
    }
}
