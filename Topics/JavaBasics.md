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


#### Output Examples: code

````Javascript
import java.util.Scanner;

public class ShowMarriedNames {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String firstName1;
      String lastName1;
      String firstName2;
      String lastName2;
      
      System.out.println("What is the first person's first name?");
      firstName1 = scnr.nextLine();
      System.out.println("What is the first person's last name?");
      lastName1  = scnr.nextLine();

      System.out.println("What is the second person's first name?");
      firstName2 = scnr.nextLine();
      System.out.println("What is the second person's last name?");
      lastName2  = scnr.nextLine();

      System.out.println("Here are some common married-couple names:");
      System.out.println(firstName1 + " " + lastName1 + " and " +
                         firstName2 + " " + lastName2);
      System.out.println(firstName1 + " and " + firstName2 + " " + lastName1);
      System.out.println(firstName1 + " and " + firstName2 + " " + lastName2);
      // FIXME: Print two hyphenated last name options, with either last name
      //        appearing first. (A hyphen can be written as "-")
      
   }
}
````
#### input: 
- Pat
- Smith
- Kelly
- Jones

#### Output:

````html

What is the first person's first name?
What is the first person's last name?
What is the second person's first name?
What is the second person's last name?
Here are some common married-couple names:
Pat Smith and Kelly Jones
Pat and Kelly Smith
Pat and Kelly Jones

````





