#Approach: Recursive
# # recursive Time complexity - 2^n
# Space complexity - O(n) 

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        def helper(coins,idx,amount):
            if (amount==0):
                return 0
            if (amount<0 or idx==len(coins)): return float('inf')
            case1= 1+ helper(coins,idx,amount-coins[idx])
            case2=helper(coins,idx+1,amount)
            return min(case1,case2)

        value = helper(coins, 0, amount)
        return value if value< float('inf') else -1
        

#Approach: DP
# time complexity -O(mxn)
# space complexity -O(mxn)

import sys
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m=len(coins)
        n=amount
        dp=[[0]*(n+1)for j in range(m+1)]
        for j in range(1,n+1):
            dp[0][j]=sys.maxsize
        for i in range(1,m+1):
            for j in range(1,n+1):
                if j < coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i-1]])
        return dp[m][n] if dp[m][n]< sys.maxsize else -1