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
public class RightCircularConeS {
             public static void calculateArea() {
        String input;
        double radius; // holds radius input
        double height; // holds height input 
        double pi = 3.141592653589793;  // holds the double value for pi
        double x; // holds the value of the square root of radius and height squared. 
        double surfaceArea; // holds volume output
        

      

        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter radius");
        radius= Double.parseDouble(input);     
        
              // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter height");
        height = Double.parseDouble(input);
        
        x = ((radius * radius)+ (height * height));

        Math.sqrt(x);
       
        // calculates volume
        surfaceArea = (x * radius * pi);
          
                
        // graphic that shows the resulting area
        JOptionPane.showMessageDialog(null, "Surface area of this Right Circular Cone is" + surfaceArea);
}    
   
}
