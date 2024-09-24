# Time complexity: O(n)
# Space complexity: O(n)
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1: return nums[0]
        dp = [0]*n
        dp[0] = nums[0]
        dp[1] = max(dp[0], nums[1]+0)

        for i in range(2, n):
            dp[i] = max(dp[i-1], dp[i-2]+nums[i])
        return dp[n-1]