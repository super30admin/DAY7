#1. We can use binary recursion, but the time limit will be exceeded
#2. DP approach with a 2D table and 2 for loops updating the table
# dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]
#TC: O(n*m)
#SC: O(n*m)
#Yes this worked in leetcode
# Faced TLE when I used brute force recursion

def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0:
            return -1
        dp = [[0 for _ in range(amount + 1)] for _ in range(len(coins) + 1)]
        for j in range(1, amount + 1):
            dp[0][j] = amount + 1
        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])
            if dp[len(coins)][amount] == amount + 1:
                return -1
        return dp[len(coins)][amount]