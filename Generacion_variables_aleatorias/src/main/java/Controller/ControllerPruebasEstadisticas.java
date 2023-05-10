/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.PruebasEstadisticas;
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
    private final WindowPruebasEstadisticas wPruebasEstadisticas;
    //hacemos uso del patrón Singleton para controlar que solo haya una instancia 
    //por cada WindowPruebasEstadisticas
    public static ControllerPruebasEstadisticas controllerPruebasEstadisticas = null;
    public PruebasEstadisticas testStatics;
    private String strUniformidad;
    private String strIndependencia;
    private String strAleatoriedad;

    private ControllerPruebasEstadisticas(WindowPruebasEstadisticas wPruebasEstadisticas) {
        this.wPruebasEstadisticas = wPruebasEstadisticas;
        this.testStatics = new PruebasEstadisticas(); //instanciamos la clase que contiene las pruebas
                                                      //estadísticas
        this.strAleatoriedad = "";
        this.strIndependencia = "";
        this.strUniformidad = "";
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
                System.out.println(i);
                datos1[i] = rand1.nextInt(100) + 1;
                this.wPruebasEstadisticas.defaultTableModel.setValueAt((int) datos1[i], i, 0);
                datos2[i] = rand2.nextInt(100) + 1;
                this.wPruebasEstadisticas.defaultTableModel.setValueAt((int) datos1[i], i, 1);
                this.wPruebasEstadisticas.jTextArea.setText(WindowPruebasEstadisticas.CONTENIDO);
            }
        });
        
        //boton para realizar pruebas estadísticas
        this.wPruebasEstadisticas.buttonRealizarPruebas.addActionListener(e ->{
            if(datos1 != null && datos2 != null){
                //reemplazamos el resultado actual por un campo vacio para evitar irregularidades
                this.wPruebasEstadisticas.jTextArea.setText(this.wPruebasEstadisticas.jTextArea.getText().replaceAll(strUniformidad, ""));
                this.wPruebasEstadisticas.jTextArea.setText(this.wPruebasEstadisticas.jTextArea.getText().replaceAll(strIndependencia, ""));
                this.wPruebasEstadisticas.jTextArea.setText(this.wPruebasEstadisticas.jTextArea.getText().replaceAll(strAleatoriedad, ""));

                var a = this.wPruebasEstadisticas.jTextArea.getText(); //obtenemos el texto

                //realizamos la prueba de uniformidad
                strUniformidad = this.testStatics.pruebaUniformidad(datos1, 0.05) 
                        ? "Los datos la columna \"Datos 1\" SON uniformes\n\n"
                        : "Los datos la columna \"Datos 1\" NO SON uniformes\n\n";
                //realizamos la prueba de aleatoriedad
                strAleatoriedad = this.testStatics.pruebaAleatoriedad(datos1, 1, 100)
                        ? "Los datos la columna \"Datos 1\" SON aleatorios\n\n"
                        : "Los datos la columna \"Datos 1\" NO SON aleatorios \n\n";
                //realizamos la prueba de independencia
                strIndependencia = this.testStatics.pruebaIndependencia(datos1, datos2)
                        ? "Los datos las columnas \"Datos 1\" y \"Datos 2\"\t\nSON independientes\n\n"
                        : "Los datos las columnas \"Datos 1\" y \"Datos 2\"\t\n NO SON independientes\n\n";

                //agregamos los resultados al panel de resultados
                this.wPruebasEstadisticas.jTextArea.setText(a + 
                        strUniformidad + strAleatoriedad + strIndependencia);
            }else{
                JOptionPane.showMessageDialog(null, "¡No hay muestras para analizar!");
            }
        });
    }

}
