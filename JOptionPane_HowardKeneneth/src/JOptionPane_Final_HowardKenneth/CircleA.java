/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JOptionPane_Final_HowardKenneth;

import javax.swing.JOptionPane;

/**
 *
 * @author 19108
 */
public class CircleA {
    public static void calculateArea() {
        String input;
        double pi = 3.141592653589793; // holds length iput
        double radius; // holds width input 
        double area; // holds area that is length * width
        double dradius; // holds the value for radius squared

        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter radius");
        radius = Double.parseDouble(input);

       dradius = radius * radius; 
       
        // calculates area 
        area = pi * dradius;
        
        
        JOptionPane.showMessageDialog(null, "Area of circle is " + area);
    }
}
