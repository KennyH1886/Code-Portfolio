# prompt 
Given a  2D Array, :

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
An hourglass in  is a subset of values with indices falling in this pattern in 's graphical representation:

a b c
  d
e f g
There are  hourglasses in . An hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum. The array will always be .

Example


-9 -9 -9  1 1 1 
 0 -9  0  4 3 2
-9 -9 -9  1 2 3
 0  0  8  6 6 0
 0  0  0 -2 0 0
 0  0  1  2 4 0
The  hourglass sums are:

-63, -34, -9, 12, 
-10,   0, 28, 23, 
-27, -11, -2, 10, 
  9,  17, 25, 18
The highest hourglass sum is  from the hourglass beginning at row , column :

0 4 3
  1
8 6 6
Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.

Function Description

Complete the function hourglassSum in the editor below.

hourglassSum has the following parameter(s):

int arr[6][6]: an array of integers
Returns

int: the maximum hourglass sum
Input Format

Each of the  lines of inputs  contains  space-separated integers .

Constraints

Output Format

Print the largest (maximum) hourglass sum found in .

Sample Input

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
Sample Output

19
Explanation

 contains the following hourglasses:

image

The hourglass with the maximum sum () is:

2 4 4
  2
1 2 4


Answer: 

### **Understanding the Question:**

We are given a **6x6 matrix (2D array)** of integers, and we need to find the maximum sum of specific patterns in this matrix known as **hourglasses**.

#### **What is an Hourglass in a Matrix?**

An hourglass in a matrix looks like this:

```
a b c
  d
e f g
```

This means an hourglass includes 7 values from the matrix arranged in the form of 3 values at the top, 1 in the middle, and 3 at the bottom.

For example, in a 6x6 matrix, one possible hourglass could start at position `(0,0)`:

```
1 1 1     <- top row
  1       <- middle element
1 1 1     <- bottom row
```

The sum of this hourglass would be the sum of these 7 elements:
```
1 + 1 + 1 + 1 + 1 + 1 + 1 = 7
```

#### **Problem Breakdown:**

- We are asked to find **all possible hourglasses** in the 6x6 matrix.
- For each hourglass, we need to calculate the **sum** of the 7 values.
- Finally, we need to **return the maximum** hourglass sum.

Since the matrix is fixed at **6x6**, the top-left corner of an hourglass can only be placed within certain bounds. Specifically, the top-left corner can be placed anywhere from row 0 to row 3 and column 0 to column 3, because an hourglass takes up 3 rows and 3 columns.

Thus, there are **16 possible hourglasses** in the 6x6 matrix:
- 4 possibilities in the first 4 rows (since the hourglass takes up 3 rows).
- 4 possibilities in the first 4 columns (since the hourglass takes up 3 columns).
- In total: 4 rows × 4 columns = 16 possible hourglasses.

#### **Goal:**
We need to calculate the sum of each hourglass and then find the **maximum** of these sums.

---

### **Solution Breakdown:**

1. **Iterate over the possible top-left corners** of each hourglass in the 6x6 matrix. The top-left corner can range from index `(0,0)` to `(3,3)` because each hourglass is 3x3 in size.

2. For each hourglass, **calculate the sum** of its 7 elements using this formula:

   ```
   arr[i][j]   + arr[i][j+1]   + arr[i][j+2]   (top row)
                arr[i+1][j+1]                   (middle element)
   arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2] (bottom row)
   ```

3. Keep track of the **maximum sum** encountered as we calculate the sum for each hourglass.

4. **Return the maximum sum** after processing all possible hourglasses.

---

### **In-Depth Explanation of the Code:**

```python
#!/bin/python3

import os

def hourglassSum(arr):
    # Initialize to a very small number because we might have negative numbers in the matrix.
    max_sum = -float('inf')  # -infinity ensures that the first comparison will replace this with any valid sum.
    
    # Loop through all valid starting points of an hourglass in the 6x6 matrix.
    for i in range(4):  # Loop through rows 0 to 3
        for j in range(4):  # Loop through columns 0 to 3
            # Calculate the sum of the current hourglass
            top = arr[i][j] + arr[i][j+1] + arr[i][j+2]
            middle = arr[i+1][j+1]
            bottom = arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]
            
            hourglass_sum = top + middle + bottom  # The total sum of the hourglass
            
            # Update max_sum if the current hourglass sum is greater
            if hourglass_sum > max_sum:
                max_sum = hourglass_sum
    
    return max_sum  # Return the maximum hourglass sum

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr = []

    # Read the 6x6 matrix from input
    for _ in range(6):
        arr.append(list(map(int, input().rstrip().split())))

    result = hourglassSum(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
```

---

### **Detailed Walkthrough of the Code:**

1. **Initialize `max_sum`:**
   We initialize `max_sum` to `-float('inf')` (negative infinity). This ensures that any hourglass sum we calculate will be larger than this initial value, so we can update `max_sum` accordingly.

2. **Iterate Over the Matrix:**
   We loop through all possible top-left corners of the hourglasses. Since the matrix is 6x6, the valid indices for the top-left corner are from `(0,0)` to `(3,3)`.

   This is why the loop iterates from `i = 0 to 3` and `j = 0 to 3`. These loops allow us to check all the hourglasses in the matrix.

3. **Calculate the Hourglass Sum:**
   For each valid top-left corner `(i, j)`, we calculate the sum of the current hourglass using:
   - **Top row:** `arr[i][j] + arr[i][j+1] + arr[i][j+2]`
   - **Middle element:** `arr[i+1][j+1]`
   - **Bottom row:** `arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]`
   
   We then sum these values to get the total hourglass sum.

4. **Update Maximum Hourglass Sum:**
   We compare the current hourglass sum with `max_sum`. If the current sum is larger, we update `max_sum`.

5. **Return the Maximum Hourglass Sum:**
   After checking all 16 possible hourglasses, we return the `max_sum`, which now holds the maximum hourglass sum found.

---

### **Example:**

Let's break down the example given in the problem:

#### Input Matrix:
```
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
```

#### All Hourglass Sums:
```
7, 4, 2, 0
4, 8, 10, 8
3, 8, 12, 10
2, 7, 9, 7
```

The maximum hourglass sum is **19**.

#### Hourglass Producing Maximum Sum:
```
2 4 4
  2
1 2 4
```

Thus, the maximum hourglass sum is **19**.

---

### **Time Complexity:**
- The time complexity of this solution is **O(1)** because the matrix size is fixed at 6x6. Even though we're looping through parts of the matrix, we always process a fixed amount of data, so the time complexity does not depend on the size of the input.

