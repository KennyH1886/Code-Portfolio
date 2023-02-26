# ArrayLists of Objects




Because all classes are derived from the Object class, programmers can take advantage of runtime polymorphism in order to create a collection (e.g., ArrayList) of objects of various class types and perform operations on the elements. The program below uses the Business class and other built-in classes to create and output a single ArrayList of differing types.

````java 
public class Business {
   protected String name;
   protected String address;
   
   public Business() {}
   
   public Business(String busName, String busAddress) {
      name = busName;
      address = busAddress;
   }
   
   @Override
   public String toString() {
      return name + " -- " + address;
   }
}
````
````java 
import java.util.ArrayList;

public class ArrayListPrinter {
   
   // Method prints an ArrayList of Objects
   public static void printArrayList(ArrayList<Object> objList) {
      int i;

      for (i = 0; i < objList.size(); ++i) {
         System.out.println(objList.get(i));
      }
   }
   
   public static void main(String[] args) {       
      ArrayList<Object> objList = new ArrayList<Object>();
      
      // Add new instances of various classes to objList
      objList.add(new Object());
      objList.add(12);
      objList.add(3.14);
      objList.add(new String("Hello!"));
      objList.add(new Business("ACME", "5 Main St"));     
      
      // Print list of Objects
      printArrayList(objList);   
   }
````


### objList is an ArrayList of Object elements. All objects derive from Object, so objList can store any type of object.
Five new objects of various class types are added to the ArrayList. Each derived class reference is automatically converted to a base class (Object) reference.
printArrayList() takes an ArrayList of Objects as an argument and outputs every element of the ArrayList.
get(i) returns each Object element. Runtime polymorphism allows the correct version of toString() to be called based on the actual class type of each element

>Note that a method operating on a collection of Object elements may only invoke the methods defined by the base class (e.g., the Object class). Thus, a statement that calls the toString() method on an element of an ArrayList of Objects called objList, such as objList.get(i).toString(), is valid because the Object class defines the toString() method. However, a statement that calls, for example, the Integer class's intValue() method on the same element (i.e., objList.get(i).intValue()) results in a compiler error even if that particular element is an Integer object.
