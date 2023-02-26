# Initialization and Constructors 


A good practice is to initialize all variables when declared. This section deals with initializing the fields of a class when a variable of the class type is allocated.

## Field initialization

A programmer can initialize fields in the field declaration. Any object created of that class type will initially have those values.


````Java 
public class Restaurant {                          
   private String name = "NoName";
   private int rating = -1;
````


> These are the fields of the class 
 
# Constructors

### Java provides a special class member method, known as a ***constructor***, that is called when an object of that class type is created, and which can be used to initialize all fields. 


##### The constructor has the same name as the class. The constructor method has no return type, not even void. Ex: public Restaurant() {...} defines a constructor for the Restaurant class.


##### A programmer specifies the constructor that should be called when creating an object. Ex: Restaurant favLunchPlace = new Restaurant(); creates a new Restaurant object and calls the constructor Restaurant().
##### If a class does not have a programmer-defined constructor, then the Java compiler implicitly defines a default constructor with no arguments. The Java compiler also initializes all fields to their default values.


````Java
public class Restaurant {
   private String name;
   private int rating;
// this is showing off a constructor 
   public Restaurant() {  // Constructor with no arguments
      name = "NoName";    // Default name: NoName indicates name was not set
      rating = -1;        // Default rating: -1 indicates rating was not set
   }
````
> Field initialization is usually preferred over using a constructor. However, sometimes initializations are more complicated, in which case a constructor is needed.




## Example code 
````Java 
public class CallBicycle {
   public static void main(String[] args) {
      Bicycle commuterBike = new Bicycle();


      commuterBike.print();
      
      commuterBike.setYear(1928);
      commuterBike.setType("tandem");


      commuterBike.print();
   }
}
public class Bicycle {                          
   private String type;
   private int year;
   
   public Bicycle() {
      type = "NoType";
      year = -1;
   }


   public void setType(String bicycleType) {  
      type = bicycleType;
   }


   public void setYear(int bicycleYear) {
      year = bicycleYear;
   }


   public void print() {  
      System.out.println(type + " " + year);
   }
}






````


#### Output: NoType -1
tandem 1928


````Java 
public class Person {
   private String name;
	private double height;


public Person(){
   name = "Unknown";
   height = 0.00;
}
````


> Constructor practice
