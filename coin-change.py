"""

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

Time Complexity: O(m * n) for Method 1 and O(m * n) for Method 2, where m is the number of coins and n is the target amount.
Space Complexity: O(m * n) for Method 1 (2D DP table) and O(n) for Method 2 (1D DP array).

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""


class Solution:
    
    def coinChange(self, coins: List[int], amount: int) -> int:

      """
      Approach: using dynamic programming to find the minimum number of coins required to make up the given amount. 
      This method uses a 2D DP table (O(m*n) space) to store results for each coin and amount combination. 
      """
      
        ## Method 1: DP with 2D table (O(m * n) space)
        if coins is None or len(coins) == 0:
            return -1

        m = len(coins) + 1
        n = amount + 1

        dp = [[0] * n for _ in range(m)]  

        for i in range(1, n):
            dp[0][i] = n  # Initialize with a large value

        for i in range(1, m):
            for j in range(1, n):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])

        return -1 if dp[m - 1][n - 1] == n else dp[m - 1][n - 1]
      
        """
        The second method optimizes space complexity by using a 1D DP array (O(amount) space) to track the minimum coins needed for each amount.
        """
      
        ## Method 2: DP with 1D array (O(amount) space)
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0

        for a in range(1, amount + 1):
            for c in coins:
                if a - c >= 0:
                    dp[a] = min(dp[a], 1 + dp[a - c])

        return dp[amount] if dp[amount] != amount + 1 else -1
