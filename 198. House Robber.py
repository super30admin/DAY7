# Time complexity : O (n)
# Space complexity : O (n)

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        # if no houses to rob, return 0
        if len(nums) == 0:
            return 0
        # initialize dp array of size of nums ( aka number of houses + 1)
        dp = [int] * (len(nums) + 1)
        
        # configure base cases.
        dp[0] = 0

        # first house we rob from nums is set to dp index 1
        dp[1] = nums[0]

        # calculate max money we can rob for the next index
        for i in range(1, len(nums)):
            dp[i+1] = max(dp[i], dp[i-1] + nums[i] )

        return dp[len(nums)]
        
