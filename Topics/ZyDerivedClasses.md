# Derived Classes 

## Derived class concept

### Commonly, one class is similar to another class but with some additions or variations. Ex: A store inventory system might use a class called GenericItem that has itemName and itemQuantity data members. But for produce (fruits and vegetables), a ProduceItem class with data members itemName, itemQuantity, and expirationDate may be desired.

## Example notes
> A GenericItem has data members itemName and itemQuantity and 3 member functions.
A ProduceItem is very similar to a GenericItem, but a ProduceItem also needs an expirationDate data member.
A ProduceItem needs the same data member functions as a GenericItem plus functions to get and set the expiration date.
If ProduceItem is implemented as an independent class, all the data/function members from GenericItem must be copied into ProduceItem, creating lots of duplicate code.
If ProduceItem is implemented as a derived class, ProduceItem need only implement what is different between a GenericItem and ProduceItem.

## Inheritance

### A ***derived class (or subclass)*** is a class that is derived from another class, called a ***base class (or superclass)***. Any class may serve as a base class. The derived class is said to inherit the properties of the base class, a concept called ***inheritance***. An object declared of a derived class type has access to all the public members of the derived class as well as the public members of the base class.
A derived class is declared by placing the keyword ***extends*** after the derived class name, followed by the base class name. Ex: class DerivedClass extends BaseClass { ... }. The figure below defines the base class GenericItem and derived class ProduceItem that inherits from GenericItem.

````java 
//private 
private String itemName;
   private int itemQuantity;
   private String expirationDate;
   private int percentageFat;
private boolean hasSeeds;
 public void setEdition(String newEdition)
   public string getEdition()
private String editionName;
private String readerName;




//public 
 public void setName(String newName)
   public void setQuantity(int newQty)
   public void printItem()
   public void setExpiration(String newDate)
   public String getExpiration()
   public void setPercentageFat(int newPercent)
   public int getPercentageFat()
public boolean getHasSeeds()
public void setReader(String newReader)
   public string getReader()



public class GenericItem {
   private String itemName;
   private int itemQuantity;

   public void setName(String newName) {
      itemName = newName;
   }

   public void setQuantity(int newQty) {
      itemQuantity = newQty;
   }

   public void printItem() {
      System.out.println(itemName + " " +
                         itemQuantity);
   }
}

public class BookItem extends GenericItem {
   private String bookTitle;

   public void setTitle(String newTitle) {
      bookTitle = newTitle;
   }

   public String getTitle() {
      return bookTitle;
   }
}

public class TextbookItem extends BookItem {
   private String editionName;

   public void setEdition(String newEdition) {
      editionName = newEdition;
   }

   public String getEdition() {
      return editionName;
   }
}

public class AudiobookItem extends BookItem {
   private String readerName;

   public void setReader(String newReader) {
      readerName = newReader;
   }

   public String getReader() {
      return readerName;
   }
}
public class ProduceItem extends GenericItem {
   private String expirationDate;

   public void setExpiration(String newDate) {
      expirationDate = newDate;
   }

   public String getExpiration() {
      return expirationDate;
   }
}

public class FruitItem extends ProduceItem {
   private boolean hasSeeds;

   public void setHasSeeds(boolean withSeeds) {
      hasSeeds = withSeeds;
   }

   public boolean getHasSeeds() {
      return hasSeeds;
   }
}
	
public class DairyItem extends ProduceItem {
   private int percentageFat;

   public void setPercentageFat(int newPercent) {
      percentageFat = newPercent;
   }

   public int getPercentageFat() {
      return percentageFat;
   }
}
````
# Derived Classes 

## Derived class concept

### Commonly, one class is similar to another class but with some additions or variations. Ex: A store inventory system might use a class called GenericItem that has itemName and itemQuantity data members. But for produce (fruits and vegetables), a ProduceItem class with data members itemName, itemQuantity, and expirationDate may be desired.

## Example notes
> A GenericItem has data members itemName and itemQuantity and 3 member functions.
A ProduceItem is very similar to a GenericItem, but a ProduceItem also needs an expirationDate data member.
A ProduceItem needs the same data member functions as a GenericItem plus functions to get and set the expiration date.
If ProduceItem is implemented as an independent class, all the data/function members from GenericItem must be copied into ProduceItem, creating lots of duplicate code.
If ProduceItem is implemented as a derived class, ProduceItem need only implement what is different between a GenericItem and ProduceItem.

## Inheritance

###A ***derived class (or subclass)*** is a class that is derived from another class, called a ***base class (or superclass)***. Any class may serve as a base class. The derived class is said to inherit the properties of the base class, a concept called ***inheritance***. An object declared of a derived class type has access to all the public members of the derived class as well as the public members of the base class.
A derived class is declared by placing the keyword ***extends*** after the derived class name, followed by the base class name. Ex: class DerivedClass extends BaseClass { ... }. The figure below defines the base class GenericItem and derived class ProduceItem that inherits from GenericItem.

````java 
//private 
private String itemName;
   private int itemQuantity;
   private String expirationDate;
   private int percentageFat;
private boolean hasSeeds;
 public void setEdition(String newEdition)
   public string getEdition()
private String editionName;
private String readerName;




//public 
 public void setName(String newName)
   public void setQuantity(int newQty)
   public void printItem()
   public void setExpiration(String newDate)
   public String getExpiration()
   public void setPercentageFat(int newPercent)
   public int getPercentageFat()
public boolean getHasSeeds()
public void setReader(String newReader)
   public string getReader()



public class GenericItem {
   private String itemName;
   private int itemQuantity;

   public void setName(String newName) {
      itemName = newName;
   }

   public void setQuantity(int newQty) {
      itemQuantity = newQty;
   }

   public void printItem() {
      System.out.println(itemName + " " +
                         itemQuantity);
   }
}

public class BookItem extends GenericItem {
   private String bookTitle;

   public void setTitle(String newTitle) {
      bookTitle = newTitle;
   }

   public String getTitle() {
      return bookTitle;
   }
}

public class TextbookItem extends BookItem {
   private String editionName;

   public void setEdition(String newEdition) {
      editionName = newEdition;
   }

   public String getEdition() {
      return editionName;
   }
}

public class AudiobookItem extends BookItem {
   private String readerName;

   public void setReader(String newReader) {
      readerName = newReader;
   }

   public String getReader() {
      return readerName;
   }
}
public class ProduceItem extends GenericItem {
   private String expirationDate;

   public void setExpiration(String newDate) {
      expirationDate = newDate;
   }

   public String getExpiration() {
      return expirationDate;
   }
}

public class FruitItem extends ProduceItem {
   private boolean hasSeeds;

   public void setHasSeeds(boolean withSeeds) {
      hasSeeds = withSeeds;
   }

   public boolean getHasSeeds() {
      return hasSeeds;
   }
}
	
public class DairyItem extends ProduceItem {
   private int percentageFat;

   public void setPercentageFat(int newPercent) {
      percentageFat = newPercent;
   }

   public int getPercentageFat() {
      return percentageFat;
   }
}
````
