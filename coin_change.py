"""
Brute force coin change approach: Greedy strategy won't work. It will fail for the case [3,2,5], and the amount is 6.
If greedy fails, then another approach would be to explore all the possible solutions exhaustively.
Generate a recursive tree and explore all the paths by choosing and not choosing the coins.
Time complexity: O(2^(m+n)), m is the number of coins, n is the amount of coins.
In the case, the sub problems are repeated, identified by recursive tree.
Since the sub problems are repeated, we can use DP.
Takes O(m*n) time and O(m*n) space complexity.
"""
from typing import List


class Solution:
    def helper_dp(self, coins, amount):
        cols = amount + 1
        rows = len(coins) + 1
        # Matrix size is based on the number of decision-making parameters.
        # In this case, it is the number of coins and amount.
        # So initialize a matrix of size number of coins * 0 to amount
        # each row represents a coin and col represents the amount
        dp_matrix = [[0 for _ in range(cols)] for _ in range(rows)]

        # initialize the first row with max value that is either infinity or amount + 1
        # first row (coin) with first column (amount) or first row and second row (2 coins) with first column (amount),
        # first row, second row and third row with first column (amount) etc. are the sub problems. And the
        # values inside the cell are the solution to those sub problems.
        for i in range(cols):
            dp_matrix[0][i] =  float("inf") # or amount + 1

        # start filling the dp matrix
        for i in range(1, rows):  # coin
            for j in range(1, cols):  # amount
                # if amount < denomination of coin, choose case not possible
                # i-1 because the matrix has one extra row than coins array
                if j < coins[i - 1]:
                    dp_matrix[i][j] = dp_matrix[i - 1][j]
                else:
                    # both choose and not choose possible
                    # minimum of cell just above and cell in the same row and 1 +( j - coins[i - 1])
                    # j (current amount) - coins[i-1] (denomination)
                    dp_matrix[i][j] = min(dp_matrix[i - 1][j], 1 + dp_matrix[i][j - coins[i - 1]])

        print(dp_matrix)
        # if answer not possible dp_matrix[rows][cols] is infinity
        return dp_matrix[rows-1][cols-1]

        # print("row size", len(dp_matrix[0]))
        # print("col size", len(dp_matrix))


    def helper_brute_force(self, index, coins, amount, coins_used):
        # base case for the invalid path
        if amount < 0 or index >= len(coins):
            return float("inf")

        # base case for the valid path
        if amount == 0:
            return coins_used

        # not choose logic
        not_choose_return = self.helper_brute_force(index + 1, coins, amount, coins_used)
        # choose logic
        choose_return = self.helper_brute_force(index, coins, amount - coins[index], coins_used + 1)

        # if choose_return == -1:
        #     return not_choose_return
        # if not_choose_return == -1:
        #     return choose_return

        min_coins = min(choose_return, not_choose_return)
        return min_coins

    def coinChange(self, coins: List[int], amount: int) -> int:
        # min_coins = self.helper_dp(0, coins, amount, 0)
        min_coins = self.helper_dp(coins, amount)

        if min_coins == float("inf"):
            return -1
        return min_coins


obj = Solution()
coins = [2]
amount = 3
ans = obj.coinChange(coins, amount)
print(ans)
