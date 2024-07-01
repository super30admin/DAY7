"""
## Problem1 (https://leetcode.com/problems/coin-change/)
"""

#Approach - 1: using exhaustive approach and trying every coins to get the result.
# TC : O(2^m+n)  m is the amount and n is the total coins
# SC : O(m + n)

class Solution:
    def helperCoinChange(self,coins, amount, idx):
        #base case
        if (amount == 0):
            return 0
        
        if (amount < 0 or idx == len(coins) ):
            return 99999
        
        #Logic
        # when we choose the coin
        choose_coin = 1 + self.helperCoinChange(coins, amount - coins[idx], idx)
        
        # when we do not choose the coin
        not_choose_coin = self.helperCoinChange(coins, amount, idx + 1)
        
        return min(choose_coin, not_choose_coin)
        
        
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins == []:
            return -1
        
        if amount == 0:
            return 0
        
        result = self.helperCoinChange(coins, amount, 0)
        if result == 99999:
            result = -1
        
        return result
        
#Approach - 2 DP matrix TC: O(N*M) ; SC: O(M)



class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        rows = len(coins) + 1
        col = amount + 1
        matrix = [[float("inf") for _ in range(col)] for _ in range(rows)]
        
        for i in range(rows):
            matrix[i][0] = 0
            
        for r in range(1, rows):
            for c in range(1, col):
                if c < coins[r-1]:
                    matrix[r][c] = matrix[r-1][c]
                else:
                    matrix[r][c] = min(matrix[r-1][c], 1 + matrix[r][c - coins[r-1]])
                    
        result = matrix[rows-1][col-1]
        
        if result == float("inf"):
            return -1
                    
        return result


