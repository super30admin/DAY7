# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins)
        n = amount

        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
        
        for j in range(1, n + 1):
            dp[0][j] = 99999
            
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if j < coins[i-1]: # no availability of choose case
                    dp[i][j] = dp[i-1][j]

                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i-1]])

        if dp[m][n] > amount:
            return -1
        return dp[m][n]

#Solution with Recursion
#     return self.helper(coins, 0, amount, 0)
# def helper(self, coins, i, amount, coinsUsed):
#     # base case
#     if amount < 0 or i > len(coins):
#         return -1
#     if amount == 0:
#         return coinsUsed
#     # logic
#     case0 = self.helper(coins, i + 1, amount, coinsUsed)
#     case1 = self.helper(coins, i, amount - coins[i], coinsUsed + 1)
#     if case0 == -1:
#         return case1
#     if case1 == -1:
#         return case0
#     return min(case0, case1)