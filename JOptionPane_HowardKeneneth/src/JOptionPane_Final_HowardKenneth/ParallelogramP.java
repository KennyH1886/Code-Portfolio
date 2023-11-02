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
public class ParallelogramP {
     public static void calculatePerimeter() {
         
        String input;
        double length; // holds length iput
        double width; // holds hieght input 
        double perimeter; // holds are that is length * height
        double tlength; // holds the length times 2
        double twidth; // holds the width times 2
         
        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter Length");
        length = Double.parseDouble(input);

        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter hieght");
        width = Double.parseDouble(input);

        tlength = length * 2;
        twidth = width * 2;
    
        // calculates Perimeter 
        perimeter = tlength * twidth;

        JOptionPane.showMessageDialog(null, "Perimeter of this Parallelogram is " + perimeter);
    
}
}
