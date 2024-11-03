# Approach:
# We use dynamic programming to solve this problem by creating a dp array where each index i represents the minimum
# number of coins needed to make up the amount i. We initialize the dp array with infinity (or a large number) to
# signify unreachable amounts, except dp[0] = 0. For each coin, we iterate over possible amounts, updating the dp
# array with the minimum count for each amount.

# Time Complexity : O(n * amount) where n is the number of coins and amount is the target amount
# Space Complexity : O(amount) for the dp array storing minimum coins required for each amount
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # Initialize dp array with infinity values, except for dp[0] = 0
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0  # Base case: 0 coins needed to make amount 0
        
        # For each coin, update the dp array
        for coin in coins:
            for x in range(coin, amount + 1):
                # Update dp[x] to the minimum coins required to make amount x
                dp[x] = min(dp[x], dp[x - coin] + 1)
        
        # Return -1 if dp[amount] is still infinity, meaning it's unreachable
        return dp[amount] if dp[amount] != float('inf') else -1
