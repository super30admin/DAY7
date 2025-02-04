'''
// Time Complexity :
# Problem 1: O(m*n) to traverse the matrix
# Problem 2: O(n) to traverse the array
// Space Complexity :
# Problem 1: O(m*n) to store result in the matrix
# Problem 2: O(n) to store result in an array using Memoization
// Did this code successfully run on Leetcode :
Yes the submission ran successfully.
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
'''
## Problem 1 - Coin Change
## Solution 1: Recursion - TIME LIMIT EXCEEDED
# Create a function that has base cases where if the amount is '0' we return 0 or if the amount becomes
# less than 0 or if all the coins are used we return "9999" which is "inf" to avoid overflow.
# Logic defines when we don't choose any coin we will end up traversing the entire array
# When we choose the coin we take the coin value from the total amount and continue traversing until
# the amount becomes '0'. Return the minimum number of coins used for the amount.
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        re = self.helper(coins, 0, amount)
        if re >= 99999: return -1 
        return re

    def helper(self, coins, idx, amount):
        ##base
        if amount == 0: return 0
        if amount < 0 or idx == len(coins): return 99999 # integer overflow
        ##logic
        ## case 1 : not choose
        case_1 = 0 + self.helper(coins, idx+1, amount)
        ## case 2 : choose
        case_2 = 1 + self.helper(coins, idx, amount - coins[idx])
        return min(case_1, case_2)

## Solution 2:  
# Create a matrix with rows as amount and columns as the number of coins.
# Initialize the first row with "max_value" and column with "0" as default values.
# Amount is less than denomination of the coin then we use the value from the column above and append.
# Else we will select the min from the above column value and compare with previous row value. Return 
# the last row, column matrx value which will be the min number of coins.
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        m = len(coins)
        n = amount
        max_value = amount + 1
        dp = [[None for i in range(n + 1)] for j in range(m + 1)]
        ## Initialize the first column and row
        for i in range(m+1):
            dp[i][0] = 0
        for j in range(1,n+1):
            dp[0][j] = max_value
        ## 
        for i in range(1,m+1):
            for j in range(1,n+1):
            # 0 case - amount is less than denomination of coins
                if  j < coins[i-1]: 
                    dp[i][j] = dp[i-1][j]
            # 0 and 1 case
                else: 
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])
        re = dp[m][n]
        if re < max_value:
            return re
        else:
            return -1

## Problem 1 - Coin Change
## Solution 1 - Recursion TIME LIMIT EXCEEDED
# Create a function with case NOT choose where we rob the current house and skip the next to rob the
# index + 2 house as we cannot rob independent houses.When case choose we will only rob the current 
# house.
# We will compare the maximum values of the two cases and return the value.
# For egde case if we reach the last index return 0 as we are comparing index + 2 which is not possible.
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return self.helper(nums, 0)

    def helper(self, nums, idx):
        ## base
        if idx >= len(nums): return 0
        ## logic
        # Case choose
        case_1 = nums[idx] + self.helper(nums, idx + 2)
        # Case do not choose
        case_2 = self.helper(nums, idx + 1)
        return max(case_1, case_2)

## Solution 2 - Top Down DP by Memoization
# Initialize an array of length of the nums array and initialize it by -1 so that we can track if a 
# value already exists or not. If value value exists we will update it.
# Create a function with case NOT choose where we rob the current house and skip the next to rob the
# index + 2 house as we cannot rob independent houses.When case choose we will only rob the current 
# house.
# We will compare the maximum values of the two cases and return the value.  
# We will store the result in the memoization array and return the maximum result.  
class Solution(object):
    memo = []
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        memo = [-1]*len(nums)
        return self.helper(memo, nums, 0)

    def helper(self, memo, nums, idx):
        ## base
        if idx >= len(nums): return 0
        if memo[idx] != -1: return memo[idx]
        ## logic
        # Case choose
        case_1 = nums[idx] + self.helper(memo, nums, idx + 2)
        # Case do not choose
        case_2 = self.helper(memo, nums, idx + 1)
        re = max(case_1, case_2)
        memo[idx] = re
        return re  

## Solution 3 - Dynamic Programming
# Create a 1 D array of length of nums. Initialize it with zeros.
# Since we are comparing the first element with the other two. We need to add the first two values
# as default. The second value will be the max of the first and second.
# We will start with the 3rd element in the array and comparing the max we will update the 1D array
# The last element in the array will be maximum value.
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        dp = [0]*n
        dp[0] = nums[0]
        if n == 1: 
            return dp[0]        
        dp[1] = max(dp[0], nums[1] + 0)
        if n == 2: 
            return dp[1]
        for i in range(2, n):
            dp[i] = max(dp[i-1], nums[i] + dp[i-2])
        return dp[n-1]
