# // Time Complexity :O(2^n)
# // Space Complexity :O(2^n)

class Solution:
    def __init__(self):
        self.s=-inf
    def rob(self, nums: List[int]) -> int:
        self.helper(nums,0,0)
        return self.s
    def helper(self,nums,index,s):
        #base
        if index>=len(nums):
            self.s=max(self.s,s)
            return
        #logic
        
        #choose
        self.helper(nums,index+2,s+nums[index])
        
        #not choose
        self.helper(nums,index+1,s)
        