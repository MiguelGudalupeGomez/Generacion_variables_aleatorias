/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Other;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */

public class TransformadaInversa implements ActionListener {
    private final JFrame frame;  // Declaramos la ventana principal como un atributo de la clase
    private final JPanel panel;  // Declaramos el panel para mostrar los números generados como un atributo de la clase
    private final JLabel label1;
    private final JLabel label2;
    private final JLabel label3;  // Declaramos los componentes de texto como atributos de la clase
    private final JLabel label4;  // Declaramos los componentes de texto como atributos de la clase
    private final JTextField field1;
    private final JTextField field2;  // Declaramos los campos de entrada como atributos de la clase
    private final JTextField field3;  // Declaramos los campos de entrada como atributos de la clase
    private final JButton button;  // Declaramos el botón para calcular como un atributo de la clase
    public static TransformadaInversa transformadaInversa;

    private TransformadaInversa() {
        // Crear la ventana principal
        frame = new JFrame("Método de la transformada inversa");
        frame.setLayout(new BorderLayout());

        // Crear el panel para mostrar los números generados aleatoriamente
        panel = new JPanel();
        label4 = new JLabel("Números generados: ");
        panel.add(label4);

        // Crear los campos de entrada y el botón para calcular
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        label1 = new JLabel("Distribución (Exponencial, Uniforme, Normal): ");
        field1 = new JTextField();
        label2 = new JLabel("Parámetro 1: ");
        field2 = new JTextField();
        label3 = new JLabel("Parámetro 2: ");
        field3 = new JTextField();
        button = new JButton("Calcular");
        button.addActionListener(this);
        inputPanel.add(label1);
        inputPanel.add(field1);
        inputPanel.add(label2);
        inputPanel.add(field2);
        inputPanel.add(label3);
        inputPanel.add(field3);
        inputPanel.add(button);

        // Agregar el panel de entrada y el panel de salida a la ventana principal
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        // Configurar la ventana principal
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtener los valores de entrada ingresados por el usuario
        String distribution = field1.getText();
        double param1 = Double.parseDouble(field2.getText());
        double param2 = Double.parseDouble(field3.getText());

        double result = 0.0;
        switch (distribution) {
            case "Exponencial" -> // Si la distribución es exponencial, usar el método de la transformada inversa para generar un número aleatorio
                result = inverseTransformExponential(param1);
            case "Uniforme" -> // Si la distribución es uniforme, usar el método de la transformada inversa para generar un número aleatorio
                result = inverseTransformUniform(param1, param2);
            case "Normal" -> // Si la distribución es normal, usar el método de la transformada inversa para generar un número aleatorio
                result = inverseTransformNormal(param1, param2);
            default -> {
            }
        }

        // Mostrar el resultado en una ventana emergente
        JOptionPane.showMessageDialog(frame, "El resultado es: " + result);

        // Agregar el número generado aleatoriamente al panel
        JLabel label = new JLabel(Double.toString(result));
        panel.add(label);
        panel.revalidate();
        panel.repaint();
    }

    private double inverseTransformExponential(double lambda) {
        // Generar un número aleatorio uniforme en el rango (0, 1)
        double u = Math.random();

        // Aplicar la transformación inversa para generar un número aleatorio exponencial con parámetro lambda
        return -Math.log(1 - u) / lambda;
    }

    private double inverseTransformUniform(double a, double b) {
        // Generar un número aleatorio uniforme en el rango (0, 1)
        double u = Math.random();

        // Aplicar la transformación inversa para generar un número aleatorio uniforme en el rango (a, b)
        return a + (b - a) * u;
    }

    private double inverseTransformNormal(double mean, double sd) {
        // Generar dos números aleatorios uniformes en el rango (0, 1)
        double u1 = Math.random();
        double u2 = Math.random();

        // Aplicar la transformación inversa para generar un número aleatorio normal con media mean y desviación estándar sd
        double z = Math.sqrt(-2 * Math.log(u1)) * Math.cos(2 * Math.PI * u2);
        return mean + sd * z;
    }
    
    public static TransformadaInversa getInstance(){
        if(transformadaInversa == null){
            transformadaInversa = new TransformadaInversa();
        }
        return transformadaInversa;
    }
}