#Problem 1
# Time Complexity: O(n * m) - where n is the amount and m is the number of coins.
# Space Complexity: O(n) - We use a list of size n+1 to store the fewest number of coins for each amount.

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # dp[i] represents the fewest number of coins needed to make up amount i
        dp = [0] + [amount + 1] * amount

        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] = min(dp[i], dp[i - coin] + 1)

        return -1 if dp[amount] == amount + 1 else dp[amount]

#Problem 2
# Time Complexity: O(n) - We iterate through the list of houses once.
# Space Complexity: O(n) - We use a list of size n to store the maximum amount that can be robbed up to each house.

class Solution:
    def rob(self, nums: List[int]) -> int:
        # Edge cases:
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums)
        
        # Dynamic programming - solve each problem based on its sub-problems
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            dp[i] = max(dp[i-1], nums[i] + dp[i-2])
        
        return dp[-1]
