#Space Complexity : O(N*M)
#Time Complexity : O(N*M)
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if len(coins) ==0:
            return 0
        dp = [[0 for x in range(amount+1)] for x in range(len(coins)+1)] 
  
        for i in range(len(dp[0])): 
            dp[0][i] = 9999
            
        for i in range(1, len(dp)): 
                for j in range(1,len(dp[0])): 
                    if j < coins[i-1]:
                        dp[i][j] = dp[i-1][j]
                    else:
                        dp[i][j] = min(dp[i-1][j],1+dp[i][j-coins[i-1]])
        
        
        result = dp[len(dp)-1][len(dp[0])-1]
        if  result >=9999:
            return -1
        else:
            return result