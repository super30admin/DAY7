# time: O(amount*coins)
# space: O(amount*coins)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = []

        for i in range(len(coins)+1):
            if i == 0:
                dp.append([amount+1]*(amount+1))
            else:
                dp.append([0]*(amount+1))

        dp[0][0] = 0

        for coin in range(1, len(coins)+1):
            for amt in range(1, amount+1):
                if amt < coins[coin-1]:
                    dp[coin][amt] = dp[coin-1][amt]
                else:
                    dp[coin][amt] = min(dp[coin-1][amt], 1+ dp[coin][amt - coins[coin-1]] )

        if dp[-1][-1]>amount:
            return -1
        return dp[-1][-1]
        