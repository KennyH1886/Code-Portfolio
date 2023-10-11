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

## linked list for 5-> 3 -> Null



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


// prints value of linked list.
void print(node*h){
    while (h !=NULL)  {
        cout << h->val << "->",
        h = h->next;
    } 
}




int main(){
node* head = new node(10, 5 ); 
head->next = new node(5);
head->next->next = new node(7);
head->next->next = new node(6);
node*temp = head-> next-> next;
// default second value can be ommited for null.
std::cout << head->val <<", "  << head-> next << '\n'  ;

// head-> val = 10;
// head-> next = NULL;

     std::cout << head <<'\n'  ; // shows random location number 

     print(head);
    return 0;
}







````


# lecture 10 linked list (continued) 


big oh of 1 is constant time 

implementing from the beginning of a linked list and the end takes exact number of steps?







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


// new node function
// 0(1) timing
// h is head , k is number i want to insert.
node* insert_at_head(node*h,int k){
// node*p = new node(k); // new node
// node*p = new node(k,h);
// p->next = h; // connects new node to head at beginning
return new node(k,h); // efficient implementation , makes new node and next node updates pointer and returns it 
}


/**
 * function to delete at head 
 * 
 * 
 * 
 **/
node* delete_at_head(node*h) {

temp = head ->next;  // makes temp variable to save next variable of head 
delete head; // deletes node head
h = temp;  // moves head deleting it but leaves node there
}


// efficient version
node* delete_at_head(node*h) {
    if (h == NULL) return NULL; // error check

node*temp = h ->next;  // makes temp variable to save next variable of head 
delete h; // deletes node head
return temp; //  returns next node 
}







// prints value of linked list.
void print(node*h){
    while (h !=NULL)  {
        cout << h->val << "->",
        h = h->next;
    } 
}




int main(){
// node*head = new node(10,new node(5));
// print (head);
// head = insert_at_head(head,7);
// print(head);
node*head = NULL;
head = insert_at_head(head,7); // adds 7
head = insert_at_head(head,10); // adds 10
head = insert_at_head(head,1); //adds 1
print (head);
head = delete_at_head(head);  // leaves 10 and 7
head = delete_at_head(head); // leaves 7
return 0;







}



````






so 



class node {
nxt
val
}

class print list{
    return linked list  - > ;
}



duplicate_list(node*h){
if(h == NULL){
return h;
}

node*ogValues = h;

while(h->next != NULL ){
    int i;
    int j;
 int dupe[i] = h->val ;


    node*newNode[j] = node(dupe[i]);
    ogValues->next = newNode;
        i++;
        j++;
}





}


int main(){
    head = new node (1);
    head = new node (2);
    duplicate_List(head);
    printList(head); // 1->1->2->2->null
}