# Time Complexity = O(n) Space Complexity = O(1)

class Solution:

    def rob(self, nums: list[int]) -> int:
        max1, max2 = 0, 0

        for n in nums:
            max1, max2 = max2, max(max2, max1 + n)

        return max2