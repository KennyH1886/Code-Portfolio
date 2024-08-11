#include <iostream>
#include <queue>

using namespace std;

// Given an initial array a size of n, on each step remove the largest two numbers
// and smash them together to generate a new number, which is the difference
// of the two numbers. This new number is added to the remaining numbers.
// This step is repeated until only one number is left.
// Return that number.
// Example:
// Input: a = { 6, 3, 10, 5}, n=4
// Step 1: remove 10 and 6, smash them to get 4 (10-6). 4,5,3 are the remaining numbers
// Step 2: remove 4 and 5, smash tehm to get 1. 1, 3 are the remaining numbers
// Step 3: remove 1 and 3, smash them to get 2. 2 are the only reminaing number
// Return: 2

int smash(int a[], int n) {
// Your code here
priority_queue<int, vector<int>, less<int>> pq;   // makes a priority queue that puts the greatest value first in the binary heap.

 // Push all elements of the array into the priority queue
    for (int i = 0; i < n; i++) {
        pq.push(a[i]);  // Push the actual array element, not the index
    }

    // Repeat until only one number is left
    while (pq.size() > 1) {
        // Remove the two largest numbers
        int num1 = pq.top();
        pq.pop();
        int num2 = pq.top();
        pq.pop();

        // Smash them together to get the difference and add it back to the priority queue
        int newNum = abs(num1 - num2);
        pq.push(newNum);
    }

    // Return the final remaining number
    return pq.top();
}







// Given array a with size n. Find the k'th smallest number in the array
// Note: You are NOT allowed to SORT the array.
// Note: The complexity of your algorithm should be not slower than O(n*logk)
// Example:
// Input: a={6,3,8,2,10}, n=5, k=3
// Return: 6
// (6 is the 3rd smallest number in a)

int kth(int a[], int n, int k) {
   priority_queue<int> maxH;

    // Insert the first k elements into the min-heap
    for (int i = 0; i < k; ++i) {
        maxH.push(a[i]);
    }

    // For the remaining elements starting from k, if they are smaller than the top of the heap,
    // replace the top with the current element
    for (int i = k; i < n; ++i) {
        if (a[i] < maxH.top()) {
            maxH.pop();
            maxH.push(a[i]);
        }
    }

    // The top of the min-heap now contains the k'th smallest element
    return maxH.top();
}





int main(){

// test case for smash method
int a[] = {6,3,10,5};
int n = 4;

int result = smash(a,n);

cout << "Result: "  << result << endl;   // output should be 2?


  int a1[] = {6, 3, 8, 2, 10};
    int n1 = 5;
    int k1 = 3;

    int result1 = kth(a1, n1, k1);

    cout << "The " << k1 << "'th smallest number is: " << result1 << endl;


  return 0;
}