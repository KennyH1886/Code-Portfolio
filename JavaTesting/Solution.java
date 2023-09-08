package JavaTesting;

/**
 * leet code easy question from neetcodeAi
 * @author Kenny
 */
public class Solution {

        // int[] input = {1,2,3,4,5};
        // int[] dupe = {1,2,2,4,5};
        // int[] noDupe = {1,2,3,4,5,6,7,8};
        // int[] twoDupe = {1,2,2,3,3,4,5};
 



        /**
         * Given an integer array nums, return true if any value appears at least twice in the array,
         *  and return false if every element is distinct.
         * 
         * @param nums array of numbers 
         * @return true or false depending on if there is a dupe or not.
         */
        public  boolean containsDuplicate(int[] nums) {
            // this implementation checks to see what
            // the next element is and compares them with a nested for loop.
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
            return false;
        }
    



/**
 * print array test , prints the numbers in an array
 * @param nums
 */
public void printArray(int[] nums) {
    int index = 0;
    while (index < nums.length) {
        System.out.println(nums[index]);
        index++;
}
   
}
}