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
public class TriangleP {
        /**
         * calculates the perimeter of a triangle after taking in the required inputs of the base and two sides.
         */
        public static void calculatePerimeter() {
         
        String input;  // input value acts as a scanner
        double side1; // holds length iput
        double side2; // holds hieght input
        double base; // holds base input
        double perimeter; // holds  the perimeter which is side1 + side 2 + base
         
        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter side1");
        side1 = Double.parseDouble(input);

        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter side2");
        side2 = Double.parseDouble(input);
             
        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter base");
        base = Double.parseDouble(input);

        
        // calculates Perimeter 
        perimeter = side1 + side2 + base;
        
        // resulting graphic of the result
        JOptionPane.showMessageDialog(null, "Perimeter of this Triangle is " + perimeter);
    
        }
}
