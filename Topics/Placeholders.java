/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JOptionPane_HowardKenneth;

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
public class Placeholders {


public class SavingsInterestCalcFrame extends JFrame implements ActionListener {
   private final JTextArea outputArea;                  // Displays yearly savings
   private final JButton calcButton;                    // Triggers savings calculation
   private final JFormattedTextField initSValueField;  // Holds savings amount
   private final JFormattedTextField yearsField;        // Holds num years


   
   
   
   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   SavingsInterestCalcFrame() {
      GridBagConstraints layoutConst = null; // Used to specify GUI component layout
      JScrollPane scrollPane = null;         // Container that adds a scroll bar
      JLabel initSValue = null;        // Label initial s value
      JLabel outputLabel = null;             // Label for Area of a circle

      // Format for the savings input
      NumberFormat currencyFormat = null;
      
      // Format for the interest rate input
      NumberFormat percentFormat = null;
      
      // Format for the years input
      NumberFormat integerFormat = null;

      // Set frame's title
      setTitle("Area of a Circle calculator");

      // Create labels
      initSValue = new JLabel("s:");
      outputLabel = new JLabel("Area:");

      // Create output area and add it to scroll pane
      outputArea = new JTextArea(10, 15);
      scrollPane = new JScrollPane(outputArea);
      outputArea.setEditable(false);

      calcButton = new JButton("Calculate");
      calcButton.addActionListener(this);

      // Create savings field and specify the currency format
      currencyFormat = NumberFormat.getCurrencyInstance();
      initSValueField = new JFormattedTextField(currencyFormat);
      initSValueField.setEditable(true);
      initSValueField.setColumns(10); // Initial width of 10 units
      initSValueField.setValue(0);

  

      // Create years field and specify the default number (for doubles) format
      integerFormat = NumberFormat.getIntegerInstance();
      yearsField = new JFormattedTextField(integerFormat);
      yearsField.setEditable(true);
      yearsField.setValue(0);

      // Use a GridBagLayout
      setLayout(new GridBagLayout());

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      add(initSValue, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 1, 5, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      add(initSValueField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(5, 1, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 2;
      add(yearsField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(0, 5, 0, 10);
      layoutConst.fill = GridBagConstraints.BOTH;
      layoutConst.gridx = 2;
      layoutConst.gridy = 1;
      add(calcButton, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 3;
      add(outputLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 4;
      layoutConst.gridwidth = 3; // 3 cells wide
      add(scrollPane, layoutConst);
   }

   @Override
   public void actionPerformed(ActionEvent event) {
      int i;                       // Loop index
      double s;       //  s value of a circle
      double Area;                // Area to calculate 

      // Get values from fields
      s = ((Number) initSValueField.getValue()).intValue();
     
       Area = ((Number) yearsField.getValue()).intValue();

      // Clear the text area
      outputArea.setText("");

      // Calculate savings iteratively in a while loop
      

   /* Creates a SavingsInterestCalcFrame and makes it visible */
    Area=s*s;
   

   }
  
//    /**
//     *
//     * @param args
//     */
//    public void main(String[] args) {
//      // Creates HeightConverterFrame and its components
//      SavingsInterestCalcFrame myFrame = new SavingsInterestCalcFrame();

//      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      myFrame.pack();
//      myFrame.setVisible(true);
   
   
    
    
    }}






    // rectangle perimeter code 



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JOptionPane_HowardKenneth;

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
public class RectangleP extends JFrame implements ActionListener {
  private JTextArea outputPerimeter;                   // Displays area of a square
   private JButton calcButton;                     // Triggers area calculation
   private JFormattedTextField lengthField;        // Holds length of the rectangles's side
   private JFormattedTextField widthField;
   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   RectangleP(){
      GridBagConstraints layoutConst = null;  // Used to specify GUI component layout
      JScrollPane scrollPane = null;          // Container that adds a scroll bar
      JLabel lengthLabel = null;  
      JLabel widthLabel = null;// Label for width
      JLabel outputLabel = null;              // Label for output

      // Format for the length input
      NumberFormat numberFormat = null;
      
         // Format for the width input
      NumberFormat widthFormat = null;
      
      

      // Set frame's title
      setTitle("Perimeter of a Rectangle calculator");

      // Create labels
      lengthLabel = new JLabel("Length:");
      widthLabel = new JLabel("Width:");
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

       // Create width field and specify the default number format
      widthFormat = NumberFormat.getNumberInstance();
      widthField = new JFormattedTextField(widthFormat);
      widthField.setEditable(true);
      widthField.setColumns(10); // Initial width of 10 units
      widthField.setValue(0);
      
   

      
      // Use a GridBagLayout
      setLayout(new GridBagLayout());
      
         layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(5, 10, 5, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      add(widthLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(5, 1, 5, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      add(widthField, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      add(lengthLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 1, 5, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 1;
      add(lengthField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(0, 5, 0, 10);
      layoutConst.fill = GridBagConstraints.NONE;
      layoutConst.anchor = GridBagConstraints.CENTER;
      layoutConst.gridx = 0;
      layoutConst.gridy = 2;
      add(calcButton, layoutConst);
      
            // controls graphic placement for out put
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 3;
      add(outputLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;      
      layoutConst.gridy = 4;
      layoutConst.gridwidth = 3;
      add(scrollPane, layoutConst);
      
       pack();
   }

   // Called when calcButton is clicked
   public void actionPerformed(ActionEvent event) {
      double length;  // Length of the Rectangle
      double width;   // Width fo the rectangle 
      double perimeter;    // Periemter of the rectangle
      double tWidth;     // value to store 2 times the width 
      double tLength;   // value to store two times the length 
      
      
      
      
      
       length = ((Number) lengthField.getValue()).intValue();
       width = ((Number) widthField.getValue()).intValue();
      
  // Clear the text area
      outputPerimeter.setText("");
      tLength = length * 2;
      tWidth = width * 2;
      
      
      perimeter =  tLength + tWidth ;
         outputPerimeter.append("The Perimeter of this Rectangle is: " + perimeter);
      
   }
    /* Creates a SavingsInterestCalcFrame and makes it visible */
   public static void main(String[] args) {
      // Creates SavingsInterestCalcFrame and its components
      RectangleP myFrame = new RectangleP();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
        
   }
}

    
   