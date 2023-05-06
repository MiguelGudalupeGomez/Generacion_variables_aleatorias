/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class WindowApp extends JFrame {
    //atributos
    
    
    //constructor
    public WindowApp() {
        super("Generación de variables aleatorias");
        this.setSize(1000, 700);//establecemos el tamaño de la ventana
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); //establecemos la posicion de la ventana en medio de la pantalla
        this.initComponents(); //inicializamos los demas componentes de la Ventana
        this.setVisible(true);//hacemos visibles la ventana
    }
    
    /*******METODOS**********/
    
    private void initComponents() {

    }
}
