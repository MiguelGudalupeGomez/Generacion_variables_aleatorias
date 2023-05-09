/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class WindowMain extends JFrame {
    //atributos
    private JLabel windowTitle; //titulo en le ventana
    private JPanel mainPanel; //panel principal
    private JLabel etiquetaBackground;
    
    
    //constructor
    public WindowMain() {
        super("Generación de variables aleatorias");
        this.setSize(600, 400);//establecemos el tamaño de la ventana
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); //establecemos la posicion de la ventana en medio de la pantalla
        this.initComponents(); //inicializamos los demas componentes de la Ventana
        this.setVisible(true);//hacemos visibles la ventana
    }
    
    /*******METODOS**********/
    
    private void initComponents() {
        mainPanel = new JPanel();
        windowTitle = new JLabel("Generación de variables aleatorias");
        
        mainPanel.add(windowTitle);
        
        
        this.getContentPane().add(mainPanel);
    }
}
