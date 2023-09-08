# lecture 3  Arrays and big O examples in C

````c++
#include <iostream>
using numspace std;

int main(){
    
int a[100]; //declares an array in c++ , time complexity O(1)
cout << a[5] << endl; 
int b;
cout << b+4  << endl;   // second way to return array 5 

int a[] = {1,2,3,4,0,1,2,3,4,4,5,6}; // compiler will figure out array size,  complexity O(n) n is the number of time it initializes 
cout << b[7]  << endl;  

/**
* c is a pointer type 
* dynamic memory allocation
* returns values to c 
* *C returns a pointer to integer type
* 
**/
int *c = new int[2000]; // allocates 2000 integers in array, it also returns starting location of them. 

new int [2000]; // allocates 200 intergers thats not allocated to anything , cant be used, useless
int *d =c;
delete [] c; // frees up the memory allocated 

delete [] d;// frees memory for d vairable 


// if you keep allocating with out freeing space , you wil run out of memory 


c = new int {2000} // reallocates variables to array complecity is constant time O(1) A bit slower than not using new.
c[0] = 20;
cout << c[0] endl;
cout << c{999} << endl;




return 0; // initializes it to 0
}

````

> stack overflow happens when you attempt to allocate too much memory in static memory which is limited , also used in recursion. if you want to use more memory , use new. remember type of variables when coding.




