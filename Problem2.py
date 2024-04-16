## Problem2 (https://leetcode.com/problems/house-robber/)

# Approach
# create a 1D array and initialize the 0th index with value at 0th index in nums. For 1st index, check the max between oth and 1st index in nums
# For every index from 2 onwards, check if the value is max at the previous index or if it is max if current value is added to 2 index prior. 
# Above condition is important as 2 adjacent houses cannot be robbed. Everytime select the max and return the value at the last index

# Time Complexity: O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No



class Solution:
    def rob(self, nums: List[int]) -> int:

        if nums is None or len(nums) == 0:
            return 0

        if len(nums) == 1:
            return nums[0]

        
        dp = [0 for i in range(len(nums))]

        dp[0] = nums[0]
        dp[1] = max(nums[0],nums[1])

        for i in range(2,len(nums)):
            dp[i] = max(dp[i-1],nums[i]+dp[i-2])

        return dp[-1]