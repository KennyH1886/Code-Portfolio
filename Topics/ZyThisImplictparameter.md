#The ‘this’ Implicit parameter 
## Implicit Parameter 
### An object's member method is called using the syntax objectReference.method(). The object reference before the method name is known as an ***implicit parameter*** of the member method because the compiler converts the call syntax objectReference.method(...) into a method call with the object reference implicitly passed as a parameter. Ex: method(objectReference, ...).
>  Within a member method, the implicitly-passed object reference is accessible via the keyword ***this***. In particular, a class member can be accessed as this.classMember. The "." is the member access operator.
### Using ***this*** makes clear that a class member is being accessed and is essential if a field member and parameter have the same identifier. In the example below, this is necessary to differentiate between the field member sideLength and the parameter sideLength.
> Essentially this is for differentiating between the same parameter and field names.
## Example 
````Java 
public class ElapsedTime {
   private int hours;
   private int minutes;


   public void setTime(int timeHr, int timeMin) {
      this.hours = timeHr;
      this.minutes = timeMin;
   }
}


public class SimpleThisKeywordEx {
   public static void main(String [] args) {
      ElapsedTime travTime = new ElapsedTime();
      int usrHrs;     
      int usrMins;
                           
      usrHrs = 5;      
      usrMins = 34;


      travTime.setTime(usrHrs, usrMins);
   }
}
````


###
> travTime is an object of class type ElapsedTime.
When travTime's SetTime() member method is called, travTime's object reference, which can be thought of as the object's memory address, is passed to the method via the implicit 'this' parameter.
The implicitly-passed object reference is accessible within the member method via the keyword 'this'. Ex: this.hours first goes to travTime's memory address, then to the hours data member.


### The "this" keyword can also be used in a constructor to invoke a different (overloaded) constructor. In the default constructor below, this(0, 0); invokes the other constructor to initialize both fields to zero. For this example, a programmer could have just set both fields to zero within the default constructor. However, invoking other constructors is useful when a class' initialization routine is lengthy and avoids rewriting the same code.
````Java 
public class ElapsedTime {
   private int hours;
   private int minutes;


   // Overloaded constructor definition
   public ElapsedTime(int timeHours, int timeMins) {
      hours   = timeHours;
      minutes = timeMins;
   }
   
   // Default constructor definition
   public ElapsedTime() {
      this(0, 0);
   }
   
   // Other methods ...
}
````


````Java 
public class CallAirplane {
   public static void main(String[] args) {
      Airplane airbus330 = new Airplane();


      airbus330.addPassengers(7);
      airbus330.addPassengers(6);


      System.out.println(airbus330.getAvailableSeats() + " seats");
   }
}
public class Airplane {
   private int totalSeats;
   private int passengers;


   public Airplane() {
      this.totalSeats = 200;
      this.passengers = 0;
   }


   public void addPassengers(int passengers) {
      this.passengers = this.passengers + passengers;
   }


   public int getAvailableSeats() {
      return this.totalSeats - this.passengers;
   }
}
````
### Output: 187 seats


````Java
// ===== Code from file CablePlan.java =====
public class CablePlan {
   private int numDays;


   // FIXME: Define setNumDays() method, using "this" implicit parameter.
   public void setNumDays(int numDays) {
   this.numDays = numDays;
      


   }


   public int getNumDays() {
      return numDays;
   }
}
// ===== end =====


// ===== Code from file CallCablePlan.java =====
import java.util.Scanner;


public class CallCablePlan {
   public static void main(String [] args) {
      Scanner scnr = new Scanner(System.in);
      CablePlan house1Plan = new CablePlan();
      int userNum;


      userNum = scnr.nextInt();
      house1Plan.setNumDays(userNum);
      System.out.println(house1Plan.getNumDays());
   }
}
// ===== end =====
````
