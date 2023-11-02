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
public class RectangularSolidA {
    public static void calculateArea() {
        String input;
        double length; // holds base input
        double height; // holds height input 
        double width;  // holds width input
        double surfaceArea; // holds area output
      

        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter length");
        length= Double.parseDouble(input);
        
           // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter width");
        width= Double.parseDouble(input);
        
        
              // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter height");
        height = Double.parseDouble(input);


       
        // calculates area 
        surfaceArea = ( (2 * height * length) + (2 * height * width) + (2 * length * width));
        
        // graphic that shows the resulting area
        JOptionPane.showMessageDialog(null, "Surface area of this Rectangular Solid is " + surfaceArea);
    }
}
