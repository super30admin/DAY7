# -*- coding: utf-8 -*-
"""
Created on Thu Jan  2 17:27:21 2020

@author: WELCOME
"""

class Solution:
    
    def coinChange(self, coins, amt):
        
        temp= self.helper(coins,amt,0,0)
        if temp==float('inf'):
            return -1
        else:
            return temp
    
    
    def helper(self,coins,amt,index,minimum):
        #Base case
        if index>=len(coins):
            return float('inf')
        if amt<0:
            return float('inf')
        if amt==0:
            return minimum


        #Choose
        case1=self.helper(coins,amt-coins[index],index,minimum+1)

        #NotChoose
        case2=self.helper(coins,amt,index+1,minimum)

        return min(case1,case2)
    
temp=Solution()
print(temp.coinChange([2,3,5],11))
