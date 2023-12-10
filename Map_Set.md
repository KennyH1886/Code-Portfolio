# Map and Set 

### very common and useful data structures 
- good for searching values 
- only use for searching mainly

# Set 

- unique 
- complexity O(n) insert n times 



````c++
#include <set>
#include <iostream>
#include <map>
using namespace std;

int main(){
    set<int> S;

tree_node* root=NULL;
cons int n = 100000;
int i;
// strand(time(NULL)) // using time to make true random numbers 
// rand () generates random numbers with integers 1-10.
t1 = time(NULL);
for (i=0; i<n ;i++){
    int k = rand();

    // cout << k << endl;  

    // root = insert(root,k);

    S.insert(k);
}
time_t t2 = time(NULL);
cout << "time spent " << t2-t1 << '\n';
// in_traversal(root); cout << endl;
cout << "hieght of tree " << height(root) << '\n';



// iterator using set function
// for each loop with auto funnction to detect variable type automatically. 
for (auto x:S)  {   
    cout << x << ", ";
}
cout <<'\n';



// iterator , iterates whole data structure.
//     set<int>::iterator it;
//     for(it=S.begin();it!=S.end()){
//         cout << *it << ", ";
//     }
// cout << endl;>>





}




````

# MAP


- map(key,value)

````c++
#include <set>
#include <iostream>
#include <map>
using namespace std;








int main(){
    map<string, double> GPA;
    // nodes in tree based on name 
    GPA("alice") = 3.5;      // insert 
    GPA("bob") = 2.8;     // insert 
    GPA("alice") = 3.7;      // updates alices

   // currently two nodes 


 const int  n = 4;
string words[4] = {"hello", "world", "hello", "abc"};

map<string,int> M;
int i;
for(i=0; i <n, i++){
if (M.find(words[i])== M.end()) {
M[words[i]]++;
} else {// not found 
    M[words[i]] = 1;
}
}
map<string,int>::iterator it;
for (it=M.begin(); it!=M.end();it++){
cout << it->first << ":" << it->second << '\n';
}







}
````
# Binary Heap and Priority Queue 

## Priority Queue

### Definition
- smallest value comes out first.
### Queue
- first-in, first-out
### Priority queue
first in first out with the highest priority.  Best case is to use binary heap over bst , more heaps than binary are usedin real world. 

### Highest Priority First
### Operations
- Insert
- DeleteMin


## Applications
- fast check out 
- fast or multivariable queues 

### Print queue
- Each job has a priority.
- The highest priority job is printed next.
- shortest path 
### Event Simulation

- Each event has a time at which it occurs
- Each new event is put into a priority queue.
- The simulator gets the next event from the priority queue and processes it.

## priority queue example implementation.
````c++
#include <iostream>
#include <queue>
using namespace std;



int main(){
    priority_queue<double> PQ;
    PQ.push(10.0);
    PQ.push(9.4);
    PQ.push(20.11);
    PQ.push(-200);
    PQ.push(2000.19);

    cout << PQ.top() << '\n';
    PQ.pop();  
    cout << PQ.top() << '\n'
    
    while (!PQ.empty()){
        cout << PQ.top() << '\n'
    }
        return 0;

}


````
>  most languages should have a priority queue , uaeful structure. 











# Binary Heaps Implementation of Priority Queue

# Binary heap definition
- binary tree
- parents less than or equal to  children
- complete tree all filled except last from left to right


![priority queue](Topics/priorityQueue.png) 

### Structure property
- Complete binary tree: a binary tree that is completely filled except for the bottom level which is fillled from left to right.
- 2^h <= n <= 2^h+1 -1.
- h = log n = O(log n)
### Heap order property
- For any pair of nodes X, if X has a child Y, then X<Y
- The smallest key is at the root
- FindMin takes O(1) time (not DeleteMin) 
### Maintain the properties when manipulate heaps


# Basic Heap operations
- Insert
- Deletemin
- Construct Heap

# Array Implementation

![Alt text](image.png)



### Store the heap in an array
- Top-down, left-right
### The array has a position 0 containing - infiniti
### The first element is stored at position 1
### Element at position i
- Left child: 2i
- Right child: 2i+1
- Parent: i/2

# Insert
````c++ 
insert (X) {
N = N+1;
A[N] = X;
i = N;
while ((i >1) && (A[i/2] >X)) { 
 	A[i]  = A[i/2];
	i = i/2;
   }
A[i] = X;
}

