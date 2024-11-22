# we start with base case of robbing the house if there is only one house or 2 (in which case we take the maximum)
# After that at any point we see if we choose the ith house then we can only leverage the collected amount until i-1 
# because we can't take adjacent house and if we drop the ith house then we can take the solution upto i-1th house
# we take the max of both
# Time complexity: O(n)
# Space complexity: O(n)
class Solution:
    def rob(self, nums: List[int]) -> int:
        num_len = len(nums)
        dp =[0 for i in range(num_len)]
        dp[0] = nums[0]
        if len(nums) == 1:
            return nums[0]
        dp[1] = max(nums[0],nums[1])
        for i in range(2,num_len):
            dp[i] = max(dp[i-1],dp[i-2] + nums[i])
        return dp[num_len -1]
        