/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class WindowPruebasEstadisticas extends JFrame{
    //definimos una variable de tipo WindowPruebasEstadisticas
    public static WindowPruebasEstadisticas instancia = null;
    private JPanel panelButton; //panel que contendra los botones
    public JPanel panelNumerosGenerados; //panel que contendra la tabla de numeros generados
    public JPanel panelResultados;
    public JButton buttonGenerarNumeros;
    public JButton buttonRealizarPruebas;
    //public DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    public DefaultTableModel defaultTableModel;
    public JTable jTable;
    public JTextArea jTextArea;
    public static final int SIZE_ARRAY = 10000;
    public static final String CONTENIDO = "\n\tPRUEBAS ESTADÍSTICAS\n\n";
    
    
    //hacemos uso del patron singelton para evitar que se cree mas de una instancia
    //de esta clase, cada que se hace click en el boton
    private WindowPruebasEstadisticas(){
        super("Pruebas estadísticas de 10,000 de números, entre 1 y 100");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.initComponents();
        
        this.setVisible(true);
    }
    public static WindowPruebasEstadisticas getInstance(){
        //la ventana solo se creará cuando "instancia" esté vacía (null)
        if(instancia == null){
            //instanciamos la clase
            instancia = new WindowPruebasEstadisticas();
            
        }
        //retornnamos la instancia
        return instancia;
    }
    
    //metodo que al ser llamado inicia el resto de componentes
    private void initComponents(){
        Font font = new Font("Times New Roman", Font.BOLD, 18);
        this.panelButton = new JPanel();
        this.panelButton.setBounds(0, 0, this.getWidth(), 40);
        this.buttonGenerarNumeros = new JButton("Generar números pseudoaleatorios");
        this.buttonGenerarNumeros.setFont(font);
        
        
        this.buttonRealizarPruebas = new JButton("Realizar pruebas");
        this.buttonRealizarPruebas.setFont(font);
        
        this.panelNumerosGenerados = new JPanel();
        this.panelNumerosGenerados.setBackground(Color.CYAN);
        this.panelNumerosGenerados.setBounds(0, 40, (this.getWidth() / 2), this.getHeight());
        
        String[] columnas = {"Datos 1", "Datos 2"};
        Object[][] filas = new Object[WindowPruebasEstadisticas.SIZE_ARRAY][2];
        for(var i :  filas){
            i[0] = "";
            i[1] = "";
        }
        this.defaultTableModel = new DefaultTableModel(filas, columnas);
        this.jTable = new JTable(this.defaultTableModel);
                DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(JLabel.CENTER);
        this.jTable.setDefaultRenderer(Object.class, render);

        this.scrollPane = new JScrollPane(jTable);
        this.scrollPane.setPreferredSize(new Dimension(this.getWidth()/2, this.getHeight()-90));
        this.panelNumerosGenerados.add(scrollPane);
        
        this.panelResultados = new JPanel();
        this.panelResultados.setBounds(this.getWidth()/2, 40, this.getWidth(), this.getHeight()-90);
        this.jTextArea = new JTextArea(CONTENIDO);
        this.jTextArea.setPreferredSize(new Dimension(this.panelResultados.getWidth(), 
                              this.panelResultados.getHeight()));
        this.panelResultados.add(jTextArea);
        
        this.panelButton.add(buttonGenerarNumeros);
        this.panelButton.add(buttonRealizarPruebas);
        
        this.getContentPane().add(panelButton);
        this.getContentPane().add(this.panelNumerosGenerados);
        this.getContentPane().add(this.panelResultados);
    }
}
