/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

import controller.DatosIniciales;
import controller.EventoAgregarProducto;
import controller.EventoTipos;
import model.AutorModel;

/**
 *
 * @author chris
 */
public class AgregarProducto extends JFrame {

    private JLabel lblNombreProducto;
    private JTextField txtNombreProducto;
    private JLabel lblAnio;
    private JTextField txtAnio;
    private JLabel lblReproducciones;
    private JTextField txtReproducciones;
    private JLabel lblAutor;
    private JComboBox<AutorModel> cbxAutores;
    private JLabel lblTipoProducto;
    private JLabel lblCancion;
    private JLabel lblAlbum;
    private JCheckBox chbTipoCancion;
    private JCheckBox chbTipoAlbum;
    private JButton btnInsertar;

    private JPanel panelCancion;
    private JLabel lblDuracion;
    private JTextField txtDuracion;
    private JLabel lblGenero;
    private JTextField txtGenero;

    private JPanel panelAlbum;
    private JLabel lblFormato;
    private JTextField txtFormato;
    private JLabel lblNumeroCanciones;
    private JTextField txtNumeroCanciones;

    public AgregarProducto() {
        initComponents();
        Localizar();
        Agregar();

    }

    public void initComponents() {
        setTitle("Producto - Agregar Producto");
        setSize(400, 280);
        setDefaultCloseOperation(2);
        setResizable(false);
        setLocationRelativeTo(null);

        DatosIniciales datos = new DatosIniciales();

        this.lblNombreProducto = new JLabel("Nombre del Producto");
        this.txtNombreProducto = new JTextField();

        this.lblAnio = new JLabel("Año de Lanzamiento");
        this.lblAnio.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.txtAnio = new JTextField();

        this.lblReproducciones = new JLabel("Reproducciones");
        this.lblReproducciones.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.txtReproducciones = new JTextField();

        this.lblAutor = new JLabel("Seleccione Autor:");
        this.lblAutor.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.cbxAutores = new JComboBox();
        this.getCbxAutores().setModel(new DefaultComboBoxModel<>(datos.getAutores().toArray(new AutorModel[datos.getAutores().size()])));
        this.getCbxAutores().setSelectedIndex(0);

        this.lblTipoProducto = new JLabel("El producto es: ");
        this.lblCancion = new JLabel("Canción");
        this.lblAlbum = new JLabel("Albúm");
        this.chbTipoCancion = new JCheckBox();
        this.chbTipoAlbum = new JCheckBox();
        EventoTipos eventoTipos = new EventoTipos(this);
        this.chbTipoCancion.addChangeListener(eventoTipos);
        this.chbTipoAlbum.addChangeListener(eventoTipos);

        this.btnInsertar = new JButton("Agregar a BD");
        EventoAgregarProducto eventoAgregar = new EventoAgregarProducto(this);
        this.btnInsertar.addActionListener(eventoAgregar);

        this.panelCancion = new JPanel();
        this.getPanelCancion().setVisible(false);
        this.lblDuracion = new JLabel("Duracion:");
        this.txtDuracion = new JTextField();
        this.lblGenero = new JLabel("Genero:");
        this.txtGenero = new JTextField();

        this.panelAlbum = new JPanel();
        this.panelAlbum.setVisible(false);
        this.lblFormato = new JLabel("Formato:");
        this.txtFormato = new JTextField();
        this.lblNumeroCanciones = new JLabel("Numero de Canciones:");
        this.txtNumeroCanciones = new JTextField();
    }

