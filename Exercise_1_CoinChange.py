# Time Complexity :

# O(M*N) , M = no. of coins, N = amount


# Space Complexity :  

# O(M*N) , M = no. of coins, N = amount , For Dynamic Programming (2D Matrix solution)


# Approach:


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not coins or len(coins) == 0:
            return 0

        rows = len(coins)+1
        cols = (amount+1)

        dp = [[0] * cols] * rows
        print("Rows and cols: ", len(dp), " x ", len(dp[0]))

        # base case
        for j in range(1, amount+1):
            dp[0][j] = amount + 1   # Fill the 0th row(corresponding to "0" coin value) with amount+1
        
        # start filling dp array for different combinations of coins and amounts
        for i in range(1, len(coins)+1):
            for j in range(1, amount + 1):
                # check if current amount(j) is less than coin value(i)
                if j < coins[i-1]:      # access the coin value at "i-1" index since we added an extra dimension for row
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j-coins[i-1]])
        

        # check if last element in the matrix is "amount+1", if so, then return -1
        if dp[rows - 1][cols - 1] == amount+1:
            return -1
        return dp[rows - 1][cols - 1]
