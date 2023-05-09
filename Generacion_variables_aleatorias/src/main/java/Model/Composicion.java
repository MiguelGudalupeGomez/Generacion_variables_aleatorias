/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author E m m a n u e l
 */
import java.util.ArrayList;
import java.util.Random;

public class Composicion {
    
    public ArrayList discretas = new ArrayList();
    public ArrayList continuas = new ArrayList();
    
    Random random = new Random();
    
    int veces; 
    
    public Composicion(int veces) {
        this.veces = veces;
        funcionamientoContinuas();
    }
    
    public void funcionamientoContinuas(){   
        // Generamos 5 números aleatorios con distribución uniforme en el rango [0,1]
        for (int i = 0; i < veces; i++) {
            double u1 = random.nextDouble(); // Generamos un número aleatorio con distribución uniforme en el rango [0,1]
            double x = 2 * u1 - 1; // Aplicamos la transformación para obtener un número aleatorio con distribución uniforme en el rango [-1,1]
            double u2 = random.nextDouble(); // Generamos otro número aleatorio con distribución uniforme en el rango [0,1] 
            while (u2 > (1 + x * x) * Math.exp(-x * x / 2)) { // Comprobamos si el número generado cumple con la distribución deseada
               u2 = random.nextDouble(); // Si no cumple, generamos otro número aleatorio
                x = 2 * random.nextDouble() - 1; // Aplicamos la transformación de nuevo para obtener otro número aleatorio con distribución uniforme en el rango [-1,1]
            }
            continuas.add(x); // guardamos el número aleatorio generado con la distribución deseada 
            
            double xDiscreta = Math.abs(x*100); 
            int xDiscretaDos = (int)xDiscreta;            
            discretas.add(xDiscretaDos);
        }
    }
}
