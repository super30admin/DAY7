// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: using a dp list and checking for max sum of current and i-2 or i-3 numbers.


class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        
        dp = [-1]*(len(nums))
        
        dp[0] = nums[0]
        if len(nums)>1:
            dp[1] = nums[1]
        if len(nums)>2:
            dp[2] = nums[2]+nums[0]
        
        for i in range(3, len(nums)):
            dp[i] = max(nums[i]+dp[i-2], nums[i]+dp[i-3])
            
        return max(dp)
