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
public class CubeS {
          public static void calculateSurfaceArea() {
        String input;
        double side; // holds side input
        double surfaceArea; // holds volume output
      

        
     
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter side");
        side= Double.parseDouble(input);
        

       
        // calculates volume
        surfaceArea = ( (side * side) * 6);
          
                
        // graphic that shows the resulting area
        JOptionPane.showMessageDialog(null, "Surface area of this Cube is " + surfaceArea);
}
}
