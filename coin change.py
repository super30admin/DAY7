# TC: O(m*n), m is the len(coins) and n is the amount
# SC: O(m*n)
# This code successfully ran in LC

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        rows = len(coins) + 1
        cols = amount + 1
        dp = [[0 for _ in range(cols)] for _ in range(rows)]
        for i in range(1, cols):
            dp[0][i] = amount + 1
        
        for i in range(1, rows):
            for j in range(cols):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]])
        
        if dp[rows-1][cols-1] == amount+1:
            return -1
        return dp[rows-1][cols-1]
