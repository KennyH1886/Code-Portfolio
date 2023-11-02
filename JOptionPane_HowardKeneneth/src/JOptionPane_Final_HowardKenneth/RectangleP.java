/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JOptionPane_Final_HowardKenneth;
import javax.swing.JOptionPane;   // needed for dialog box


/**
 * The program find area of rectangle using 
 * input output dialog  box.
 * @author Kenny
 */
public class RectangleP {
    
public static void calculatePerimeter() {
        String input;
        double length;  // holds length value
        double width;  // holds width value
        double tlength; // holds the value for length times 2
        double twidth; // holds the value for width times 2
        double perimeter; // holds the output of the perimeter.

        
         // takes the length input value 
        input = JOptionPane.showInputDialog("Enter Length");
        length = Double.parseDouble(input);

        
        // takes into the width input value
        input = JOptionPane.showInputDialog("Enter Width");
        width = Double.parseDouble(input);

        
          
        tlength = length * 2;
        twidth = width * 2;
        
        
        // perimeter formula
        perimeter = tlength * twidth;
        
        
        // output value 
        JOptionPane.showMessageDialog(null, "Perimeter of rectangle is " + perimeter);
    }
}

    



