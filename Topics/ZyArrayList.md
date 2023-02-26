# ArrayList
## ArrayList introduction
### Sometimes a programmer wishes to maintain a list of items, like a grocery list, or a course roster. An ***ArrayList*** is an ordered list of reference type items that comes with Java. Each item in an ArrayList is known as an ***element***. The statement import java.util.ArrayList; enables use of an ArrayList.
### The declaration ArrayList<Integer> vals = new ArrayList<Integer>() creates reference variable vals that refers to a new ArrayList object consisting of Integer objects. The ArrayList list size can grow to contain the desired elements. ArrayList does not support primitive types like int, but rather reference types like Integer. A common error among beginners is to declare an ArrayList of a primitive type like int, as in ArrayList<int> myVals, yielding a compilation error: "unexpected type, found : int, required: reference."
# Example 
````Java 
ArrayList<Integer> valsList = new ArrayList<Integer>();


//Creating space for 3 Integers
valsList.add(31);
valsList.add(41);
valsList.add(59);


System.out.println(valsList.get(1));


// Setting the value of existing elements


valsList.set(1, 119);


System.out.println(valsList.get(1));


````
> valsList is a reference variable that refers to an ArrayList object consisting of Integer objects.
Java automatically creates an Integer object from the integer literal passed to the add() method. The add() method then adds the Integer object to the end of the ArrayList.
The get() method returns the element at the specified list location.
The set() method replaces the element at the specified list position with the new Integer object. Again, Java automatically converts the integer literal 119 to an Integer object with that value.


### This example sets up an array list that takes in integers into a list, sets 119 at index 1 and prints it with a get 
 | Common ArrayListMethods |
| method name | definition / description | example |
| ------------ | ----------------------- | ------------ |
|  add()|add(element) Create a Space for and add the element at the end of the list |  // List originally empty , valsList.add(31); // List now: 31 |
| get() | get(index) Returns the element at the specified list location known as the index. Indices start at 0. | // List originally: 31 41 59. Assume x is an int. x = valsList.get(0);  // Assigns 31 to x |
|set()| set(index, element) Replaces the element at the specified position in this list with the specified element. | // List originally: 31 41 59 , valsList.set(1, 119);// List now 31 119 59|
|size | size() Returns the numbe of list elements | // List originally: 31 41 59. Assume x is an int. x = valsList.size();  // Assigns x with 3 | 


## Accessing ArrayList elements
### The ArrayList's get() method returns the element at the specified list location, and can be used to lookup the Nth item in a list. The program below allows a user to print the name of the Nth most popular operating system. The program accesses the Nth most popular operating system using ***operatingSystems.get(nthOS - 1);***. Note that the index is nthOS - 1 rather than just nthOS because an ArrayList's indices start at 0, so the 1st operating system is at index 0, the 2nd at index 1, etc.
An ArrayList's index must be an integer type. The index cannot be a floating-point type, even if the value is 0.0, 1.0, etc
````Java 
import java.util.ArrayList;
import java.util.Scanner;


public class MostPopularOS {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      ArrayList<String> operatingSystems = new ArrayList<String>(); 
      int nthOS;      // User input, Nth most popular OS
      
      // Source: StatCounter.com, 2018
      operatingSystems.add("Windows 10");
      operatingSystems.add("Windows 7");
      operatingSystems.add("Mac OS X");
      operatingSystems.add("Windows 8");
      operatingSystems.add("Windows XP");
      operatingSystems.add("Linux");
      operatingSystems.add("Chrome OS");
      operatingSystems.add("Other");


      System.out.println("Enter N (1-8): ");
      nthOS = scnr.nextInt();


