# Problem20:  (https://leetcode.com/problems/coin-change/)

# Time Complexity : O(m * n)
# Space Complexity : O(m * n)   
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins)
        n = amount
        dp =[[0] * (n+1) for _ in range (m+1)] # dp matrix of m * n of values 0 
        for j in range(1,n+1):
            dp[0][j] = 99999 # put max value in first dummy row
        
        for i in range(1,m+1):
            for j in range(1,n+1):
                if coins[i-1] > j: # if the coin value is > amount so far
                    dp[i][j] = dp[i-1][j] # just take the above value
                else:  #else take the min of above entry or 1 + coin[i-1] entries left in the same row
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]]) 
        
        res = dp[m][n]
        if res >= 99999: # if the res is max it means no coins can make the amount
            return -1 # so return -1 
        return res
        
