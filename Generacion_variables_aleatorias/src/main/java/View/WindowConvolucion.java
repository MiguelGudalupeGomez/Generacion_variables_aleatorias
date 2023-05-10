package View;

import Model.Convolucion;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class WindowConvolucion extends JFrame{
    
    JPanel panel = new JPanel(); 
    JLabel titulo = new JLabel("MÉTODO DE CONVOLUCIÓN");
    JLabel pedir = new JLabel("Veces : ");
    JTextField veces = new JTextField();
    JButton generar = new JButton("Generar"); 
    JTable tabla = new JTable();
    DefaultTableModel dtm = new DefaultTableModel();
    JScrollPane barra = new JScrollPane(); 
    
    public WindowConvolucion() {
        
        setSize(664,445); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Método de convolución | Equipo 2");
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
        
        titulo.setBounds(260,10,370,40); 
        titulo.setFont(new Font("Roboto Black",Font.BOLD,26));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        pedir.setBounds(350,60,100,30);
        pedir.setFont(new Font("Roboto",Font.BOLD,14));
        
        veces.setBounds(440,60,109,30);
        Evento e = new Evento(); 
        veces.addKeyListener(e);
        
        generar.setBounds(385,105,89,32);
        generar.setBackground(new Color(255,255,255));
        generar.setForeground(Color.RED);
        
        JLabel icono = new JLabel(new ImageIcon("Poker.png"));
        icono.setBounds(10,30,200,170);
        
        tabla.setBounds(280,155,330,240);
        barra.setBounds(280,155,330,240); 
        barra.setViewportView(tabla);
        
        generar.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarTabla();
                
                int v; 
                try{
                    
                    v = Integer.parseInt(veces.getText());
                
                    Convolucion c = new Convolucion(v);

                    for(int i=0; i<v; i++){

                        double continua = (double) c.continuas.get(i);
                        int dis = (int) c.discretos.get(i);

                        String indice = Integer.toString(i+1);
                        String discreta = Integer.toString(dis);

                        String [] fila = new String []{indice,discreta,formatoContinuas(continua)};
                        dtm.addRow(fila);
                    }
                    
                }catch(NumberFormatException n){}
                
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
