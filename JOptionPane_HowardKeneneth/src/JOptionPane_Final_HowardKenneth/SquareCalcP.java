/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JOptionPane_Final_HowardKenneth;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



/**
 *
 * @author 19108
 */
public class SquareCalcP extends JFrame implements ActionListener {
 private JTextArea outputPerimeter;                   // Displays area of a square
   private JButton calcButton;                     // Triggers area calculation
   private JFormattedTextField lengthField;        // Holds length of the square's side

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   SquareCalcP(){
      GridBagConstraints layoutConst = null;  // Used to specify GUI component layout
      JScrollPane scrollPane = null;          // Container that adds a scroll bar
      JLabel lengthLabel = null;              // Label for length
      JLabel outputLabel = null;              // Label for area

      // Format for the length input
      NumberFormat numberFormat = null;

      // Set frame's title
      setTitle("Square Perimeter calculator");

      // Create labels
      lengthLabel = new JLabel("Side length:");
      outputLabel = new JLabel("Perimeter:");

      // Create output area and add it to scroll pane
      outputPerimeter = new JTextArea(10, 15);
      scrollPane = new JScrollPane(outputPerimeter);
      outputPerimeter.setEditable(false);

      calcButton = new JButton("Calculate");
      calcButton.addActionListener(this);

      // Create length field and specify the default number format
      numberFormat = NumberFormat.getNumberInstance();
      lengthField = new JFormattedTextField(numberFormat);
      lengthField.setEditable(true);
      lengthField.setColumns(10); // Initial width of 10 units
      lengthField.setValue(0);

      // Use a GridBagLayout
      setLayout(new GridBagLayout());

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      add(lengthLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 1, 5, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      add(lengthField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(0, 5, 0, 10);
      layoutConst.fill = GridBagConstraints.BOTH;
      layoutConst.gridx = 2;
      layoutConst.gridy = 0;
      add(calcButton, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      add(outputLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 2;
      layoutConst.gridwidth = 3;
      add(scrollPane, layoutConst);
   }

   // Called when calcButton is clicked
   public void actionPerformed(ActionEvent event) {
      double length;  // Length of the square's side
      double perimeter;    // Area of the square
      
       length = ((Number) lengthField.getValue()).intValue();
      
  // Clear the text area
      outputPerimeter.setText("");
      
      perimeter = length * 4;
         outputPerimeter.append("The Perimeter of this square is: " + perimeter);
      
   }
    /* Creates a SavingsInterestCalcFrame and makes it visible */
   public static void main(String[] args) {
      // Creates SavingsInterestCalcFrame and its components
      SquareCalcP myFrame = new SquareCalcP();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
        
   }
}