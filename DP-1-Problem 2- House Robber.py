"""

 FAANMG Problem #21 {Easy}

198. House Robber

Time Complexity : O(N)
 

Space Complexity : O(1)


Did this code successfully run on Leetcode : Yes


We are using two pointers curr and prev

As the condition states:
     return the maximum amount of money you can rob  by choosing the alterantive houses to avoid alarns
    
So the max of max( curr , prev + nums[i]) is calculated

where for I
 curr is i-1
 prev = i-2
@name: Rahul Govindkumar_RN27JUL2022
"""



class Solution:
    def rob(self, nums: List[int]) -> int:
        
        n = len(nums)
        
   
        
        if(n==1):
            return nums[0]
        
        prev=nums[0]
        curr = max( nums[0] , nums[1])
        
        for i in range (2,n):
            temp =curr
            curr = max( curr , prev + nums[i])
            prev = temp
            
        return curr