"""
TC: O(m*n) m: amount, n: len(coins)
SP:O(m) where m is the amount to make
"""
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount+1]*(amount+1)
        dp[0] = 0
        for i in range(len(coins)):
            for j in range(1, amount+1):
                if j-coins[i] >=0:
                    dp[j]= min(dp[j], 1+dp[j-coins[i]])

        return dp[-1] if dp[-1]!=amount+1 else -1
