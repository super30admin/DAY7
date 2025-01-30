# Problem21: (https://leetcode.com/problems/house-robber/)

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach


class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums) 
        if n == 0:
            return 0
        dp = [0 for _ in range(n+1)] # DP list of length n+1
        dp[1] = nums[0] # assign dp[1] as nums[0]
        for i in range(1,n): # for a loop from 1 to n
            val = nums[i]
            dp[i+1] = max(dp[i], (dp[i-1] + val)) # for the next entry either take the current value or 
            # take the previous entry + curr value
        
        return dp[n]
        