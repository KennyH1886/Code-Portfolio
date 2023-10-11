#include <iostream>
using namespace std;

// node variable
class node
{
public:
    int val;
    node *next;
    node(int v, node *nxt = NULL)
    {
        val = v;
        next = nxt;
    }
};

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

// duplicate all the nodes in h and return the head of the new linked list
// Example 1:
// Input: 1->2->NULL
// Return: 1->1->2->2->NULL
// Example 2:
// Input: 3->3->1->NULL
// Return: 3->3->3->3->1->1->1->NULL

node *duplicate_list(node *h)

    {
    if (h == nullptr) {
        return nullptr;
    }

    node* ogValues = h;

    while (h != nullptr) {
        // Duplicate the current node
        node* newNode = new node(h->val);
        newNode->next = h->next;
        h->next = newNode;

        // Move to the next original node
        h = newNode->next;
    }

    return ogValues;
}





// Given linked list h and position k, return the value of the node at position
// k.

// Allow python style position where k can be negative

// Example 1:
// Input: 2->1->4->5->NULL, k=2
// Return: 4

// Example 2:
// Input: 10->11->12->NULL, k=-1
// Return: 12

int position(node *h, int k)
{
  // Handle the case where the linked list is empty
  if (h == NULL) {
    std::cout << "Linked list is empty." << endl;
    return -1; 
  }

  // Count the number of nodes in the linked list
  int count = 0;
  node *current = h;
  while (current != nullptr) {
    count++;
    current = current->next;
  }

  // Calculate the actual position considering negative indices
  int actualPosition = (k >= 0) ? k : count + k;

  // Check if the calculated position is valid
  if (actualPosition < 0 || actualPosition >= count) {
    cerr << "Error: Invalid position." << endl;
    return -1; 
  }

  // Traverse the linked list to the desired position
  current = h;
  for (int i = 0; i < actualPosition; i++) {
    current = current->next;
  }

  // Return the value of the node at the specified position
  return current->val;
}



// remove all nodes with even numbers in a given linked list and return the head
// of resulting linked list
// NOTE: Don't create a new linked list (never call 'new' keyword)
// NOTE: Delete the memory for the deleted nodes

// Example 1:
// Input: 2->1->4->NULL
// Return: 1->NULL

// Example 2:
// Input: 8->10->20->NULL
// Return: NULL

node *remove_even(node *h)
{
    // null check
    if (h == NULL)
    {
        return NULL;
    }

    // check if even and deletes
    while (h != NULL && h->val % 2 == 0)
    {
        node *temp = h;
        h = h->next;
        delete h;
    }

    // updates the next value if its even

    // new pointer node
    node *pointer = h;

    while (pointer != NULL && pointer->next != NULL)
    {
        if (pointer->next->val % 2 == 0)
        {
            node *temp = pointer->next;
            pointer->next = pointer->next->next;
            delete temp;
        }
        else
        {
            pointer = pointer->next;
        }
    }

    return h;
}


// 0(n)
node*reverse(node* h){
if (h ==NULL|| h->next == NULL){
    return h;
}
    // 3->5-2-2-10
  node* p =  reverse(h->next); // call from second to last and reverses it 
    h->next->next = h; // puts 10 at the end beginning value to the end.
     h->next= NULL; // ends the loop
     return p;
}




int main()
{
    node *duplicate_list(node * h);
    node *remove_even(node * h);
    int position(node * h, int k);

   
    node *head1 = new node(2);
    head1->next = new node(1);
    head1->next->next = new node(4);

    node *result1 = remove_even(head1);
    printList(result1); // Output: 1

    // Example 2
    node *head2 = new node(8);
    head2->next = new node(10);
    head2->next->next = new node(20);

    node *result2 = remove_even(head2);
    printList(result2); // Output: (empty list)

        node* head3 = new node(1);
    head3->next = new node(2);

    node* result3 = duplicate_list(head3);
    printList(result3);  // Output: 1 -> 1 -> 2 -> 2

    node* head4 = new node(3);
    head4->next = new node(3);
    head4->next->next = new node(1);

    node* result4 = duplicate_list(head4);
    printList(result4);  // Output: 3 -> 3 -> 3 -> 3 -> 1 -> 1 -> 1


 node* head5 = new node(10);
    head5->next = new node(2);
    head5->next->next = new node(5);
    head5->next->next->next = new node(3);

node* result5 = reverse(head5);
    printList(head5); 

 // Test Case 2: Negative index
  node *list2 = new node(10);
  list2->next = new node(11);
  list2->next->next = new node(12);
  int result6 = position(list2, -1);
  cout << "Test Case 2: " << result6 << " (Expected: 12)" << endl;



    return 0;
}
