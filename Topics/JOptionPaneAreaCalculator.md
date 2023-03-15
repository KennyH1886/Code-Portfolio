
````java

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joptionpane_howardkeneneth;
import javax.swing.JOptionPane;   // needed for dialog box

/**
 * The program find area of rectangle using 
 * input output dialog  box.
 * @author Kenny
 */
public class RectangleTest {
    
public static void main(String[] args) 
{
    
String input;  // to hold String input.
int length;  // to hold length 
int width;  // to hold width 
int area; // to hold area 

//Prompt user to input length.
input = JOptionPane.showInputDialog("Enter Length");

// Convert the String input to an int .
length = Integer.parseInt(input);

// prompt user to input width.
input = JOptionPane.showInputDialog("Enter Width");

// Convert the String input to an int.
width = Integer.parseInt(input);

// Calculate area of rectangle.
area = length * width;

// Display area of rectangle.
JOptionPane.showMessageDialog(null, "Area of rectangle is " + area);

}
````

> Done using swing and netbeans ide
