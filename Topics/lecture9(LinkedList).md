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

# Reverse linked list 

> good way to practice recursion 

10->2->5->3->NULL



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
node*head = NULL;
node*tail = NULL;

// Utility function to print the linked list
void printList(node *head)
{
    while (head != nullptr)
    {
        std::cout << head->val;
        if (head->next != nullptr)
        {
            std::cout << " -> ";
        }
        head = head->next;
    }
    std::cout << std::endl;
};

public:     LinkeList() {
    head = tail = NULL;
}
void push_at_head(int k){
    insert_at_head(k);
} int pop_at_head(){
    int temp = head->val;
    delete_at_head();
    return temp;
} int pop_at_tail(){
    int temp = tail->val;
    delete_at_tail();
    return temp;
}

// 0(n) very slow
void delete_at_tail(node*){
if (head== tail){
    delete tail;
    head = tail = NULL
    return;
}

node*newtail = head
while (newtail->next != tail) newtail = newtail->next;

delete tail;
tail = newtail;
tail->next = NULL;
}




//(0)n
node*reverse(node* h){
if (h ==NULL|| h->next == NULL){
    return h;
}
    // 3->5-2-10
   p =  reverse(h->next); // call from second to last and reverses it 
    h->next->next = h; // puts 10 at the end beginning value to the end.
    h->next= NULL; // ends the loop
    return p;
}
// (0)1
void insert_at_tail(int k){
    // use these as global values.
    if (head == NULL ){
        head = tail = new node(k);
    } else {}
    // node*head;
    // node*tail;
    tail->next = new node(k);
    tail = tail->next;



}




int main(){

    // linked list application after implimentation of utility variables.
LinkedList l;
l.push_at_head(1);
l.push_at_head(2);
l.push_at_head(3);
l.push_at_head(4);
l.printList();
int r = l.pop_at_head();
l.printList();
l.push_at_tail(10);
l.printlist();
r = l.pop_at_tail();
cout << "the tail value"
l.printList();

















 node* head1 = new node(10);
    head1->next = new node(2);
    head1->next->next = new node(5);
    head1->next->next->next = new node(3);

node* result = reverse(head1);
    printList(head1); 

insert_at_tail(5);
insert_at_tail(10);
insert_at_tail(3);
printList(head);


}






````

> important
more examples of linked list implementation included.


# Linked List code wrap up

````c++ 
#include <iostream>
using namespace std;

class node {
public:
    int val;
    node* next;
    
    node(int v,node* nxt=NULL) {
        val = v;
        next = nxt;
    }
};
class LinkedList {
private:
    node *head, *tail;
    // return the new head of linked list
    // O(1)
    void insert_at_head(int k) {
        if (head==NULL) head = tail = new node(k);
        else head = new node(k,head);    
    }
    void delete_at_head() {
        if (head==NULL) return;
        node* temp = head->next;
        delete head;
        head = temp;
        if (head==NULL) tail=NULL;
    }
/*
    // O(n)
node* reverse(node* h) {
    if (h==NULL or h->next==NULL) return h;
    node *p = reverse(h->next);
    h->next->next = h;
    h->next = NULL;
    return p;
}
*/
    // O(1)
    void insert_at_tail(int k) {
        if (head == NULL) head = tail = new node(k);
        else {
            tail->next = new node(k);
            tail = tail->next;
        }
    }
    // O(n): use this function with caution. Very slow
    void delete_at_tail() {
        if (head==NULL) return;
        if (head==tail) { // there is one node
            delete tail;
            head = tail = NULL;
            return;
        }
        // move new tail to right before the old tail
        node *newtail = head;
        while (newtail->next != tail) newtail = newtail->next;
        // delete old the tail
        delete tail;
        tail = newtail;
        tail->next = NULL;
    }
    
public:
    LinkedList() {
        head = tail = NULL;
    }
    LinkedList(int a[], int n) {
        head = tail = NULL;
        for (int i=0;i<n;i++) {
            insert_at_tail(a[i]);
        }
    }
    void push_at_head(int k) {
        insert_at_head(k);
    }
    int pop_at_head() {
        int temp = head->val;
        delete_at_head();
        return temp;
    }
    void push_at_tail(int k) {
        insert_at_tail(k);
    }
    int pop_at_tail() { // SLOW function
        int temp = tail->val;
        delete_at_tail();
        return temp;
    }
    void print() {
        node *h = head;
        while (h!=NULL) {
            cout << h->val << "->";
            h = h->next;
        }
        cout << "NULL" << endl;
    }
};
int main() {
    LinkedList l;
    l.push_at_head(1);
    l.push_at_head(2);
    l.push_at_head(3);
    l.push_at_head(4);
    l.print();
    int r = l.pop_at_head();
    cout << "the head value=" << r << endl;
    l.print();
    l.push_at_tail(10);
    l.print();
    r = l.pop_at_tail();
    cout << "the tail value=" << r << endl;
    l.print();
    
    int a[] = { 5,6,7,8,9,20, 3 };
    LinkedList l2(a,sizeof(a)/sizeof(int));
    l2.print();
    return 0;
}





````




# bonus linked list functions , (remove odd & cycle)
````C++
#include <iostream>
using namespace std;

class node {
public:
    int val;
    node* next;
    
    node(int v,node* nxt=NULL) {
        val = v;
        next = nxt;
    }
};
// print utility function 
    void print() {
        node *h = head;
        while (h!=NULL) {
            cout << h->val << "->";
            h = h->next;
        }
        cout << "NULL" << endl;
    }


/**
 * Removes odd positon nodes and deletes them  * and returns the updated head. using recursion.
 * 
 **/
node* remove_odd(node*h){
if (h == NULL){
return NULL;
}
if (h->next == NULL){
 delete h;
return NULL;
}
node*p = h->next;
h->next = r;

h = h->next;
node*r = remove_odd(h->next) ;
h->next = r;
return h;
}


/**
 * Removes odd positon nodes and deletes them  * and returns the updated head.
 * 
 **/
node* remove_odd(node*h){
if (h == NULL){
return NULL;
}

node*q = h->next;
delete h;
h = q;
node* p = h; // used p to save h to return.
while (p->next != NULL &&  p->next != NULL){
    q = p->next;
p->next = p->next->next; 
p = p->next;
delete q;
}

return h;
}
















// make test cases
int main(){
node*head = new node(1) ;
print(head);
head = remove_odd(head);
print(head);


}















````


> binary and hash table used to hold unique values , useful in linked list.

for cycles you can use two pointers to record values and find patterns to eventually find an end statement to the program , tortiose and hare structure.