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
public class ProductoModel {

    private int id;
    private int autorFK;
    private String nombreProducto;
    private int anio;
    private int reproducciones;

    private String autor;
    private String tipo;
    private String opinion;
    private String usuNombre;
    private String usuCorreo;

    /*
        Cosntructor que llama todos los datos
     */
    public ProductoModel(int id, int autorFK, String nombreProducto, int anio, int reproducciones) {
        this.id = id;
        this.autorFK = autorFK;
        this.nombreProducto = nombreProducto;
        this.anio = anio;
        this.reproducciones = reproducciones;
    }

    /*
        Constructor usado para insertar datos
     */
    public ProductoModel(int autorFK, String nombreProducto, int anio, int reproducciones) {
        this.autorFK = autorFK;
        this.nombreProducto = nombreProducto;
        this.anio = anio;
        this.reproducciones = reproducciones;
    }

    public ProductoModel(int id, String autor, String nombreProducto, String tipo, String opinion, String usuNombre, String usuCorreo) {
        this.id = id;
        this.autor = autor;
        this.nombreProducto = nombreProducto;
        this.tipo = tipo;
        this.opinion = opinion;
        this.usuNombre = usuNombre;
        this.usuCorreo = usuCorreo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the autorFK
     */
    public int getAutorFK() {
        return autorFK;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombre to set
     */
    public void setNombre(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * @return the reproducciones
     */
    public int getReproducciones() {
        return reproducciones;
    }

    /**
     * @param reproducciones the reproducciones to set
     */
    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @return the opinion
     */
    public String getOpinion() {
        return opinion;
    }

    /**
     * @return the usuNombre
     */
    public String getUsuNombre() {
        return usuNombre;
    }

    /**
     * @return the usuCorreo
     */
    public String getUsuCorreo() {
        return usuCorreo;
    }

    public Object[] toArray() {
        Object[] data = {id,autor, nombreProducto, tipo, opinion, usuNombre, usuCorreo};
        return data;
    }

}
