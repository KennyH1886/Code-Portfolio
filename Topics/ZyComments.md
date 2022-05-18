## Comments (Zybooks)

A ***comment*** is text a programmer adds to code, to be read by humans to better understand the code but ignored by the compiler. Two common kinds of comments exist:

A ***single-line comment*** starts with **//** and includes all the following text on that line. Single-line comments commonly appear after a statement on the same line.
A **multi-line comment starts** with /* and ends with */, where all text between /* and */ is part of the comment. A multi-line comment is also known as a block comment.


> example of a how to comment a program

````javascript
import java.util.Scanner;

/*
   This program calculates the amount of pasta to cook, given the
   number of people eating.

   Author: Andrea Giada
   Date:   May 30, 2017
*/

public class PastaCalculator {
   public static void main (String [] args) {
      Scanner scnr = new Scanner(System.in);
      int numPeople;         // Number of people that will be eating
      int totalOuncesPasta;  // Total ounces of pasta to serve numPeople

      // Get number of people
      System.out.println("Enter number of people: ");
      numPeople = scnr.nextInt();

      // Calculate and print total ounces of pasta
      totalOuncesPasta = numPeople * 3;  // Typical ounces per person
      System.out.println("Cook " + totalOuncesPasta + " ounces of pasta.");
   }
}
````

> remember to format code correctly as well.


In programming, every little detail counts. Programmers must get in a mindset of ***paying extreme attention to detail.***

Thus, another reason for caring about whitespace in program output is to help new programmers get into a "precision" mindset when programming. Paying careful attention to details like whitespace instructions, carefully examining feedback regarding whitespace differences, and then modifying a program to exactly match expected whitespace is an exercise in strengthening attention to detail. Such attention can lead programmers to make fewer mistakes when creating programs, thus spending less time debugging, and instead creating programs that work correctly.