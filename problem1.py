# Time Complexity : O(amount*len(coins))
# Space Complexity : O(amount + len(coins))
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach
import math
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        cache = {}
        
        # Approach 1 --> len(coins) branches for each amount node
        def dfs(remaining):
            if remaining in cache:
                return cache[remaining]
            if remaining == 0:
                return 0
            elif remaining < 0:
                return math.inf
            
            res = math.inf
            for coin in coins:
                res = min(res, dfs(remaining - coin) + 1)
            
            cache[remaining] = res
            return res
        
        res = dfs(amount)

        # Approach 2 --> 0/1 at each coin index
        memo = {}
        def search(ix, amount):
            if (ix, amount) in memo:
                return memo[(ix,amount)]
            # base case
            if ix == len(coins) or amount < 0:
                return math.inf
            if amount == 0:
                return 0
            # logic
            choose = search(ix, amount - coins[ix]) + 1
            # don't choose
            _choose = search(ix+1, amount)

            memo[(ix,amount)] = min(choose, _choose)

            return memo[(ix,amount)]
        
        res = search(0,amount)

        return res if res != math.inf else -1