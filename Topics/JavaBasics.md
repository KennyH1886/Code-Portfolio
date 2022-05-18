## Java Basics 

### Basic Program example  

>Start of a **class** in java , remember to always **comment**

````javascript
/**
* for the class salary 
*/
public class Salary{
    
    public static void main (String [] args)
    // example of an initialization for a variable.
    int wage;
    // setting value ot the variable 
    wage = 20;

System.out.Print("Salary is ");
System.out.Println(wage * 40 * 52);    
}


````

### Basic input
>Programs commonly get input values, perform some processing on that input, and put output values to a 
screen or elsewhere. Input is commonly gotten from a keyboard, a file, fields on a web form or app, etc.

The following code at the top of a file enables the program to get input:

>A **Scanner** is a text parser that can get numbers, words, or phrases from an input source such as the keyboard. Getting input is achieved by first creating a Scanner object via the statement:

> **Scanner:** __scnr = new Scanner(System.in);__. System.in corresponds to keyboard input. Then, given Scanner object scnr, the following statement gets an input value and assigns x with that value: **x = scnr.nextInt();**

Example of the **Scanner** being used.

````javascript
// scanner import ( aka the base code that provides the scanner functionality is being called.)
import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
    int wage;
    
    // initializing scanner
    Scanner scnr = new Scanner(System.in);
    //next input to scanner.
    wage = scnr.nextInt();
    
    System.out.print("Salary is ");
    System.out.print(wage * 40 * 52);
}
}
````
#### Basic output: text

The ***System.out.print*** construct supports output. Outputting text is achieved via: System.out.print("desired text");. Text in double quotes " " is known as a string literal. Multiple output statements continue printing on the same output line.
