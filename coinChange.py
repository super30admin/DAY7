# // Time Complexity :O(m*n) for dp array traversal
# // Space Complexity :O(m*n) can be reduced to O(n) by using an array
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Couldn't use 0 or 9999 to initialize dp array.


# // Your code here along with comments explaining your approach
# We will first create a Dp matrix of MxN.
# We will first find the horizontal subproblem and then compare it with the vertical subproblem.
# the output should be on the last element.

class Solution:
    def coinChange(self, coins: list[int], amount: int) -> int:
        m = len(coins)
        n = amount

        # dp = [[0 for row in range(n+1)] for col in range(m+1)]    # //cant initialize 0 due to min function
        dp = [[float('inf')]*(n+1) for i in range(m+1)]             # dp matrix
        
        
        for j in range(n):                                          # base case: fill iniital row with inf or amt+1
            dp[0][j] = amount+1
        
        for i in range(m + 1):                                      # base case 2: fill 1st col with 0
            dp[i][0] = 0   
        
        for i in range(1,m+1):                                      # starting from 2nd row, check 3 conditions       
            for j in range(0,n+1):
                if j < coins[i-1]:                                  # 1)amount less than coin value, no chose availablity case
                    dp[i][j] = dp[i-1][j]                           # [1,3,5,x,] -> i-1
                else :                                              # 2)no choose case vs 3)choose case
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]])
        

        if dp[m][n]>amount+1:                                       # if inf/max amt value return -1
            return -1
        else:
            return dp[m][n]                                         # last item from matrix