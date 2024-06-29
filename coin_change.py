#brute force - exhaustive approach

def coin_change(coins, amount):
    def helper(coins, amount):
        # Base cases
        if amount == 0:
            return 0
        if amount < 0:
            return float('inf')
        
        # Recursive case
        min_coins = float('inf')
        for coin in coins:
            result = helper(coins, amount - coin)
            if result != float('inf'):
                min_coins = min(min_coins, result + 1)
        
        return min_coins
    
    result = helper(coins, amount)
    return result if result != float('inf') else -1

# Example usage
coins = [1, 2, 5]
amount = 11
print(coin_change(coins, amount))  # Output: 3 (11 = 5 + 5 + 1)