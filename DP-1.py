# DP-1

## Problem1 (https://leetcode.com/problems/coin-change/)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins == None or len(coins) == 0:
            return -1
        n = len(coins)
        dp = [[0]*(amount+1)]*(n+1)
        for i in range(1, amount+1):
            dp[0][i] = amount +1
        for i in range(n+1):
            for j in range(amount+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]])
        if dp[n][amount] == amount +1:
            return -1
        return dp[n][amount]
# TC = O(m*n), SC =O(m*n)

## Problem2 (https://leetcode.com/problems/house-robber/)

class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums == None or len(nums)==0:
            return 0
        n = len(nums)
        skip = 0
        take = nums[0]
        for i in range(1,n):
            temp = skip
            skip = max(skip, take)
            take = temp + nums[i]            
        return max(skip, take)

#TC =O(n), SC =O(1)

