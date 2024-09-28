class Solution:
    def rob(self, nums: List[int]) -> int:
        
        m = len(nums)
        
        if m == 0:
            return 0
        if m == 1:
            return nums[0]
        dp = [0] * m
        dp[0] = nums[0]    
        dp[1] = max(nums[1],nums[0])
        
        for i in range(2,m):
            dp[i] = max(nums[i] + dp[i-2], dp[i-1])
        
        
        return dp[m-1]