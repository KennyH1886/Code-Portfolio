# Constructor Overloading 
## Basics 
### Programmers often want to provide different initialization values when creating a new object. A class creator can ***overload*** a constructor by defining multiple constructors differing in parameter types. When an object is created with the new operator, arguments can be passed to the constructor. The constructor with matching parameters will be called.


````Java 
public class Restaurant {
   ...


   // Default constructor
   public Restaurant() {
      name = "NoName";
      rating = -1;
   }


   // Another constructor
   public Restaurant(String initName, int initRating) {
      name = initName;
      rating = initRating;
   }
}


public class RestaurantFavorites {
   public static void main(String[] args) {
      // Calls default constructor
      Restaurant foodPlace = new Restaurant();           
    
      // Calls another constructor
      Restaurant coffeePlace = new Restaurant("Joe's", 5);


      ...
   }
}
````
> Passing a String and int argument to the constructor causes the constructor with matching parameters to be called instead. The object gets initialized with those argument values. 
Creating a new object with no constructor arguments calls the default constructor. In this case, the object gets initialized with NoName and -1.
Passing a String and int argument to the constructor causes the constructor with matching parameters to be called instead. The object gets initialized with those argument values.


### If any constructor defined, should define default
If a programmer defines any constructor, the compiler does not implicitly define a default constructor, so good practice is for the programmer to also explicitly define a default constructor so that an object creation like new MyClass() remains supported.


>  If the programmer doesn't define any constructors, the compiler implicitly defines a default constructor having no statements.
> If the programmer defines any constructor, then the programmer should define a default constructor. Failing to do so yields a compiler error for a statement like MyClass x = new MyClass();.
> how you define a default constructor. 
public MyClass() { ... }


## Example of Constructor manipulation 
````Java 
public class CallPet {
   public static void main(String[] args) {
      Pet dog = new Pet();
      Pet cat = new Pet(3);
      Pet bird = new Pet("Ruby", 5);


      bird.print();
      dog.print();
      cat.print();
   }
````
````Java 
public class CallPet {
   public static void main(String[] args) {
      Pet dog = new Pet();
      Pet cat = new Pet(3);
      Pet bird = new Pet("Ruby", 5);


      bird.print();
      dog.print();
      cat.print();
   }
public class Pet {
   private String name;
   private int age;


   public Pet() {
      name = "Unnamed";
      age = -1;
   }


   public Pet(int yearsOld) {
      name = "NoName";
      age = yearsOld;
   }


   public Pet(String petName, int yearsOld) {
      name = petName;
      age = yearsOld;
   }


   public void print() {
      System.out.println(name + ", " + age);
   }
}
````


####Output: Ruby, 5
Unnamed, -1
NoName, 3






````Java // ===== Code from file PhonePlan.java =====
public class PhonePlan {
   private int freeMinutes;
   private int freeMessages;


   public PhonePlan() {
       freeMinutes  = 0;
       freeMessages = 0;
    }


    // FIXME: Create a second constructor with numMinutes and numMessages parameters.


  public PhonePlan (int minutes, int messages) {
     freeMinutes = minutes; 
    freeMessages = messages;
     
     
     
  }


   public void print() {
      System.out.println("Minutes: " + freeMinutes + ", Messages: " + freeMessages);
   }
}
// ===== end =====


// ===== Code from file CallPhonePlan.java =====
public class CallPhonePlan {
   public static void main(String [] args) {
      PhonePlan user1Plan = new PhonePlan(); // Calls default constructor
      PhonePlan user2Plan = new PhonePlan(1000, 5000); // Calls newly-created constructor


      System.out.print("User1: ");
      user1Plan.print();


      System.out.print("User2: ");
      user2Plan.print();
   }
}
// ===== end =====
````


### Output: User1: Minutes: 0, Messages: 0  , User2: Minutes: 1000, Messages: 5000
