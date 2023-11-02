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
public class ParallelogramA {
    
    public static void calculateArea() {
        String input;
        double length; // holds length iput
        double height; // holds hieght input 
        double area; // holds area that is length * height

        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter Length");
        length = Double.parseDouble(input);

        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter hieght");
        height = Double.parseDouble(input);

    
        // calculates area 
        area = length * height;

        JOptionPane.showMessageDialog(null, "Area of this Parallelogram is " + area);
    
    
}
    
    
    
    
}
