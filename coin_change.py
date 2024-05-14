# Time complexity: O(mn):m - len of coins array, n- amount
# Space complexityL O(mn): creating dp matrix
# Approach:
# create a dp matrix of size (m+1)(n+1) with indices of array as rows and amount from 0 to amount as columns
# initialise dp[0][0]=0
# dp[0][cols] will become infinite since amount cant be formed with 0 coins
# until the amount is smaller than the value of coin, we return the value of before row
# else, we get the minimum of include and not included case.
# if we get the value from included case, 
# we have to do 1+ (value at same row and col at (present col-coin used in present row))
# for not included case, we just copy the before row value since the amount will be same. 

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins==None:
            return -1
        m = len(coins)
        n = amount
        dp= [[0 for i in range(n+1)]for j in range(m+1)]
        dp[0][0]=0
        for j in range(1,n+1):
            dp[0][j]=amount+1
        for i in range(1,m+1):
            for j in range(1,n+1):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j], 1+dp[i][j-coins[i-1]])
        if (dp[m][n]== amount+1):
            return -1
        return dp[m][n]
        
        