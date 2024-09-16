# // Time Complexity : O(m*n)
# // Space Complexity : O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Yes a bit tricky and confusing in python


# // Your code here along with comments explaining your approach

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins== None or len(coins)==0:
            return 0
        
        m=len(coins)
        n=amount
        
        #Making the array of length plus 1 to accomodate the 0
        dp=[amount+1] * (n+1)
        
        
        for i in range(1,m+1):
            for j in range(n+1):
                if j<coins[i-1]:
                    dp[j]=dp[j]
                else:
                    dp[j]=min(dp[j],1+dp[j-coins[i-1]])
        
        result=dp[n]
        if result>amount:
            return -1
        else:
            return result
        
        

