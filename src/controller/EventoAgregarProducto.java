/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import access.ProductoDAO;
import access.CancionDAO;
import access.AlbumDAO;
import model.AlbumModel;
import model.AutorModel;
import model.CancionModel;
import model.ProductoModel;
import view.AgregarProducto;

/**
 *
 * @author chris
 */
public class EventoAgregarProducto implements ActionListener {

    private AgregarProducto agregarProducto;

    public EventoAgregarProducto(AgregarProducto agregarProducto) {
        this.agregarProducto = agregarProducto;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == agregarProducto.getBtnInsertar()) {
            try {

                String nombreProducto = agregarProducto.getTxtNombreProducto().getText();
                int anio = Integer.parseInt(agregarProducto.getTxtAnio().getText());
                int reproducciones = Integer.parseInt(agregarProducto.getTxtReproducciones().getText());
                int autor = ((AutorModel) agregarProducto.getCbxAutores().getSelectedItem()).getId();
                boolean chbCancion = agregarProducto.getChbTipoCancion().isSelected();
                boolean chbAlbum = agregarProducto.getChbTipoAlbum().isSelected();

                if (chbCancion && !"".equals(nombreProducto)) {
                    int duracion = Integer.parseInt(agregarProducto.getTxtDuracion().getText());
                    String genero = agregarProducto.getTxtGenero().getText();

                    if (!"".equals(genero)) {
                        ProductoDAO productoDAO = creaProducto(autor, nombreProducto, anio, reproducciones);
                        CancionModel cancion = new CancionModel(productoDAO.getUnico(), duracion, genero);
                        CancionDAO cancionDAO = new CancionDAO();
                        cancionDAO.insertarAlumes(cancion);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error : Campo vacio o incorrecto");
                    }

                } else if (chbAlbum && !"".equals(nombreProducto)) {
                    String formato = agregarProducto.getTxtFormato().getText();
                    int numero_canciones = Integer.parseInt(agregarProducto.getTxtNumeroCanciones().getText());
                    if (!"".equals(formato)) {
                        ProductoDAO productoDAO = creaProducto(autor, nombreProducto, anio, reproducciones);
                        AlbumModel album = new AlbumModel(productoDAO.getUnico(), formato, numero_canciones);
                        AlbumDAO albumDAO = new AlbumDAO();
                        albumDAO.insertarAlumes(album);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error : Campo vacio o incorrecto");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Error : Campo vacio o incorrecto");
                }
                agregarProducto.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error : Campo vacio o incorrecto");
            }
        }
    }

    private ProductoDAO creaProducto(int autor, String nombreProducto, int anio, int reproducciones) {
        ProductoDAO productoDAO = new ProductoDAO();
        ProductoModel producto = new ProductoModel(autor, nombreProducto, anio, reproducciones);
        productoDAO.insertarProductos(producto);
        return productoDAO;
    }

}
