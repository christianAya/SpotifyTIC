/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import access.ProductoDAO;
import access.AlbumDAO;
import access.CancionDAO;
import access.ComentarioDAO;

/**
 *
 * @author chris
 */
public class EliminarProducto extends JFrame implements ActionListener {

    private JLabel lblProductoID;
    private JTextField txtProductoID;
    private JButton btnEliminar;

    public EliminarProducto() {

        initComponentes();
    }

    public void initComponentes() {
        setTitle("Producto - Eliminar Producto");
        setSize(300, 150);
        setLayout(null);
        setDefaultCloseOperation(2);
        setResizable(false);
        setLocationRelativeTo(null);

        this.lblProductoID = new JLabel("Producto ID:");
        lblProductoID.setBounds(30, 30, 80, 20);
        this.add(lblProductoID);

        this.txtProductoID = new JTextField();
        txtProductoID.setBounds(100, 30, 150, 20);
        this.add(txtProductoID);

        this.btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(100, 70, 100, 20);
        this.add(btnEliminar);
        btnEliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnEliminar) {
            try {
                int idProducto = Integer.parseInt(txtProductoID.getText());

                ProductoDAO productoDAO = new ProductoDAO();
                int tipoProducto = productoDAO.getTipo(idProducto);

                if (tipoProducto == 1) {
                    CancionDAO cancionDAO = new CancionDAO();
                    cancionDAO.borrarCancion(idProducto);

                } else if (tipoProducto == 2) {
                    AlbumDAO albumDAO = new AlbumDAO();
                    albumDAO.borrarAlbum(idProducto);
                }
                
                ComentarioDAO comentarioDAO = new ComentarioDAO();
                comentarioDAO.borrarProducto(idProducto);
                
                productoDAO.borrarProducto(idProducto);
                
                this.dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error : Campo vacio o incorrecto");
            }
        }
    }

}
