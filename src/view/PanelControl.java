/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/*import controller.ChangeEvent;
import controller.ClickEvent;
import controller.InitialData;*/
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.ProductoModel;
import controller.DatosIniciales;
import controller.EventoBuscar;

/**
 *
 * @author chris
 */
public class PanelControl extends JPanel {

    private JLabel lblTipo;
    private JComboBox cbxTipo;
    private JLabel lblComentario;
    private JComboBox cbxComentario;
    private JLabel lblAutor;
    private JTextField txtAutor;
    private JButton btnBuscar;
    private JButton btnAgregarProducto;
    private JButton btnEditarAutor;
    private JButton btnEliminarProducto;
    private JTable tblResultados;

    /**
     * Constructor de la clase PanelControl.
     *
     * @param resultsPanel
     */
    public PanelControl(PanelResultados resultsPanel) {
        this.tblResultados = resultsPanel.getTblResults();
        initComponents();
    }

    /**
     *
     */
    private void initComponents() {
        setLayout(new GridLayout(5, 2));
        DatosIniciales datos = new DatosIniciales();

        this.setTblResultados(datos.getProductos());
        // Selección de Tipo de Producto
        this.lblTipo = new JLabel("Tipo de Producto");
        add(this.getLblTipos());

        this.cbxTipo = new JComboBox();
        this.cbxTipo.addItem("Todos Los Productos");
        this.cbxTipo.addItem("Canción");
        this.cbxTipo.addItem("Album");
        this.cbxTipo.setSelectedIndex(0);
        add(this.getCbxTipos());

        // Selección de opción de comentarios
        this.lblComentario = new JLabel("Comentario");
        add(this.getLblComentarios());

        this.cbxComentario = new JComboBox();
        this.cbxComentario.addItem("Todos Los Comentarios");
        this.cbxComentario.addItem("Comentarios");
        this.cbxComentario.addItem("Sin Comentarios");
        this.cbxComentario.setSelectedIndex(0);
        add(this.getCbxComentarios());

        // Label Autor 
        this.lblAutor = new JLabel("Nombre del Autor");
        add(this.getLblAutor());

        this.txtAutor = new JTextField();
        add(this.getTxtAutor());

        // Botón Buscar
        this.btnBuscar = new JButton("Buscar");
        add(this.btnBuscar);

        EventoBuscar clickEvent = new EventoBuscar(this);
        this.btnBuscar.addActionListener(clickEvent);

        // Botón Agregar Producto
        this.btnAgregarProducto = new JButton("Agregar Nuevo Producto");
        add(this.getBtnAgregarProducto());
        this.getBtnAgregarProducto().addActionListener(clickEvent);

        this.btnEditarAutor = new JButton("Editar Autor");
        add(this.getBtnEditarAutor());
        this.getBtnEditarAutor().addActionListener(clickEvent);

        this.btnEliminarProducto = new JButton("Eliminar Producto");
        add(this.getBtnEliminarProducto());
        this.getBtnEliminarProducto().addActionListener(clickEvent);

    }

    /**
     * @return the lblTipo
     */
    public JLabel getLblTipos() {
        return lblTipo;
    }

    /**
     * @return the cbxTipo
     */
    public JComboBox getCbxTipos() {
        return cbxTipo;
    }

    /**
     * @return the lblComentario
     */
    public JLabel getLblComentarios() {
        return lblComentario;
    }

    /**
     * @return the cbxComentario
     */
    public JComboBox getCbxComentarios() {
        return cbxComentario;
    }

    /**
     * @return the lblAutor
     */
    public JLabel getLblAutor() {
        return lblAutor;
    }

    /**
     * @return the txtAutor
     */
    public JTextField getTxtAutor() {
        return txtAutor;
    }

    /**
     * @return the btnBuscar
     */
    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    /**
     * @return the btnAgregarProducto
     */
    public JButton getBtnAgregarProducto() {
        return btnAgregarProducto;
    }

    public JButton getBtnEditarAutor() {
        return btnEditarAutor;
    }

    public JButton getBtnEliminarProducto() {
        return btnEliminarProducto;
    }

    /**
     * @return the tblResultados
     */
    public JTable getTblResulatos() {
        return tblResultados;
    }

    /**
     * @param producto
     */
    public void setTblResultados(ArrayList<ProductoModel> producto) {
        String[] headers = {"ID", "Autor", "Producto", "Tipo", "Opinion", "Usuario", "Correo"};
        this.tblResultados.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResultados.setModel(tableModel);
        for (int i = 0; i < producto.size(); i++) {
            tableModel.addRow(producto.get(i).toArray());
        }
    }

}
