class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        lcoins = len(coins)+1 #4
        lamount = amount+1    #12
        
        dp = [[99999 for _ in range(lamount)] for _ in range(lcoins)]
        
        for i in range(0,lcoins):
            dp[i][0] = 0
        
        for i in range(1,lcoins):
            for j in range(1,lamount):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j-coins[i-1]])
        
                    
        if dp[-1][-1] >= 99999:
            return -1
        else:
            return dp[-1][-1]
    
