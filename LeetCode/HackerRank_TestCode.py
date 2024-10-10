# Function to reverse the array using slicing (for testing)
def reverseArray(a):
    print("Reversing array for testing:\n")
    return a[::-1]

# Function to calculate the maximum hourglass sum in a 6x6 array
def hourglassSum(arr):
    max_sum = -float('inf')  # Initialize to a very small number to account for negative sums
    
    # Loop through all valid top-left corners of hourglasses
    for i in range(4):
        for j in range(4):
            # Calculate the sum of the current hourglass
            top = arr[i][j] + arr[i][j+1] + arr[i][j+2]
            middle = arr[i+1][j+1]
            bottom = arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]
            hourglass_sum = top + middle + bottom
            
            # Update max_sum if the current hourglass_sum is larger
            if hourglass_sum > max_sum:
                max_sum = hourglass_sum
    
    return max_sum

# Main block to test the hourglassSum function with hardcoded data
if __name__ == "__main__":
    # Reverse array test with hardcoded data
    arr = [1, 2, 3, 4, 5]
    print("Original array:", arr)
    reversed_arr = reverseArray(arr)
    print("Reversed array:", reversed_arr)
    
    # Hardcoded 6x6 matrix for hourglass sum testing
    test_matrix = [
        [1, 1, 1, 0, 0, 0],
        [0, 1, 0, 0, 0, 0],
        [1, 1, 1, 0, 0, 0],
        [0, 0, 2, 4, 4, 0],
        [0, 0, 0, 2, 0, 0],
        [0, 0, 1, 2, 4, 0]
    ]
    
    # Print the matrix
    print("6x6 Matrix:")
    for row in test_matrix:
        print(row)

    # Call the hourglassSum function and print the result
    result = hourglassSum(test_matrix)
    print("Maximum hourglass sum:", result)
