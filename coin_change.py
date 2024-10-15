# Time complexity: O(n) 
# space complexity: O(m*n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins)
        n = amount
        # dp = [99999 for i in range(n+1)]
        dp = [0]*(n+1)

        for i in range(1,n+1):
            dp[i] = 99999

        for i in range(1,m+1):
            for j in range(1,n+1):
                # till amount is lesser than coin value only 0 case available
                if j < coins[i-1]:
                    dp[j] = dp[j]
                else:
                    dp[j] = min(dp[j], 1+ dp[j-coins[i-1]])
        if dp[n] >= 99999:
            return -1
        return dp[n]