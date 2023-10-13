# Stack and Queues Notes

# Stack 

- Linear Data Structure

- LIFO or FILO
- Last In First Out or First In -Last Out
- Applications
- Undo/Redo
- Depth first search
- Backtracking
- Sudoku solver, 8-queen, …
- Function Call stack
- Implementing Recursion

![stack pic](/Topics/Stack_Example.png)


## Important Operations on Stack
- Push
```C++






```











- Pop
```C++






```
- Top(peek)
```C++






```
- isEmpty
```C++






```




## Implementation

Linked List
- Advantage? 
Disadvantage?

- Array / Vector
Advantage?
Disadvantage?




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

## Operations on Queue

- Enqueue


```C++






```
- Insert to the end of queue
O(1)


```C++






```
- Dequeue


```C++






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


````C++


````