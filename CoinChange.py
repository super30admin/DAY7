"""
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

"""

# Time Complexity : O(m*n) m is number of coins, n is numbers of amount 
# Space Complexity : O(m*n)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : I could not solve this. I had to take lot of help but understood everything. I took online help. 


from typing import List
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        if coins == [] or len(coins) < 1:
            return -1

        dp = []
        
        for i in range(len(coins) + 1):
            L = [(amount+1) if (i == 0 and j>=1) else 0 for j in range(amount + 1)]
            dp.append(L)

        for i in range(1, len(coins) + 1):
            for j in range(1,amount + 1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]] + 1)

        result = dp[(len(coins)+1) - 1][(amount + 1) - 1]
        if result >= (amount+1):
            return -1
        else:
            return result
        
