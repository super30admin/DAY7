class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount + 1] * (amount + 1)
        # Base Case
        dp[0] = 0 # It takes 0 coins for 0 amt

        for a in range(1, amount + 1): # amt -> 1, 2, ...., amt
            for c in coins:
                if a - c >= 0: # Only look for a solution if amt is +ve after using the coin
                    dp[a] = min(dp[a], 1 + dp[a - c]) # eg: dp[7] = 1 + dp[7 - 4] where c = 4

        # Return dp of amt if it's not equal to the default value
        # Else amount was not found and return -1
        return dp[amount] if dp[amount] != amount + 1 else -1

        # T: O(amt * len(coins)), S: O(amt)