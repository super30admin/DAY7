# The code defines a coinChange method to find the minimum number of coins needed to make up a given amount using a dynamic programming approach.
# The method uses a dp array where dp[a] represents the minimum number of coins needed to achieve the amount 'a'.
# 
# Initialization:
#   - The dp array is initialized with a value of (amount + 1) for all indices, representing an initially unattainable state.
#   - dp[0] is set to 0 because no coins are needed to make an amount of 0.
# 
# Dynamic Programming Iteration:
#   - For each amount 'a' from 1 up to the target amount:
#       - For each coin in the list of coins:
#           - If the coin can be used to make the current amount (a - c >= 0), the dp value for dp[a] is updated:
#               - dp[a] is set to the minimum of its current value or (1 + dp[a - c]), representing using one more coin to reach 'a'.
# 
# Final Result:
#   - If dp[amount] remains as (amount + 1), it indicates that it is impossible to make up the amount with the given coins, so -1 is returned.
#   - Otherwise, dp[amount] holds the minimum number of coins needed to achieve the amount, which is returned.
# 
# TC: O(amount * n) - Where 'amount' is the target amount and 'n' is the number of coins, as each amount considers every coin.
# SC: O(amount) - The space complexity is linear due to the dp array storing the minimum coins needed for each amount up to the target.


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0

        for a in range(1, amount + 1):
            for c in coins:
                if a - c >= 0:
                    dp[a] = min(dp[a], 1 + dp[a - c])
        return dp[amount] if dp[amount] != amount + 1 else -1