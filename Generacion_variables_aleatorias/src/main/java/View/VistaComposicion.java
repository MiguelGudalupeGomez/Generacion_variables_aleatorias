/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author E m m a n u e l
 */
import Model.Composicion;
import javax.swing.*;
import java.awt.Color; 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.table.DefaultTableModel;

public class VistaComposicion extends JFrame{
    
    JPanel panel = new JPanel(); 
    JLabel titulo = new JLabel("MÉTODO DE COMPOSICIÓN");
    JLabel pedir = new JLabel("Cantidad:");
    JTextField veces = new JTextField();
    JButton generar = new JButton("Generar"); 
    JTable tabla = new JTable();
    DefaultTableModel dtm = new DefaultTableModel();
    JScrollPane barra = new JScrollPane(); 
    
    public VistaComposicion() {
        
        setSize(664,445); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Método de composición");
        String [] encabezado = new String[]{"i","Discretas","Continuas"};
       
        dtm.setColumnIdentifiers(encabezado);
        tabla.setModel(dtm); 
        darFormato(); 
    }
    
    public void limpiarTabla() {
        
        for(int i=0; i<dtm.getRowCount(); i++) {
        
            dtm.removeRow(i);
            i-=1; 
        }
    }
    
    public String formatoContinuas(Double numero) {
        String s = Double.toString(Math.abs(numero)); 
        
        if(s.length()>6){
            
            s = s.substring(0,6);
        }
        
        return s; 
    }
    
    public void darFormato() {
        
        panel.setBackground(Color.white);
        panel.setLayout(null); 
        getContentPane().add(panel); 
        
        titulo.setBounds(260,30,370,40); 
        titulo.setFont(new Font("Roboto Black",Font.BOLD,26));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        pedir.setBounds(300,80,100,30);
        pedir.setFont(new Font("Roboto",Font.BOLD,14));
        
        veces.setBounds(390,80,109,30);
        Evento e = new Evento(); 
        veces.addKeyListener(e);
        
        generar.setBounds(335,125,89,32);
        generar.setBackground(new Color(255,255,255));
        generar.setForeground(new Color(255,204,0));
        
        JLabel icono = new JLabel(new ImageIcon("/Dados.png"));
        icono.setBounds(10,30,200,170);
        
        tabla.setBounds(220,130,300,300);
        barra.setBounds(220,130,300,300); 
        barra.setViewportView(tabla);
        
        generar.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarTabla();
                
                int v; 
                v = Integer.parseInt(veces.getText());
                
                Composicion c = new Composicion(v);
                
                for(int i=0; i<v; i++){
                    
                    double continua = (double) c.continuas.get(i);
                    int dis = (int) c.discretas.get(i);
                    
                    String indice = Integer.toString(i+1);
                    String discreta = Integer.toString(dis);
                    
                    String [] fila = new String []{indice,discreta,formatoContinuas(continua)};
                    dtm.addRow(fila);
                }
            }
        });
        
        panel.add(barra); 
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
