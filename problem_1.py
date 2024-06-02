
# Time = O(N^2)
# Space = O(N)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # Step 1: Define the DP array with size (amount + 1)
        dp = [amount + 1] * (amount + 1)
        
        # Step 2: Initialize the DP array
        dp[0] = 0  # Base case: 0 coins are needed to make the amount 0
        
        # Step 3: Fill the DP array using the transition formula
        for coin in coins:
            for j in range(coin, amount + 1):
                dp[j] = min(dp[j], dp[j - coin] + 1)
        
        # Step 4: Check the result and return
        return dp[amount] if dp[amount] != amount + 1 else -1

        