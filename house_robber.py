class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        : m = length of nums, n = 2
        : space complexity : O(m*n) or O(m)
        : time complexity : O(m)
        """
        
        row=len(nums)
        col = 2
        dp = [[0 for _ in range(col)]  for _ in range(row)]
        dp[0][1] = nums[0]
        dp[0][0] = 0
        for i in range(1, len(nums)):
            # not choose
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            
            # choose
            dp[i][1] = dp[i-1][0]+nums[i]
            
        return max(dp[-1][0], dp[-1][1])