/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Arrays;
import org.apache.commons.math3.distribution.UniformRealDistribution;
import org.apache.commons.math3.stat.Frequency;
import org.apache.commons.math3.stat.inference.ChiSquareTest;
import org.apache.commons.math3.stat.inference.KolmogorovSmirnovTest;

/**
 *
 * @author PC
 */
public class PruebasEstadisticas {

    //Este método tiene dos parametros, "datos" es un arreglo de datos del que se desea
    //hacer la prueba y "significancia" generalemente se suele usar 0.05 para aceptar 
    //o rechazar la hipotesis nula
    //Si el valor de retorno es true los datos siguen una distribucion uniforme
    public boolean pruebaUniformidad(double[] datos, double significancia) {
        //var retorno = true; //variable de retorno
        Frequency frequency = new Frequency();
        ChiSquareTest test = new ChiSquareTest();
        long[] observed = new long[datos.length];
        double[] expected = new double[datos.length];

        for (var i : datos) {
            frequency.addValue(i);
        }
        for (var i = 0; i < datos.length; i++) {
            observed[i] = frequency.getCount(i + 1);
        }
        Arrays.fill(expected, datos.length / (double) datos.length);
        double pValue = test.chiSquareTest(expected, observed);

        //Si el valor de retorno es true los datos siguen una distribucion uniforme
        return !(pValue < significancia);
    }//fin del método

    //Este método recibe 3 argumentos, un arreglo de numeros pseudoaleatorios "datos"
    //el rango "lower" y "upper" en el que se encuentraen los numeros generados
    //El método devuelve true si la muestra sigue una distribucion uniforme
    public boolean pruebaAleatoriedad(double[] datos, double lower, double upper) {
        KolmogorovSmirnovTest smirnovTest = new KolmogorovSmirnovTest();
        double pValue = smirnovTest.kolmogorovSmirnovTest(new UniformRealDistribution(lower, upper), datos);
        return !(pValue < 0.05);
    }//fin del método

    //Este método tiene como parametro dos arreglos, ambos deben ser del mismo tamaño
    //para poder realizar la prueba
    //El método retorna true si la muestra sigue una distribución independiente
    public boolean pruebaIndependencia(double datos1[], double[] datos2) {
        if (datos1.length != datos2.length) {
            throw new IllegalArgumentException("Los dos arreglos deben tener la misma longitud");
        }
        ChiSquareTest test = new ChiSquareTest();
        long[][] observed = new long[datos1.length][datos1.length];
        for (var i = 0; i < datos1.length; i++) {
            observed[(int) (datos1[i] - 1)][(int) (datos2[i] - 1)]++;
        }
        double pValue = test.chiSquare(observed);
        return !(pValue < 0.05);
    }
}
