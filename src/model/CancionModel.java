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
public class CancionModel {

    private int id;
    private int productoFK;
    private int duracion;
    private String genero;

    public CancionModel(int id, int productoFK, int duracion, String genero) {
        this.id = id;
        this.productoFK = productoFK;
        this.duracion = duracion;
        this.genero = genero;
    }

    public CancionModel(int productoFK, int duracion, String genero) {
        this.productoFK = productoFK;
        this.duracion = duracion;
        this.genero = genero;
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
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

}
