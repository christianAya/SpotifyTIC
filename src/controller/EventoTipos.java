/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.AgregarProducto;

/**
 *
 * @author chris
 */
public class EventoTipos implements ChangeListener {

    private AgregarProducto agregarProducto;

    public EventoTipos(AgregarProducto agregarProducto) {
        this.agregarProducto = agregarProducto;

    }

    @Override
    public void stateChanged(ChangeEvent actionEvent) {
        if (agregarProducto.getChbTipoCancion().isSelected()) {
            
            agregarProducto.getChbTipoCancion().setEnabled(true);
            agregarProducto.getChbTipoAlbum().setEnabled(false);
            /*
            - limpiar los textField de cancion cuando se deseleccione y lo mismo para albúm
            - hacer las pruebas de inserción en producto
            */
            agregarProducto.getPanelCancion().setVisible(true);
            agregarProducto.getPanelAlbum().setVisible(false);          
            
        } else if (agregarProducto.getChbTipoAlbum().isSelected()) {
            agregarProducto.getChbTipoAlbum().setEnabled(true);
            agregarProducto.getChbTipoCancion().setEnabled(false);
            agregarProducto.getPanelCancion().setVisible(false);
            agregarProducto.getPanelAlbum().setVisible(true);
        } else {
            agregarProducto.getChbTipoAlbum().setEnabled(true);
            agregarProducto.getChbTipoCancion().setEnabled(true);
            agregarProducto.getPanelCancion().setVisible(false);
            agregarProducto.getPanelAlbum().setVisible(false);
        }
    }

}
