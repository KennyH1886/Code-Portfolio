# Basic Graphics 
### Java supports a set of objects for developing ***graphical applications***. A graphical application is a program that displays drawings and other graphical objects. Graphical applications display their contents inside a window called a ***frame*** using a ***JFrame object***. The following program shows how to create and configure a JFrame object to display an empty application window.

> Creating a JFrame object for a graphical application.
````java

import javax.swing.JFrame;

public class EmptyFrame {
   public static void main(String[] args) {
      
      // Construct the JFrame object
      JFrame appFrame = new JFrame();

      // Set the frame's width (400) and height (250) in pixels
      appFrame.setSize(400, 250);
      
      // Set the frame's title
      appFrame.setTitle("An Empty Frame");
      
      // Set the program to exit when the user
      // closes the frame
      appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Make the frame visible to the user
      appFrame.setVisible(true);
   }
}
````

<img title="a title" alt="Alt text" src="GuiPic1.png">