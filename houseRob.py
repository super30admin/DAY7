# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


class Solution:
    def rob(self, nums) -> int:
        if len(nums)==0:
            return 0
        dp = [0]*(len(nums)+1)
        
        dp[0] = 0
        dp[1] = nums[0]
        
        for i in range(1,len(nums)):
            dp[i+1] = max(dp[i],dp[i-1]+nums[i])
        
        return dp[-1]
        
obj = Solution()
house = [1,2,3,1]
print(obj.rob(house))