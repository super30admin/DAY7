"""
Problem 322:
Approach --
Note - Start evaluating Greedy approach. Check if it works for all the cases. If not, try recursion(exhaustive) approach.
However, the problem with recursive approach is, it causes time limit to exceed because the approach is evaluated
multiple times for each case. Here's where we use Dynamic Programming. Since, a part of problem is already evaluated, we
don't need to evaluate same problems over and over again. Thus, it saved time.

1. Start by deciding to choose or not to choose a particular index - these are the two cases which will be evaluated
2. Once decided which to evaluate, reach targe if reached 0

TC - O(row*col)
SC - O(row*col)
"""
import sys

coin = [1, 2, 5]
t = 11


def coinChange(coins, amount):
    if coins is None or len(coins) == 0: return -1

    row = len(coins) + 1
    col = amount + 1

    # here +1 is added because we need to start from 1st row and col of the matrix and not the 0th row and col
    matrix = [[0 for x in range(col)] for y in range(row)]

    # fill 1st row of matrix with infinity, i.e. amount + 1, since we'll never go beyond the amount (equivalent to inf)
    for j in range(1, col):
        matrix[0][j] = amount + 1

    #fill remaining rows
    for i in range(1, row):
        # fill cols
        for j in range(1, col):
            if j < coins[i-1]:
                matrix[i][j] = matrix[i-1][j]
            else:
                matrix[i][j] = min(matrix[i-1][j], 1 + matrix[i][j - coins[i - 1]])

    # this case is to handle infinity
    if matrix[row-1][col-1] == amount + 1:
        return -1

    return matrix[row-1][col-1]


print(coinChange(coin, t))
