# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
Used two temporary variables to calculate the repeated subroblems and finally reused them to form the solution


class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == None or len(nums) == 0:
            return 0
        n = len(nums)
        rob = nums[0]
        notrob = 0
        for i in range(1,n):
            temp = rob
            rob = notrob + nums[i]
            notrob = max(temp,notrob)
            
        return max(rob,notrob)
            
                
            
            
        
        