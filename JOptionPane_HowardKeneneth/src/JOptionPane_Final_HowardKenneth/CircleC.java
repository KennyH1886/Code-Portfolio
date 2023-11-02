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
public class CircleC {
     void jButton1ActionPerformed(java.awt.event.ActionEvent evt){
        String input;
        double pi = 3.141592653589793; // holds length iput
        double radius; // holds width input 
        double diameter; // holds the value of the diameter
        double area; // holds are that is length * width
        double dradius; // holds the value for radius squared
        double twoPi;   // holds the value for two times pi
        double circumfrence;

       int response =  JOptionPane.showConfirmDialog(null, "Would you like to input the diameter(YES) or the radius(NO)?", "Confirm", JOptionPane.YES_NO_OPTION  , JOptionPane.QUESTION_MESSAGE );

        
        if (response == JOptionPane.YES_OPTION ){
            
            System.out.print("YES, you have selected to enter the diameter!");     
             // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter diameter ");
        diameter = Double.parseDouble(input);
        
        
            // calculates the circumference using the diameter d * pi
          circumfrence = pi * diameter; 
        
        // gui graphic that shows the result
         JOptionPane.showMessageDialog(null, "The circumference is " + circumfrence);
         
         
        }else if(response == JOptionPane.NO_OPTION) {
            // prints message to show what option was selected.
            System.out.print("No, you have selected to enter the radius!");
            
        // gui graphic and input code message
        input = JOptionPane.showInputDialog("Enter radius");
        radius = Double.parseDouble(input);
        
        
        
        // calculates pi squared 
        twoPi = 2 * pi;
        
        // calculates the circumference using the radius 2pi * r
        circumfrence = twoPi * radius; 
        
        // gui graphic that shows the result
         JOptionPane.showMessageDialog(null, "The circumference is " + circumfrence);
        
     }        
        

        


      
        
        
       
    }
     

     
}
