#  Time Complexity : O(m*n)
#  Space Complexity :O(m*n)
#  Did this code successfully run on Leetcode :Yes
#  Any problem you faced while coding this : No
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)
        m = amount

        # Initialize a 2D DP array where dp[i][j] will be the minimum number of coins 
        # to make amount j using the first i coins.
        dp = [[float('inf')] * (m + 1) for _ in range(n + 1)]
        
        # Base case: 0 coins are needed to make amount 0
        dp[0][0] = 0
        print(dp)
        # Fill the DP table
        for i in range(1, n + 1):
            for j in range(m + 1):
                # If we don't take the current coin (coins[i-1])
                dp[i][j] = dp[i-1][j]
                
                # If the current coin can be used (coin[i-1] <= j)
                if coins[i-1] <= j:
                    dp[i][j] = min(dp[i][j], 1 + dp[i][j - coins[i-1]])
               

        # If dp[n][m] is still inf, then it's not possible to make the amount
        return dp[n][m] if dp[n][m] != float('inf') else -1