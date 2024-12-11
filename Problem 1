class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        def change(n):
            if F[n] != -1:
                return F[n]
            value = float('inf')
            for coin in coins:
                if coin <= n:
                    value = min(change(n-coin),value)
            F[n] = value + 1 if value != -1 else -1
            return F[n]
        if amount == 0:
            return 0
        F = [-1 for _ in range(amount+1)]
        F[0] = 0
        change(amount)
        return F[-1] if F[-1] != float('inf') else -1
