# DP-1

## Problem1 (https://leetcode.com/problems/coin-change/)
## Solution: Dynamic Programming
# Create a matrix with rows as amount and columns as the number of coins.
# Initialize the first row with "max_value" and column with "0" as default values.
# Amount is less than denomination of the coin then we use the value from the column above and append.
# Else we will select the min from the above column value and compare with previous row value. Return 
# the last row, column matrx value which will be the min number of coins.

## Problem2 (https://leetcode.com/problems/house-robber/)
## Solution: Dynamic programming
# Create a 1 D array of length of nums. Initialize it with zeros.
# Since we are comparing the first element with the other two. We need to add the first two values
# as default. The second value will be the max of the first and second.
# We will start with the 3rd element in the array and comparing the max we will update the 1D array
# The last element in the array will be maximum value.  
