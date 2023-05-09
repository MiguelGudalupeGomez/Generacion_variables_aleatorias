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
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        
        titulo.setBounds(280,30,370,40); 
        titulo.setFont(new Font("Roboto Black",Font.BOLD,26));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        pedir.setBounds(300,80,50,30);
        pedir.setFont(new Font("Roboto",Font.BOLD,14));
        
        veces.setBounds(390,80,109,30);
        Evento e = new Evento(); 
        veces.addKeyListener(e);
        
        generar.setBounds(320,120,89,32);
        generar.setBackground(new Color(255,255,255));
        generar.setForeground(new Color(255,204,0));
        
        JLabel icono = new JLabel(new ImageIcon("/Dados.png"));
        icono.setBounds(10,30,200,170);
        
        panel.add(icono); 
        panel.add(generar); 
        panel.add(veces); 
        panel.add(pedir); 
        panel.add(titulo); 
        
    }
    
    
    private class Evento implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) { // para no ingresar el letras "solo números"
            if(e.getKeyChar()<'0' || e.getKeyChar()>'9') e.consume(); 
        }

        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
        
    }
}
