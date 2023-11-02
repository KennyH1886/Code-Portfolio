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
public class RightCircularConeFrustumV {
                      public static void calculateVolume() {
        String input;
        double radius; // holds radius input
        double height; // holds height input 
        double R;  // holds the value of big R
        double pi = 3.141592653589793;  // holds the double value for pi
        double volume; // holds volume output
      

        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter radius");
        radius= Double.parseDouble(input);     
        
              // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter height length");
        height = Double.parseDouble(input);

                 // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter R input");
        R = Double.parseDouble(input);


       
        // calculates volume
        volume = ( (pi * ((radius * radius)+(radius * R)+(R * R) * height )) / 3);
          
                
        // graphic that shows the resulting volume
        JOptionPane.showMessageDialog(null, "Volume of this Right Circular Cone Frustum is" + volume);
}
}
