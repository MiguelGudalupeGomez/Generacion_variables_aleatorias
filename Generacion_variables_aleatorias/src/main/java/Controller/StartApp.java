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

    public StartApp(WindowMain windowApp) {
        this.windowApp = windowApp;

        this.initComponents();
    }

    private void initComponents() {
        //definicmos el comportamiento para el boton Composicion
        this.windowApp.composicionButton.addActionListener(e -> {

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

    }
}
