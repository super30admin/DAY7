'''
Time complexity: O(n*m) where n is the number of coins and m is the amount
Space complexity: O(m) where m is the amount
Did this code successfully run on Leetcode : Yes (#322)
Any problem you faced while coding this : No
Approach:
- Create a dp array of size amount+1 and initialize it with infinity
- dp[0] = 0 as minimum number of coins required to make amount 0 is 0
- For each coin, iterate over the dp array and update the minimum number of coins required to make amount j
'''


from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
            dp = [float('inf')] * (amount + 1)
            dp[0] = 0
            for i in range(len(coins)):
                for j in range(coins[i],amount+1):
                    dp[j]= min(dp[j],dp[j-coins[i]] + 1)
            return dp[amount] if dp[amount]!=float('inf') else -1
    

#Driver code
s = Solution()
coins = [1,2,5]
amount = 11
print(s.coinChange(coins, amount)) #3