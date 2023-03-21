package JavaTesting;

/**
 * MainClass
 */
public class MainClass {

    static Solution solution = new Solution();
public static void main(String[] args) {
    // print test 
    System.out.println("Hello world");



    int[] input = {1,2,3,4,5};
    int[] dupe = {1,2,2,4,5};
    int[] noDupe = {1,2,3,4,5,6,7,8};
    int[] twoDupe = {1,2,2,3,3,4,5};

boolean arrayOne = solution.containsDuplicate(input);
boolean arrayTwo = solution.containsDuplicate(dupe);
boolean arrayThree = solution.containsDuplicate(noDupe);
boolean arrayFour = solution.containsDuplicate(twoDupe);


//array contents test 
solution.printArray(input);


// solutions print test 
System.out.println("It is " + arrayOne  + " that this array contains a duplicate");
System.out.println("It is " + arrayTwo  + " that this array contains a duplicate");
System.out.println("It is " + arrayThree  + " that this array contains a duplicate");
System.out.println("It is " + arrayFour  + " that this array contains a duplicate");

}






}


