"""
// Time Complexity :O(m * n) m = coin denomination and n = amount
// Space Complexity :O(m * n) recursive stack. RECURSION DOES NOT RUN IN PARALLEL
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NA

//Explanation:
#bf description: two cases either choose coin or not choose coin.
return the min of case1 or case2

# dp solution: Build dp matrix. If the coin denomination > amount i.e
if the amount can not be made using coin denomination, copy the previous row result.
else calculate the min between previous row and 1 (coin required
for that coin denomination) + coin required for the amount - coin_denom-> Go that
steps back.
"""
# DP solution: T = O(m*n) S = O(m*n)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
      if coins is None or len(coins) == 0: return

      rows,columns = len(coins) + 1, amount + 1
      dp = [[0 for i in range(columns)] for j in range(rows)]
      for i in range(1, len(dp[0])):
        dp[0][i] = 999

      for r in range(1, len(dp)):
        for c in range(1,len(dp[0])):
          if c < coins[r - 1]:
            dp[r][c] = dp[r-1] [c]
          else:
            dp [r][c] =min(dp[r-1] [c], 1+dp[r][c -coins[r-1]])
      #print(dp)
      result = dp[len(coins)][amount]
      return -1 if result >= 999 else result
"""
// Time Complexity :O(2^m+n) m = coin denomination and n = amount
// Space Complexity :O(2^m+n)

#recursive solution
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
      if len(coins) == 0 or coins is None: return -1
      else:
        return self.helper(coins,amount,0,0)

    def helper(self,coins, amount, i, count):
      # base case
      if amount == 0: return count
      if amount < 0 or i == len(coins) : return -1

      # main logic
      # choose coin
      case1 = self.helper(coins,amount-coins[i],i,count+1)

      # not choose coin
      case2 = self.helper(coins,amount,i+1, count)

      if case1 == -1: return case2
      elif case2 == -1 : return case1
      return min(case1,case2)
"""
if __name__ =="__main__":
  s = Solution()
  print(s.coinChange([1,2,5],11))
