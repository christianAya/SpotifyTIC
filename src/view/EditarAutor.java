/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import access.ProductoDAO;
import controller.DatosIniciales;
import model.AutorModel;

/**
 *
 * @author chris
 */
public class EditarAutor extends JFrame implements ActionListener {

    private JLabel lblAutor;
    private JComboBox<AutorModel> cbxAutores;
    private JLabel lblNombreAutor;
    private JTextField txtNombreAutor;
    private JButton btnCambiar;
    //private PanelControl panel;
    private DatosIniciales datos;

    public EditarAutor(/*PanelControl panel*/) {
        //this.panel = panel;
        initComponentes();
    }

    public void initComponentes() {

        setTitle("Autor - Editar Autor");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(2);
        setResizable(false);
        setLocationRelativeTo(null);

        datos = new DatosIniciales();

        this.lblNombreAutor = new JLabel("ID Producto:");
        lblNombreAutor.setBounds(40, 30, 70, 20);        
        add(lblNombreAutor);

        this.txtNombreAutor = new JTextField();
        txtNombreAutor.setBounds(120, 30, 120, 20);
        add(txtNombreAutor);
        
        this.lblAutor = new JLabel("Autor:");
        lblAutor.setBounds(40, 70, 100, 20);
        add(lblAutor);

        this.cbxAutores = new JComboBox();
        this.cbxAutores.setModel(new DefaultComboBoxModel<>(datos.getAutores().toArray(new AutorModel[datos.getAutores().size()])));
        cbxAutores.setBounds(120, 70, 120, 20);        
        add(cbxAutores);

        this.btnCambiar = new JButton("Cambiar");
        btnCambiar.setBounds(100, 110, 100, 20);
        add(btnCambiar);
        btnCambiar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnCambiar) {
            try {
                int autorID = ((AutorModel) (cbxAutores.getSelectedItem())).getId();
                int productoID = Integer.parseInt(txtNombreAutor.getText());

                ProductoDAO productoDAO = new ProductoDAO();
                productoDAO.updateAutor(autorID, productoID);
                //panel.setTblResultados(datos.getProductos());                
                this.dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error : Campo vacio o incorrecto");
            }
        }
    }

}
