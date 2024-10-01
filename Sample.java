// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Coin Change
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """

        row = len(coins) + 1
        col = amount + 1

        dp = [[0 for _ in range(col)] for _ in range(row)]

        for j in range(1,col):
            dp[0][j] = 9999999
        
        #table
        for i in range(1,row): //Time-Complexity=O(N^2)
            for j in range(1,col):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j],1 + dp[i][j - coins[i-1]])
        if(dp[row-1][col-1] > amount):
            return -1
        return dp[row-1][col-1]

//House Robber
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dp = [0]*(len(nums)+1)

        for i in range(1,len(nums)+1):
            dp[i] = -9999999999
        dp[1] = max(dp[0],nums[0])

        for i in range(2,len(nums)+1):    //Time-complexity=O(N)
            dp[i] = max(dp[i-1],nums[i-1]+dp[i-2])
        print(dp)
        return dp[len(nums)]