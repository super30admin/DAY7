#Approach
# Every time we will choose or not choose the element if we choose same index will be passed to next
#recursive call else pass the next index to next recursive call and find the min.


# complexities
#Time Complexity : O(m*n)
#Space Complexity : O(1)

from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        result = self.helper(coins, amount, 0)
        return result if result != float("inf") else -1

    def helper(self, coins, amount, index):

        if amount < 0 or index>=(len(coins)):
            return float("inf")
        elif amount == 0:
            return 0


        case0 = self.helper(coins,amount,index+1)
        case1 = self.helper(coins,amount-coins[index],index)
        if case1 != float("inf"):
            case1+=1
        return min(case0,case1)


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        result = self.helper(coins, amount, 0)
        return result if result != float("inf") else -1

    def helper(self, coins, amount, index):
        n = len(coins) + 1
        dp = [[float("inf")] * (amount + 1)] * n

        for i in range(len(dp)):
            dp[i][0] = 0

        for i in range(1, n):
            for j in range(1, (amount + 1)):
                case0 = dp[i - 1][j]
                case1 = float("inf")
                if j - coins[i - 1] >= 0:
                    case1 = 1 + dp[i][j - coins[i - 1]]
                dp[i][j] = min(case0, case1)

        return dp[n - 1][amount]
