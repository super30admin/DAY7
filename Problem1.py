# DP-1

## Problem1 (https://leetcode.com/problems/coin-change/)

# Approach
# Create a 2D matrix array with row as available coins and columns as the amount from 0 to max amount. Set 1st index & column to 0
# If the value of coin is less than the amount, copy the amount from the previous row and same column. 
# Else, compare min from the previous row same column and the amount value places back in the same row +1. Whichever is the lower value, add it. Final answer would be the last index of row and column

# Time Complexity: O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        dp = []
        for i in range(len(coins)+1):
            row = []
            for j in range(amount+1):
                row.append(99999)
            dp.append(row)
        
        for i in range(len(coins)+1):
            dp[i][0] = 0
        
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1+ dp[i][j-coins[i-1]] )
        
        if dp[-1][-1] == 99999:
            return -1
        else:
            return dp[-1][-1]