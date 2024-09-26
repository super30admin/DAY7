# -*- coding: utf-8 -*-
"""
Created on Thu Jan  2 18:54:26 2020

@author: WELCOME
"""
#Time Complexity is 0(N)
#Space Complexity is O(N)

class Solution:
    def rob(self, nums):
        list1=[]
        for i in range(len(nums)+1):
            list1.append([0,0])
        for i in range(1,len(nums)+1):
            list1[i][0]=max(list1[i-1][0],list1[i-1][1])
            list1[i][1]=list1[i-1][0]+nums[i-1]
            
        return max(list1[-1][0],list1[-1][1])
    
temp=Solution()
print(temp.rob([1,3,5,6]))
            
            
            
        
        
    