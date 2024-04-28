#T.C. O(m*n)
#S.C. O(n)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0

        for i in range(1, amount + 1):
            for j in range(0, len(coins)):
                if i >= coins[j]:
                    dp[i] = min(dp[i], 1 + dp[i-coins[j]])
        if dp[amount] < amount + 1:
            return dp[amount]
            
        else:
            return -1
