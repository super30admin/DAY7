# Time Complexity : O(n) - n is len(nums)
# Space Complexity : O(n) - n is len(nums)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Maintain a dp array to store the max value that can be robbed at every index
Then for any give index we can do, max(prev, current value + result of prev_prev)
"""

def rob(nums):
    #     memo = []
    #     n = len(nums)
    #     self.memo = [-1]*n
    #     return self.helper(nums,0)

    # def helper(self, nums, i):
    #     if i >= len(nums):
    #         return 0
    #     if self.memo[i] != -1:
    #         return self.memo[i]
    #     else:
    #         maxAmount = max(nums[i] + self.helper(nums, i + 2), self.helper(nums, i + 1))
    #         self.memo[i] = maxAmount
    #         return maxAmount

    if len(nums) == 1:
        return nums[0]
    n = len(nums)
    dp = [0] * n

    dp[0] = nums[0]
    dp[1] = max(dp[0], nums[1] + 0)

    for i in range(2, n):
        dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])

    return dp[n - 1]




