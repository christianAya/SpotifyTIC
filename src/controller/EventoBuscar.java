/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import access.ProductoDAO;
import model.ProductoModel;
import view.AgregarProducto;
import view.EditarAutor;
import view.EliminarProducto;
import view.PanelControl;

/**
 *
 * @author chris
 */
public class EventoBuscar implements ActionListener {

    private PanelControl panel;

    public EventoBuscar(PanelControl panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource() == this.panel.getBtnBuscar()) {
            int tipo = panel.getCbxTipos().getSelectedIndex();
            int comentario = panel.getCbxComentarios().getSelectedIndex();
            String autor = panel.getTxtAutor().getText();
            ProductoDAO productoDAO = new ProductoDAO();
            ArrayList<ProductoModel> productos = productoDAO.getProductosFiltrados(tipo, comentario, autor);
            this.panel.setTblResultados(productos);

        } else if (actionEvent.getSource() == this.panel.getBtnAgregarProducto()) {
            AgregarProducto vistaAgregarProducto = new AgregarProducto();
            vistaAgregarProducto.setVisible(true);

        } else if (actionEvent.getSource() == this.panel.getBtnEditarAutor()) {
            EditarAutor vistaEditarProducto = new EditarAutor(/*panel*/);
            vistaEditarProducto.setVisible(true);
        
        }else if (actionEvent.getSource() == this.panel.getBtnEliminarProducto()) {
            EliminarProducto vistaEliminarProducto = new EliminarProducto();
            vistaEliminarProducto.setVisible(true);
        }
    }

}
