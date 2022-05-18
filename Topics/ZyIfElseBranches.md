# Branches (if-else)

In a program, a **branch** is a sequence of statements only executed under a certain condition. Ex: A hotel may discount a price only for people over age 65. An if branch is a branch taken only IF an expression is true.


**If-else** branches
An if-else branch has two branches: The first branch is executed IF an expression is true, ELSE the other branch is executed.

### Detecting if two statments are Equal using IF statements

A program commonly needs to determine if two items are equal. Ex: If a hotel gives a discount for guests on their 50th wedding anniversary, a program to calculate the discount can check if a variable numYears is equal to the value 50. A programmer can use an if statement to check if two values are equal.

An **if statement** executes a group of statements if an expression is true. Braces surround the if branch's statements. Braces { }, sometimes redundantly called curly braces, represent a grouping, such as a grouping of statements. Note: { } are braces, [ ] are brackets.

The example below uses ==. The equality operator (==) evaluates to true if the left and right sides are equal. Ex: If numYears is 50, then numYears == 50 evaluates to true. Note the equality operator is ==, not =.

Good practice is to indent a branch's statements, using a consistent number of spaces. This material indents 3 spaces.
> example of a if else statement

````javascript
public static void main (String [] args) {
   Scanner scnr = new Scanner(System.in);   
   int hotelRate;
   int numYears;

   hotelRate = 150;

   System.out.print("Enter years married: ");
   numYears = scnr.nextInt();

   if (numYears == 50) {
      System.out.print("Congrats on 50 years ");
      System.out.println("of marriage!");

      hotelRate = hotelRate / 2;
   }

   System.out.print("Your hotel rate: ");
   System.out.println(hotelRate);
````

````html
Enter Years married: 50
Congrats on 50 years of marriage!
Your hotel rate: 75

````

### Equality and inequality operators

| Oprator       | Description          | Example(assume x is 3)  |
| ------------- |:-------------:| -----:|
| ==      | a == b means a is eqaul to b | $x == 3 is true
|!=|a =! b means a is not equal to b |x1=3 is false ,x!=4 is true|


### Multi Branch IF-else examples 

````javascript

import java.util.Scanner;

public class MultIfElseAnniv {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int numYears;

      System.out.print("Enter number years married: ");
      numYears = scnr.nextInt();

      if (numYears == 1) {
         System.out.println("Your first year -- great!");
      }
      else if (numYears == 10) {
         System.out.println("A whole decade -- impressive.");
      }
      else if (numYears == 25) {
         System.out.println("Your silver anniversary -- enjoy.");
      }
      else if (numYears == 50) {
         System.out.println("Your golden anniversary -- amazing.");
      }
      else {
         System.out.println("Nothing special.");
      }
   }
}
````

#### output:
````html
Enter number years married: 10
A whole decade -- impressive.

...

Enter number years married: 25
Your silver anniversary -- enjoy.

...

Enter number years married: 30
Nothing special.

...

Enter number years married: 1
Your first year -- great!
````



### Detecting ranges with IF  else 



