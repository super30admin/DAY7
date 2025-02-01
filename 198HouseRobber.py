from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        n = len(nums)
        if n == 1:
            return nums[0]
        if n == 2:
            return max(nums[0], nums[1])
        
        prev_prev = nums[0]
        prev = max(nums[0], nums[1])
        
        for i in range(2, n):
            current = max(prev, prev_prev + nums[i])
            prev_prev, prev = prev, current
        
        return prev