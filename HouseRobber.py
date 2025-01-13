# Time complexity O(n)
# Space complexity O(n) ----- 2n for this now space complexity becomes 0(1)

from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0

        skip = 0
        take = nums[0]

        for i in range(1, len(nums)):
            tempskip = skip
            skip = max(skip, take)
            take = tempskip + nums[i]
        
        return max(skip, take )
        