# Unit testing (classes)
## Testbenches
#### Like a chef who tastes food before serving, a class creator should test a class before allowing use. 
#### A testbench is a program whose job is to thoroughly test another program (or portion) via a series of input/output checks known as *** test cases***. 
#### ***Unit testing*** means to create and run a testbench for a specific item (or "unit") like a method or a class.










***100% code coverage:*** Every line of code is executed. 
Includes not just typical values but also ***border cases:*** Unusual or extreme test case values like 0, negative numbers, or large numbers.
## Test Case examples 


````Java 
public class StatsInfo {


   // Note: This class intentionally has errors


   private int num1;
   private int num2;


   public void setNum1(int numVal) {
      num1 = numVal;
   }


   public void setNum2(int numVal) {
      num2 = numVal;
   }


   public int getNum1() {
      return num1;
   }


   public int getNum2() {
      return num1;
   }


   public int getAverage() {
      return num1 + num2 / 2;
   }
}


public class StatsInfoTest {
   public static void main(String[] args) {
      StatsInfo testData = new StatsInfo();


      // Typical testbench tests more thoroughly


      System.out.println("Beginning tests.");


      // Check set/get num1
      testData.setNum1(100);
      if (testData.getNum1() != 100) {
         System.out.println("   FAILED set/get num1");
      }


      // Check set/get num2
      testData.setNum2(50);
      if (testData.getNum2() != 50) {
         System.out.println("   FAILED set/get num2");
      }


      // Check getAverage()
      testData.setNum1(10);
      testData.setNum2(20);
      if (testData.getAverage() != 15) {
         System.out.println("   FAILED GetAverage for 10, 20");
      }


      testData.setNum1(-10);
      testData.setNum2(0);
      if (testData.getAverage() != -5) {
         System.out.println("   FAILED GetAverage for -10, 0");
      }


      System.out.println("Tests complete.");
   }
}
````


>  Sometimes it is good practice to do test cases before you even write the method. You are essentially making scenarios where your executed methods should produce the output within your proposed parameters otherwise they are not complete. 


> side note a “testbench” should have a unique message ot tell which has failed.


# Regression testing


### ***Regression testing*** means to retest an item like a class anytime that item is changed; if previously-passed test cases fail, the item has "regressed".
### A testbench should be maintained along with the item, to always be usable for regression testing.
### Testbenches may be complex, with thousands of test cases. Various tools support testing, and companies employ test engineers who only test other programmers' items. A large percent, like 50% or more, of commercial software development time may go into testing.
> Testing that consumes 50% or more of the software's total development time is not unheard of. Writing thorough testbenches is a job in itself.
> Testbenches are kept, to be used later as the item being tested is updated.
> Even minor changes to an item may unexpectedly introduce bugs. An automated testbench can easily be run when an item is changed, to detect such "regression".
# Erroneous unit tests
### An erroneous unit test may fail even if the code being tested is correct. A common error is for a programmer to assume that a failing unit test means that the code being tested has a bug. Such an assumption may lead the programmer to spend time trying to "fix" code that is already correct. Good practice is to inspect the code of a failing unit test before making changes to the code being tested.
> essentially some test cases could be written wrong and it’s nto a problem with the code itself , make sure ot break it down and check both possibilities.

````Java 
public class CallRectangle {
   public static void main(String[] args) {
      Rectangle myRectangle = new Rectangle();


      myRectangle.setSize(1, 1);
      if (myRectangle.getArea() != 1) {
         System.out.println("FAILED getArea() for 1, 1");
      }
      if (myRectangle.getPerimeter() != 4) {
         System.out.println("FAILED getPerimeter() for 1, 1");
      }


      myRectangle.setSize(2, 3);
      if (myRectangle.getArea() != 6) {
         System.out.println("FAILED getArea() for 2, 3");
      }
      if (myRectangle.getPerimeter() != 10) {
         System.out.println("FAILED getPerimeter() for 2, 3");
      }
   }
````


> other code mentioned area is height * width and area is height * 2 + width * 2  


### Output: FAILED getPerimeter() for 1, 1
FAILED getPerimeter() for 2, 3


1 4 
Area h * w   = 4 
Perimeter h*2 + w*2  = 2 + 8 = 10 


2 6 
Area h * w   = 12 
Perimeter h*2 + w*2  = 4 + 12 = 16


2 3 


Area h * w = 6
Perimeter h*2 + w*2 =  4 + 6 = 10




1, 1
Area h * w =  1
Perimeter h*2 + w*2 = 4


2, 3 
Area h * w =  6 
Perimeter h*2 + w*2 = 4 +6 = 10






````Java // ===== Code from file InventoryTag.java =====
public class InventoryTag {
   private int quantityRemaining;


   public InventoryTag() {
      quantityRemaining = 0;
   }


   public int getQuantityRemaining() {
      return quantityRemaining;
   }


   public void addInventory(int numItems) {
      if (numItems > 10) {
         quantityRemaining = quantityRemaining + numItems;
      }
   }
}
// ===== end =====


// ===== Code from file CallInventoryTag.java =====
import java.util.Scanner;


public class CallInventoryTag {
   public static void main(String [] args) {
      Scanner scnr = new Scanner(System.in);
      InventoryTag redSweater = new InventoryTag();
      int sweaterShipment;
      int sweaterInventoryBefore;


      sweaterInventoryBefore = redSweater.getQuantityRemaining();
      sweaterShipment = scnr.nextInt();


      System.out.println("Beginning tests.");


      // FIXME add unit test for addInventory
   redSweater.addInventory(sweaterShipment);
   if (sweaterShipment != 25 ){
System.out.println("   UNIT TEST FAILED: " + "addInventory()");
}
      System.out.println("Tests complete.");
   }
}
// ===== end =====
````


> Keep in mind variable manipulation 
### Output of the code was essentially what was required or preferred. 
