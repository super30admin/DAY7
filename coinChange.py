"""
322. Coin Change

DP approach --

TC - O(m * n)
SC - O(m * n)
"""

c = [1, 2, 5]
amt = 11

# c = [2]
# amt = 3


def coinChange(coins, amount):
    if coins is None or len(coins) == 0 or amount is None: return 0

    m = len(coins)
    n = amount

    maxAmt = amount + 1

    # +1 since we need to take 0th row and 0th col for DP matrix
    dp = [[0 for i in range(n + 1)] for i in range(m + 1)]

    # make the 0th col as 0 since 0 amount can be formed using 0 coins
    for i in range(m + 1):
        dp[i][0] = 0

    # make the 0th row to have inf value (maxAmt)
    for i in range(1, n + 1):
        dp[0][i] = maxAmt

    # start filling dp matrix
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            # if coin is less than the amount to be achieved, add the value from the row above
            # coins[i-1] and not coins[0] since range above is starting from 1
            # and we are comparing amount to coins array
            if j < coins[i - 1]:
                dp[i][j] = dp[i - 1][j]
            else:
                # min((toprow, same col), (same row, j-coins[i-1]))
                dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])

    if dp[m][n] == maxAmt: return -1

    return dp[m][n]


if __name__ == '__main__':
    print(coinChange(c, amt))
