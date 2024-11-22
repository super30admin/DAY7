# In this problem, after drawing the recursie tree, found that any x amount somewhere in the tree is getting calculated multiple times
# Using memoization to avoid calculating that
# Approach: we start with the base case amount 0 can be made with zero coins. at any point we get negative amount that means
# we have chosen the wrong coin so we return -1
# If we encounter the amount that has been precalculated then we return that
# otherwise after iterating through all coins we pick the path with coins that have minimum usage
# Time Complexity: O(amount* number of coins) where amount = depth of tree if we ended up with worse case of coin amount 1
# number of coins is the branching factor in the tree
# Space complexity: O(2*amount): one for memo array other for one recursive call
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        return self._coinchange(coins,amount,{})

    def _coinchange(self, coins: List[int], amount: int,memo) -> int:
        if amount == 0:
            return 0
        if amount < 0:
            return -1
        if amount in memo.keys():
            return memo[amount]
        min_coins = float("inf")
        for coin in coins:
            rem = amount - coin
            output = self._coinchange(coins,rem,memo)
            if output != -1:
                output += 1
                min_coins = min(output,min_coins)
        if min_coins == float("inf"):
            memo[amount] = -1
            return -1
        memo[amount] = min_coins
        return min_coins  

          