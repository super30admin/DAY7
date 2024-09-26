# -*- coding: utf-8 -*-
"""
Created on Thu Jan  2 16:29:38 2020

@author: WELCOME
"""

class Solution:
    def coinChange(self, coins, amt):
        list1=[]
        for i in range(len(coins)+1):
            list2=[]
            for j in range((amt)+1):
                list2.append(9999)
            list1.append(list2)
        for i in range(len(coins)+1):
            list1[i][0]=0
            
        for i in range(1,len(coins)+1):
            for j in range(1,(amt)+1):
                if j<coins[i-1]:
                    list1[i][j]=list1[i-1][j]
                else:
                    list1[i][j]=min(list1[i-1][j],list1[i][j-coins[i-1]]+1)
                    
        if list1[-1][-1]>=9999:
            return -1
        else:
            return list1[-1][-1]
                    
                    
            
            
        
temp=Solution()
print(temp.coinChange([1,2,6],11))
                
        
        
        