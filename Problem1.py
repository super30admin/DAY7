# 322. Coin Change
# Using 2Darray tabulation
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins)
        n = amount

        dp = [[0] * (n + 1) for _ in range(m + 1)]

        for j in range(1, n + 1):
            dp[0][j] = 99999

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])

        if dp[m][n] > amount:
            return -1
        return dp[m][n]

#Using tabulation : 1D array
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins)
        n = amount

        dp = [0] * (n+1)

        for j in range(1,n+1):
            dp[j] = amount + 1

        for i in range(1,m+1):
            for j in range(1,n+1):
                if j < coins[i-1]:
                    dp[j] = dp[j]
                else:
                    dp[j] = min(dp[j], 1+dp[j-coins[i-1]])

        if dp[n] > amount: return -1
        return dp[n]


        