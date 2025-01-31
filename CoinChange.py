class Solution:
    def coinChange(self, coins: List[int], n: int) -> int:
        if not n:      return 0
        coins = [c for c in coins if c<=n]
        if not coins: return -1
        if len(coins) < 2:
            ret = n // coins[0]
            return -1 if n-ret*coins[0] else ret
        if n & 1 and not any(c & 1 for c in coins): return -1
        res = 1 << n 
        for i in range(1, n ):
            cur = res
            for coin in coins:
                res |= cur >> coin
            if res & 1:
                return i
            if cur == res: return -1