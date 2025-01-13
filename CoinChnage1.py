# Time Complexity O(M *N) 
# Space complexity O(M *N)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # Initialize dp_array with "infinity" (amount + 1)
        dp_array = [[amount + 1] * (amount + 1) for _ in range(len(coins) + 1)]
        
        # Base case: zero amount requires zero coins
        for i in range(len(coins) + 1):
            dp_array[i][0] = 0
        
        # Fill the dp array
        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                if j < coins[i - 1]:  # Coin cannot be included
                    dp_array[i][j] = dp_array[i - 1][j]
                else:  # Choose the minimum of excluding or including the coin
                    dp_array[i][j] = min(dp_array[i - 1][j], 1 + dp_array[i][j - coins[i - 1]])
        
        # Final answer is in dp_array[len(coins)][amount]
        return dp_array[len(coins)][amount] if dp_array[len(coins)][amount] != amount + 1 else -1
