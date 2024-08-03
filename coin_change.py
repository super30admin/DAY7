import sys
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # time complexity -O(mxn)
        # space complexity -O(mxn)
        m = len(coins)
        n = amount
        dp = [[0]*(n+1) for j in range(m+1)] 
        for j in range(1, n+1):
            dp[0][j] = sys.maxsize

        for i in range(1, m+1):   
            for j in range(1, n+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j],1+ dp[i][j-coins[i-1]])    
        return dp[m][n] if dp[m][n] < sys.maxsize else -1


        # optimized space to O(n) 
        # time complexity -O(mxn)
        #     def coinChange(self, coins: List[int], amount: int) -> int:
        # m = len(coins)
        # n = amount
        # dp = [0]*(n+1) 
        # for j in range(1, n+1):
        #     dp[j] = sys.maxsize

        # for i in range(1, m+1):   
        #     for j in range(1, n+1):
        #         # if j < coins[i-1]:
        #         #     dp[j] = dp[j]
        #         # else:
        #         if j >= coins[i-1]:
        #             dp[j] = min(dp[j],1+ dp[j-coins[i-1]])    
        # return dp[n] if dp[n] < sys.maxsize else -1


        # recursive Time complexity - 2^n
        # Space complexity - O(n) 
        def helper(coins, index, amount):
            # base 
            if (amount < 0 or index == len(coins)-1): 
                return sys.maxsize
            if (amount == 0): return 0 #valid path

            # dont choose
            case1 = helper(coins, index + 1, amount)
            case2 = 1 + helper(coins, index, amount - coins[index])
            return min(case1, case2)
    
        val = helper(coins, 0, amount)
        return val if val< sys.maxsize else -1

        