# Time Complexity : O(m*n) for dp as 2d array was used.
# Space Complexity : O(m*n)

# Did this code successfully run on Leetcode : Yes 

# Any problem you faced while coding this : Yes when i initially filling the matrix based on the tree. I was not able to figure out easily how can i get the value.



class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n=len(coins)
        m=amount
        ans=0

        dp=[[0 for i in range(m+1)] for j in range(n+1)]
       
        for j in range(1,m+1):
            dp[0][j]=999999999
        for i in range(1,n+1):
            for j in range(1,m+1):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]

                else:
                    dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i-1]])

        
        x=dp[n][m]
        if x==999999999:
            return -1
        else:
            return x

        # for i in range

## Recursive brute force going TLE:

        # def helper(coins,amount,index):
        #     if amount==0:
        #         return 0
        #     if amount<0 or index>=len(coins):
        #         return 99999999999
        #     take = 1 + helper(coins,amount-coins[index],index)
        #     notake=0 + helper(coins,amount,index+1)
        #     return min(take,notake)
        # x=helper(coins,amount,0)
        # if x==99999999999:
        #     return -1
        # else:
        #     return x

#Approach:
#followd the same approach taught in the class