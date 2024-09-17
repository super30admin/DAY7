# APPROACH - 1 - GREEDY (MY APPROACH)
# Time Complexity : O(c log c), c is the length of the coins
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : NO (Greedy approach won't work here as what if we get the amount in least number of coins without the highest denominnation)
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Sort the coins in-place, in descending order.
# 2. Till amount is not 0, keep subtracting the highest denomination from it if it less than target, else move to the next denomination
# 3. If we get amount not 0 but less than the lowest denomination, then return -1.

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        if not coins:
            return -1
        
        coins.sort(reverse = True)
        count_coins = 0
        
        while amount != 0:
            for ind in range(len(coins)):
                if amount >= coins[ind]:
                    amount = amount - coins[ind]
                    count_coins += 1
                    break
                    
                elif ind == len(coins) - 1:
                    return -1
                
        return count_coins
            


# APPROACH 2: BRUTE FORCE SOLUTION (RECURSIVE)
# Time Complexity : O(2 ^ (t / min(n))) - t is the amount and n is the coins array
# Space Complexity : O(t / min(n)) - space taken by the recursive call stack space
# Did this code successfully run on Leetcode : NO (TIME LIMIT EXCEEDED)
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. It's a recursive. arguments: coins, remaining amount, index in coins list (current position), current count of coins used to reach target - remaining amount
# 2. Base case - if the remaining amount < 0 or reached end of coins list -> return -1
#                                - if the remaining amount == 0 -> return the count of coins
# 3. 2 cases: Don't choose the coin: the remaining amount and current count remains same, only coin index gets increemented.
#             Choose the coin : the new remaining amount will be old remaining amount - current coin value, current count gets increemented by 1 (as we used one coin here), 
#                                 but the coin ind remains same (as the same coin can be chosen again)
# 4. If either of the cases is invalid return the other. Else return minimum of above 2 cases.


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        return self.helper(coins, amount, 0, 0)
    
    def helper(self, coins, remaining_amt, coin_ind, curr_count):
        
        if remaining_amt < 0 or coin_ind >= len(coins):
            return -1
        
        if remaining_amt == 0:
            return curr_count
        
        # Dont choose the coin
        case_1 = self.helper(coins, remaining_amt, coin_ind + 1, curr_count)
        
        # Choose the coin
        case_2 = self.helper(coins, remaining_amt - coins[coin_ind], coin_ind, curr_count + 1)
        
        if case_1 == -1: 
            return case_2
        
        if case_2 == -1:
            return case_1
        
        return min(case_1, case_2)
            
 
# APPROACH 3: DYNAMIC PROGRAMMING
# Time Complexity : O(ac), a: amount and c: len(coins)
# Space Complexity : O(ac)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Create a 2-d array to store solution of all cases. Has (amount + 1) columns and len(coins) + 1 rows. Each cell will store minimum number of coins that sum up to
#     target (column)
# 2. 1st column is 0 as target column is 0. 1st row (from 1st column) is infinity as we have only 0 denomination coins.
# 3. Then for each cell, if target amount (column) < denomination -> then same as previous row's value
#                         Else, Cell value = min(previous row's value, 1 + optimal number of coins required for target - denomination(current))
# 4. last cell in the matrix is the final answer.


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        dp = [[None for _ in range(amount + 1)] for _ in range(len(coins) + 1)]
        
        for row in range(len(dp)):
            dp[row][0] = 0
            
        for column in range(1, len(dp[0])):
            dp[0][column] = float('inf')
            
        for row in range(1, len(dp)):
            for column in range(1, len(dp[0])):
                
                if column < coins[row - 1]:
                    dp[row][column] = dp[row - 1][column]
                    
                else:
                    dp[row][column] = min(dp[row - 1][column], 1 + dp[row][column - coins[row - 1]])
        
        if dp[-1][-1] == float('inf'):
            return -1
        else:
            return dp[-1][-1]
