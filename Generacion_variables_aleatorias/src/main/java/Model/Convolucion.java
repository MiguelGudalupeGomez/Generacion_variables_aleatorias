package Model;

import java.util.ArrayList;

public class Convolucion {
    
    public ArrayList discretos = new ArrayList();
    public ArrayList continuas = new ArrayList(); 
    
    private double m;
    private int convolucionDiscreta;
    private double convolucionContinua; 
    private final int veces; 
        
    public Convolucion(int veces) {
            
        this.veces = veces; 
        generar(); 
    }
        
    public void generar() {
            
        for(int i=0; i<veces; i++) {
                
            m = Math.random()*10+0;
            convolucionDiscreta = (int) (((int)m - 6) * 8 + 65);
            
            m = Math.random()*10+0;
            convolucionContinua = ((m - 6) * 8 + 65);
            
            discretos.add(convolucionDiscreta);
            continuas.add(convolucionContinua);
        }
    }
}
