# Time Complexity = O(mn) Space Complexity = O(n)

class Solution:
    def coinChange(self, coins: list[int], amount: int) -> int:
        m = len(coins)
        n = amount
        # dp = [[0 for i in range(n+1)] for j in range(m+1)]
        dp = [0 for i in range(n + 1)]

        for j in range(1, n + 1):
            dp[j] = amount + 1

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if j >= coins[i - 1]:  # choose case not available
                    dp[j] = min(dp[j], 1 + dp[j - coins[i - 1]])

        if dp[n] > amount:
            return -1
        return dp[n]


