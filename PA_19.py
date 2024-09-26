#Recursive Solution
#Time Complexity - Exponential
#Space Complexity - O(m) where m is the amount
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if not coins:
            return 0
        def helper(coins,amount,index,total):
            #base
            if amount == 0:
                return total
            if index >= len(coins) or amount < 0:
                return -1

            #logic
            #dont choose
            case1 = helper(coins,amount,index + 1,total)
            #choose
            case2 = helper(coins,amount-coins[index],index,total+1)
            if case1 == -1:
                return case2
            elif case2 == -1:
                return case1
            else:
                return min(case1,case2)
            
        return helper(coins,amount,0,0)


#Dynamic Programming Solution
#Time Complexity - O(m*n) where m is the number of coins and n is the amount
#Space Complexity - O(m*n) where m is the number of coins and n is the amount
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if not coins:
            return 0
        dp = []
        for i in range(len(coins)+1):
            dp.append([99999]*(amount+1))
        for i in range(len(dp)):
            dp[i][0] = 0
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j],1+dp[i][j-coins[i-1]])
        if dp[-1][-1] != 99999:
            return dp[-1][-1]
        return -1