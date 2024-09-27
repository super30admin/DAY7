class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = [amount+1]*(amount+1)
        dp[0]=0
        
        for amt in range(1,amount+1):
            for coin in coins:
                if amt>=coin:
                    dp[amt] = min(dp[amt], dp[amt-coin]+1)
                
        if dp[amount]>amount:
            return -1
        else:
            return dp[amount]
            