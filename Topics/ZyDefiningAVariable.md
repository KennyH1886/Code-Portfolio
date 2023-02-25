

# Defining a class





````java 
public class CallPerson {
   public static void main(String [] args) {
      String userName;
      String differentUserName;
      Person person1 = new Person();

      userName = "Bob";
      differentUserName = "Ron";
   
      person1.setFirstName(userName);
      System.out.println("You are not " + person1.getFirstName());
      person1.setFirstName(differentUserName);
      System.out.println("You are " + person1.getFirstName());
   }
}

````java
public class Person {
   private String firstName;

   public void setFirstName(String firstNameToSet) {
      firstName = firstNameToSet;
   }
   
   public String getFirstName() {
      return firstName;
   }
}
````


output :
 You are not Bob
You are Ron 

````java 
public class CallPerson {
   public static void main(String [] args) {
      String aFirstName;
      String anotherFirstName;
      String aLastName;
      String anotherLastName;

      aFirstName = "Sam";
      anotherFirstName = "Bob";
      aLastName = "Stark";
      anotherLastName = "Banner";

      Person person1 = new Person();
      Person person2 = new Person();
      
      person1.setLastName(aLastName);
      person2.setLastName(anotherLastName);
      person1.setFirstName(aFirstName);
      person2.setFirstName(anotherFirstName);

      System.out.println("You are " + person1.getFullName());
      System.out.println("I am " + person2.getFullName());
   }
}
````
````java
public class Person {
   private String firstName;
   private String lastName;

   public void setFirstName(String firstNameToSet) {
      firstName = firstNameToSet;
   }
   
   public void setLastName(String lastNameToSet) {
      lastName = lastNameToSet;
   }
   
   public String getFullName() {
      return "(" + lastName + ", " + firstName + ")";
   }
}
````



````java 
// ===== Code from file DogLicense.java =====
public class DogLicense {
   private int licenseYear;
   private int licenseNum;

   public void setYear(int yearRegistered) {
      licenseYear = yearRegistered;
   }

   // FIXME: Write createLicenseNum()

  
  
   public void createLicenseNum(int customID){
      licenseNum = (customID * 100000 + licenseYear); 
   }

   public int getLicenseNum() {
      return licenseNum;
   }
}
// ===== end =====

// ===== Code from file CallDogLicense.java =====
import java.util.Scanner;

public class CallDogLicense {
   public static void main(String [] args) {
      Scanner scnr = new Scanner(System.in);
      DogLicense dog1 = new DogLicense();
      int userYear;
      int userId;

      userYear = scnr.nextInt();
      userId = scnr.nextInt();

      dog1.setYear(userYear);
      dog1.createLicenseNum(userId);
      System.out.println("Dog license: " + dog1.getLicenseNum());

   }
}
// ===== end =====
````

Output:

 Dog license: 77702014: 
