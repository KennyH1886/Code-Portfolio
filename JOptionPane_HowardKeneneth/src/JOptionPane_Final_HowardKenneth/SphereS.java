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
public class SphereS {
                  public static void calculateVolume() {
        String input;
        double radius; // holds radius input
        double pi = 3.141592653589793;  // holds the double value for pi
        double surfaceArea; // holds volume output
      

        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter radius");
        radius= Double.parseDouble(input);     
        
   

       
        // calculates volume
        surfaceArea = ( ((4)* pi)*(radius * radius ));
          
                
        // graphic that shows the resulting area
        JOptionPane.showMessageDialog(null, "Surface area of this Sphere is" + surfaceArea);
}
}
