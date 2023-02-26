##  Mutators, accessors, and private helpers 
A class' public methods are commonly classified as either mutators or accessors.
A mutator method may modify ("mutate") a class' fields.
An accessor method accesses fields but may not modify a class' fields.
 > Commonly, a field has two associated methods: a mutator for setting the value, and an accessor for getting the value, known as a ***setter*** and ***getter*** method, respectively, and typically with names starting with set or get. Other mutators and accessors may exist that aren't associated with just one field, such as the print() method below.




### Private helper methods
A programmer commonly creates private methods, known as *** private helper methods***, to help public methods carry out tasks.




````Java 
public class MyClass {
   private int numA;


   private int methodX() {
      ...
   }


   public void method1() { 
   


   }
}


````
>  This essentially uses private functions within public methods to help use private fields for a class.


### Example code 


````Java
public class CallDog {
   public static void main(String [] args) {
      Dog buddy = new Dog();
      
      buddy.setAge(4);
      System.out.print(buddy.getStage());


   }
}


````


````Java 
public class Dog {
   private int months;
   
   public void setAge(int monthsToSet) {
      months = monthsToSet;
   }
   
   public String getStage() {
      String stage;
      
      if (months < 12) {
         stage = "Puppy";
      }
      else if (months < 16) {
         stage = "Adolescence";
      }
      else if (months < 60) {
         stage = "Adulthood";
      }
      else {
         stage = "Senior";
      }
       
      return stage;
   }
}
````


Input : 4 
output : Puppy 


Input : 13
output : Adolescence




Input : 50 
output : adulthood 




Input : 61
output : Senior 




````Java 
public class CallDog {
   public static void main(String [] args) {
      Dog buddy = new Dog();
      
      buddy.setAge(1);
      buddy.addBirthday();
      buddy.addBirthday();
      buddy.addBirthday();
      buddy.addBirthday();
      buddy.addBirthday();


      System.out.print(buddy.getAge());
   
   }
}


public class Dog {
   private int years;
   
   public void setAge(int yearsToSet) {
      years = yearsToSet;
   }
   
   public void addBirthday() {
      years = years + 1;
   }
   
   public int getAge() {
      return years;
   }
}
````


Output: 1+1+1 etc = 6


````Java 
public class CallDog {
   public static void main(String [] args) {
      Dog buddy = new Dog();


      buddy.setWeight(82);
      System.out.print("Your dog is " + buddy.getSize());
   
   }
}


public class Dog {
   private int weight;
   private String size;
   
   public void setWeight(int weightToSet) {
      weight = weightToSet;
      
      if (weight <= 25) {
         size = "small";
      }
      else if (weight <= 55) {
         size = "medium";
      }
      else {
         size = "large";
      }
   }


   public String getSize() {
      return size;
   }
}
````




Output: Your dog is large






````Java 
public class CallDog {
   public static void main(String [] args) {
      Dog buddy = new Dog();


      buddy.setWeightAndAge(14, 5);
      System.out.print("Human years: " + buddy.getHumanYears());
   
   }
}
public class Dog {
   private int years;
   private int weight;
   private String size;
   private int humanYears;


   private void setHumanYears() {
      int factor;
   
      if (size.equals("small")) {
         factor = 6;
      }
      else if (size.equals("medium")) {
         factor = 7;
      }
      else {
         factor = 8;
      }
   
      humanYears = years * factor;
   }
   
   public int getHumanYears() {
      return humanYears;
   }


   public void setWeightAndAge(int weightToSet, int yearsToSet) {
      weight = weightToSet;


      if (weight <= 25) {
         size = "small";
      }
      else if (weight <= 55) {
         size = "medium";
      }
      else {
         size = "large";
      }


      years = yearsToSet;
      setHumanYears();
   }
}
````




Output: Human Years: 30 
