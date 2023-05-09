/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.variablesaleatorias.generacion_variables_aleatorias;

import Controller.StartApp;
import View.WindowMain;
import java.awt.EventQueue;

/**
 *
 * @author PC
 */
public class Generacion_variables_aleatorias {

    public static void main(String[] args) {
        //nos aseguramos de que cualquier tarea que actualice la GUI,
        //lo haga de manera segura y evita problemas de concurrencia
        EventQueue.invokeLater(() -> {
            //instanciamos WindowMain para mostrar la ventana
            WindowMain windowApp = new WindowMain();
            
            //agregamos widowApp al controlador
            StartApp startApp = new StartApp(windowApp);
        });
    }
}
