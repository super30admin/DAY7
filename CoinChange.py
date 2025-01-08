class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # TC: O(length of coins * amount)
        # SC: O(length of coins * amount)
        if coins is None or len(coins) == 0:
            return -1
        dp = [[0]*(amount+1)]*(len(coins)+1)
        print(len(dp),len(dp[0]))
        for i in range(1,amount+1):
            dp[0][i] = amount +1
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j],1+dp[i][j-coins[i-1]])
        if dp[len(coins)][amount] == amount +1 :
            return -1
        return dp[len(coins)][amount]