# Time complexity -
# Space complexity -

# Approach 1 - Recursive (Exhaustive)


# Approach 2 - DP
from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)

        # dp = [[0] * 2] * (n) # This doesn't work because it repeats list reference in memory
        # i.e. modifying one element in any row will affect all rows
        dp = [[0 for i in range(2)] for j in range(n)]

        dp[0][1] = nums[0]

        for i in range(1, n):
            dp[i][0] = max(dp[i-1][1], dp[i-1][0])
            dp[i][1] = nums[i] + dp[i-1][0]
        
        return max(dp[n-1][0], dp[n-1][1])

# Approach 3 - Temp variables
