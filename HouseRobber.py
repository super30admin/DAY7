    
#money1 = max(maxmoney(nums, i-1, money), maxmoney(nums, i-2, money+nums[i]))
    
def rob(nums) -> int:
    array = [0] * (len(nums)+1)
    
    array[1] = nums[0]
    
    if len(nums) >= 2:
        for i in range(2, len(array)):
            array[i] = max(array[i-1], array[i-2]+nums[i-1])
    elif len(nums) == 1:
        return nums[0]
    
    return max(array[-1],array[-2])


nums = [2,7,9,3,1]
print(rob(nums))