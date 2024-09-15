from typing import List

"""

    Student : Shahreen Shahjahan Psyche

    Brute-Force/Recursive:
        Time Complexity : O(2^n)
        Space Complexity : O(n)
    This solution faced time limit exceeded error in Leetcode

    Dynammic Programming:
        Time Complexity : O(mn)
        Space Complexity : O(mn)
    This solution passed all the test cases in Leetcode


"""

class Solution:
      
    # This is the recursive/brute force method
    def _helper_bf(self, coins, amount, index, min_val):
        
        # base case
        if amount < 0 or index > len(coins) - 1:
            return -1
        if amount == 0:
            return min_val
        
        # zero-action/one-action
        case1 = self._helper_bf(coins, amount, index+1, min_val)
        case2 = self._helper_bf(coins, amount - coins[index], index, min_val+1)
        
        # If case1 is not possible then we are returning case2
        if case1 == -1:
            return case2
        # If case2 is not possible them we are returning case1
        if case2 == -1:
            return case1
        
        # If both of the cases are possible then we are taking the minimum value between two
        min_val = min(case1, case2)
        
        return min_val
    
    # This is the DP method
    def _helper_dp(self, coins, amount):
        
        # Saving the dimension of the matrix in m and n
        m = len(coins) + 1
        n = amount + 1
        
        # Initializing the matrix with 0
        records = [[0 for _ in range(n)] for _ in range(m)] 
        
        # The first column amount is 0. Thats why the minumum number needed in first column will always be 0.
        for i in range(m):
            records[i][0] = 0
        
        # Until we reach the amount equal or greater than the current coin, we should just copy the zero case. Cause, one case is not
        # possible before that
        for j in range(n):
            records[0][j] = n
        
        # Here, we start storing our matrix values depending on the minimum value from either zero case or one case
        for i in range(1, m):
            for j in range(1, n):
                if j < coins[i-1]:
                    records[i][j] = records[i-1][j]
                else:
                    records[i][j] = min(records[i-1][j], records[i][j - coins[i-1]]+1)
        if records[m-1][n-1] >= amount+1:
            return -1
        return records[m-1][n-1]
                    
    
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        # base case
        if amount == 0 :
            return 0
        if coins == None or len(coins) == 0:
            return -1
        
        # brute force method calling
        min_val = self._helper_bf(coins, amount, 0, 0)
        # dp method calling
        min_val = self._helper_dp(coins, amount)
        
        
        return min_val
        
        
        
        
        