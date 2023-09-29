# lecture 9 C++ Linked Lists 



> tips 
- learn data structure approaches , two pointer method. 




# Linked List 
pro
- accessing with index is fast. constant time (0)1 becuas ethey are in contious memory. 
- also called random access, ram.
- dynamic size 
- linked list doesnt need to shift to add and remove values.

disadvantage
- takes more steps to check

# code implimentation

head is only a pointer not a node 


A node class has a value and a next pointer .

visualize it as you make it.

````c++
#include <iostream>
using namespace std;


class node {
    public:       // bad practice
    int val;
    node* next;
    node(int v, node* nxt){
        val = v;
        next = nxt;

    }
};



int main(){
node* head = new node(10,NULL); // default second value can be ommited for null.
std::cout << head->val <<", "  << head-> next << '\n'  ;

// head-> val = 10;
// head-> next = NULL;

     std::cout << head <<'\n'  ; // shows random location number 
    return 0;
}







````




