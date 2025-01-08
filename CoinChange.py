# Time Complexity : O(m * n), where m is the number of coins and n is the amount
# Space Complexity : O(m * n), where m is the number of coins and n is the amount
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# to store the values of repeated subproblems, we use dp, 2d array because 2 decision making params - coins and amount
# every cell is the storing the minimum number of coins used to make that amount, rows are coins and columns are the amounts
# every coin can have 2 cases - whether to pick the coin or not
# the 0 case is the case when the coin is not picked, then the amount remains same, and this value is found in the column, previous row
# the 1 case is when the coin is picked and the amount changes, and the value is found at amount - current_coin_value columns behind the current column
# every cell stores the min of these two cases
# the last cell will contain the final value

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if coins is None or len(coins) == 0:
            return -1

        # initializing the 2D array
        dp = [[0] * (amount + 1) for _ in range(len(coins) + 1)]
        
        # row 1 as infinity 
        for j in range(1, amount+1):
            dp[0][j] = amount + 1

        for i in range(1, len(coins) + 1):
            for j in range(amount + 1):
                if j < coins[i - 1]:
                    # becuae there is one extra row of 0s in the dp array
                    # so to match the index of dp array row and coins, we have to do -1 here
                    # we only have access to 0 case here
                    # in 0 case, the amount does not change, so the value lies right above
                    dp[i][j] =  dp[i-1][j]
                else:
                    # so the amount is either equal or greater than the current coin
                    # now we have access to both 0 and 1 case
                    # 1 case coins[i - 1] steps behind from the current column (j)
                    # min of case 0 and case 1
                    dp[i][j] = min(dp[i-1][j], dp[i][j - coins[i - 1]] + 1)

        
        if dp[len(coins)][amount] == amount + 1:
            return -1
        else:
            return dp[len(coins)][amount]


      

