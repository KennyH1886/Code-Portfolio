# Access by members of derived classes
## Member access
### The members of a derived class have access to the public members of the base class, but not to the private members of the base class. This is logical—allowing access to all private members of a class merely by creating a derived class would circumvent the idea of private members. Thus, adding the following member method to the Restaurant class yields a compiler error.

> ### Member methods of a derived class cannot access private members of the base class.

````Java 
public class Business {
   private String name;
   private String address;

   ...

}

public class Restaurant extends Business {
   private int rating;
   
   ...

   public void displayRestaurant() {
      System.out.println(name);
      System.out.println(address);
      System.out.println("Rating: "+ rating);
   }
   ...
}
````
> this code will not work

## Protected member access

### Recall that members of a class may have their access specified as public or private. A third access specifier is ***protected***, which provides access to derived classes and all classes in the same ***package*** but not by anyone else. Packages are discussed in detail elsewhere, but for our purposes a package can just be thought of as the directory in which program files are located. Thus, classes in the same package are located in the same directory. The following illustrates the implications of the protected access specifier.
### In the following example, the member called name is specified as protected and is accessible anywhere in the derived class. Note that the name member is also accessible in main()—the protected specifier also allows access to classes in the same package; protected members are private to everyone else.
## Access specifiers—Protected allows access by derived classes and classes in the same package but not by others.
### Private- accessible by self 

### Protected- Accessible by self, derived classes and other classes in the same package 

### public accessible by self , derived classes and everyone else.

### no specifier Accessible by self and other classes in the same package.

# Class definitions
### Separately, the keyword "public" in a class definition like public class DerivedClass {...} specifies a class's visibility in other classes in the program:
public : A class can be used by every class in the program regardless of the package in which either is defined.
no specifier : A class can be used only in other classes within the same package, known as ***package-private.***
Most beginning programmers define classes as public when learning to program.

