# The approach uses dynamic programming with O(n) time complexity, where n is the length of nums.  
# A 2D DP table tracks the maximum profit with two states: robbing or skipping the current house.  
# It computes the optimal solution by updating states iteratively and returns the maximum profit.  
class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        
        n = len(nums)
        dp = [[0 for i in range(2)] for j in range(n)]
        
        dp[0][0] = 0
        dp[0][1] = nums[0]
        
        for i in range(1, n):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            dp[i][1] = nums[i] + dp[i-1][0]
        
        return max(dp[n-1][0], dp[n-1][1])
