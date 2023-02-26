# Overriding member methods
## Overriding
When a derived class defines a member method that has the same name and parameters as a base class's method, the member method is said to ***override*** the base class's method. The example below shows how the Restaurant's getDescription() method overrides the Business's getDescription() method.

The ***@Override*** annotation is placed above a method that overrides a base class method so the compiler verifies that an identical base class method exists. An ***annotation*** is an optional command beginning with the "@" symbol that can provide the compiler with information that helps the compiler detect errors better. The @Override annotation causes the compiler to produce an error when a programmer mistakenly specifies parameters that are different from the parameters of the method that should be overridden or misnames the overriding method. Good practice is to always include an @Override annotation with a method that is meant to override a base class method.

> essentially the variables are the same within different classes being extended to thechild class and needs to be overriden to differentiate them.

## Overriding vs. overloading
Overriding differs from overloading. In overloading, methods with the same name must have different parameter types, number of parameters, or return values. In overriding, a derived class member method must have the same parameter types, number of parameters, and return value as the base class member method with the same name. Overloading is performed if derived and base member methods have different parameter types; the member method of the derived class does not hide the member method of the base class.

## Calling a base class method

````java

public class Restaurant extends Business{
   ...
   
   @Override
   public String getDescription() {
      return super.getDescription() + "\n  Rating: " + rating;
   }
   
   ...
}
***
````
> A common error is to leave off super when wanting to call a base class method. Without the use of the super keyword, the call to getDescription() refers to itself (a recursive call), so getDescription() would call itself, which would call itself, etc., never actually printing anything

