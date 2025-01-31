'''
Time Complexity :
O(n2)
Space Complexity : O(n)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
'''
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=len(nums)
        dp=[0]*n
        dp[0]=nums[0]
        if n>1:
            dp[1]=nums[1]
        for i in range(2,n):
            dp[i]=max(dp[:i-1])+nums[i]
        
        return max(dp)