from typing import List

class Solution:
   # Time O(m*n), Space O(m*n) - dp matrix runtime and size
   def coinChange(self, coins: List[int], amount: int) -> int:

    # create dp array
    dp = [[0 for _ in range (amount+1)] for _ in range (len(coins)+1)]

    # first row - make it impossible by initializing with amount + 1
    for j in range(1, amount+1):
        dp[0][j] = amount+1
    
    # build dp matrix
    for i in range(1, len(coins)+1):
        for j in range(1, amount+1):
            # available amount is less than coin denomination, no choose
            # get prev row denomination value in the same column or amount
            if(j < coins[i-1]):
                dp[i][j] = dp[i-1][j]
            # choose possible
            # no choose or, choose current coin and take output of remaining amount column in the same row-denomination
            else:
                dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])

    # impossible or infeasible output
    if(dp[len(coins)][amount] >= amount+1):
        return -1

    # feasible output
    return dp[len(coins)][amount]

if __name__ == "__main__":
    #
    # coins = list(map(int, input("coins :").split(" ")))
    # amount = int(input("amount :"))

    coins = [1, 2, 5]
    amount = 11

    object = Solution()
    answer = object.coinChange(coins, amount)

    print(f"Coins = {coins}, amount = {amount}")
    print(f"Mininum coin change number = {answer}") 
