#include <iostream>
#include <queue>
#include <stack>
using namespace std;
class tree_node { 
public:
    int val;
    tree_node* left;
    tree_node* right;
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
int sum(tree_node* r) {
    if (r == NULL) return 0;
// works for no node
// works for single node r val
// works for 2 values 
return sum(r->left) + sum(r->right) + r->val;

}



// you can change the order by moving the left and right resursive call, pre & post order etc..

// prints value for root left and right nodes post order
void post_traversal(tree_node* r){
if (r == NULL) return;


post_traversal(r->left); 
post_traversal(r->right); 
cout << r->val <<" ";


}


// prints value for root left and right nodes in order
void in_traversal(tree_node* r){
if (r == NULL) return;


in_traversal(r->left); 
cout << r->val <<" ";
in_traversal(r->right);


}

// prints value for root left and right nodes pre ordered
void pre_traversal(tree_node* r){
if (r == NULL) return;

cout << r->val <<" ";
pre_traversal(r->left); 
pre_traversal(r->right);


}

tree_node* insert(tree_node* r, int k){
if (r == NULL) return new tree_node(k);  // base null case

if (r->val < k)  r-> right =  insert(r->right,k);  // if is node is less than, insert node to the right 

else if (r->val > k)  r->left =  insert(r->left,k); // if node is greater than , return it to the left.
// returns root a fter insertion
return r;  // returns base root 
    
}
// searches value in search tree, best case O(1) , worst case O(h)
bool search(tree_node* r, int k){
if (r == NULL) return false;  // base null case
if (r->val < k)   return search(r->right,k); 
else if (r->val > k)  return search(r->left,k);
else return true;  // returns base root  
}

// level order traversal














int main(){
tree_node* r = new tree_node(10); // root 
r->left = new tree_node(11);   // left child
r->right = new tree_node(7);   // right child

// child node for 7 
r->right->left = new tree_node(30);

cout << count(r) << '\n'; // returns number of nodes
cout << leaves(r) << '\n';   // 11,30 are leaves with no children , should return 2
cout << sum(r) << '\n'; 
 pre_traversal(r);  // pre ordered tree {root , right, left}
 cout << "pre traversal"<< '\n'; 
 post_traversal(r); // post ordered tree {left,right,root}
  cout << "post traversal"<< '\n'; 
 in_traversal(r);   // in order tree  {left,root,right}
cout << "in traversal"<< '\n'; 
tree_node* root = NULL;
 root = insert(root,1);   // insert node made with recursion
 root =  insert(root,5);
 root = insert(root,3);
 root = insert(root,2);
 root =  insert(root,10);
 in_traversal(root);  // proof it is in the correct order
cout << "insert test"<< '\n'; 
cout << search(root,1) << '\n';
cout << search(root,11) << '\n';
cout << "search test"<< '\n'; 
cout << "tree hieght"<< '\n'; 
return 0;

}