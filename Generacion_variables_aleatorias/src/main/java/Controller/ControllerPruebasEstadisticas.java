/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.WindowPruebasEstadisticas;

/**
 *
 * @author Miguel G. Gómez Guzmán
 */
public class ControllerPruebasEstadisticas {
    
    //hacemos uso del patrón Singleton para controlar que solo haya una instancia 
    //por cada WindowPruebasEstadisticas
    public static ControllerPruebasEstadisticas controllerPruebasEstadisticas = null;
    private ControllerPruebasEstadisticas(WindowPruebasEstadisticas windowPruebasEstadisticas){
        this.initComponents();
    }
    
    public static ControllerPruebasEstadisticas otherInstance(WindowPruebasEstadisticas windowPruebasEstadisticas){
        if(windowPruebasEstadisticas == null){
            controllerPruebasEstadisticas = new ControllerPruebasEstadisticas(windowPruebasEstadisticas);
        }
        return controllerPruebasEstadisticas;
    }
    
    public void initComponents(){
        
    }
}
