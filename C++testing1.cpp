#include <iostream>
#include <vector>
#include <string>
#include <stack>
#include <queue>

using namespace std;




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
