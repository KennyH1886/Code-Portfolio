def two_sum(nums, target):
    # create a hash map to store the index of each number 
    num_map ={}
    
    
    # loop through the array
    for i, num in enumerate(nums):
        # calculating the compliment we need to reach the target
        compliment = target - num
        
        # if the compliment exists in the hash map return the indices
        if compliment in num_map:
            return [num_map[compliment],i]
            
        # otherwise, store the current number and index in the hash map
        num_map[num] = i
        
    # if no solution is found return none 
    return None
    
    
nums = [2,7,11,15]
target = 9
print (two_sum(nums,target))


# 0(1 time complexity )