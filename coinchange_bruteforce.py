# // Time Complexity :O(2^n)
# // Space Complexity :O(2^n)

class Solution:
    def __init__(self):
        self.res=inf
    def coinChange(self, coins: List[int], amount: int) -> int:
        self.helper(coins,0,amount,0)
        if self.res==inf:
            return -1
        return self.res
    def helper(self,coins,index,amount,num):
        #base
        if amount==0:
            self.res=min(self.res,num)
            return
        if amount<0 or index==len(coins):
            return
            
            
        #logic
        #choose
        self.helper(coins,index,amount-coins[index],num+1)
        #notchoose
        self.helper(coins,index+1,amount,num)