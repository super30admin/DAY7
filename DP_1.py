
## Problem1 (https://leetcode.com/problems/coin-change/)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf')] * (amount + 1)  
        dp[0] = 0 
        
        for coin in coins:
            for j in range(coin, amount + 1):
                dp[j] = min(dp[j], dp[j - coin] + 1)
        
        return dp[amount] if dp[amount] != float('inf') else -1
##Explanation-
## Create a dp array where dp[i] represents the minimum coins needed to make up amount i, initialized with inf, except dp[0] = 0.
## Iterate over each coin, updating dp[j] = min(dp[j], dp[j - coin] + 1) for all j ≥ coin.
## If dp[amount] remains inf, return -1 (no valid combination exists); otherwise, return dp[amount].
## This solution runs in O(n * amount) time complexity, where n is the number of coin denominations.

## Problem2 (https://leetcode.com/problems/house-robber/)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:  # If the list is empty, return 0
            return 0
        if len(nums) == 1:  # If only one house, rob it
            return nums[0]
        
        prev1, prev2 = 0, 0  # prev1 = dp[i-1], prev2 = dp[i-2]
        
        for num in nums:
            temp = prev1
            prev1 = max(prev1, prev2 + num)  # Choose max between skipping or robbing
            prev2 = temp  # Move forward
        
        return prev1  # The max money robbed

##Explanation-
##Think of it as a decision for each house: Either
##Rob the current house → Then you must skip the previous house.
##Skip the current house → Then take whatever was stolen from the previous houses.
##Use Dynamic Programming (DP): Keep track of the maximum money you can rob up to each house.
##Use a formula: dp[i] = max(dp[i-1], dp[i-2] + nums[i]), where:
##dp[i-1] → If you skip the current house.
##dp[i-2] + nums[i] → If you rob the current house (add its money to the best result two houses before).
##Return the last value in dp, which contains the max amount you can rob.
