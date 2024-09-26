# -*- coding: utf-8 -*-
"""
Created on Thu Jan  2 18:54:26 2020

@author: WELCOME
"""
#Time Complexity is 0(N)
#Space Complexity is O(N)

class Solution:
    def rob(self, nums):
        choose=0
        notchoose=0
        for i in range(len(nums)):
            temp2=notchoose
            notchoose=max(choose,notchoose)
            choose=temp2+nums[i]
        return max(choose,notchoose)
    
temp=Solution()
print(temp.rob([1,3,5,6]))
            
            
            
        
        
    