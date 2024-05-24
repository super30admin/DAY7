# Time Complexity : O(m*n), where m is the amount and n is the number of coins
# Space Complexity : O(m*n)
class Solution:
    def coinChange(self, amount, coins) -> int:
        if not coins:
            return -1;
        dp = [[0] * (amount + 1) for _ in range(len(coins) + 1)] # 2D Array that maintains the min number of coins (row) required to make the amount (column). Intialized to all zeroes.
        for j in range(1, amount+1) : 
            # Filling the zero row colums, except zeroes with higher than the amount value
            dp[0][j] = amount+1
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if j<coins[i-1] : 
                    # Since one case is not possible here, the amount for the current cell will be the same as the zero case
                    dp[i][j] = dp[i-1][j]
                else : 
                    #  Sets the current cell value as the minimum of the zero case and one case for the current cell
                    dp[i][j] = min(dp[i-1][j],dp[i][j-coins[i-1]]+1)
        if dp[len(coins)][amount] >  amount : # If the final value is higher than the required amount, that amount can't be reached by the given coins
            return -1;
        return dp[len(coins)][amount]

# Example 1:
solution = Solution();
amount = 11
coins = [1,2,5]
print(solution.coinChange(amount, coins)) # Should print 3

# Example 2:
amount = 3
coins = [2]
print(solution.coinChange(amount, coins)) # Should print -1

# Example 3:
amount = 0
coins = [1]
print(solution.coinChange(amount, coins)) # Should print 0