/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author chris
 */
public class AlbumModel {

    private int id;
    private int productoFK;
    private String formato;
    private int numero_canciones;

    public AlbumModel(int id, int productoFK, String formato, int numero_canciones) {
        this.id = id;
        this.productoFK = productoFK;
        this.formato = formato;
        this.numero_canciones = numero_canciones;
    }

    public AlbumModel(int productoFK, String formato, int numero_canciones) {
        this.productoFK = productoFK;
        this.formato = formato;
        this.numero_canciones = numero_canciones;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the productoFK
     */
    public int getProductoFK() {
        return productoFK;
    }

    /**
     * @return the formato
     */
    public String getFormato() {
        return formato;
    }

    /**
     * @param formato the formato to set
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

    /**
     * @return the numero_canciones
     */
    public int getNumero_canciones() {
        return numero_canciones;
    }

    /**
     * @param numero_canciones the numero_canciones to set
     */
    public void setNumero_canciones(int numero_canciones) {
        this.numero_canciones = numero_canciones;
    }

}
