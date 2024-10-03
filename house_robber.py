class Solution(object):

    # Dynamic programming solution
    def rob(self, nums):
        n = len(nums)
        dp = [0] * n

        if n == 1:  # If only one house, rob it
            return nums[0]

        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])  # Compare the first two houses

        # Fill the dp array with max robbings up to each house
        for i in range(2, n):
            dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])  # Max of robbing or skipping

        return dp[-1]  # Max amount robbed from all houses


# time and space complexity is O(n) where n is the length of the array nums
