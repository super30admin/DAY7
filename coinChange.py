# Time Complexity : O(M*N)
# Space Complexity : O(M*N)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO



class Solution:
    def coinChange(self, coins, amount: int) -> int:
        cols = amount+1
        rows = len(coins)+1
        
        dp = [[0 for i in range(cols)] for j in range(rows)]
        
        dp[0][0] = 0
        for j in range(1,cols):
            dp[0][j] = amount+1 #infinity types
           
        for i in range(1,rows):
            dp[i][0] = 0
            
        for i in range(1,rows):
            for j in range(1,cols):
                if j<coins[i-1]:
                    #zero case
                    dp[i][j] = dp[i-1][j]
                else:
                    #zero and one case
                    dp[i][j] = min(dp[i-1][j],1+dp[i][j-coins[i-1]])
                    
        res = dp[rows-1][cols-1]
        if res>amount:
            return -1
        return res

obj = Solution()
coins = [1,2,5]
amount = 13
print(obj.coinChange(coins,amount))