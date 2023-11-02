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
public class TrapezoidA {
          public static void calculateArea() {
        String input;
        double base1; // holds base input
        double base2; // holds height input 
        double hieght;  // holds the hieght 
        double area; // holds area 
      

        
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter base1");
        base1 = Double.parseDouble(input);
        
          // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter base2");
        base2 = Double.parseDouble(input);
        
        
              // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter height");
        hieght = Double.parseDouble(input);


       
        // calculates area 
        area = (base1 + base2) * hieght * 1/2;
        
        // graphic that shows the resulting area
        JOptionPane.showMessageDialog(null, "Area of the Trapezoid is " + area);
    }
    
}
