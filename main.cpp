#include <iostream>
using namespace std;


//lecture 3 code 
int max_in_array(int a[], int n) {
    int max_Value = a[0];
  

    for (int i = 1; i < n; i++ ){
        if (a[i] > max_Value ){
            max_Value = a[i];
        } 
    }
    return max_Value;
}

// int iFinder(int a[], int n){

//     for(int i = 1; i < n; i++){
//         return Ivalue;

//     }
// }


/**
 * takes in an array and returns if it is sorted or not.
*/
int Sorted(int a[], int n) {
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

int missing(int a[], int n ){

int numCheck = a[0];

for(int i = 1 ; i < n; i++){
    if (numcheck != a[i]){
        return a[i];
    }
    return 0;

}





int main(){
int arr[] = {1,2,3,4};
int size = 4;
int max =  max_in_array(arr, size);
// sorted array
int sortA[]= {1,2,3,4};
// array out of order 
int sortB[] = {5,4,3,2};

int missingNum[] = {0,1,2,3,4,5}
int size6 = 6;

miss = missing(missingNum, size6);



int sort = Sorted(sortA,size);

int Bsort = Sorted(sortB,size);


std::cout << "the maximum value in the array is: " << max << std::endl;

std::cout << "if this array is sorted this will display 1 : " << sort << std::endl;

std::cout << "this array isnt sorted so this will display 0 : " << Bsort << std::endl;

std::cout << "this is th emissing number in the array " << missing << std::endl;

    return 0;
}