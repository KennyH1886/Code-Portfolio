#include <iostream>
#include <vector>
#include <string>
#include <stack>
#include <queue>

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



int evaluate(const vector<string> &tokens) {
    stack<int> s;

    for (const string &token : tokens) {
        if (isdigit(token[0]) || (token.size() > 1 && isdigit(token[1]))) {
            // If the token is a number, push it onto the stack
            s.push(stoi(token));
        } else {
            // If the token is an operator, pop the top two operands, apply the operator, and push the result back
            int operand2 = s.top();
            s.pop();
            int operand1 = s.top();
            s.pop();

            if (token == "+") {
                s.push(operand1 + operand2);
            } else if (token == "-") {
                s.push(operand1 - operand2);
            } else if (token == "*") {
                s.push(operand1 * operand2);
            } else if (token == "/") {
                s.push(operand1 / operand2);
            }
            // Note: This is a simple example and does not handle division by zero or other error cases
        }
    }

    // The final result should be on the top of the stack
    return s.top();
}

// Given the root of tree r, the level (or depth) l, return a string that includes all values of nodes in the tree at level l from left to right and seperated by a single space
// Example: 
// Input:  1
//        / \
//       2   3
//   l=1
// Return: "2 3"
// Note: There should be only one space between numbers
string print_level(tree_node *r, int l) {
if (!r) return ""; // base null case

if(l == 0 ) return to_string(r->val) + " "; 
string left_level = print_level(r->left, l-1);
string right_level = print_level(r->right, l-1);

return left_level + right_level;
}


// Given the root of tree r, return the depth of the shallowest leaf
// Example:
// Input:  1
//        / \
//       2   3
//      /
//     4
// Return: 1
// (3 is the shallowest leaf, the depth which is 1)

int shallowest_leaf_recursive(tree_node *node) {
    if (!node) {
        return 0;  // null node base case
    }

    if (!node->left && !node->right) {
        return 1; //  leaf node base case , returning 1
    }

    // Recursive cases for left and right subtrees
    int leftDepth = shallowest_leaf_recursive(node->left);
    int rightDepth = shallowest_leaf_recursive(node->right);

    // Return the min depth among the left and right subtrees, plus 1 for the current node
    return 1 + min(leftDepth, rightDepth);
}

int shallowest_leaf(tree_node *r) {
    // Call the recursive function starting from the root
    return shallowest_leaf_recursive(r) - 1; // Subtract 1 to account for the root node only
}

































int main() {
    // Example 1
    vector<string> expr1 = {"10", "3", "-"};
    cout << "Example 1 Result: " << evaluate(expr1) << endl;

    // Example 2
    vector<string> expr2 = {"10", "2", "3", "+", "*"};
    cout << "Example 2 Result: " << evaluate(expr2) << endl;

   // Example 3
    vector<string> expr3 = {"0", "10", "20","-"};
    cout << "Example 3 Result: " << evaluate(expr3) << endl;

  // Example 4
    vector<string> expr4 = {"0", "1", "2","3","+","*"};
    cout << "Example 3 Result: " << evaluate(expr4) << endl;

  // Test Case 1
    // Input:
    //         1
    //        / \
    //       2   3
    //      / \
    //     4   5
    // Level 1
    // Expected Output: "1"
    tree_node* root1 = new tree_node(1);
    root1->left = new tree_node(2);
    root1->right = new tree_node(3);
    root1->left->left = new tree_node(4);
    root1->left->right = new tree_node(5);
    cout << "Test Case 1: " << print_level(root1, 1) << endl;



    // Test Case 2
    // Input:
    //         1
    //        / \
    //       2   3
    //      / \
    //     4   5
    // Level 2
    // Expected Output: "2 3"
    cout << "Test Case 2: " << print_level(root1, 2) << endl;

    // Test Case 3
    // Input:
    //         1
    //        / \
    //       2   3
    //      / \
    //     4   5
    // Level 3
    // Expected Output: "4 5"
    cout << "Test Case 3: " << print_level(root1, 2) << endl;

   // Test Case 1
    tree_node* root4 = new tree_node(1);
    root4->left = new tree_node(2);
    root4->right = new tree_node(3);
    root4->left->left = new tree_node(4);
    cout << "Test Case 1: " << shallowest_leaf(root4) << endl;

    // Test Case 2
    tree_node* root2 = new tree_node(10);
    root2->left = new tree_node(5);
    root2->right = new tree_node(15);
    root2->left->left = new tree_node(3);
    root2->left->right = new tree_node(7);
    root2->right->right = new tree_node(18);
    cout << "Test Case 2: " << shallowest_leaf(root2) << endl;

    // Test Case 3
    tree_node* root3 = new tree_node(5);
    cout << "Test Case 3: " << shallowest_leaf(root3) << endl;

    // Test Case 4
    cout << "Test Case 4: " << shallowest_leaf(nullptr) << endl;




    return 0;
}
