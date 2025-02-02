
#  Time Complexity : O(n)
#  Space Complexity :O(1)
#  Did this code successfully run on Leetcode :Yes
#  Any problem you faced while coding this : No

class Solution:
    def rob(self, nums: List[int]) -> int:
        prev = nums[0]

        if len(nums) >=2:
            curr = max(nums[0],nums[1])
        
        for i in range (2,len(nums)):
            temp = curr
            curr = max(nums[i]+prev , temp)
            prev = temp
        return curr