## The Object class
The built-in Object class serves as the base class for all other classes and does not have a base class. All classes, including user-defined classes, are derived from Object and implement Object's methods. In the following discussion, note the subtle distinction between the term "Object class" and the generic term "object", which can refer to the instance of any class. Two common methods defined within the Object class are toString() and equals().
The toString() method returns a String representation of the Object. By default, toString() returns a String containing the object's class name followed by the object's hash code in hexadecimal form. Ex: java.lang.Object@372f7a8d.

The equals(otherObject) method compares an Object to otherObject and returns true if both variables reference the same object. Otherwise, equals() returns false. By default, equals() tests the equality of the two Object references, not the equality of the Objects' contents.
## Overriding toString() in the derived class

### Both the base class Business and derived class Restaurant override toString() in the figure below. The Restaurant toString() uses the super keyword to call the base class toString() to get a string with the business name and address. Then toString() concatenates the rating and returns a string containing the name, address, and rating.
