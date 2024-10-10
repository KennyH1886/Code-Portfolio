Sure! Let's go step-by-step through the solution to the multilevel doubly linked list problem and break it down for understanding.

---

# Problem: Flatten a Multilevel Doubly Linked List

## Problem Breakdown

We are given a **multilevel doubly linked list** where:
- Each node contains a `val`, `next`, `prev`, and an additional `child` pointer.
- The `child` pointer may point to another doubly linked list (a "sublist").
- We need to **flatten** the multilevel linked list so that all nodes appear in a **single-level** doubly linked list.
  
The task is to:
1. Traverse the list, flattening the child nodes at every level.
2. Return the head of the newly flattened list.
3. Ensure that all `child` pointers in the flattened list are set to `null`.

## Example

### Example 1:
**Input**:
```
1---2---3---4---5---6--NULL
        |
        7---8---9---10--NULL
            |
            11--12--NULL
```

**Output**:
```
1---2---3---7---8---11---12---9---10---4---5---6---NULL
```

---

### Approach

To flatten this multilevel linked list, we need to use **depth-first search (DFS)** to handle any child pointers. We can either use a recursive or iterative approach. Here’s the plan using an **iterative approach with a stack**:

1. **Stack Usage**: 
   - We traverse the list from the head.
   - If we encounter a node with a `child` pointer, we push the `next` node onto the stack (because after processing the child list, we need to come back to the next node).
   - We then proceed to traverse the child list and link it to the main list.

2. **Step-by-Step Explanation**:
   - We need to link the `child` list to the current node (`curr`).
   - We need to ensure that `prev`, `next`, and `child` pointers are all set correctly.
   - When the child list is fully processed, we pop the stack to return to the next node.

### Solution (Code):

```python
class Node:
    def __init__(self, val, prev=None, next=None, child=None):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child

class Solution:
    def flatten(self, head: 'Node') -> 'Node':
        if not head:
            return head
        
        # Use a stack to keep track of the nodes
        stack = []
        current = head
        
        while current:
            # If the current node has a child
            if current.child:
                # If the current node has a next, push it to the stack (we'll return to it later)
                if current.next:
                    stack.append(current.next)
                
                # Connect current node to the child
                current.next = current.child
                if current.next:  # Set child's prev to current
                    current.next.prev = current
                
                # Set the child pointer to None, as it's been flattened
                current.child = None
            
            # If no next node and there's something in the stack, pop from stack
            if not current.next and stack:
                current.next = stack.pop()
                current.next.prev = current  # Set correct prev pointer
            
            # Move to the next node in the list
            current = current.next
        
        return head
```

---

### Step-by-Step Breakdown of Code:

1. **Initialization**:
   - We initialize an empty stack to store the nodes we might need to return to later (nodes after processing a child list).
   - We start at the head of the list, using `current` to traverse through the nodes.

2. **Traversal Loop**:
   - The loop continues until we’ve traversed all nodes in the multilevel doubly linked list.
   
3. **Handling Child Pointers**:
   - If the `current` node has a `child`, we handle this case:
     - If `current.next` exists (i.e., the node has a sibling), we push it onto the stack for later.
     - We then set `current.next` to point to the `child`, linking the `child` list to the main list.
     - We set the `prev` pointer of the child list’s head to `current`.
     - Finally, we set `current.child` to `None` because we are flattening the list.

4. **Returning to Siblings**:
   - If `current.next` is `None` (i.e., the end of the current sublist) and there are nodes in the stack, we pop a node from the stack.
   - We link this node as `current.next` and update the `prev` pointer.

5. **End of Loop**:
   - The loop continues, moving through each node until no more nodes are left to process.

6. **Return**:
   - Finally, we return the head of the flattened list.

---

### Detailed Example Walkthrough:

Let’s walk through the example:

**Input**:
```
1---2---3---4---5---6--NULL
        |
        7---8---9---10--NULL
            |
            11--12--NULL
```

1. **Step 1** (Start at node 1):
   - `current = 1`, `stack = []`.
   - No child, move to `2`.

2. **Step 2** (At node 2):
   - `current = 2`, `stack = []`.
   - No child, move to `3`.

3. **Step 3** (At node 3, has child):
   - `current = 3`, `stack = []`.
   - `current` has a child (7), so push `4` (which is `current.next`) to the stack.
   - Set `current.next` to `7` (the child), set `7.prev` to `3`, and set `current.child = None`.
   - Move to `7`.

4. **Step 4** (At node 7):
   - `current = 7`, `stack = [4]`.
   - No child, move to `8`.

5. **Step 5** (At node 8, has child):
   - `current = 8`, `stack = [4]`.
   - `current` has a child (11), so push `9` (which is `current.next`) to the stack.
   - Set `current.next` to `11` (the child), set `11.prev` to `8`, and set `current.child = None`.
   - Move to `11`.

6. **Step 6** (At node 11):
   - `current = 11`, `stack = [4, 9]`.
   - No child, move to `12`.

7. **Step 7** (At node 12):
   - `current = 12`, `stack = [4, 9]`.
   - No child, and `current.next` is `None`.
   - Pop `9` from the stack, set `current.next = 9`, set `9.prev = 12`.
   - Move to `9`.

8. **Step 8** (At node 9):
   - `current = 9`, `stack = [4]`.
   - No child, move to `10`.

9. **Step 9** (At node 10):
   - `current = 10`, `stack = [4]`.
   - No child, and `current.next` is `None`.
   - Pop `4` from the stack, set `current.next = 4`, set `4.prev = 10`.
   - Move to `4`.

10. **Step 10** (At node 4):
    - `current = 4`, `stack = []`.
    - No child, move to `5`.

11. **Step 11** (At node 5):
    - `current = 5`, `stack = []`.
    - No child, move to `6`.

12. **Step 12** (At node 6):
    - `current = 6`, `stack = []`.
    - No child, and `current.next` is `None`.

13. **End**: We are done, and the list is flattened.

**Output**:
```
1---2---3---7---8---11---12---9---10---4---5---6---NULL
```

---

### Complexity Analysis

- **Time Complexity**: O(n), where `n` is the total number of nodes in the multilevel doubly linked list. We traverse each node exactly once.
- **Space Complexity**: O(n) in the worst case due to the stack, where every node might have a child and need to be pushed onto the stack.

---

This explanation breaks down the iterative stack-based solution to flatten the multilevel doubly linked list with detailed examples and step-by-step reasoning.
