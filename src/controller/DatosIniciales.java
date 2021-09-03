/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

import access.ProductoDAO;
import access.AutorDAO;

import model.AutorModel;
import model.ProductoModel;

/**
 *
 * @author chris
 */
public class DatosIniciales {

    private ArrayList<ProductoModel> productos = null;
    private ArrayList<AutorModel> autores = null;

    public DatosIniciales() {
        ProductoDAO prodDAO = new ProductoDAO();
        productos = prodDAO.getProductos();
        
        AutorDAO autorDAO = new AutorDAO();
        autores = autorDAO.getAutores();
    }

    /**
     * @return the productos
     */
    public ArrayList<ProductoModel> getProductos() {
        return productos;
    }

    /**
     * @return the autores
     */
    public ArrayList<AutorModel> getAutores() {
        return autores;
    }

}
