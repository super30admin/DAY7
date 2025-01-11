# Time - O(mn), m = num of coins, n = amount
# Space - O(mn) 
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # m = len(coins)
        # dp_arr = [[0] * (amount + 1)] * (m + 1) # Extra row and column
        # dp_arr[0][1:] = [amount + 1] * amount # Max value can also be stored # Fill the dummy row
        # for i in range(1,m+1):
        #     for j in range(amount + 1):
        #         if j < coins[i - 1]: #//0 case where amount < coin denomination -> we just take value from above
        #             dp_arr[i][j] = dp_arr[i-1][j] 
        #         else:
        #             dp_arr[i][j] = min(dp_arr[i-1][j],1 + dp_arr[i][j - coins[i - 1]]) # 1 case
        
        # # Edge Case [2] with amount 3 see notes
        # if dp_arr[m][j] > amount:
        #     return -1
        
        # return dp_arr[m][j]
    
    # -------------------------Optimized Space from O(mn) to O(n) by using 1D array---------------------------
        m = len(coins)
        dp_arr = [0] * (amount + 1) # 
        dp_arr[1:] = [amount + 1] * amount # Max value can also be stored # Fill the dummy row
        for i in range(1, m+1):
            for j in range(amount + 1):
                if j < coins[i - 1]: #//0 case where amount < coin denomination -> we just take value from above
                    dp_arr[j] = dp_arr[j] 
                else:
                    dp_arr[j] = min(dp_arr[j],1 + dp_arr[j - coins[i - 1]]) # 1 case
        
        # Edge Case [2] with amount 3 see notes
        if dp_arr[j] > amount:
            return -1
        return dp_arr[j]
        