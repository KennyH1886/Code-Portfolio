# Classes and ArrayLists
### A programmer commonly uses classes and ArrayLists together. The program below creates a Review class (reviews might be for a restaurant, movie, etc.), then manages an ArrayList of Review objects.
## Example 
````Java 
public class Review {
   private int rating = -1;
   private String comment = "NoComment";
   
   public void setRatingAndComment(int revRating, String revComment) {
      rating = revRating;
      comment = revComment;
   }
   public int getRating() { return rating; }
   public String getComment() { return comment; }
}
import java.util.ArrayList;
import java.util.Scanner;


public class ReviewSystem {
 
   public static void main(String [] args) {
      Scanner scnr = new Scanner(System.in);
      ArrayList<Review> reviewList = new ArrayList<Review>();
      Review currReview;
      int currRating;
      String currComment;
      int i;
   
      System.out.println("Type rating + comments. To end: -1");
      currRating = scnr.nextInt();
      while (currRating >= 0) {
         currReview = new Review();
         currComment = scnr.nextLine(); // Gets rest of line
         currReview.setRatingAndComment(currRating, currComment);
         reviewList.add(currReview);
         currRating = scnr.nextInt();
      }
   
      // Output all comments for given rating
      System.out.println();
      System.out.println("Type rating. To end: -1");
      currRating = scnr.nextInt();
      while (currRating != -1) {
         for (i = 0; i < reviewList.size(); ++i) {
            currReview = reviewList.get(i);
            if (currRating == currReview.getRating()) {
               System.out.println(currReview.getComment());
            }
         }
         currRating = scnr.nextInt();
      }
   }
}
````
> Output: Type rating + comments. To end: -1
5 Great place!
5 Loved the food.
2 Pretty bad service.
4 New owners are nice.
2 Yuk!!!
4 What a gem.     
-1


Type rating. To end: -1
5
 Great place!
 Loved the food.
1
4
 New owners are nice.
 What a gem.     
-1
## A class with an ArrayList: The Reviews class
### A class can also involve ArrayLists. The program below redoes the example above, creating a Reviews class for managing an ArrayList of Review objects.
The Reviews class has methods for reading reviews and printing comments. The resulting main() is clearer than above.
The Reviews class has a getter method that returns the average rating. The method computes the average rather than reading a private field, but the class user need not know how the method is implemented.
## Improved reviews program with a Reviews class.
````Java 
import java.util.ArrayList;
import java.util.Scanner;


public class Reviews {
   private ArrayList<Review> reviewList = new ArrayList<Review>();
   
   public void inputReviews(Scanner scnr) {
      Review currReview;
      int currRating;
      String currComment;
   
      currRating = scnr.nextInt();
      while (currRating >= 0) {
         currReview = new Review();
         currComment = scnr.nextLine(); // Gets rest of line
         currReview.setRatingAndComment(currRating, currComment);
         reviewList.add(currReview);
         currRating = scnr.nextInt();
      }
   }
   
   public void printCommentsForRating(int currRating) {
      Review currReview;
      int i;
   
      for (i = 0; i < reviewList.size(); ++i) {
         currReview = reviewList.get(i);
         if (currRating == currReview.getRating()) {
            System.out.println(currReview.getComment());
         }
      }
   }
   
   public int getAverageRating() {
      int ratingsSum;
      int i;
   
      ratingsSum = 0;
      for (i = 0; i < reviewList.size(); ++i) {
         ratingsSum += reviewList.get(i).getRating();
      }
      return (ratingsSum / reviewList.size());
   }
}
````


## Using Reviews in the Restaurant class
### Programmers commonly use classes within classes. The program below uses a Restaurant class that contains a Reviews class so reviews can be associated with a specific restaurant.
````Java 
import java.util.ArrayList;
import java.util.Scanner;


public class CallProduct {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      ArrayList<Product> productList = new ArrayList<Product>();
      int currPrice;
      String currName;
      int i;
      Product resultProduct;


      currPrice = scnr.nextInt();
      while (currPrice >= 0) {
         resultProduct = new Product();
         currName = scnr.next();
         resultProduct.setPriceAndName(currPrice, currName);
         productList.add(resultProduct);
         currPrice = scnr.nextInt();
      }


      resultProduct = productList.get(0);


      for (i = 0; i < productList.size(); ++i) {
         if (productList.get(i).getPrice() > resultProduct.getPrice()) {
            resultProduct = productList.get(i);
         }
      }


      System.out.println("$" + resultProduct.getPrice() + " " + resultProduct.getName());
   }
}
```
###Input  : 5 tuna , 6 Foil ,7 Belt 
###Output : $7 Belt


Current price - discount 
5-3 = 2
12-3 = 9


````Java 
public class CallProducts {
   public static void main(String[] args) {
      Products allProducts = new Products();


      allProducts.inputProducts();
      allProducts.printAfterDiscount(3);
   }
}
import java.util.ArrayList;
import java.util.Scanner;


public class Products {
   private ArrayList<Product> productList;


   public Products() {
      productList = new ArrayList<Product>();
   }


   public void inputProducts() {
      Scanner scnr = new Scanner(System.in);
      Product currProduct;
      int currPrice;
      String currName;


      currPrice = scnr.nextInt();
      while (currPrice >= 0) {
         currProduct = new Product();
         currName = scnr.next();
         currProduct.setPriceAndName(currPrice, currName);
         productList.add(currProduct);
         currPrice = scnr.nextInt();
      }
   }


   public void printAfterDiscount(int discountPrice) {
      int i;
      int currDiscountPrice;


      for (i = 0; i < productList.size(); ++i) {
         currDiscountPrice = productList.get(i).getPrice() - discountPrice;


         System.out.println(productList.get(i).getName() + ": " + currDiscountPrice);
      }
   }
}


public class Product {
   private int price;
   private String name;


   public void setPriceAndName(int productPrice, String productName) {
      price = productPrice;
      name = productName;
   }


   public int getPrice() {
      return price;
   }


   public String getName() {
      return name;
   }
}
````


### Input: 5 tuna , 12 Flowers, -1
### Output: 
Tuna: 2
Flowers: 9





