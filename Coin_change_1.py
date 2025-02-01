# Time complexity: O(m x n)
# Space complexity: O(m x n)
import math
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[math.inf] * (amount+1) for i in range(len(coins)+1)]
        for j in range(1, len(coins)+1):
            dp[j][0] = 0
            for i in range(1, amount+1):
                if coins[j-1] > i:
                    dp[j][i] = dp[j-1][i]
                else:
                    dp[j][i] = min(dp[j-1][i], 1 + dp[j][i-coins[j-1]])
        return -1 if dp[-1][-1] == math.inf else dp[-1][-1]

# Reduced space
# Time complexity:O(m x n)
# Space complexity: O(m) m = amount
import math
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [math.inf] * (amount+1)
        for j in range(0, len(coins)):
            dp[0] = 0
            for i in range(1, amount+1):
                if coins[j] <= i:
                    dp[i] = min(dp[i], 1+dp[i-coins[j]])
        return -1 if dp[-1] == math.inf else dp[-1]



