/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
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

    //botones
    public JButton pruebasEstadtisticasButton;
    public JButton composicionButton;
    public JButton transformadaInversa;
    public JButton convulsion;

    private Dimension prefDimension;
    private Image backgroundImage;
    String imagePath = "cp.png";

    //constructor
    public WindowMain() {
        super("Generación de variables aleatorias");
        this.setSize(600, 400);//establecemos el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false); //desactivamos el ridimensionamiento de la ventana
        this.setLayout(null);
        this.setLocationRelativeTo(null); //establecemos la posicion de la ventana en medio de la pantalla
        this.initComponents(); //inicializamos los demas componentes de la Ventana
        this.setVisible(true);//hacemos visibles la ventana

    }

    /**
     * *****METODOS*********
     */
    private void initComponents() {
        try {
            this.backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
        }
        setPreferredSize(new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null)));

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
        this.menuPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, null);
            }
        };

        //this.menuPanel.setLayout(new GridLayout(1, 1));
        //this.menuPanel.setLayout(new BoxLayout(this.menuPanel, BoxLayout.Y_AXIS));
        this.menuPanel.setBounds(0, 90, this.getWidth(), this.getHeight());
        //this.menuPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        /*-----------------------------------------------------------------*/
        font = new Font("Times New Roman", Font.PLAIN, 22);//redefinimos la fuente para usarla
        //en los botones
        this.pruebasEstadtisticasButton = new JButton("Pruebas estadísticas");
        this.pruebasEstadtisticasButton.setPreferredSize(prefDimension);
        this.pruebasEstadtisticasButton.setFont(font);

        this.composicionButton = new JButton("Método de la composición");
        this.composicionButton.setFont(font);
        //this.composicionButton.setPreferredSize(new Dimension(20, 100));

        this.transformadaInversa = new JButton("Método de le transformada inversa");
        this.transformadaInversa.setMinimumSize(prefDimension);
        this.transformadaInversa.setMaximumSize(prefDimension);
        //this.transformadaInversa.setPreferredSize(prefDimension);
        this.transformadaInversa.setFont(font);

        this.convulsion = new JButton("Método de la convulsión");
        this.convulsion.setFont(font);

        //agrupamos los botones
        //----------------------------------------------------------------------
        GroupLayout layoutMenu = new GroupLayout(this.menuPanel);
        this.menuPanel.setLayout(layoutMenu);
        layoutMenu.setHorizontalGroup(layoutMenu.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layoutMenu.createSequentialGroup()
                                .addContainerGap(130, Short.MAX_VALUE)
                                .addGroup(layoutMenu.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(this.pruebasEstadtisticasButton)
                                        .addComponent(this.composicionButton)
                                        .addComponent(this.transformadaInversa)
                                        .addComponent(this.convulsion))
                                .addGap(130, 130, 130))
        );
        layoutMenu.setVerticalGroup(layoutMenu.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(layoutMenu.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(this.pruebasEstadtisticasButton)
                                .addGap(18, 18, 18)
                                .addComponent(this.composicionButton)
                                .addGap(18, 18, 18)
                                .addComponent(this.transformadaInversa)
                                .addGap(18, 18, 18)
                                .addComponent(this.convulsion)
                                .addContainerGap(55, Short.MAX_VALUE))
        );
        //----------------------------------------------------------------------

        //creamos un layout
        //this.flowLayout = new FlowLayout(FlowLayout.CENTER, 30, 30);
        //this.menuPanel.setLayout(this.flowLayout);//le agregamos el layout al panel del meú
        //Component espaciador = Box.createHorizontalStrut(10);
        this.menuPanel.add(this.pruebasEstadtisticasButton);
        this.menuPanel.add(this.composicionButton);
        this.menuPanel.add(this.transformadaInversa);
        this.menuPanel.add(this.convulsion);
        /*-----------------------------------------------------------------*/
        //agregagmos los componenetes a la ventana
        this.getContentPane().add(this.jPanelTitle);
        this.getContentPane().add(this.panelDescripcion);
        this.getContentPane().add(this.menuPanel);
    }
}
