## Loops
> A ***while loop*** is a program construct that repeatedly executes a list of sub-statements (known as the loop body) while the loop's expression evaluates to true. Each execution of the loop body is called an ***iteration***. Once entering the loop body, execution continues to the body's end, even if the expression would become false midway through.
````java 
while (expression) { // Loop expression
    // Loop body: Executes if expression evaluated to true 
    // After body, execution jumps back to the "while"
}
// Statements that execute after the expression evaluates to false
````



````java 
import java.util.Scanner;

public class CountUp {
  public static void main(String[] args) {
     Scanner scnr = new Scanner(System.in);
     int currPower;
     char userChar;
 
     currPower = 2;
     userChar = 'y';
 
     while (userChar == 'y') {
        System.out.println(currPower);
        currPower = currPower * 2;
        userChar = scnr.next().charAt(0);
     }
 
     System.out.println("Done");
  }
}
````
1. When encountered, a while loop's expression is evaluated. If true, the loop's body is entered. Here, userChar was initialized with 'y', so userChar == 'y' is true.
2. Thus, the loop body is executed, which outputs currPower's current value of 2, doubles currPower, and gets the next input.
3. Execution jumps back to the while part. userChar is 'y' (the first input), so userChar == 'y' is true, and the loop body executes (again), outputting 4.
4. userChar is 'y' (the second user input), so userChar == 'y' is true, and the loop body executes (a third time), outputting 8.
5. userChar is now 'n', so userChar == 'y' is false. Thus, execution jumps to after the loop, which outputs "Done".

````java 
import java.util.Scanner;

public class ConvertCtoF {
   public static void main(String [] args) {
      Scanner scnr = new Scanner(System.in);
      double celsiusValue;
      double fahrenheitValue;
      char userChar;

      celsiusValue = 0.0;
      userChar = 'y';

      while (userChar == 'y') {
         fahrenheitValue = (celsiusValue * 9.0 / 5.0) + 32.0;

         System.out.print(celsiusValue + " C is ");
         System.out.println(fahrenheitValue + " F"); 

         System.out.print("Type y to continue, any other to quit: ");
         userChar = scnr.next().charAt(0);

         celsiusValue = celsiusValue + 5;
         System.out.println("");
      }
   
      System.out.println("Goodbye.");
   }
}
````


## Getting input before a loop

The above examples got user input into a variable only at the end of the loop body. The examples assigned that variable an initial value that always caused the loop body to execute the first time. Another common pattern gets that initial value from user input as well, thus getting input in two places: before the loop, and at the loop body's end.


````java
// Get input into userChar

while (userChar == 'y') {
   // Do something ...
   // Get input into userChar
}

````



````java
import java.util.Scanner;

public class AncestorsPrinter {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      final int YEARS_PER_GEN = 20; // Approx. years per generation
      int userYear;                 // User input
      int consYear;                 // Year being considered
      int numAnc;                   // Approx. ancestors in considered year

      consYear = 2020;
      numAnc = 2;

      System.out.print("Enter a past year (neg. for B.C.): ");
      userYear = scnr.nextInt();

      while (consYear >= userYear) {
         System.out.println("Ancestors in " + consYear + ": " + numAnc);

         numAnc = 2 * numAnc;                 // Each ancestor had two parents
         consYear = consYear - YEARS_PER_GEN; // Go back 1 generation
      }
   }
}
````

### output
````
Enter a past year (neg. for B.C.): 1900
Ancestors in 2020: 2
Ancestors in 2000: 4
Ancestors in 1980: 8
Ancestors in 1960: 16
Ancestors in 1940: 32
Ancestors in 1920: 64
Ancestors in 1900: 128

Enter a past year (neg. for B.C.): 1600
Ancestors in 2020: 2
Ancestors in 2000: 4
Ancestors in 1980: 8
Ancestors in 1960: 16
Ancestors in 1940: 32
Ancestors in 1920: 64
Ancestors in 1900: 128
Ancestors in 1880: 256
Ancestors in 1860: 512
Ancestors in 1840: 1024
Ancestors in 1820: 2048
Ancestors in 1800: 4096
Ancestors in 1780: 8192
Ancestors in 1760: 16384
Ancestors in 1740: 32768
Ancestors in 1720: 65536
Ancestors in 1700: 131072
Ancestors in 1680: 262144
Ancestors in 1660: 524288
Ancestors in 1640: 1048576
Ancestors in 1620: 2097152
Ancestors in 1600: 4194304
````


