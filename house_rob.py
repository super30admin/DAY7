class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums)==1:
            return nums[0]
        if not nums:
            return 0
        dp = nums
        dp[0]=nums[0]
        dp[1] = max(nums[0],nums[1])
        for i in range(2,len(nums)):
            dp[i] = max(nums[i-1],nums[i]+dp[i-2])
        
        print(dp)
        return dp[-1]
