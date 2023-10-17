#include <iostream>
#include <vector>
#include <string>
#include <stack>
#include <queue>

using namespace std;

// Given a string s consists of symbols: (, ), [, ], {, },
// Return true if the string is balanced, return false otherwise
// Example 1:
//   Input: ())
//   Return: false
// Example 2:
//   Input: ([]{})
//   Return: true
// Example 3:
//   Input: ][
//   Return: false
bool balanced(string s) {
    stack<char> stacker;

    for (int i = 0; i < s.length(); i++) {
        if (s[i] == '(' || s[i] == '[' || s[i] == '{') {
            stacker.push(s[i]);
        } else if (s[i] == ')' || s[i] == ']' || s[i] == '}') {
            if (stacker.empty()) {
                return false; // Unmatched closing symbol
            }

            char topSymbol = stacker.top();
            if ((s[i] == ')' && topSymbol == '(') ||
                (s[i] == ']' && topSymbol == '[') ||
                (s[i] == '}' && topSymbol == '{')) {
                stacker.pop();
            } else {
                return false; // Unmatched closing symbol
            }
        }
    }

    return stacker.empty(); // Check for unmatched opening symbols
}








// Give a vector of string tokens, evaluate the postfix expression
// Example 1:
//   Input: { "10", "3", "-" }
//   Return: 7
// Example 2:
//   Input: { "10", "2", "3", "+", "*"}
//   Return: 50
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



int main() {

    string  tests[] = {"{}{}{}","[][][[[]]]","{}()[]","{{{}}})))", "{{{{{}}}}}}}}}}))))))(((())))))))"}; 
    // Calculate the number of elements in the array
    int numTests = sizeof(tests) / sizeof(tests[0]);

  for(int i = 0 ; i <  numTests; i++){
    if (balanced(tests[i])) {
       cout << "Test " << i + 1 << ": The string is balanced." << endl;
        } else {
            cout << "Test " << i + 1 << ": The string is not balanced." << endl;
        }
  }

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







  return 0;
}