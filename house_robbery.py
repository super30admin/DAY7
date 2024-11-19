# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach

class Solution:
    def rob(self, nums: List[int]) -> int:
        skip=0
        take=0
        for i in range(len(nums)):
            temp=skip
            skip=max(skip,take)
            take=temp+nums[i]
        return max(skip,take)
        



        