````
> Kind of percolate up

![Alt text](image-1.png)


# Deletemin

````c++ 
deletemin (A) {
ans = A[1];
A[1] = A[N];
N= N-1;
percolatedown (A,1);
return (ans);
}

percolatedown(A,i) {
if (2i >N) return;  // the node “i” is a leaf node;
if ((2i + 1 <= N) && (A[2i+1] < A[2i] ))  j = 2i+1 ;
else j = 2i;
if (A[j] < A[i] ) { 
        swap (A[i], A[j]); 
        percolatedown (A, j);
}
}


````

![Alt text](image-2.png)


> because heaps are complete trees you can find parent nodes using an array by dividing the index by 2 
# Build Heap
### Approach 1: insert (A[i]), i=0,1,...n.
- complexity O(nlogn)
### Approach 2:
- Place N keys into the tree in any order
- Use percolate down to create heap-ordered tree
- Code
- Buildheap () {
for i=N/2  down to 1  { percolatedown (i); }
### Approach 3:
- Suppose that a tree with root T, and left subtree T1 and right subtree T2 is a heap. How to adjust them and make a heap?
- Use percolate down.




# Complexity of build heap


- T(n) = 2T(n/2) + logn
- n=2k
- T(2k) = 2T(2k-1) + k
- tk = 2tk-1 + k
- tk = O(2k)    
- T(n) = O(n)

# Priority Queue in C++ STL

- #include <queue>
- priority_queue<int> Q
- Operations:
- top()
- push()
- pop()
- size()
- empty()




# Map and Set (continued)


### heap 
 putting stuff on the top , more on bottom, less on top


AVL tree has a pointer to parent node.

reminder: 
- Because heaps are complete trees you can find parent nodes using an array by dividing the index by 2 

## insert Binary heap  
### big oh 
- worst case: log(n) 
- Best case: 0(1),
-  average case: O(1)
````c++
#include <iostream>
using namespace std;

int MaxSize = 1024;
int n = 0;
int *h;











void heap_insert(int *h, int n, int k) {
if (n==0) {
    h[1] = k;
    n++;
    return;
}
// where should we attempt to save k?
int p = n+1;
while (true) {
    if (p==1 || h[p/2] <= k){
        h[p] = k;
        n++;
        break;
    }
    if (h[p/2]){
    h[p] = k;
    n++;
    break;
}else {
    h[p] = h[p/2]; // move the parent down. 
    p /= 2;
}

}
}













int main(){

h = new int [MaxSize]
int n = 0;
heap_insert(10);

}


````



# delete min
- best case : o(logn)?
- avg case: o(logn)
- worst case: o(logn)


````c++
#include <iostream>
using namespace std;

int MaxSize = 1024;
int n = 0;
int *h;



// decrements and swaps the last node and then updates the heap and its leaves in order to least value parents 
int  delete_min(){
    if(n == 0){
        throw = "Empty Heap";
    }
if (n==1){
    n=0;
return h[1];
}
// now the number of items in the heap is at least 2
int k = h[n];
n-= 1;
int p = 1;
while (true) {
    if (2*p>n) {
        h[p] =k;
        break;
    }
    // now handle case when p has only one child
    if (2*p + 1 > n){ // no right child 
    if (k > h[p*2]) {
        h[p] = h[p*2]; 
        h[p*2]= k;
    }else {
        h[p] = k;
    } 
    break;
    }

    }
    // try to put to pos p 
    if (k>h[p*2] || k>h[p/2+1]){ // k is greater than at least one child 
        if (h[p*2] < h[p*2 + 1]){
            h[p] = h[p*2];
            p *= 2;
        } else { // right child smaller 
         h[p] = h[p*2 + 1];
            p = p*2+1;
        }
        else { // k is less than both children. 
            h[p] = k;
            break;
 }
        }
        return res;
    }





int main(){

// delete min helper method for printing
    int r; 
    while (){
        r = deletemin();
        cout << r << '\n';
    }

h = new int [MaxSize]
int n = 0;
heap_insert(10);



return 0;
}


````
###  heap sort 
> there is a heap sort , best case , worst case , average case , complexity of other sort algorithims are O (logn)


# unordered set 

````c++
#include <set>
#include <iostream>
#include <map>
using namespace std;

unordered_set<int> S;

S.insert();
S.insert();
S.insert();
S.insert();
set<int>::iterator it;
for (it=S.begin();it!=S.end();it++){

}


int main(){

}


````