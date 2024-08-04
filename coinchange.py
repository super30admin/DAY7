# TC : O(2^m+n)  m is the amount and n is the total coins
# SC : O(m + n)

class Solution:
    def helperCoinChange(self,coins, amount, idx):
        #base case
        if (amount == 0):
            return 0

        if (amount < 0 or idx == len(coins) ):
            return 99999
        
        # when we choose the coin
        choose_coin = 1 + self.helperCoinChange(coins, amount - coins[idx], idx)

        # when we do not choose the coin
        not_choose_coin = self.helperCoinChange(coins, amount, idx + 1)

        return min(choose_coin, not_choose_coin)


    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins == []:
            return -1

        if amount == 0:
            return 0

        result = self.helperCoinChange(coins, amount, 0)
        if result == 99999:
            result = -1

        return result