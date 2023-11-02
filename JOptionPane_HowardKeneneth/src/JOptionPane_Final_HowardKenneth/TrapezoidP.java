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
public class TrapezoidP {
            /**
         * calculates the perimeter of a triangle after taking in the required inputs of the base and two sides.
         */
        public static void calculatePerimeter() {
         
        String input;  // input value acts as a scanner
        double side1; // holds length iput
        double side2; // holds hieght input
        double base1; // holds base1 input
        double base2; // holds base2 input
        double perimeter; // holds  the perimeter which is side1 + side 2 + base1 + base2

         
        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter side1");
        side1 = Double.parseDouble(input);

        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter side2");
        side2 = Double.parseDouble(input);      
        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter base1");
        base1 = Double.parseDouble(input);
        
          // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter base2");
        base2 = Double.parseDouble(input);       
    
        // calculates Perimeter 
        perimeter = side1 + side2 + base1 + base2;
        
        // resulting graphic of the result
        JOptionPane.showMessageDialog(null, "Perimeter of this Trapezoid is " + perimeter);
    
}
}