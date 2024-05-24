# Time Complexity : O(n), where n is the size of the nums array
# Space Complexity : O(n), which is created by the DP array
class Solution:
    def rob(self, nums):
        if not nums: # Base case
            return 0
        
        n = len(nums)
        if n == 1: # Only one house
            return nums[0]
        
        dp = [0] * n # Array that maintains the total amount that can be robbed till the current house. Initialized to all zeroes to start
        dp[0] = nums[0] # First house can only have one value
        dp[1] = max(nums[0], nums[1]) # Max of either the first or second house, as the robber can start in either house
        
        for i in range(2, n):
            # The amount collected in each house will be the max of the amount collected till the previous house and the sum of the amount that can be collected in the current house with the amount collected two houses back
            dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])
        
        return dp[n - 1] # The last value in the array will be the maximum amount that can be collected in all the houses.

# Example 1
sol = Solution()
nums = [2, 7, 9, 3, 1]
print(sol.rob(nums))  # Expected output: 12

# Example 2
nums = [1,2,3,1]
print(sol.rob(nums))  # Expected output: 4

# Example 3
nums = [2,1,1,2]
print(sol.rob(nums))  # Expected output: 4

# Example 4
nums = [1,2]
print(sol.rob(nums))  # Expected output: 2

# Example 5
nums = [1,3,1]
print(sol.rob(nums))  # Expected output: 3
