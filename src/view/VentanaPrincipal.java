/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JFrame;

/**
 *
 * @author chris
 */
public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Museos - MVC");
        setSize(720, 670);
        //setLayout(null);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        PanelResultados resultsPanel = new PanelResultados();
        setContentPane(resultsPanel);
        add(new PanelControl(resultsPanel));

        

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
