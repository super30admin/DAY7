"""
TC: O(n) n: len(nums)
SP:O(n)  n: len(nums)
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [0] * (len(nums)+2)
        for i in range (2, len(nums)+2):
            dp[i] = max(dp[i-2]+nums[i-2], dp[i-1])
        return dp[-1]

        