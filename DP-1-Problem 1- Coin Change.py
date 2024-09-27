"""
 FAANMG Problem #20 {Medium}

322. Coin Change


Time Complexity : O(MN)
 

Space Complexity : O(MN)

M = Number of coins
N = Amont denomination

Did this code successfully run on Leetcode : Yes


2D matrix is used to store the number of coins based on the amount chnages
the column represent the amount from 0
and the row consist of the didderent coins

The value of a particular cell is calculatesed as follows:
    
For the value of Jth column and ith row 
  untill j < coins[i-1]): dp[i][j] = dp[i-1][j] the value from above row
    else:
       the minimum of above value and the value 1 + dp[i][j- coins[i-1]]
       
             dp[i][j] = min(dp[i-1][j], 1 + dp[i][j- coins[i-1]])
    
@name: Rahul Govindkumar_RN27JUL2022
"""


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        
        if(len(coins)==0):
            return 0
        
        m = len(coins)
        n = amount
        
        
        dp = [[0]*(n+1) for i in range (m+1)]
        
        #top row
        for j in range(1,n+1):
            dp[0][j] = amount +1
            
  
        
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                
                #till the amount is not equal to the domination
                
                if(j < coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j- coins[i-1]])
                    

        result = dp[m][n]
        
        if(result > amount):
            return -1
        
        return result


"""
 FAANMG Problem #20 {Medium}

322. Coin Change


Time Complexity : O(MN)
 

Space Complexity : O(N)


Did this code successfully run on Leetcode : Yes



Above soln but using 1D array of size N eqaul to the amount count
     
@name: Rahul Govindkumar_RN27JUL2022
"""
              
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        
        if(len(coins)==0):
            return 0
        
        m = len(coins)
        n = amount
        
        
        dp = [0]*(n+1)
        
        #top row
        for j in range(1,n+1):
            dp[j] = amount +1
            
  
        
        for i in range(m):
            for j in range(1,n+1):
                
                #till the amount is not equal to the domination
                
                if(j >= coins[i-1]):
                    dp[j] = min(dp[j], 1 + dp[j- coins[i-1]])
                    

        result = dp[n]
        
        if(result > amount):
            return -1
        
        return result
                
                
        
        
        