# Bottom up approach
# initialize an array of the size of amount
# iterate through coisn list, if there is a minimum value, update our amount array

# Time Complexity - O(n)
# Space Complexity - O(amount) i.e constant 

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        dp = [amount + 1] * (amount + 1)

        dp[0] = 0
        
        for a in range(1, amount +1):
            for c in coins:
                if a >= c:
                    dp[a] = min(dp[a], 1 + dp[a - c])

        if dp[amount] != amount + 1:
            return dp[amount]
        else:
            return -1
