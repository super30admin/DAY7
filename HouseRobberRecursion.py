# -*- coding: utf-8 -*-
"""
Created on Thu Jan  2 18:54:26 2020

@author: WELCOME
"""

class Solution:
    def rob(self, nums):
        return self.helper(nums,0,0)
        
        
    
    def helper(self,nums,index,maximum):
        
        if index>=len(nums):
            return maximum
        
        
        #Choose
        choose=self.helper(nums,index+2,maximum+nums[index])
        
        #Not Choose
        notchoose=self.helper(nums,index+1,maximum)
        
        return max(choose,notchoose)
    
temp=Solution()
print(temp.rob([1,3,5,6]))
    