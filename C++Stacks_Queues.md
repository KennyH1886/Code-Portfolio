# Stack and Queues Notes

# Stack 

- Linear Data Structure
#### Stack is a high level data structure that specifies a behavior 
- LIFO or FILO
####  Last In First Out or First In -Last Out

# Applications
#### very important data structure , 
1. function call- calls stack A->B->C->D
2. to store local variables 
3. stack is memory (placeholder)
- Undo/Redo
- Depth first search
- Backtracking
- Sudoku solver, 8-queen, …

- Implementing Recursion

![stack pic](/Topics/Stack_Example.png)


## Important Operations on Stack
-lifo 

- Push // adds to the stack  0(1)
```C++

private:
    Node<T>* top;

// insert at tail


append //python allocates to the last position
a[n] = k; n++
n = size();
// array push
a[n-1]


   node* newNode = new Node<T>(val);
        newNode->next = top;
        top = newNode;





```











- Pop  // returns and remove from stack 0(1)
```C++

private:
    Node<T>* top;

// delete at tail 0(n)

// pop array
n--  // decrement size to delete at end. 

  if (isEmpty()) {
            std::cout << "Stack underflow: The stack is empty." << std::endl;
            return;
        }
        node * temp = top;
        top = top->next;
        delete temp;









```
- Top(peek)  // the top of the stack 0(1)
```C++

private:
    Node<T>* top;

        if (isEmpty()) {
            std::cerr << "Stack is empty." << std::endl;
            exit(EXIT_FAILURE);
        }
        return top->data;




```
- isEmpty() 0(1)
- size() 0(1)
```C++






```




# Implementation

## Linked List
- Advantage? 
###### easier to code
- Disadvantage?
###### slower

## Array / Vector
Advantage? 
###### faster than linked list

- Disadvantage?



amortized cost - scan size for the future 



## Stack in C++ STL

````C++
#include <stack>
stack<int> S;
S.push(5); // 5 is pushed to the top of the stack
S.pop(); // removes the front element of a stack
S.empty(); // tests if a stack is empty
S.top()
```````







# Example problems & Functions


## parenthesis check stack
```C++






```

# Queues

![queue pic](/Topics/Queue_Example.png)

- Linear Data Structure

- FIFO
- First In First Out
- Applications
- Scheduling CPU, Job 
- Breadth first search
- cores 
- operating systems use queues to run multiple tasks



## Operations on Queue

- Enqueue


```C++
   Node<T>* newNode = new Node<T>(val);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail->next = newNode;
            tail = newNode;
        }

        std::cout << val << " enqueued to the queue." << std::endl;
    }





```
- Insert to the end of queue
O(1)


```C++






```
- Dequeue


```C++
     if (isEmpty()) {
            std::cout << "Queue is empty. Cannot dequeue." << std::endl;
            return;
        }

        Node<T>* temp = head;
        head = head->next;

        if (head == nullptr) {
            tail = nullptr;
        }

        std::cout << temp->data << " dequeued from the queue." << std::endl;
        delete temp;
    }





```
- Front


```C++






```
# Implementation
- Pros:
Size is not a concern



- Cons:
Frequent Dynamic Allocation and De-allocation


## Circular Array Implementation Complexity

- Enqueue:
Best case: O(1)
Worst case: O(n)
Amortized cost: O(1)

- Dequeue, Front:
Best case, Worst Case, Average : O(1)


# Queue in C++ STL


````C++
#include <queue>
queue<int> Q;
Q.push(5); // 5 is pushed to the end of the queue
Q.front(); // returns the front value of a queue
Q.pop(); // removes the front element of a queue
Q.empty(); // tests if a queue is empty
````


## Example problems 



Using a queue to put values in front of a list after updating it.


````C++


````