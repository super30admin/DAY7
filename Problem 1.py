# Time Complexity : O(m*n)
# Space Complexity :O(m*n )


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[float('inf') for j in range(amount + 1)] for i in range(len(coins) + 1)]

        for k in range(len(coins) + 1):
            dp[k][0] = (0)
        for l in range(1, amount + 1):
            dp[0][l] = float('inf')

        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1)

        if dp[len(coins)][amount] == float('inf'):
            return -1
        return dp[len(coins)][amount]