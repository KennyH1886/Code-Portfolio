def merge_sort(arr):
    # Base case: If the array has 1 or 0 elements, it's already sorted
    if len(arr) <= 1:
        return arr

    # Step 1: Split the array into two halves
    mid = len(arr) // 2
    left = arr[:mid]
    right = arr[mid:]

    # Step 2: Recursively sort both halves
    left = merge_sort(left)
    right = merge_sort(right)

    # Step 3: Merge the sorted halves
    return merge(left, right)

def merge(left, right):
    sorted_arr = []
    i = j = 0

    # Compare elements from both lists and merge them in sorted order
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            sorted_arr.append(left[i])
            i += 1
        else:
            sorted_arr.append(right[j])
            j += 1

    # If there are remaining elements in either list, add them to the result
    sorted_arr.extend(left[i:])
    sorted_arr.extend(right[j:])
    
    return sorted_arr

# Example usage:
nums = [5, 2, 3, 1]
sorted_nums = merge_sort(nums)
print(sorted_nums)  # Output: [1, 2, 3, 5]

