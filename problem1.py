'''
## Problem1 (https://leetcode.com/problems/coin-change/)

Solution1: Exhaustive Recurssion
TC: O(2^n)
SC: O(n) due to recursive stack
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : handling base cases

Solution2: Dynamic programming
TC: O(n^2) filling up 2-D matrix
SC: O(n^2) 2-D matrix 
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
'''

#-----------------------Exhaustive Recurssion-----------------------

class Solution1:
  def coinChange(self, coins, amount):
    if coins == None or len(coins) == 0 or amount < 0:
      return -1

    minCoins = self.minCoinsRecursion(coins, amount, 0)

    if minCoins > amount:
      return -1

    return minCoins

  def minCoinsRecursion(self, coins, amount, idx):
    #base cases
    if idx == len(coins) or amount < 0:
      return float('inf') #equivalent to Infinity or MAX_INTEGER value
    if amount == 0:
      return 0
    
    #recursion logic
    case0 = self.minCoinsRecursion(coins, amount, idx + 1)
    case1 = self.minCoinsRecursion(coins, amount - coins[idx], idx) + 1

    return min(case0, case1)
  
#-----------------------Dynamic programming-----------------------

class Solution2:
  def coinChange(self, coins, amount):
    if coins == None or len(coins) == 0 or amount < 0:
      return -1

    matrix = [[0 for i in range(amount + 1)].copy() for i in range(len(coins) + 1)]

    for col in range(1, amount + 1):
      matrix[0][col] = amount + 1

    for coinIdx in range(1, len(coins) + 1):
      for amtVal in range(1, amount + 1):
        if coins[coinIdx - 1] > amtVal:
          matrix[coinIdx][amtVal] = matrix[coinIdx - 1][amtVal]
        else:
          matrix[coinIdx][amtVal] = min(matrix[coinIdx - 1][amtVal], matrix[coinIdx][amtVal - coins[coinIdx - 1]] + 1)
    
    if matrix[len(coins)][amount] > amount:
      return -1

    return matrix[len(coins)][amount]

coins1 = [1, 2, 5]
amount1 = 15

coins2 = [1, 2, 3]
amount2 = 20

coins3 = [5, 10]
amount3 = 53

coins4 = [1, 2, 3, 5]
amount4 = 534

coins5 = [1, 2, 3, 5, 50, 100]
amount5 = 53442

coins6 = [5, 10]
amount6 = 53447

s1 = Solution1()
s2 = Solution2()
print('Using Exhaustive recursion:')
print()
print('Minimim coins required to form {} using values {} is {}.'.format(amount1, coins1, s1.coinChange(coins1, amount1)))
print('Minimim coins required to form {} using values {} is {}.'.format(amount2, coins2, s1.coinChange(coins2, amount2)))
print('Minimim coins required to form {} using values {} is {}.'.format(amount3, coins3, s1.coinChange(coins3, amount3)))
print()

print('Using Dynamic programming:')
print()
print('Minimim coins required to form {} using values {} is {}.'.format(amount4, coins4, s2.coinChange(coins4, amount4)))
print('Minimim coins required to form {} using values {} is {}.'.format(amount5, coins5, s2.coinChange(coins5, amount5)))
print('Minimim coins required to form {} using values {} is {}.'.format(amount6, coins6, s2.coinChange(coins6, amount6)))
