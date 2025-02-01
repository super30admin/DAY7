class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # worst case :- 
        # dp of size amount + 1 initialized to a large value (amount + 1 is used as a placeholder for infinity). 
        # This is because the maximum number of coins needed to form any amount i can't exceed i (when using 1-denomination coins). Set dp[0] = 0 since zero coins are needed to make an amount of 0.

        dp = [amount + 1] * (amount + 1)

        # base case 
        dp[0] = 0

        for i in range(1, amount+1):
            for coin in coins:
                if coin <= i:
                    dp[i] = min(dp[i], dp[i-coin] + 1)
        
        return dp[amount] if dp[amount] <= amount else -1
