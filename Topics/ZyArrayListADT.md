# ArrayList ADT
## List interface and ArrayList ADT
### The ***Java Collection Framework*** (or JCF) defines interfaces and classes for common ADTs known as collections in Java. A ***Collection*** represents a generic group of objects known as elements. Java supports several different Collections, including List, Queue, Map, and others. Refer to Introduction to Collection Interfaces and Java Collections Framework overview from Oracle's Java documentation for detailed information on each Collection type. Each Collection type is an interface that declares the methods accessible to programmers.
> ### The ***List*** interface is one of the most commonly used Collection types as it represents an ordered group of elements -- i.e., a sequence. Both an ArrayList and LinkedList are ADTs implementing the List interface. Although both ArrayList and LinkedList implement a List, a programmer should select the implementation that is appropriate for the intended task. For example, an ArrayList offers faster positional access -- e.g., myArrayList.get(2) -- while a LinkedList offers faster element insertion and removal.
 ### The ArrayList type is an ADT implemented as a class (actually as a generic class that supports different types such as ArrayList<Integer> or ArrayList<String>, although generics are discussed elsewhere).
### For the commonly-used public member methods below, assume an ArrayList declared as: ArrayList<T> arrayList = new ArrayList<T>()


### where T represents the ArrayList's type, such as:  ArrayList<Integer> teamNums = new ArrayList<Integer>(); Assume ArrayList teamNums has existing Integer elements of 5, 9, 23, 11, 14



````Java 
int i;
ArrayList<Integer> itemList = new ArrayList<Integer>();


itemList.add(27);
itemList.add(44);
itemList.add(9);
itemList.add(17);
itemList.remove(1);
itemList.add(0, 88);


System.out.println("Contents:");
for (i = 0; i < itemList.size(); i++) {
   System.out.println(" " + itemList.get(i));
}
````
### Output: 88,27,9,17


### Java automatically creates an Integer object from the integer literal passed to the add() method. The add() method then adds the element to the end of the ArrayList and increases ArrayList's size by 1.
### The remove() method removes the element at the specified index. Elements from higher positions are moved back to fill the gap and the ArrayList size is decreased by 1.
### The add() method can be also be used to add a new element at a specified index. Elements at that index and higher are shifted over to make room. The ArrayList's size is increased by 1.
### The size() method returns the number of elements currently in the ArrayList and is commonly used in a for loop to iterate through each element. The get() method returns the element at the specified index.


### One can deduce that the ArrayList class has a private field that stores the current size. In fact, the ArrayList class has several private fields. However, to use an ArrayList, a programmer only needs to know the public abstraction of the ArrayList.
### Example: List of players' jersey numbers
### The program below assists a soccer coach in scouting players, allowing the coach to enter the jersey number of players, enter the jersey number of players the coach wants to cut, and printing a list of those numbers when requested.


````Java 


import java.util.ArrayList;
import java.util.Scanner;


public class PlayerManager {
   // Adds playerNum to end of ArrayList
   public static void addPlayer (ArrayList<Integer> players, int playerNum) {
      players.add(playerNum);
   }


   // Deletes playerNum from ArrayList
   public static void deletePlayer (ArrayList<Integer> players, int playerNum) {
      int i;
      boolean found;


      // Search for playerNum in ArrayList
      found = false;
      i = 0;


      while ( (!found) && (i < players.size()) ) {
         if (players.get(i).equals(playerNum)) {
            players.remove(i); // Remove
            found = true; 
         }


         ++i;
      }
   }
   
   // Prints player numbers currently in ArrayList
   public static void printPlayers(ArrayList<Integer> players) {
      int i;


      for (i = 0; i < players.size(); ++i) {
         System.out.println(" " + players.get(i));
      }
   }


   // Maintains ArrayList of player numbers 
   public static void main(String [] args) {
      Scanner scnr = new Scanner(System.in);
      ArrayList<Integer> players = new ArrayList<Integer>();
      String userInput;
      int playerNum;


      userInput = "-";


      System.out.println("Commands: 'a' add, 'd' delete,");
      System.out.println("'p' print, 'q' quit: ");


      while (!userInput.equals("q")) {
         System.out.print("Command: ");
         userInput = scnr.next();


         if (userInput.equals("a")) {
            System.out.print(" Player number: ");
            playerNum = scnr.nextInt();


            addPlayer(players, playerNum);
         }
         if (userInput.equals("d")) {
            System.out.print(" Player number: ");
            playerNum = scnr.nextInt();


            deletePlayer(players, playerNum);
         }
         else if (userInput.equals("p")) {
            printPlayers(players);
         }
      }


   }
}
````
### Output: Commands: 'a' add, 'd' delete,
'p' print, 'q' quit: 
Command: p
Command: a Player number: 27Command: aPlayer number: 44Command: a Player number: 9Command: p 27 44 9 Command: d Player number: 9 Command: p 27 44Command: q
### The line highlighted in the addPlayer() method illustrates use of the add() member method. Note from the sample input/output that the items are stored in the ArrayList in the order they were added. The program's deletePlayer() method uses a common while loop form for finding an item in an ArrayList. The loop body checks if the current item is a match; if so, the item is deleted using the remove() method, and the variable found is set to true. The loop expression exits the loop if found is true, since no further search is necessary. A while loop is used rather than a for loop because the number of iterations is not known beforehand.
Note that the programmer did not specify an initial ArrayList size in main(), meaning the size is 0. Note from the output that the items are stored in the ArrayList in the order they were added.


> tips on how to make an array list while keeping in ascending order 
The first number is added to the ArrayList.
44 is greater than 27 so it is added to the end of the ArrayList.
9 is less than 27. 44 and 27 are moved down so 9 can be added to front of the ArrayList.
The rest of the numbers are added in the appropriate spots.


````Java 
import java.util.ArrayList;


public class IntegerManager {
   public static void printItems(ArrayList<Integer> numsList) {
      int i;


      System.out.print("items:");


      for (i = 0; i < numsList.size(); ++i) {
         System.out.print(" " + numsList.get(i));
      }


      System.out.println();
   }


   public static void main(String[] args) {
      int i;
      ArrayList<Integer> intList = new ArrayList<Integer>();


      for (i = 0; i < 5; ++i) {
         intList.add(i);
      }
      printItems(intList);


      intList.remove(1);
      printItems(intList);


      intList.add(2, 6);
      printItems(intList);
   }
}
````


### Output: items: 0 1 2 3 4 items: 0 2 3 4 items: 0 2 6 3 4


````Java 
import java.util.ArrayList;
import java.util.Scanner;


public class ArrayListADT {
   public static void printArrayList(ArrayList<Integer> numsList) {
      int i;


      for (i = 0; i < numsList.size(); ++i) {
         System.out.print(numsList.get(i));
         System.out.print(" ");
      }


      System.out.println("");
   }


   public static void main(String [] args) {
      Scanner scnr = new Scanner(System.in);
      ArrayList<Integer> numsList = new ArrayList<Integer>();
      int userInput;
      int i;


      for (i = 0; i < 3; ++i) {
         userInput = scnr.nextInt();
         numsList.add(userInput);
      }
   numsList.remove(1);
   numsList.add(0,100);
   numsList.add(2,102);


     


      printArrayList(numsList);
   }
}
````
### Input: 101 200 103
### Output: 100 101 102 103