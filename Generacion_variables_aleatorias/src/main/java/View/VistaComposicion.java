/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author E m m a n u e l
 */
import javax.swing.*;
import java.awt.Color; 

public class VistaComposicion extends JFrame{
    
    JPanel panel = new JPanel(); 
    JLabel titulo = new JLabel("MÉTODO DE COMPOSICIÓN");
    JLabel pedir = new JLabel("Cantidad:");
    JTextField veces = new JTextField();
    JButton generar = new JButton("Generar"); 
    
    public VistaComposicion() {
        
        setSize(664,445); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Método de composición");
        darFormato(); 
    }
    
    public void darFormato() {
        
        panel.setBackground(Color.white);
        
    }
}
