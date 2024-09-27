class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==0:
            return 0
        

        dp=[0]
        dp.append(nums[0])
        def recur(dp,nums):
            val = 0
            for i in range(2,len(nums)+1):
                dp.append(max(dp[i-1],dp[i-2]+nums[i-1]))
            return dp[len(dp)-1]
        return recur(dp,nums)