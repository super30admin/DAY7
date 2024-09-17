#Time Complexity:O(m*n),m = length of the coins arrayl,n = amount
#Space Coplexity:O(n)
#Ran successfully on Leetcode:Yes
#Difficulties faced: Understanding dynamic programming

#dp[i] will be storing the number of solutions for 
# value i. We need n+1 rows as the table is constructed 
# in bottom up manner using the base case (n = 0) 
# Initialize all dp values as 0.


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [0]*(amount+1)
        if not amount:
            return 0
    # Pick all coins one by one and update the dp[] values 
    # after the index greater than or equal to the value of the 
    # picked coin 
        for i in range( amount+1):
            if i in coins:
                dp[i] = 1#Base case (If given value is 0) 
                continue
            min_coins = float("inf")
            for coin in coins:
                if i-coin >= 0:
                    min_coins = min(dp[i-coin], min_coins)
            dp[i] = min_coins+1
        if dp[-1] == float("inf"):
            return -1
        return dp[-1]
        
