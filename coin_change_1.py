class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        :m = length of the coins array
        :n = amount
        :Time complexity: O(mn)
        :Space complexity: O(n)
        """
        dp = [0]*(amount+1)
        for i in range(1, amount+1):
            if i in coins:
                dp[i] = 1
                continue
            min_coins = float("inf")
            for coin in coins:
                if i-coin >= 0:
                    min_coins = min(dp[i-coin], min_coins)
            dp[i] = min_coins+1
        if dp[-1] == float("inf"):
            return -1
        return dp[-1]


        # """
        # Below soln gives time limit exceeded since exponential 
        # TC:O(2^n)
        # SC:O(n)
        # """
        
        # def coinChange(self, coins: List[int], amount: int) -> int:
    
        #     return self.helper(coins, amount, 0, 0)
        
        # def helper(self, coins, summ, index, mincoins):
        #     # base 
        #     if summ==0:
        #         return mincoins
        #     if summ<0 or index==len(coins):return -1
            
            
            
        #     # logic
        #     # choose
        #     case1 = self.helper(coins, summ-coins[index], index, mincoins+1)
            
        #     # not choose
        #     case2 = self.helper(coins, summ, index+1, mincoins)
            
        #     if case1==-1: return case2
        #     if case2==-1: return case1
        #     return min(case1, case2)
            

            