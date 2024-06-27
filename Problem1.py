#The coinChange function uses dynamic programming to find the minimum number of coins needed to make up a given amount using a set of coin denominations. It initializes a dp array where each entry represents the minimum coins required for corresponding amounts. By iterating through each coin denomination and updating the dp array based on previous calculations, it efficiently computes the result. Time complexity is O(coins⋅amount), and space complexity is O(amount).


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        if amount == 0: 
            return 0

        dp = [float("inf") for _ in range(amount+1)]
        dp[0] = 0
        
        for denom in coins:
            for i in range(1, len(dp)):
                if i >= denom:
                    dp[i] = min(dp[i], 1 + dp[i - denom])

        return dp[-1] if dp[-1] != float("inf") else -1
