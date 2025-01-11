# Approach 1 - Recursive (Exhaustive) -Time limit exceeded
# Time complexity - O(2^n)
# Space complexity - O(1)
# from typing import List
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         return self.recurse(nums, 0, 0)
    
#     def recurse(self, nums: List[int], idx: int, amountRobbed: int) -> int:
#         # base
#         if idx >= len(nums):
#             return amountRobbed

#         # logic
#         case0 = self.recurse(nums, idx+1, amountRobbed)

#         case1 = self.recurse(nums, idx+2, amountRobbed + nums[idx])

#         return max(case0, case1)

# Approach 2 - DP
# Time complexity - O(n)
# Space complexity - O(n)
# from typing import List
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         n = len(nums)

#         # dp = [[0] * 2] * (n) # This doesn't work because it repeats list reference in memory
#         # i.e. modifying one element in any row will affect all rows
#         dp = [[0 for i in range(2)] for j in range(n)]

#         dp[0][1] = nums[0]

#         for i in range(1, n):
#             dp[i][0] = max(dp[i-1][1], dp[i-1][0])
#             dp[i][1] = nums[i] + dp[i-1][0]
        
#         return max(dp[n-1][0], dp[n-1][1])

# Approach 3 - Temp variables - More efficient space complexity
# Time complexity - O(n)
# Space complexity - O(1)
from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        skip = 0
        take = nums[0]

        for i in range(1, n):
            temp = skip
            skip = max(skip, take)
            take = nums[i] + temp
        
        return max(skip, take)