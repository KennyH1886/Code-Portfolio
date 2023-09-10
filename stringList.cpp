#include <iostream>

using namespace std;

// returns 1 if s is in strlist, 0 if not. n is the size of strlist
int find_string_in_array(string s, string strlist[], int n) { 

// sets a variable to hold s 
string str = s;

// for loop using the size provided iterates through the array and finds if the s is in the list to return 1 and if not default to returning 0
for (int i = 1; i < n; i++){
    if (strlist[i] == str ){
        return 1;
    } 
}
     return 0;
}

  


  




