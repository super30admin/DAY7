# Time Complexity : O(MN)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
Created a dp matrix to reuse the results of repeated calculations.


class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if coins == None or len(coins) == 0:
            return 0
        
        m = len(coins) + 1
        n = amount + 1
        dp = [[0]*n]*m
        for i in range(m):
            dp[i][0] = 0
            
        for j in range(1,n):
            dp[0][j] = 9999
            
        for i in range(1,m):
            for j in range(1,n):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1)
        
        if dp[m-1][n-1] >= 9999:
            return -1
        else:
            return dp[m-1][n-1]
        
        
        