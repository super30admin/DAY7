# Time complexity: O(m*n)
# Space complexity: O(m)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)
        m = amount
        dp = [0 for j in range(m+1)]
        #print(dp)
        for j in range(1, m+1):
            dp[j] = amount+1
        #print(dp)
        for i in range(1, n+1):
            for j in range(1, m+1):
                #case1 available
                # till the time amount < denomination of curr coin
                if coins[i-1] > j:
                    #no choose
                    dp[j] = dp[j]
                else:
                    # choose
                    dp[j] = min(dp[j], 1+ dp[j-coins[i-1]])
        if dp[m] >= amount+1:
            return -1
        else:
            return dp[m]

