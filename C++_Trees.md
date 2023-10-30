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


# binary tree code Examples

````c++
#include <iostream>
#include <queue>
#include <stack>
using namespace std;

public:
    int val;
    tree_node *left;
    tree_node *right;
public:
tree_node(int v,tree_node* l=NULL, tree_node* r=NULL) {
    val = v;
    left = l;
    right = r;
}
};

// returns the number of nodes in tree r.
int count(tree_node* r){

// if (r->left == NULL && r->right == NULL){
//     return 1;  // one node left. 
// }
if(r == NULL){
    return 0;  // empty tree
}
return count(r->left)+ count(r->right)+1; // counts nodes on each side untill it can't , then adds root variable
}

// counts the numeber of leaves.
int leaves(tree_node* r){
    if (r==NULL) return 0; // empty tree
if(r->left ==NULL && r->right == NULL) return 1;//single root tree

    return leaves(r->left)+leaves(r->right);

}


// sum of all nodes
int sum(tree*node r) {
    if (r== NULL) return 0;
// works for no node
// works for single node r val
// works for 2 values 
return sum(r->left) + sum(r->right) + r->val;

}



// you can change the order by moving the left and right resursive call, pre & post order etc..

// prints value for root left and right nodes post order
void post_traversal(tree*node r){
if (r == NULL) return;


post_traversal(r->left); 
post_traversal(r->right); 
cout << r->val <<" ";


}


// prints value for root left and right nodes in order
void in_traversal(tree*node r){
if (r == NULL) return;


in_traversal(r->left); 
cout << r->val <<" ";
in_traversal(r->right);


}

// prints value for root left and right nodes pre ordered
void pre_traversal(tree*node r){
if (r == NULL) return;

cout << r->val <<" ";
pre_traversal(r->left); 
pre_traversal(r->right);


}

// level order binary search incorporating queue
void level_traversal(tree_node* r) {
if (r==NULL) return;
queue<tree_node*> Q;
Q.push(r);
while(!Q.empty()){
    tree_node* p = Q.front();
    cout << p->val << "" ;  // middle
    Q.pop(); 
    if (p->left)  Q.push(p->left);  // left node
      if (p->right)  Q.push(p->right);  // right node 
}

// level order binary search incorporating queue
void preorder_traversal2(tree_node* r) {
if (r==NULL) return;
stack<tree_node*> S;
S.push(r);
while(!S.empty()){
    tree_node* p = S.top();
    cout << p->val << "" ;  // middle
    S.pop(); 
    if (p->left)  S.push(p->left);  // left node
      if (p->right)  S.push(p->right);  // right node 
}


// level order binary search incorporating queue
void inorder_traversal2(tree_node* r) {
if (r==NULL) return;
stack<tree_node*> S;
S.push(r);
while(!S.empty()){
    tree_node* p = S.top();
    S.pop(); 
        cout << p->val << "" ;   
    if (p->left)  S.push(p->left);  // left node
      if (p->right)  S.push(p->right);  // right node 
}



}


int main(){
tree_node* r = new tree_node(10); // root 
r->left = new tree_node(11);   // left child
r->right = new tree_node(7);   // right child

// child node for 7 
r->right->left = new tree_node(30);

// child nodes for 11
r->left->right = new tree_node(8);

r->left->left = new tree_node(5);

cout << count(r) << '\n'; // returns number of nodes
cout << leaves(r) << '\n';   // 11,30 are leaves with no children , should return 2
cout << sum(r) << '\n'; 
pre_traversal(r);  // pre ordered tree {root , right, left}
post_traversal(r); // post ordered tree {left,right,root}
in_traversal(r);  // in order tree  {left,root,right}
level_traversal(r);// level order traversal using queue
preorder_traversal2(r);// preorder level traversal using stack
inorder_traversal2(r);// in order level traversal using stack
return 0;


}


````

# Binary Search trees

### Hieght of a tree 

each level is equal to the hieght. 
ex. level 3 tree has a hieght of 3. dont count the root as a level. 

### perfect tree: 

all levels must be filled , also a complete tree but not vice versa 

h | level \
0 | 1 \
1 | 3 \
2 | 7 \
3 | 15 \
4| 31 \
5 | 63 \
6 | (63 + 64 )127 \
7 | 250 \
h | 2^h+1 - 1

h = 20 -> 2^21 - 1 = 2 million+ !!! 
uses 20 steps at most to find within 2 million nodes


n = 5 \
min h = 2 \
max h = 4

n = 100 \
max h = 99 \
min h = 6

n = 1000000 19n 10^6- 1



log base2(n+1) 



### complete tree

A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes at the last level h.

filled from left to right on last level 


### Full tree 
A full binary tree is also known as 2-tree in which every node other than the leaf nodes has two child nodes. It means all the leaf nodes should be at the same level and all other internal nodes should contain two child nodes each.

- expression tree are always a full tree


 ## binary search tree

 important parameters are hieght and level


left values are less than the right of the root

designed for searching 


1 node can be a binary search tree

2 nodes are also a tree

### applications 
- searching for a particular node value
- using its rule to shorten search times. 
- no more than h + 1 steps involved  worst case: O(h)
- better case than array search 


binary trees on test not search tree , no code for it on test \

insert,search, delete, O(h)