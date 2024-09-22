# time complexity : O(mn)
# space Complexity : O(mn)
# m = number of coins
# n = total amount
class Solution:

    # exhaustive
    def coinChange1(self, coins, amount) -> int:
        return self.helper(coins,0,amount,0)
    
    def helper(self,coins, i, amount, minCoins):
        # base
        if amount == 0:
            return minCoins
        if amount<0 or i == len(coins):
            return -1
        # logic
        # choose 
        case1 = self.helper(coins,i,amount-coins[i],minCoins+1)
        # not choose
        case2 = self.helper(coins,i+1,amount,minCoins)
        if case1 == -1:
            return case2
        if case2 == -1:
            return case1
        return min(case1,case2)



        
    # dp 
    def coinChange(self, coins, amount) -> int:
        m = len(coins)
        n = amount
        dp = [[0 for i in range(n + 1)] for j in range(m + 1)]
        
        for j in range(1,len(dp[0])):
            dp[0][j] = 99999

        for i in range(1,len(dp)):
            for j in range(1,len(dp[i])):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j],1+dp[i][j-(coins[i-1])])
       
        if dp[m][n] >= 99999:
            return -1

        return dp[m][n]

obj = Solution()
print(obj.coinChange([1,2,5],11))

