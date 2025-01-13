"""
Time Complexity: 0(2 ^ max(amount+len(coins)))
Space Complexity: 0(2 ^ max(amount+len(coins))
Approach: Choose Not Choose -- Going Exhaustive
"""
class Solution:

    def __chooseNotChoose(self, coins: List[int], idx: int, amount: int, coinsCount: int) -> int:
        
        # base-case
        if idx == len(coins):
            # out of index
            return float('inf')
        
        if idx < len(coins) and amount < 0:
            # amount is going -ve
            return float('inf')

        if idx < len(coins) and amount == 0:
            # amount is zero
            return coinsCount

        # logic-case

        # choose
        chooseCount = self.__chooseNotChoose(coins, idx, amount-coins[idx], coinsCount + 1)

        # not choose
        notChooseCount = self.__chooseNotChoose(coins, idx+1, amount, coinsCount)

        return min(chooseCount, notChooseCount)
        
    def coinChange(self, coins: List[int], amount: int) -> int:

        coinsCount = 0
        idx = 0

        result = self.__chooseNotChoose(coins, idx, amount, coinsCount)

        if result == float('inf'):
            return -1
        else:
            return result