/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Other.TransformadaInversa;
import View.VistaComposicion;
import View.WindowMain;
import View.WindowPruebasEstadisticas;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author PC
 */
public class StartApp {

    private final WindowMain windowApp; //creamos una variable de de la ventan principal

    public StartApp(WindowMain windowApp) {
        this.windowApp = windowApp; //asignamos el valor del argumento a nuestra variable local
        this.initComponents(); //inicamos los componentes
    }
    
    //definicmos los componentes
    private void initComponents() {
        //definicmos el comportamiento para el boton Composicion
        this.windowApp.composicionButton.addActionListener(e -> {
            new VistaComposicion().setVisible(true);
        });

        //definimos el comportamiento del boton pruebas estadísticas
        this.windowApp.pruebasEstadtisticasButton.addActionListener(e -> {
            //generamos una instancia de la ventana de las pruebas estadísticas
            WindowPruebasEstadisticas wPruebasEstadisticas = WindowPruebasEstadisticas.getInstance();
            //generamos una instancia del controlador de las pruebas estadísticas
            ControllerPruebasEstadisticas.getInstance(wPruebasEstadisticas);

            //detectemos que la ventana de pruebas estadísticas se cierre
            wPruebasEstadisticas.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    //cuando se cierra la ventana la instancia la reestablecemos a null
                    //con eso controlamos que solo se instancie el objeto cuando no hay otro objeto
                    //del mismo tipo ya creado
                    WindowPruebasEstadisticas.instancia = null;
                }

            });

        });
        
        this.windowApp.transformadaInversa.addActionListener(e ->{
            TransformadaInversa.getInstance();
        });
        this.windowApp.convulsion.addActionListener(e -> {
            //code
        });
    }
}
