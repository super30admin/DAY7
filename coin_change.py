class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        m = len(coins)
        n = amount

        # Initialize dp table with size (m+1) x (n+1)
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        # Initialize the first row (no coins) with a large number
        for j in range(1, n + 1):
            dp[0][j] = amount + 1

        # Fill the dp table
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if (
                    j < coins[i - 1]
                ):  # If the coin value is greater than the current amount
                    dp[i][j] = dp[i - 1][j]  # Use the value from the previous row
                else:
                    dp[i][j] = min(
                        dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]
                    )  # Choose the minimum of not using or using the coin

        # Return the result if it's valid, otherwise return -1
        return dp[m][n] if dp[m][n] <= amount else -1


# time complexity is O(m*n)  where m is the number of coin types and n is the target amount
# space complexity is O(m*n) where m is the number of coin types and n is the target amount
