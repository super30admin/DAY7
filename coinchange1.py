# The approach uses dynamic programming with a 2D table with O(n*amount) time complextiy to find the minimum coins needed.  
# For each amount, it considers whether to include or exclude the current coin and takes the minimum.  
# If no solution is found, it returns -1; otherwise, it returns the minimum value in dp[n][amount].

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins == None or len(coins) == 0:
            return 0
        n = len(coins)

        dp = [[0] * (amount+1)] * (n+1)
        for i in range(1 , amount +1):
            dp[0][i] = amount +1 # infinity

        for i in range( 1 , n+1):
            for j in range(1 , amount+1):
                # till the time denomintion > amount(j) that we need to make -> 0 case
                if j < coins[i-1]:
                    # 0 case
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j] , 1 + dp[i][j - coins[i-1]])
        if dp[n][amount] == amount + 1:
            return -1
        return dp[n][amount]
