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
public class CubeV {
          public static void calculateVolume() {
        String input;
        double side; // holds side input
        double volume; // holds volume output
      

        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter side");
        side= Double.parseDouble(input);
        

       
        // calculates volume
        volume = ( side * side * side);
          
                
        // graphic that shows the resulting area
        JOptionPane.showMessageDialog(null, "Volume of the Cube is " + volume);
}
}
