# Time Complexity : O(m*n) - m is amount, n is len(coins)
# Space Complexity : O(m*n) - m is amount, n is len(coins)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Build a matrix to store the min no. of coins for all permutations and combinations of amount and coins.
But as there will be repeated sub problems, calculate only once for every repeated sub problems.

"""

def coinChange(coins, amount):
    """
    :type coins: List[int]
    :type amount: int
    :rtype: int
    """
    m = len(coins)
    n = amount
    max_amount = amount + 1
    dp = [[0 for i in range(n + 1)] for i in range(m + 1)]

    # fill the first row as max_amount (infinity)
    for i in range(1, n + 1):
        dp[0][i] = max_amount

    # fill the dp matrix
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            # if amount is less than coin denomination, we cannot use that coin ,
            # so take the value as without using the coin
            if j < coins[i - 1]:
                dp[i][j] = dp[i - 1][j]
            else:
                # min(not choosing that coin + choosing that coin)
                dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])

    if dp[m][n] == max_amount:
        return -1

    return dp[m][n]