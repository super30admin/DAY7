# Time Complexity:O(mn) m-no of coins, n-amount

# Space Complexity:O(mn)

# Did it run on Leetcode?Yes

# Approach:
# Make a matrix of m*n. Calculate in each denomination how many coins will be needed to obtain that amount by picking that coin always and subtracting the value of coin from the column of the amount. To evaluate how many coins will be needed for remainder amount we seek the remainder amount column in same row and add that many coins needed. Now we take minimum of how many coins will be needed if we pick this coin and how many coins will be needed if we dont pick this coin(ie the previos denomination row). We assign the minimum of the two to the matrix element. the last row and column will give us the number of coins needed.

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        matrix = [[0] * (amount + 1) for i in range(len(coins) + 1)]
        for i in range(1, len(matrix[0])):
            matrix[0][i] = 99999
        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                if (j < coins[i - 1]):
                    matrix[i][j] = matrix[i - 1][j]
                else:
                    matrix[i][j] = min(matrix[i - 1][j], (1 + matrix[i][j - coins[i - 1]]))
        if (matrix[len(coins)][(amount)] == 99999):
            return -1
        return matrix[len(coins)][(amount)]
