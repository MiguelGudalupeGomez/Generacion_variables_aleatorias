/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Composicion;
import Model.PruebasEstadisticas;
import View.WindowMain;
import View.WindowPruebasEstadisticas;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author PC
 */
public class StartApp {
    private PruebasEstadisticas pEstadisticas;
    private Composicion composicion;
    private WindowMain windowApp;
    
    public StartApp(WindowMain windowApp){
        this.windowApp = windowApp;
        
        this.initComponents();
    }
    private void initComponents(){
        //definicmos el comportamiento para el boton Composicion
        windowApp.composicionButton.addActionListener(e -> {
        
        });
        
        //definimos el comportamiento del boton pruebas estadísticas
        windowApp.pruebasEstadtisticasButton.addActionListener(e -> {
            WindowPruebasEstadisticas wPruebasEstadisticas = WindowPruebasEstadisticas.otraInstancia();
            
            //detectemos que la ventana de pruebas estadísticas se cierre
            wPruebasEstadisticas.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e){
                    //cuando se cierra la ventana el la instancia la reestablecemos a null
                    //con eso controlamos que solo se instancie el objeto cuando no hay otro objeto
                    //del mismo tipo
                    WindowPruebasEstadisticas.instancia = null;
                }
            
            });
        
        });
        
    }
}
