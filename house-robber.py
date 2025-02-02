# The algorithm uses dynamic programming to calculate the maximum amount that can be robbed, 
# considering each house and the previous choices. It keeps track of the maximum robbery amount without robbing two adjacent 
# houses by updating two variables.

# Time: O(N) | Space: O(1)
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         n = len(nums)
#         if n == 1:
#             return nums[0]
#         dp = [0] * n
#         dp[0] = nums[0]
#         dp[1] = max(nums[0], nums[1])
#         for i in range(2, n):
#             dp[i] = max(dp[i-1], nums[i]+dp[i-2])
#         return dp[-1]
class Solution:
    def rob(self, nums: List[int]) -> int:
        prev_rob = max_rob = 0
        for curr_val in nums:
            temp = max(max_rob, prev_rob + curr_val)
            prev_rob = max_rob
            max_rob = temp
        return max_rob