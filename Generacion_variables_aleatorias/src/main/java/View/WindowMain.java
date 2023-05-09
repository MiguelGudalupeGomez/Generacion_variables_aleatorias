/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JButton;
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
    private JPanel menuPanel; //panel del menu
    private JPanel jPanelTitle; //panel del titulo
    private JPanel panelDescripcion;
    private JLabel labelDescripcion;
    private FlowLayout flowLayout;
    
    //botones
    public JButton pruebasEstadtisticasButton;
    public JButton composicionButton;
    public JButton other1;
    public JButton other2;
    
    
    //constructor
    public WindowMain() {
        super("Generación de variables aleatorias");
        this.setSize(600, 400);//establecemos el tamaño de la ventana
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false); //desactivamos el ridimensionamiento de la ventana
        this.setLayout(null);
        this.setLocationRelativeTo(null); //establecemos la posicion de la ventana en medio de la pantalla
        this.initComponents(); //inicializamos los demas componentes de la Ventana
        this.setVisible(true);//hacemos visibles la ventana
        
    }
    
    /*******METODOS**********/
    
    private void initComponents() {
        /*---------------------------------------------------------*/
        //Definimos las propiedas de la fuente para el título.
        Font font = new Font("Times New Roman", Font.BOLD, 34);
        //creamos la etiqueta del titulo y le agregamos el titulo
        this.windowTitle = new JLabel("Generación de variables aleatorias");
        this.windowTitle.setFont(font);//le agregamos la fuente a la etiqueta
        
        this.jPanelTitle = new JPanel();//creamos el panel que contendá la etiqueta del título
        this.jPanelTitle.setBackground(Color.CYAN);
        this.jPanelTitle.setBounds(0, 0, this.getWidth(), 50);//definimos la posicion y el tamaño
        
        this.jPanelTitle.add(windowTitle);//agregamos la etiqueta del título al panel
        /*--------------------------------------------------------------*/
        this.labelDescripcion = new JLabel("Menú de opciones: seleccione una opción");
        font = new Font("Times New Roman", Font.PLAIN, 24);
        this.labelDescripcion.setFont(font);
       
        this.panelDescripcion = new JPanel();
        this.panelDescripcion.setBounds(0, 50, this.getWidth(), 40);
        this.panelDescripcion.add(this.labelDescripcion);
        /*---------------------------------------------------------------*/
        //creamos el panel del menu
        this.menuPanel = new JPanel();
        this.menuPanel.setBounds(0, 90, this.getWidth(), this.getHeight());
        //this.menuPanel.setBackground(Color.red);
        //this.menuPanel.s
        /*-----------------------------------------------------------------*/
        font = new Font("Times New Roman", Font.PLAIN, 22);//redefinimos la fuente para usarla
                                                                        //en los botones
        this.pruebasEstadtisticasButton = new JButton("Pruebas estadísticas");
        this.pruebasEstadtisticasButton.setFont(font);
        
        this.composicionButton = new JButton("Composición");
        this.composicionButton.setFont(font);
        //this.composicionButton.setPreferredSize(new Dimension(20, 100));
        
        this.other1 = new JButton("Other 1");
        this.other1.setFont(font);
        
        this.other2 = new JButton("Other 2");
        this.other2.setFont(font);
        
        //creamos un layout
        this.flowLayout = new FlowLayout(FlowLayout.CENTER, 30, 30);
        this.menuPanel.setLayout(this.flowLayout);//le agregamos el layout al panel del meú
        
         //Component espaciador = Box.createHorizontalStrut(10);
        this.menuPanel.add(this.pruebasEstadtisticasButton);
        //this.menuPanel.add(add(new JPanel()))
        this.menuPanel.add(this.composicionButton);
        this.menuPanel.add(this.other1);
        this.menuPanel.add(this.other2);
        
        /*-----------------------------------------------------------------*/
        //agregagmos los componenetes a la ventana
        this.getContentPane().add(this.jPanelTitle);
        this.getContentPane().add(this.panelDescripcion);
        this.getContentPane().add(this.menuPanel);
    }
}
