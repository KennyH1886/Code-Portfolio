# Static fields and methods
## Static fields
### The keyword ***static*** indicates a variable is allocated in memory only once during a program's execution. Static variables reside in the program's static memory region and have a global scope. Thus, static variables can be accessed from anywhere in a program.
In a class, a ***static field*** is a field of the class instead of a field of each class object. Thus, static fields are independent of any class object, and can be accessed without creating a class object. Static fields are declared and initialized in the class definition. Within a class method, a static field is accessed using the field name. A public static field can be accessed outside the class using dot notation: ClassName.fieldName.


> Instance and class variable , Static fields are also called ***class variables***, and non-static fields are also called ***instance variables***.
##Example incrementing static variable 
````Java 
public class Store {   
   // Declare and initialize public static field
   public static int nextId = 101;


   // Define private fields 
   private String name;
   private String type;
   private int id;


   public Store(String storeName, String storeType) {
      name = storeName;
      type = storeType;
      id = nextId;


      ++nextId;   // Increment each time a Store object is created
   }


   ...
}






public class NewStores {
   public static void main(String[] args) {
      Store store1 = new Store("Macy's", "Department");
      Store store2 = new Store("Albertsons", "Grocery");
      Store store3 = new Store("Ace", "Hardware");
    
      System.out.println("Store 1's ID: " + store1.getId());
      System.out.println("Store 2's ID: " + store2.getId());
      System.out.println("Store 3's ID: " + store3.getId());
      System.out.println("Next ID: " + Store.nextId);
````
The Store class' static field nextId is declared and initialized in the Store class definition. Only one instance of the field nextId will exist in memory.
When a Store object is created, memory is allocated for the object's name, type, and id fields, but not the static field nextId.
The constructor assigns an object's id with nextId, and then increments nextId. Each time an object is created, nextId is incremented. Thus, each object will have a unique id.
Any class method can access or mutate a static field. Because nextId is public, nextId can also be accessed outside the class using the member access operator (.)


## Static member methods
#### A ***static member method*** is a class method that is independent of class objects. Static member methods are typically used to access and mutate private static fields from outside the class. Since static methods are independent of class objects, the this parameter is not passed to a static member method. So, a static member method can only access a class' static fields.
> A class' public static fields can be accessed outside the class because the fields are public. But, a private field can only be accessed by the class' methods.
> A field belongs to the class, not each class object. Memory is only allocated once for a field, not for each object.
##Example 
````Java 
public class CallFood {
   public static void main(String[] args) {
      FoodType order1 = new FoodType("Soup");
      FoodType order2 = new FoodType("Noodles");
      FoodType order3 = new FoodType("Pasta");


      order1.print();
      order2.print();
      order3.print();
   }
}


public class FoodType {
   public static int nextId = 30;


   private String type;
   private int id;


   public FoodType(String foodType) {
      type = foodType;
      id = nextId;


      nextId += 4;
   }


   public void print() {
      System.out.println(id + ": " + type);
   }
}
````
> good example for decremneting and incrementing
### Output: 30: Soup , 34: noodles , 38: pasta


````Java 
public class CallFood {
   public static void main(String[] args) {
      FoodType order1 = new FoodType("Taco");
      FoodType order2 = new FoodType("Burrito");
      FoodType order3 = new FoodType("Lobster");
      FoodType order4 = new FoodType("Bread");
      FoodType order5 = new FoodType("Ham");


      order2.print();


      System.out.println("Next ID: " + FoodType.getNextId());
   }
}
public class FoodType {
   private static int nextId = 0;


   private String type;
   private int id;


   public FoodType(String foodType) {
      type = foodType;
      id = nextId;


      nextId += 2;
   }


   public void print() {
      System.out.println(id + ": " + type);
   }


   public static int getNextId(){
      return nextId;
  ````


### Output: 2: Burrito , Next ID: 10
> += 2; increment doubles it?








