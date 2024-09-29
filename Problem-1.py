'''
    Time Complexity: O(mn)
    Space Complexity: O(n)
    Approach: Dynamic Programming
    1. Use dp array of length amount + 1 and initialise it to amount + 1 except index 0 = 0
    2. Traverse for each coin, for no choose and choose cases. 
    3. If no choose maintain the previous value if choose set the minimum of previous and 1 + j - coins[i-1]
'''
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins)
        n = amount

        dp = [None for i in range(n+1)]

        dp[0] = 0

        for j in range(1, n+1):
            dp[j] = amount + 1

        for i in range(1, m+1):
            for j in range(n+1):
                if j < coins[i-1]:
                    dp[j] = dp[j]
                else:
                    dp[j] = min(dp[j], 1 + dp[j - coins[i-1]])

        if dp[n] > amount:
            return - 1

        return dp[n]