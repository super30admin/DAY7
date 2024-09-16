# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


# // Your code here along with comments explaining your approach


# class Solution:
#     def rob(self, nums: List[int]) -> int:

#         #If the length is 0 or empty list
#         if nums==None or len(nums)==0:
#             return 0
        
#         #If the length is only 1 then return the only element
#         if len(nums)==1:
#             return nums[0]
        

#         n=len(nums)
#         #Create an array of length n
#         dp=[0]*n

        
#         dp[0]=nums[0]
#         #The 1st number will be the max between itself and the 0th number
#         dp[1]=max(nums[0],nums[1])
        
#         for i in range(2,n):
#             #It will be either the max between previous element or the sum of elemnt 2 step back
#             dp[i]=max(dp[i-1],nums[i]+dp[i-2])
        

#         #Returning the elemnt n-1 because we added the 0th index
#         return dp[n-1]


# Approach using only 2 points and no additional array

class Solution:
    def rob(self, nums: List[int]) -> int:

        #If the length is 0 or empty list
        if nums==None or len(nums)==0:
            return 0
        
        #If the length is only 1 then return the element
        if len(nums)==1:
            return nums[0]
        
        n=len(nums)
        
        prev=nums[0]
        #curr pointer will be the max of prev and the current
        curr=max(prev,nums[1])
        
        for i in range(2,n):
            temp=curr
            #It will be either the max between previous element or the sum of elemnt 2 step back
            curr=max(curr,nums[i]+prev)
            #moving the prev to the curr position
            prev=temp
            
        return curr