"""
Problem1 (https://leetcode.com/problems/coin-change/)
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
--Example 1:--
Input: coins = [1, 2, 5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1 Example 2:
Input: coins = [2], amount = 3 Output: -1 Note: You may assume that you have an infinite number of each kind of coin.

Time complexity: O(m*n) where m is amount and n is the count of types of coin denominations.
Space complexity: O(m) where m is amount

Executed in leetcode - Yes
Comments: We create a new data structure of size amount + 1(as numbering starts at 0) and fill with value 'infinity'. The first item is
set to zero as it corresponds to the number of  ways to attain a zero amount. We compute the minimum change for amount upto the
given value. 
"""
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0 or len(coins) == 0:
            return 0                         #Is this correct? Should it be -1?
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        
        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] = min(dp[i], dp[i-coin] + 1)
        if dp[amount] != float('inf'):
            return dp[amount]
        else:
            return -1 
