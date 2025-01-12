class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1  # Base case: one way to make amount 0
        
        for coin in coins:
            for a in range(coin, amount + 1):
                dp[a] += dp[a - coin]
        
        return dp[amount]

# time complexity: O(n * m) where n is the number of coins and m is the amount
# space complexity: O(m) where m is the amount
