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

public class SquareCalc extends JFrame implements ActionListener {
   private JTextArea outputArea;                   // Displays area of a square
   private JButton calcButton;                     // Triggers area calculation
   private JFormattedTextField lengthField;        // Holds length of the square's side

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   SquareCalc(){
      GridBagConstraints layoutConst = null;  // Used to specify GUI component layout
      JScrollPane scrollPane = null;          // Container that adds a scroll bar
      JLabel lengthLabel = null;              // Label for length
      JLabel outputLabel = null;              // Label for area

      // Format for the length input
      NumberFormat numberFormat = null;

      // Set frame's title
      setTitle("Square area calculator");

      // Create labels
      lengthLabel = new JLabel("Side length:");
      outputLabel = new JLabel("Area:");

      // Create output area and add it to scroll pane
      outputArea = new JTextArea(10, 15);
      scrollPane = new JScrollPane(outputArea);
      outputArea.setEditable(false);

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
      double area;    // Area of the square
      
       length = ((Number) lengthField.getValue()).intValue();
      
  // Clear the text area
      outputArea.setText("");
      
      area = length * length;
         outputArea.append("The area of this square is: " + area);
      
   }
    /* Creates a SavingsInterestCalcFrame and makes it visible */
   public static void main(String[] args) {
      // Creates SavingsInterestCalcFrame and its components
      SquareCalc myFrame = new SquareCalc();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
        
   }
}