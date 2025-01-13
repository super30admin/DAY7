class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0 or coins == None:
            return -1
        
        n = len(coins) 

        dp = [(amount+1) * [0]] * (n+1)

        for i in range(1,amount+1):
            dp[0][i] = amount+1

        for i in range(1 , n+1):
            for j in range(1,amount + 1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]] )
        
        if dp[n][amount] == amount + 1:
            return -1 

        return dp[n][amount]
    
    

        


        