    public void Localizar() {
        this.setLayout(null);
        lblNombreProducto.setBounds(30, 15, 120, 20);
        txtNombreProducto.setBounds(150, 15, 200, 20);
        lblAnio.setBounds(30, 45, 100, 20);
        txtAnio.setBounds(30, 75, 100, 20);
        lblReproducciones.setBounds(150, 45, 100, 20);
        txtReproducciones.setBounds(150, 75, 100, 20);
        lblAutor.setBounds(260, 45, 100, 20);
        cbxAutores.setBounds(260, 75, 100, 20);
        lblTipoProducto.setBounds(30, 110, 80, 20);
        lblCancion.setBounds(120, 110, 50, 20);
        chbTipoCancion.setBounds(160, 110, 20, 20);
        lblAlbum.setBounds(190, 110, 50, 20);
        chbTipoAlbum.setBounds(230, 110, 20, 20);
        btnInsertar.setBounds(260, 110, 100, 20);


        /*
            Localización de Panel de Canción y sus componentes
         */
        panelCancion.setBounds(30, 130, 250, 70);
        lblDuracion.setBounds(0, 10, 50, 20);
        txtDuracion.setBounds(60, 10, 100, 20);
        lblGenero.setBounds(0, 40, 50, 20);
        txtGenero.setBounds(60, 40, 100, 20);

        /*
            Localización de Panel de Album y sus componentes
         */
        getPanelAlbum().setBounds(30, 130, 250, 70);
        lblFormato.setBounds(0, 10, 50, 20);
        getTxtFormato().setBounds(60, 10, 100, 20);
        lblNumeroCanciones.setBounds(0, 40, 120, 20);
        getTxtNumeroCanciones().setBounds(130, 40, 100, 20);

    }

    public void Agregar() {
        add(this.lblNombreProducto);
        add(this.txtNombreProducto);
        add(this.lblAnio);
        add(this.txtAnio);
        add(this.lblReproducciones);
        add(this.txtReproducciones);
        add(this.lblAutor);
        add(this.cbxAutores);
        add(this.lblTipoProducto);
        add(this.lblCancion);
        add(this.lblAlbum);
        add(this.chbTipoCancion);
        add(this.chbTipoAlbum);
        add(this.btnInsertar);

        add(this.getPanelCancion());
        getPanelCancion().setLayout(null);
        getPanelCancion().add(this.lblDuracion);
        getPanelCancion().add(this.txtDuracion);
        getPanelCancion().add(this.lblGenero);
        getPanelCancion().add(this.txtGenero);

        add(this.getPanelAlbum());
        getPanelAlbum().setLayout(null);
        getPanelAlbum().add(this.lblFormato);
        getPanelAlbum().add(this.getTxtFormato());
        getPanelAlbum().add(this.lblNumeroCanciones);
        getPanelAlbum().add(this.getTxtNumeroCanciones());

    }

    /**
     * @return the txtNombreProducto
     */
    public JTextField getTxtNombreProducto() {
        return txtNombreProducto;
    }

    /**
     * @return the txtAnio
     */
    public JTextField getTxtAnio() {
        return txtAnio;
    }

    /**
     * @return the txtReproducciones
     */
    public JTextField getTxtReproducciones() {
        return txtReproducciones;
    }

    /**
     * @return the cbxAutores
     */
    public JComboBox<AutorModel> getCbxAutores() {
        return cbxAutores;
    }

    /**
     * @return the chbTipoCancion
     */
    public JCheckBox getChbTipoCancion() {
        return chbTipoCancion;
    }

    /**
     * @return the chbTipoAlbum
     */
    public JCheckBox getChbTipoAlbum() {
        return chbTipoAlbum;
    }

    /**
     * @return the btnInsertar
     */
    public JButton getBtnInsertar() {
        return btnInsertar;
    }

    /**
     * @return the panelCancion
     */
    public JPanel getPanelCancion() {
        return panelCancion;
    }

    /**
     * @return the txtDuracion
     */
    public JTextField getTxtDuracion() {
        return txtDuracion;
    }

    /**
     * @return the txtGenero
     */
    public JTextField getTxtGenero() {
        return txtGenero;
    }

    /**
     * @return the panelAlbum
     */
    public JPanel getPanelAlbum() {
        return panelAlbum;
    }

    /**
     * @return the txtFormato
     */
    public JTextField getTxtFormato() {
        return txtFormato;
    }

    /**
     * @return the txtNumeroCanciones
     */
    public JTextField getTxtNumeroCanciones() {
        return txtNumeroCanciones;
    }
}
