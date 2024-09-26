# Approach: We want to find the max sums at every iteration without the adjacent elements
# Base Cases:
# If length of nums is empty --> return 0
# If length is 1, that will be the maximum sum, we assign a new array and update its indices with the following
# Otherwise at every i, the max will be max(i, i-1, i-2 + i)
# Time Complexity: O(N)
# Space Complexity: O(N)
# Successfully ran on leetcode

def house_reobber(nums):
    if len(nums) == 0:
        return 0
    
    if len(nums) == 1:
        return nums[0]
    
    maxSum = nums[:]
    maxSum[1] = max(nums[0], nums[1])
    for i in range(2, len(nums)):
        maxSum[i] = max(maxSum[i-1], maxSum[i-2] + maxSum[i], maxSum[i])
        
    return maxSum[-1]



# Attempt after attending the class
# Recursion Method - Brute Force
# Time complexity: O(2^N)
# Space Complexity: O(N)

def houseRobber(houses):
    
    return helper(houses, 0, 0)


def helper(houses, max_val, index):
    
    # base case:  when all houses are visted, we use > since at times we step 2 times
    if index >= len(houses):
        return max_val
    
    # logic
    # not choose, if we dont choose, we can visit the adjacent node,hence index + 1
    skip = helper(houses, max_val, index + 1)
    
    # choose, we use index + 2 since we are skipping adjacent houses traversed
    take = helper(houses, max_val + houses[index], index + 2)
    
    return max(skip, take)
    
    
print(houseRobber([1,2,3,1]))


# Optimized Solution
# Time: O(N)
# Space: O(N) -- linear since we store only a 1d array


def rob(self, houses: List[int]) -> int:
        
    if not houses:
        return 0
    
    rows = len(houses)
    cols = 2
    dp = [[0] * cols for i in range(rows)]
    dp[0][1]  = houses[0] # fill the first base case when we just start and choose that 1st house

    for i in range(1, rows):
        # no choose case
        dp[i][0] = max(dp[i-1][0], dp[i-1][1])

        # choose

        dp[i][1] = dp[i-1][0] + houses[i]

    return max(dp[rows-1][0], dp[rows-1][1])
    
