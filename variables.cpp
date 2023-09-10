#include <iostream>      
#include <bits/stdc++.h>




// return the number of out of order pairs in array a of n elements
// Example 1: { 1, 2, 3 } -> 0 (explaination: all pairs are in order)
// Example 2: { 2, 3, 1 } -> 2 (explaination: (2,1), (3,1) are out of order)
int out_of_order(int a[], int n) {
         int count = 0;

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (a[i] > a[j]) {
                count++;
            }
        }
    }

    return count;                             

}










// remove symbols (including spaces) and digits from a char array str in place.
// Only keep the alphabets.
// Example 1: str="hello world!" -> str="helloworld"
// Example 2: str=":a,b,c,de." -> str="abcde"
// Notes: you are not allowed to create another array to solve this problem.
// Therefore, space complexity=O(1) Notes: char array ends with '\0'. HINT:
// strlen() function returns the length of a char array. Look up this function
// on the Internet on how to use. HINT: isalpha() functions checks if a symbol
// is an alphabet or not.
void remove_symbols(char str[]) {

    int length = alength(str);
    int i = 0; 

    for (int i = 0; i < length ; i++) {
        if (isalpha(str[i])) { // checks if it is in the alphabet
            
            str[index++] = str[i]; // if so adds ot modified string 
        }
    }

    str[index] = '\0'; // null termiante 
}

}


  // Your code here
}




// convert binary string to hexadecial string
// e.g. b="10010011111", return "49F"
// e.g. b="10", return "2"
// Note: return letters in hex in uppercase. The length of binary string can be
// very long!
string binary_to_hex(string b) {
  // Your code here
}







int main(){
    int x = 5; // declares variable 
    int y = 6; 
    int sum = x + y;
    
    std::cout << x << std::endl;
    std::cout << y << '\n';   // uses line break instead.
    std::cout << sum << std::endl;







    return 0;

}