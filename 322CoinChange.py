# Time complexity = O(mxn) where m is number of coins and n is the amount
# Space complexity = O(mxn)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)

        dp = [amount + 1] * (amount + 1)
        dp[0] = 0

        for a in range(1, amount + 1):
            for c in coins:
                if a >= c:
                    dp[a] = min(dp[a], 1 + dp[a-c])
        if dp[amount] == amount + 1:
            return -1

        return dp[amount]