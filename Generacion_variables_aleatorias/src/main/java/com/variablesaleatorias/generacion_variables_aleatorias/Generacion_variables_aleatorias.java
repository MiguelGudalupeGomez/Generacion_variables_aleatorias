/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.variablesaleatorias.generacion_variables_aleatorias;

import Controller.StartApp;
import View.WindowApp;
import java.awt.EventQueue;

/**
 *
 * @author PC
 */
public class Generacion_variables_aleatorias {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            //instanciamos WindowApp para mostrar la ventana
            WindowApp windowApp = new WindowApp();
            
            //agregamos widowApp al controlador
            StartApp startApp = new StartApp(windowApp);
        });
    }
}
