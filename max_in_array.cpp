#include <iostream>
using namespace std;

// returns the maximum value in array a, n is the size of this array
int max_in_array(int a[], int n) {
    int max_Value = a[0];
  

    for (int i = 1; i < n; i++ ){
        if (a[i] > max_Value ){
            max_Value = a[i];
        } 
    }
    return max_Value;
}