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
public class RectangularSolidV {
      public static void calculateVolume() {
        String input;
        double length; // holds base input
        double height; // holds height input 
        double width;  // holds width input
        double volume; // holds volume output
      

        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter length");
        length= Double.parseDouble(input);
        
           // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter width");
        width= Double.parseDouble(input);
        
        
              // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter height");
        height = Double.parseDouble(input);


       
        // calculates volume
        volume = ( length * width * height);
          
                
        // graphic that shows the resulting volume
        JOptionPane.showMessageDialog(null, "Volume of this Rectangular Solid is " + volume);
}
}