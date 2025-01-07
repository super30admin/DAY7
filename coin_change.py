#Time Complexity -  O(n*m)
#Space Complexity - O(n*m)

class Solution:
    def coinChange(self, coins, amount):
        # Initializing the DP table
        dp = [[float('inf') for i in range(amount + 1)] for j in range(len(coins) + 1)]
        
        # Base case: 0 amount requires 0 coins
        for i in range(len(coins) + 1):
            dp[i][0] = 0
        
        # Filling the DP table
        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]  # Coin is not used
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1)  # Use the coin
        
        # If the amount cannot be reached, return -1
        return -1 if dp[-1][-1] == float('inf') else dp[-1][-1]
