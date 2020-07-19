class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins==None or len(coins)==0:
            return 0
        
        dp=[[0 for x in range(len(coins)+1)] for y in range(amount+1)]
        m=len(dp)
        n=len(dp[0])
        for i in range(1,n):
            dp[0][i]=9999
        for i in range(1,m):
            for j in range(1,n):
                #straight away copying from top array to bottom
                #so if j's value for example 0,1 is less than coins[i-1] say 2, till
                #that index of j we copy from top to next row, from coins[i-1]
                #onward we use else part
                if(j<coins[i-1]):
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j],dp[i][j-coins[i-1]]+1)
        result=dp[m-1][n-1]
        if results>=9999:
            return -1
        return result
#time complexity is O(nm)
#space is again O(nm)
