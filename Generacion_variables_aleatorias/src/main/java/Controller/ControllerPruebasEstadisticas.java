/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.WindowPruebasEstadisticas;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel G. Gómez Guzmán
 */
public class ControllerPruebasEstadisticas {

    double[] datos1;
    double[] datos2;
    private WindowPruebasEstadisticas wPruebasEstadisticas;
    //hacemos uso del patrón Singleton para controlar que solo haya una instancia 
    //por cada WindowPruebasEstadisticas
    public static ControllerPruebasEstadisticas controllerPruebasEstadisticas = null;

    private ControllerPruebasEstadisticas(WindowPruebasEstadisticas wPruebasEstadisticas) {
        this.wPruebasEstadisticas = wPruebasEstadisticas;
        System.out.println("hola mundo");
        this.initComponents();
    }

    public static ControllerPruebasEstadisticas getInstance(WindowPruebasEstadisticas windowPruebasEstadisticas) {
        if (controllerPruebasEstadisticas == null) {
            controllerPruebasEstadisticas = new ControllerPruebasEstadisticas(windowPruebasEstadisticas);
        }
        return controllerPruebasEstadisticas;
    }

    private void initComponents() {
        
        //boton para generar números
        this.wPruebasEstadisticas.buttonGenerarNumeros.addActionListener((var e) -> {
            wPruebasEstadisticas.defaultTableModel = (DefaultTableModel) this.wPruebasEstadisticas.jTable.getModel();
            datos1 = new double[WindowPruebasEstadisticas.SIZE_ARRAY];
            datos2 = new double[WindowPruebasEstadisticas.SIZE_ARRAY];
            Random rand1 = new Random();
            Random rand2 = new Random();
            Thread hilo = new Thread() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, "Generando números");
                }
            };
            hilo.start();

            for (var i = 0; i < WindowPruebasEstadisticas.SIZE_ARRAY; i++) {
                datos1[i] = rand1.nextInt(100) + 1;
                this.wPruebasEstadisticas.defaultTableModel.setValueAt((int) datos1[i], i, 0);
                datos2[i] = rand2.nextInt(100) + 1;
                this.wPruebasEstadisticas.defaultTableModel.setValueAt((int) datos1[i], i, 1);
            }

        });
        
        //boton para realizar pruebas estadísticas
        this.wPruebasEstadisticas.buttonRealizarPruebas.addActionListener(e ->{
            //codigo
        });
    }

}
