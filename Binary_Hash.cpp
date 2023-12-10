#include <iostream>
#include <map>
#include <string>


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



// Given a binary search r s in r that have value greater
// than k.
// Example 1:
// Input: k=5
//    r:   5
//        / \
//       1   9
// Return: 1
// Explanation: 9 is the only node greater than 5. So return 1.

int count_greater(tree_node *r, int k) {
  // null base case
  if (r == NULL) {
    return 0;
  }
  // counter to hold value of integer over k
  int counter = 0;

  if (k < r->val) {
    counter = 1 + count_greater(r->left, k) + count_greater(r->right, k);
  }

  else return counter = count_greater(r->left, k) + count_greater(r->right, k); // returns final amount larger than k.
}

// return the number of node



// Given a binary search r with all positive integer values
// and k, return the value of the node that has the closest
// value to k. If there is tie, return the larger
// one of the tie.
// Example 1:
// Input: k=3
//    r:   5
//        / \
//       1   9
// Return: 5
// Explanation: 5 and 1 are equally close to 3, so return the
// larger one of the 5 and 1, which is 5.
// Example 2:
// Input: k=9
//    r:   5
//        / \
//       1   9
// Return: 9
// Explanation: 9 in the tree is the cloest to 9. So return 9
// REQUIREMENT: The complexity of your code should be O(h)
// (h is the height of the tree)
int closest(tree_node *r, int k) {
  // Your code here
  if (r == NULL) {
    return INT_MAX; // Return a large val if the tree is empty
  }

  // Initialize closest to a dummy node with INT_MAX val
  tree_node *closest = new tree_node(INT_MAX);

  while (r != NULL) {
    // Update closest if the current node is closer to k
    if (abs(r->val - k) < abs(closest->val - k) ||
        (abs(r->val - k) == abs(closest->val - k) && r->val > closest->val)) {
      closest = r;
    }

    // Move to the left or right subtree based on the comparison with k
    if (k < r->val) {
      r = r->left;
    } else if (k > r->val) {
      r = r->right;
    } else {
      break; // Found an exact match, no need to search further
    }
  }

  // Return the val of the closest node
  return closest->val;
}

int MaxSize = 1024;





int main(){

  
 const int  n = 4;
string words[4] = {"hello", "world", "hello", "abc"};

map<string,int> M;
int i;
for(i=0; i <n, i++;){
if (M.find(words[i])== M.end()) {
M[words[i]]++;
} else {// not found 
    M[words[i]] = 1;
}
}
map<string,int>::iterator it;
for (it=M.begin(); it!=M.end();it++){
cout << it->first << ":" << it->second << '\n';
}

return 0;
} 