      if ((nthOS >= 1) && (nthOS <= 8)) {
         System.out.print("The " + getNumberSuffix(nthOS) + " most popular OS is ");
         System.out.println(operatingSystems.get(nthOS - 1));
      }
   }


   private static String getNumberSuffix(int number) {
      String[] firstThree = { "st", "nd", "rd" };
      if (number >= 1 && number <= 3) {
         return number + firstThree[number - 1];
      }
      return number + "th";
   }
}
````
Output: 
Enter N (1-8): 
1
The 1st most popular OS is Windows 10
...
Enter N (1-8): 
3
The 3rd most popular OS is Mac OS X
...
Enter N (1-8): 
6
The 6th most popular OS is Linux
# ArrayList initialization
### While a technique exists to initialize an ArrayList's elements with specific values in the object creation, the syntax is relatively complex. Thus, this material does not describe such initialization here.
# Iterating through ArrayLists
### The program below allows a user to enter 8 numbers, then prints the average of those 8 numbers. The first loop uses the add() method to add each user-specified number to the ArrayList userNums. After adding the numbers to userNums, the size() method can be used to determine the number of elements in userNums. Thus, size() is used in the second for loop to calculate the sum, and in the statement that computes the average.
### With an ArrayList and loops, the program could easily be changed to support say 100 numbers; the code would be the same, and only the value of NUM_ELEMENTS would be changed to 100


##ArrayLists with Loops
````Java
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListAverage {
   public static void main(String[] args) {
      final int NUM_ELEMENTS = 8;
      Scanner scnr = new Scanner(System.in);
      ArrayList<Double> userNums = new ArrayList<Double>(); // User numbers
      Double sumVal;
      Double averageVal; 
      int i; 
      
      // Get user numbers and add to userNums
      System.out.println("Enter " + NUM_ELEMENTS + " numbers...");
      for (i = 0; i < NUM_ELEMENTS; ++i) {
         System.out.print("Number " + (i + 1) + ": ");
         userNums.add(scnr.nextDouble());
      }
      
      // Determine average value
      sumVal = 0.0;
      for (i = 0; i < userNums.size(); ++i) {
         sumVal = sumVal + userNums.get(i); // Calculate sum of all numbers
      }
      averageVal = sumVal / userNums.size(); // Calculate average 
      
      System.out.println("Average: " + averageVal);
   }
}

````
Output:
Enter 8 numbers...
Number 1: 1.2
Number 2: 3.3
Number 3: 5.5
Number 4: 2.4
Number 5: 3.14
Number 6: 3.0
Number 7: 5.3
Number 8: 3.1
Average: 3.3675


> initializing an array list example: ArrayList<Integer> frameScores = new ArrayList<Integer>(); 
## Java Collections Framework
### An ArrayList is one of several ***Collections*** supported by Java for keeping groups of items. Other collections include LinkedList, Set, Queue, Map, and many more. A programmer selects the collection whose features best suit the desired task. For example, an ArrayList can efficiently access elements at any valid index but inserts are expensive, whereas a LinkedList supports efficient inserts but access requires iterating through elements. So a program that will do many accesses and few inserts might use an ArrayList.
##Examples 
````Java 
import java.util.ArrayList;

public class IntegersList {
   public static void main(String[] args) {
      ArrayList<Integer> userVals = new ArrayList<Integer>();
      int i;

      userVals.add(3);
      userVals.add(4);
      userVals.add(8);

      for (i = 0; i < userVals.size(); ++i) {
         System.out.println(userVals.get(i));
      }
   }

````
> Example of arrayList iteration         
````Java  
import java.util.ArrayList;
public class IntegersList {
   public static void main(String[] args) {
      ArrayList<Integer> userVals = new ArrayList<Integer>();
      int i;
      userVals.add(3);
      userVals.add(5);
      userVals.add(8);
      userVals.set(2, userVals.get(2) + 1);
      for (i = 0; i < userVals.size(); ++i) {
         System.out.println(userVals.get(i));
      }
   }
}
````
````Java 
import java.util.ArrayList;

public class IntegersList {
   public static void main(String[] args) {
      ArrayList<Integer> userVals = new ArrayList<Integer>();
      int i;

      userVals.add(1);
      userVals.add(4);
      userVals.add(8);

      userVals.set(1, userVals.get(0));

      for (i = 0; i < userVals.size(); ++i) {
         System.out.println(userVals.get(i));
      }
   }
}

````
