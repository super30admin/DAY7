class Solution:
    def coinChange(self, coins: List[int], amount: int, memo = None) -> int:
        if memo is None:
            memo = {}
        
        if amount == 0: 
            return 0  # Base case: no coins needed for amount 0
        
        if amount < 0: 
            return -1  # Invalid case: cannot make change for negative amounts
        
        if amount in memo: 
            return memo[amount]  # Return the result if already computed
        
        shortestComb = None
        
        for coin in coins:
            rem = amount - coin
            remComb = self.coinChange(coins, rem, memo)
            if shortestComb:
                if remComb != -1:  # Valid solution found for the remaining amount
                    shortestComb = min(shortestComb, remComb + 1)
            else: shortestComb = remComb + 1
        # Memoize the result
        if shortestComb:
            memo[amount] = shortestComb 
        else: memo[amount] = -1
        
        return memo[amount]
