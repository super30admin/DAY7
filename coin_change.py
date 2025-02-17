class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        

        # def helper(coins,idx,amount):

        #     if idx>=len(coins) or amount<0:
        #         return 99999
            
        #     if amount==0:
        #         return 0
            
        #     return min(1+helper(coins,idx,amount-coins[idx]),helper(coins,idx+1,amount))
        # if helper(coins,0,amount)==99999:
        #     return -1
        
        # return helper(coins,0,amount)


        dp_array = [99999]*(amount+1)

        dp_array[0]=0

        for i in range(1,len(dp_array)):
            for coin in coins:
                if i>=coin:
                    dp_array[i] = min(1+dp_array[i-coin],dp_array[i])
                
        

        if dp_array[-1]==99999:
            return -1
        
        return dp_array[-1]


