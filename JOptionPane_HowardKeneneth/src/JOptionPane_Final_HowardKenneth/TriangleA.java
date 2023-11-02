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
public class TriangleA {
      public static void calculateArea() {
        String input;
        double base; // holds base input
        double height; // holds height input 
        double area; // holds area that is length * width
      

        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter base");
        base = Double.parseDouble(input);
        
        
              // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter height");
        height = Double.parseDouble(input);


       
        // calculates area 
        area = (base * height) *  1/2;
        
        // graphic that shows the resulting area
        JOptionPane.showMessageDialog(null, "Area of the Triangle is " + area);
    }
}