> Each iteration prints a line with the year and the ancestors in that year. (Note: the numbers are large due to not considering breeding among distant relatives, but nevertheless a person has many ancestors).


## More while examples 

````java 

import java.util.Scanner;

// Output GCD of user-input numA and numB

public class GCDCalc {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int numA;  // User input
      int numB;  // User input

      System.out.print("Enter first positive integer: ");
      numA = scnr.nextInt();

      System.out.print("Enter second positive integer: ");
      numB = scnr.nextInt();

      while (numA != numB) { // Euclid's algorithm
         if (numB > numA) {
            numB = numB - numA;
         }
         else {
            numA = numA - numB;
         }
      }

      System.out.println("GCD is: " + numA);
   }
}
````


### output 
````

Enter first positive integer: 9
Enter second positive integer: 7
GCD is: 1

...

Enter first positive integer: 15
Enter second positive integer: 10
GCD is: 5

...

Enter first positive integer: 99
Enter second positive integer: 33
GCD is: 33

...

Enter first positive integer: 500
Enter second positive integer: 500
GCD is: 500
````


## while loop conversation program

````java 
mport java.util.Scanner;

/* Program that has a conversation with the user. 
   Uses a if-else statements and a random number (sort of) 
   to mix up the program's responses. */

public class Conversation {

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int randNum;       // Random number 0 to 3
      String userText;      // User input

      System.out.println("Tell me something about yourself.");
      System.out.println("You can type \"Goodbye\" at anytime to quit.\n");
      System.out.println();
      System.out.print("> ");

      userText = scnr.nextLine();

      while (!userText.equals("Goodbye")) {
         randNum = userText.length() % 4; // "Random" num. %4 ensures 0-3
         System.out.println();

         if (randNum == 0) {
            System.out.println("Please explain further.");
         }
         else if (randNum == 1) {
            System.out.println("Why do you say: \"" + userText + "\"?");
         }
         else if (randNum == 2) {
            System.out.println("I don't think that's right.");
         }
         else if (randNum == 3) {
            System.out.println("What else can you share?");
         }
         else {
            System.out.println("Uh-oh, something went wrong. Try again.");
         }
         System.out.println();
                   System.out.print("> ");
         userText = scnr.nextLine();
      }
      System.out.println();

      System.out.println("It was nice talking with you. Goodbye.");
   }
}

````



## output 
````
Tell me something about yourself.
You can type "Goodbye" at anytime to quit.


> I'm 26 years old.

Why do you say: "I'm 26 years old."?

> Well, I was born 26 years ago.

I don't think that's right.

> I am sure it is correct.

Please explain further.

> Goodbye
It was nice talking with you. Goodbye.



````


## while loop program that shows positive integers



````java 
import java.util.Scanner;

// Outputs average of list of positive integers
// List ends with 0 (sentinel)
// Ex: 10 1 6 3 0  yields (10 + 1 + 6 + 3) / 4, or 5

public class ListAverage {
   public static void main(String [] args) {
      Scanner scnr = new Scanner(System.in);
      int currValue;
      int valuesSum;
      int numValues;
      
      valuesSum = 0;
      numValues = 0;
      
      currValue = scnr.nextInt();
      
      while (currValue > 0) { // Get values until 0 (or less)
         valuesSum = valuesSum + currValue;
         numValues = numValues + 1;
         currValue = scnr.nextInt();
      }

      System.out.println("Average: " + (valuesSum / numValues));
   }
}


````

***output***


````java 
10 1 6 3 0
Average: 5

...

90 70 30 10 99 1 0
Average: 50
````

# For Loops


## Basics
A loop commonly must iterate a specific number of times, such as 10 times. Though achievable with a while loop, that situation is so common that a special kind of loop exists.

>    A for loop is a loop with three parts at the top: a loop variable initialization, a loop expression, and a loop variable update. A for loop describes iterating a specific number of times more naturally than a while loop.

````java 

) {
}

// Loop body

) {

for ( i = i + 1; i < 5; i = 0;)
int i;


````