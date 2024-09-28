from typing import List
"""
The exhaustive solution: Generate a recursive tree and explore all the paths by choosing and not choosing the houses.
Time complexity: O(2^n) and space complexity: O(n)
The above approach runs in exponential time, so need to optimize it.
DP approach: Since the sub problems are repeating in the exhaustive solution for example, the sub problem [1,2,3] 
includes sub problem [1,2], so the solution of [1,2] could be saved to solve [1,2,3].
Time complexity: O(n) and space complexity: O(n)
# todo: can be further optimized to one variable 
"""

class Solution:
    def dp_sol(self, nums):
        # Since the number of parameters given is 1 (nums array), we will use 1D array to save the solution to
        # sub problems.
        cols = len(nums) + 1
        dp = [0 for _ in range(cols)]
        dp[1] = nums[0]
        for i in range(2, cols):
            dp[i] = max(dp[i - 1], nums[i - 1] + dp[i - 2])
        return dp[cols - 1]

    def exhaustive_sol(self, nums, idx, amount):
        # base case
        if idx >= len(nums):
            return amount
        # not choose logic
        not_choose = self.exhaustive_sol(nums, idx + 1, amount)

        # choose logic
        choose = self.exhaustive_sol(nums, idx + 2, amount + nums[idx])

        return max(not_choose, choose)

    def rob(self, nums: List[int]) -> int:
        return self.exhaustive_sol(nums, 0, 0)


obj = Solution()
ans = obj.rob([1, 2, 3, 1])
print(ans)
