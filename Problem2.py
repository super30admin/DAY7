#Keeping 2 columns skip and take and adding optimal solution until that row
# TC: O(n)
# SC: O(n)
# Yes, this worked in leetcode

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        n = len(nums)
        skip = 0
        take = nums[0]
        for i in range(1, n):
            temp = skip
            skip = max(skip, take)
            take = temp + nums[i]
        return max(skip, take)