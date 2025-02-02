# The algorithm uses dynamic programming to find the minimum number of coins needed to make up a given amount by iterating
#  through each coin and updating the minimum coins required for each sub-amount. If the target amount is unreachable, 
#  it returns -1; otherwise, it returns the minimum coins required.

# Time: O(N * M) (N = amount, M = number of coins) | Space: O(N).
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        min_coins = [amount + 1] * (amount + 1)
        min_coins[0] = 0 
        for i in range(1, amount + 1):
            for c in coins:
                if i - c >= 0:
                    min_coins[i] = min(min_coins[i], 1 + min_coins[i - c])
        return min_coins[-1] if min_coins[-1] != amount + 1 else -1