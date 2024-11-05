# The code defines a rob method to find the maximum amount of money that can be robbed from a series of houses without robbing two adjacent houses.
# This is a dynamic programming approach that maximizes the total sum while adhering to the constraint of non-adjacency.

# Base Cases:
#   - If nums is empty, there are no houses to rob, so 0 is returned.
#   - If there is only one house, the maximum amount that can be robbed is the value of that house (nums[0]).

# Dynamic Programming Initialization:
#   - The dp array is initialized to store the maximum amount that can be robbed up to each house.
#   - dp[0] is set to nums[0] as only one house can be robbed at this point.
#   - dp[1] is set to the maximum of the first two houses (max(nums[0], nums[1])) to handle the choice between robbing the first or second house.

# Dynamic Programming Iteration:
#   - For each house from the third one onward:
#       - dp[i] is calculated as the maximum of two choices:
#           - Not robbing the current house, in which case dp[i] is dp[i - 1].
#           - Robbing the current house, in which case dp[i] is nums[i] + dp[i - 2] (the value of the current house plus the maximum amount robbed up to two houses before).

# Final Result:
#   - dp[-1] (the last element in dp) holds the maximum amount that can be robbed from all houses without violating the adjacency constraint, which is returned.

# TC: O(n) - The time complexity is linear, as each house is processed once.
# SC: O(n) - The space complexity is linear due to the dp array storing maximum rob amounts up to each house.


class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])
        
        return dp[-1]