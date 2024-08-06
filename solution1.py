# Time: O(n)
# space: O(n)

class Solution(object):
    def coinChange(self, coins, amount):
        # tabulation 
        tab = [99999 for i in range(amount + 1)]
        tab[0] = 0
        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                if j < coins[i - 1]:
                    tab[j] = tab[j]
                else:
                    tab[j] = min(tab[j], 1 + tab[j - coins[i - 1]])
        print(tab)
        if tab[amount] >= 99999:
            return -1
        return tab[amount]



        # recursive solution
    #     ret = self.helper(coins, 0, amount)
    #     if ret >= 9999:
    #         return -1
    #     else:
    #         return ret

    # def helper(self, coins, idx, amount):
    #     if amount < 0 or idx >= len(coins):
    #         return 9999
    #     if amount == 0:
    #         return 0
    #     print(amount)
    #     #choose
    #     case1 = 1 + self.helper(coins, idx, amount-coins[idx])
    #     # dont choose
    #     case2 = self.helper(coins, idx+1, amount)
    #     return min(case1, case2)
       