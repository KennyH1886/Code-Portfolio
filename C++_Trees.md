# C++ Trees

- trees can have as many branches as you want.
- each branch is a child under the immediate parent or root
- multiple children nodes are siblings
- each tree has a root
- define empty tree
- define single node tree
- children can not have an overlapping node. its a graph not a tree
- all branches are independent
- a linked list can be considered a tree
- recursive intensive

# Binary Search Tree

### Tree with at most two children is binary tree

![binary search tree](/Topics/bs_tree.png) 

- Not a linear structure
- Hierarchical
###  Root
Top most node
### Child
node under parent

E.g. k is child of j
- Parent
E.g. f is parent of h
- Height
2 in this case
- Level
- Depth
- Path

### leaf 
has no children


### 3 nodes
- left(first child),val,right (second child)

more complicate dot add nodes to tree



# Applications of Trees

#### Data structure for fast search
- Binary search tree
- B-Tree, 
- AVL tree, …
#### Manipulate Hierarchical Data
- File system

- Parsing, Expression Tree

# Properties of Binary Trees

### Maximum number of nodes in level L is 2L
Level 0: 1, Level 1: 2, Level 2: 4, …
### Maximum number of nodes in binary tree of height H is:
2H+1-1
### In a binary tree with N nodes
What is the maximum height?
What is the minimum height?

- Number of edges = Number of nodes - 1


# Types of Binary Trees: Full Binary Tree

Full Binary Tree: Every node either have 2 children or no child.
![full binary tree pic](/Topics/full_binary.png) 



# Types of Binary Trees: Complete Binary Tree

Every level is completely filled excepted for the last level is fill from left to right

Perfect Binary Tree is Complete Binary Tree with last level filled

![complete binary tree pic](/Topics/complete_binary.png) 

## Balanced Binary Tree
Height of Left and Right child of any node differ at most by one

## Degenerate Binary Tree
Each node has at most one child
Linked List?



# How to Store Binary Tree in Computer

### Node and Pointers
- Similar to Linked List
- Use dynamic allocation
- Data, Left Child, Right Child
### Arrays
- More efficient that previous approach
- Only works for Complete Binary Tree
- Binary heap (will learn later) use array




# Exercises


```c++
class treenode{
    int val;
    treenode left;
    treenode right;
}


```




# Tree Traversal

### Breadth First 
- Print All Nodes Level by Level
### Inorder
- Left, Root, Right
### Preorder
- Root, Left, Right
### Postorder
- Left, Right, Root
