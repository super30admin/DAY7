'''
Recursive solution
class Solution:
    def recurse(self, coins, i, amount, coinsUsed):
        #base case
        if i==len(coins) or amount<0:
            return -1
        if amount==0:
            return coinsUsed
        #do not pick
        no_pick = self.recurse(coins,i+1,amount,coinsUsed)
        #pick
        pick = self.recurse(coins,i,amount-coins[i],coinsUsed+1)
        if pick==-1:
            return no_pick
        elif no_pick==-1:
            return pick
        return min(no_pick,pick)
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not coins:
            return 0
        return self.recurse(coins, 0, amount,0)
        
'''
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not coins:
            return -1
        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        for i in range(1,amount+1):
            dp[0][i] = amount + 1
        for j in range(len(coins)+1):
            dp[j][0] = 0
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]])
        if dp[len(coins)][amount] == amount+1:
            return -1
        else:
            return dp[len(coins)][amount]
        