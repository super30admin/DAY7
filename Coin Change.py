class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins == None or len(coins) ==0:
            return 0
        n= len(coins)
    
        dp=[[0]*(amount+1) for _ in range (n+1)]
        
        for i in range (1, amount+1):
            dp[0][i]=amount+1
            
        for i in range (1, n+1):
            for j in range (1, amount+1):
                if j< coins[i-1]:
                    dp[i][j]= dp[i-1][j]
                else:
                    dp[i][j]= min( dp[i-1][j], 1+dp[i][j-coins[i-1]])
            if dp[n][amount]> amount:
                return -1
        return dp[n][amount]