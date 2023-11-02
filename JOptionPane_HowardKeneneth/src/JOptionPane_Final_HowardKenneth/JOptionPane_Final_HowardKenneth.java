/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JOptionPane_Final_HowardKenneth;

import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author 19108
 */
public class JOptionPane_Final_HowardKenneth {
    
    
    /**
     * @param args the command line arguments
     * dialog box that takes the input and selects the various Geometric methods.
     * 
     */
    public static void main(String[] args) {
        JDialog.setDefaultLookAndFeelDecorated(true);
         boolean keepRunning = true;
         
         
       // do while loop to continue the program  
         do {
    Object[] selectionValues = { "Area of a Square", "Perimeter of a Square", "Perimeter of a Rectangle" , "Area of a Rectangle", "Area of a Parallelogram", "Perimeter of a Parallelogram", "Area of a Circle", "Circumfrence of a Circle", "Area of a Triangle", "Perimeter of a Triangle", "Area of a Trapezoid", "Perimeter of a Trapezoid", "Volume of a Rectangular Solid"  ,"Surface Area of a Rectangular Solid" , "Volume of a Cube" , "Surface area of a Cube" , "Volume of a Right Circular Cylinder" ,  "Surface area of Right Circular Cylinder", "Volume of a Sphere", "Surface area of a Sphere", "Volume of a Right Circular Cone" , "Surface area of Right Circular Cone", "Volume of a Square or Rectangular Pyramid", "Surface Area of Right Circular Cone Frustum" , "Volume of a Right Circular Cone Frustum"};
    String initialSelection = "Area of a Square";
    Object selection = JOptionPane.showInputDialog(null, "What do you want to calculate?",
        "Geometry Calculator", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
         SquareCalc squareObject = new SquareCalc();
         SquareCalcP squareObjectP = new SquareCalcP();
         RectangleP rectangleP = new RectangleP();
         RectangleA rectangleA = new RectangleA();
         ParallelogramA parallelogramA = new ParallelogramA();
         ParallelogramP parallelogramP = new ParallelogramP();
         CircleA circleA = new CircleA();
         CircleC circleC = new CircleC();
        Object evt = null;
         TriangleA triangleA = new TriangleA();
         
         

       // switch statement to converts object to string and then matches it for each statement
    switch (selection.toString()) {
      case "Area of a Square":
    squareObject.setVisible(true);    // j command to show the specific gui of the class
    squareObject.setSize(500,300);  // j command to set gui to a certain size 
    squareObject.setLocation(700,400); // j command to set the starting location of gui 
        break;
                
      case "Perimeter of a Square":
    squareObjectP.setVisible(true);    // j command to show the specific gui of the class
    squareObjectP.setSize(500,300);  // j command to set gui to a certain size 
    squareObjectP.setLocation(700,400); // j command to set the starting location of gui 
    squareObjectP.pack();
    break;

      case "Perimeter of a Rectangle":
       RectangleP.calculatePerimeter();
        break;
        
      case "Area of a Rectangle":
       RectangleA.calculateArea();
        break;
        
      case "Area of a Parallelogram":
          ParallelogramA.calculateArea();
        break;
        
       case "Perimeter of a Parallelogram":
           ParallelogramP.calculatePerimeter();
        break;
              case "Area of a Circle":
           CircleA.calculateArea();
        break;
        
         case "Circumfrence of a Circle":
           circleC.jButton1ActionPerformed((ActionEvent) evt);
                      
          break;

              case "Area of a Triangle":
            TriangleA.calculateArea();
        break;
        
              case "Perimeter of a Triangle":
            TriangleP.calculatePerimeter();
        break;
        
              case "Area of a Trapezoid":
                  TrapezoidA.calculateArea();
        break;
        
              case "Perimeter of a Trapezoid":
                  TrapezoidP.calculatePerimeter();
        break;
      
              case "Volume of a Rectangular Solid":
                  RectangularSolidV.calculateVolume();
        break;
              case "Surface Area of a Rectangular Solid" :
                  RectangularSolidA.calculateArea();
        break;
              case "Volume of a Cube":
                  CubeV.calculateVolume();
        break;
              case "Surface area of a Cube":
                  CubeS.calculateSurfaceArea();
        break;
        
              case "Volume of a Right Circular Cylinder":
                  RightCircularCylinderV.calculateVolume();
        break;
              case "Surface area of Right Circular Cylinder":
                  RightCircularCylinderS.calculateArea();
        break;
              case "Volume of a Sphere":
                  SphereV.calculateVolume();
        break;
              case "Surface area of a Sphere":
                  SphereS.calculateVolume();
        break;
              case "Volume of a Right Circular Cone":
                  SphereV.calculateVolume();
        break;
             case "Surface area of Right Circular Cone":
                 RightCircularConeS.calculateArea();
        break;
             case "Volume of a Square or Rectangular Pyramid":
                 SquareOrRectangularPyramidV.calculateVolume();
        break;
             case "Surface Area of Right Circular Cone Frustum":
                 RightCircularConeFrustumS.calculateArea();
        break;
             case "Volume of a Right Circular Cone Frustum":
                 RightCircularConeFrustumV.calculateVolume();
        break;
      default:
          
        break; 
    } 
    
       int response = JOptionPane.showConfirmDialog( null, "Do you want to continue?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        keepRunning = response == JOptionPane.YES_OPTION;
    } while (keepRunning);
         }
}
