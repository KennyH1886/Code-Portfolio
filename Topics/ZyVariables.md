## Variables

> In a program, a ***variable*** is a named item, such as x or numPeople, used to hold a value.


>An ***assignment*** assigns a variable with a value, such as x = 5. That assignment means x is assigned with 5, and x keeps that value during subsequent assignments, until x is assigned again.



>An assignment's left side must be a variable. The right side can be an expression, so an assignment may be x = 5, y = x, or z = x + 2. The 5, x, and x + 2 are each an expression that evaluates to a value.


#### Variables (int)
>  variable declaration is a statement that declares a new variable, specifying the variable's name and type. Ex: int userAge; declares a new variable named userAge that can hold an integer value. The compiler allocates a memory location for userAge capable of storing an integer.

````javascript
            // name of file 
public class ZyCodePracticeJava1{
    public static void main(String[] args) {
       int litterSize;
       int yearlyLitters;
       int annualMice;
    
       litterSize    = 3; // Low end of litter size range
       yearlyLitters = 5; // Low end of litters per year
 
       System.out.print("One female mouse may give birth to ");
       annualMice = litterSize * yearlyLitters;
       System.out.println(annualMice + " mice,");
 
       litterSize    = 14; // High end
       yearlyLitters = 10; // High end
 
       System.out.print("and up to ");
       annualMice = litterSize * yearlyLitters;
       System.out.println(annualMice + " mice, in a year.");
    }
 }
 
 ````
 
> Remember java is generally run with camel case ex: javaPracticeMode

| Arithmetic Operator | Description |
|---  |----                         |
| +   | The addition operator is +, as in x + y. | 
| -   | The subtraction operator is -, as in x - y. Also, the - operator is for negation, as in -x + y, or x + -y.|
|*   |The multiplication operator is *, as in x * y.|
|/   |The division operator is /, as in x / y.|
| % | Divides two numbers and returns the remainder, example: num1= 5 , num1 = 2 , mod = num1 % num2; print mod; Remainder = 1|


#### Variable table 

| Variables       | Description|
| ------------- |:-------------:| 
|double     |  stores floating point numbers aka numbers with decimals.| 
| String     |  stores text, such as "Hello". String values are surrounded by double quotes     | 
| float |  - stores floating point numbers, with decimals, such as 19.99 or -19.99  | 
| char | stores single characters, such as 'a' or 'B'. Char values are surrounded by single quotes    | 
| boolean | stores values with two states: true or false      | 
| int |  stores integers (whole numbers), without decimals, such as 123 or -123      | 


#### Variable Descriptions and examples 


##### Double
> A ***floating-point number*** is a real number containing a decimal point that can appear anywhere (or "float") in the number. Ex: 98.6, 0.0001, or -55.667. A double variable stores a floating-point number. Ex: double milesTravel; declares a double variable.

>A ***floating-point literal*** is a number with a fractional part, even if the fraction is 0, as in 1.0, 0.0, or 99.573. Good practice is to always have a digit before the decimal point, as in 0.5, since .5 might mistakenly be viewed as 5.

>Scanner's ***nextDouble()*** method reads a floating-point value from input. Ex: currentTemp = scnr.nextDouble(); reads a floating-point value from the input and assigns currentTemp with that value.

##### String
> Created a variable called name of type String and assign it the value "John":
````javascript
String name = "John";
System.out.println(name);
````

##### Float

````javascript
float myFloatNum = 5.99f;
````

##### Char
````javascript
char myLetter = 'D';
````

##### Boolean
> can only be true or false.
````javascript
boolean myBool = true;
````




##### Int
>Create a variable called myNum of type int and assign it the value 15:

````javascript
int myNum = 15;
System.out.println(myNum);

````

> You can also declare a variable without assigning the value, and assign the value later also thaat if you re asign it it will overwrite the previous variable:

````javascript
int myNum;
myNum = 15;
System.out.println(myNum);

````

>An **object** consists of some internal data items plus operations that can be performed on that data. Ex: String movieTitle = "Frozen"; declares a String reference variable named movieTitle that refers to a String object. That String object stores the string "Frozen".

> The **Random** class provides methods that return a random integer in the range -2^31 to 2^31  or a programmer-defined range.



### Reading Coding API Documentation

First **API**  stands for application programming interface, which is a set of definitions and protocols for building and integrating application software.

this is a link to the [API for java](https://docs.oracle.com/en/java/javase/12/docs/api/index.html) (Recommended to use the search bar for specifc definition.)




### Variable Example
````javascript
public class Salary {                         
   public static void main(String[] args) { 
      int hourlyWage;

      hourlyWage = 20;
                   
      System.out.print("Annual salary is: ");         
      System.out.println(hourlyWage * 40 * 50);   
    
      System.out.print("Monthly salary is: ");
      System.out.println((hourlyWage * 40 * 50) / 1); 
      // FIXME: The above is wrong. Change the 1 so the statement prints monthly salary.

   } 
}

````

