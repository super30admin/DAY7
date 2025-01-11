# Time complexity - O(m * n) # (len(coins) + 1) * (amount + 1)
# Space complexity - O(m * n)

# Approach - Maintain a 2D table
# As long as coin value is less than amount; assign (table[prev_coin][amount])
# When coin value greater than amount; assign min of table[prev_coin][amount] and table[coin][amount-prev_coin]
# Return the right bottom corner element of the table

from typing import List
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)

        dp = [[0] * (amount+1)] * (n+1)

        for i in range(1, amount+1): # amount
            dp[0][i] = amount + 1 # infinity

        for i in range(1, n+1):
            for j in range(1, amount+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j-coins[i-1]])
        
        if dp[n][amount] == amount + 1:
            return -1
        return dp[n][amount]