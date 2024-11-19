# // Time Complexity :O(m*n)
# // Space Complexity :O(m*n)



class Solution:
    
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp=[[0 for i in range(amount+1)]for j in range(len(coins)+1)]
        for i in range(1,len(dp[0])):
            dp[0][i]=inf
        for i in range(1,len(dp)):
            for j in range(len(dp[0])):
                
                if j==0:
                
                    dp[i][j]=0
                elif j<coins[i-1]:
                
                    dp[i][j]=dp[i-1][j]
                else:
                    
                    dp[i][j]=min(dp[i-1][j],dp[i][j-coins[i-1]]+1)
                    

        if dp[-1][-1]==inf:
            return -1
        return dp[-1][-1]