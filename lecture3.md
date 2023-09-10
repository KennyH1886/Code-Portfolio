# lecture 3  C++ DATA STRUCTURES 


go through an array with a for loop 


````c++

// creates a int goes to end of the list by iterating i. 
for (int i= 1 ; i < size ; i++ ){

}



i-- // used for decrementing for loops

/**
 * takes in an array and returns if it is sorted or not.
*/
Sorted(int a[], int n) {
    int counter = a[0];  // creates a pointer variable 

// checks if the array is in order by iterating through it 
for (int i = 1; i < n; i++){
    if (counter < a[i]){
        counter == a[i];
        return 1;
    }
}
return 0;

}

````
> for loop examples in c++

