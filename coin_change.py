'''
Time Complexity :
O(amount*len(coins))
Space Complexity : O(amount))
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
'''

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        import math
        dp=[float('inf') for _ in range(0,amount+1)]
        dp[0]=0
        for coin in coins:
            for i in range(coin,amount+1):
                dp[i]=min(dp[i], 1 + dp[i-coin])

        return dp[amount] if dp[amount] != float('inf') else -1