"""
DP-1

Problem1 (https://leetcode.com/problems/coin-change/)

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 
Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

Time Complexity : O(mxn) because we're iterating over m coins and n amount
Space Complexity : O(mxn) because we're creating a dp 2D array of m coins and n amount
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Idea behind this problem is we're finding the repeatitive sub problems so we need to store them either in the DP array or we need to memoise it. 
so in approach 1 we're using dp array with a value of len(coins)+1 & amount+1 as rows and columns. we're storing extra row & to column to store 0th value
for each of them which would be 0 in case of column since we can't make anything with 0 and with 0 coin and positive amount it'll be max amount since we can't make the amount.
After that we start iterating over coins along with amount starting both loops from index 1 since we're having 0 results and we check if current coin i.e., coins[i-1] is greater than amount if yes we
take prev result which is dp[i-1][j] since we can't form the amount with current coin else we get the min of previous coin's result along with 1 + dp[i][j-coins[i-1]] which is considering current coin and
adding posibilities of current amount which is j-coins[i-1]. Final result is stored at the end which is dp[len(coins)][amount]
"""

# Approach 1 using DP
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0 or amount < 0:
            return -1

        dp = [[0] * (amount+1) for _ in range(len(coins)+1)]

        for j in range(1, amount+1):
            dp[0][j] = amount+1

        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if coins[i-1] > j: # coin is greater than amount, take prev since it can't be found with current
                    dp[i][j] = dp[i-1][j] # take previous coin's no of coins since we can't make form the amount with this coin
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j-coins[i-1]])
        

        return dp[len(coins)][amount] if dp[len(coins)][amount] != amount+1 else -1

# Approach 2 using memoisation
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        memo = {}
        def coin_change_helper(curr_amount):
            if curr_amount in memo:
                return memo[curr_amount]
            
            if curr_amount < 0 or curr_amount > amount:
                return -1
            
            if curr_amount == 0:
                return 0
            
            min_no_of_coins = amount+1 # max value infinity
            for coin in coins:
                no_of_coins = coin_change_helper(curr_amount - coin)

                if no_of_coins != -1:
                    min_no_of_coins = min(min_no_of_coins, no_of_coins + 1)
            
            memo[curr_amount] = min_no_of_coins if min_no_of_coins != amount+1 else -1
            return memo[curr_amount]

                
            return -1
        
        if len(coins) == 0 or amount < 0:
            return -1

        return coin_change_helper(amount)

        

